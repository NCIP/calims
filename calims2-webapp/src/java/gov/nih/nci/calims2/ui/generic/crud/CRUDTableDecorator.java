/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.context.MessageSource;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.uic.descriptor.ColumnVisibility;
import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.TableDecorator;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.table.Column;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
import gov.nih.nci.calims2.util.json.JsonSerializer;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * 
 * Default table decorator to be used in CRUD use cases that do not need any special behavior for the list. The default behavior
 * implemented by this decorator is the following:<br/>
 * 
 * @author viseem
 * @param <T> The type of entity processed.
 * 
 */
public class CRUDTableDecorator<T extends EntityWithId> implements TableDecorator<T> {

  private CRUDControllerConfig config;
  private JsonSerializer jsonSerializer = new JsonSerializer();
  private Locale locale;
  private MessageSource messageSource;
  private PrivilegeEvaluator privilegeEvaluator;
  private List<T> rows;
  private Table table;

  private Map<String, Object> dataStore;
  private Map<String, DateTimeFormatter> dateTimeFormatters = new HashMap<String, DateTimeFormatter>();
  private Map<String, ColumnLength> lengths;
  private List<Boolean> securityFlags;

  /**
   * {@inheritDoc}
   */
  public ColumnVisibility getColumnVisibility(Column column) {
    return getDefaultColumnVisibility(column);
  }

  /**
   * Default calculation of the visibility of a column. This method is used by this decorator and is intended to be used in
   * subclasses for columns that have no special behavior.
   * 
   * @param column The column
   * @return The visibility of the given column
   */
  protected ColumnVisibility getDefaultColumnVisibility(Column column) {
    return (column.getVisibility() == null) ? ColumnVisibility.INITIALLY_VISIBLE : column.getVisibility();
  }

  /**
   * {@inheritDoc}
   */
  public int getColumnLength(Column column) {
    ColumnLength length = lengths.get(column.getName());
    if (column.getMaxLength() != 0 && length.getMaxLength() >= column.getMaxLength()) {
      return column.getMaxLength();
    }
    if (length.getMaxLength() < column.getMinLength()) {
      return column.getMinLength();
    }
    return length.getMaxLength();
  }

  /**
   * {@inheritDoc}
   */
  public List<Column> getDisplayableColumns() {
    List<Column> columns = new ArrayList<Column>();
    for (Column column : table.getColumns()) {
      ColumnVisibility visibility = getColumnVisibility(column);
      if (visibility != ColumnVisibility.ALWAYS_INVISIBLE) {
        columns.add(column);
      }
    }
    return columns;
  }

  /**
   * {@inheritDoc}
   */
  public String getValue(T row, Column column, Object value) {
    return getDefaultValue(row, column, value);
  }

  /**
   * Default calculation of the value of a column. This method is used by this decorator and is intended to be used in subclasses
   * for columns that have no special behavior.
   * 
   * @param row The row of the table
   * @param column The column
   * @param value the value of the jstl expression
   * @return The visibility of the given column
   */
  public String getDefaultValue(T row, Column column, Object value) {
    return formatValue(column, value);
  }

  /**
   * Formats the given value according to its type and the current locale.
   * @param column The column
   * 
   * @param value The value to format
   * @return The formatted value
   */
  public String formatValue(Column column, Object value) {
    if (value == null) {
      return "";
    }
    if (value instanceof I18nEnumeration) {
      return ((I18nEnumeration) value).getLocalizedValue(locale);
    }
    if (value instanceof DateTime) {
      return getDateTimeFormatter(column).print((DateTime) value);
    }
    if (value instanceof BigDecimal) {
      return ((BigDecimal) value).toPlainString();
    }
    if (value instanceof Collection<?>) {
      ExpressionParser expressionParser = new SpelExpressionParser();
      Expression expression = expressionParser.parseExpression(StringUtils.stripToNull(column.getFormat()));
      StringBuilder builder = new StringBuilder();
      for (Object entity : (Collection<?>) value) {
        EvaluationContext context = new StandardEvaluationContext(entity);
        Object expresionValue = evaluateExpression(expression, context);
        if (expresionValue != null) {
          builder.append(expresionValue.toString());
          builder.append("<br/>");
        }
      }
      return builder.toString();
    }
    return value.toString();
  }
  
  /**
   * Get the formatter for the DateTime column.
   * @param column The column
   * @return The formatter for the DateTime column
   */
  DateTimeFormatter getDateTimeFormatter(Column column) {
    DateTimeFormatter formatter = dateTimeFormatters.get(column.getName());
    if (formatter == null) {
      String format = (column.getFormat() != null) ? column.getFormat() : "S-";
      formatter = DateTimeFormat.forStyle(format).withLocale(locale);
      dateTimeFormatters.put(column.getName(), formatter);
    }
    return formatter;
  }

  /**
   * {@inheritDoc}
   */
  public String getDataStore() {
    return jsonSerializer.serializeObject(dataStore);
  }

  /**
   * {@inheritDoc}
   */
  public CommandVisibility getCommandVisibility(Command command) {
    return getDefaultCommandVisibility(command);
  }

  /**
   * Default calculation of the visibility of a command. This method is used by this decorator and is intended to be used in
   * subclasses for commands that have no special behavior.
   * 
   * @param command The command to evaluate
   * @return The visibility of the field.
   */
  protected CommandVisibility getDefaultCommandVisibility(Command command) {
    if (privilegeEvaluator.isAllowed(command.getUrl())) {
      return CommandVisibility.ACTIVE;
    }
    return CommandVisibility.INVISIBLE;
  }

  /**
   * {@inheritDoc}
   */
  public List<Command> getActiveCommands() {
    List<Command> commands = new ArrayList<Command>();
    for (Command command : table.getCommands()) {
      CommandVisibility visibility = getCommandVisibility(command);
      if (visibility == CommandVisibility.ACTIVE) {
        commands.add(command);
      }
    }
    return commands;
  }

  /**
   * Initialize this decorator. This method is intended to do any preliminary work that would usefully cache results before the
   * actual rendering of the datastore.
   */
  public void init() {
    computeSecurityFlags();
    computeDataStore();
  }

  /**
   * Computes the security flags.
   */
  private void computeSecurityFlags() {
    securityFlags = new ArrayList<Boolean>();
    for (Command command : table.getItemCommands()) {
      securityFlags.add(privilegeEvaluator.isAllowed(command.getUrl()));
    }
    securityFlags = Collections.unmodifiableList(securityFlags);
  }

  /**
   * Compute the datastore and the column lengths.
   */
  private void computeDataStore() {
    List<Column> columns = getDisplayableColumns();
    lengths = new HashMap<String, ColumnLength>();
    for (Column column : columns) {
      String header = messageSource.getMessage(config.getViewPrefix() + "list." + column.getName(), null, locale);
      ColumnLength length = new ColumnLength(header.length());
      lengths.put(column.getName(), length);
    }
    Map<String, Expression> expressions = getColumnExpressions(columns);
    dataStore = new TreeMap<String, Object>();
    dataStore.put("identifier", "id");
    List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
    for (T row : rows) {
      EvaluationContext context = new StandardEvaluationContext(row);
      Map<String, Object> item = new TreeMap<String, Object>();
      List<Boolean> flags = getItemCommandFlags(securityFlags, row);
      item.put("id", row.getId().toString() + convertItemCommandFlags(flags));
      for (Column column : columns) {
        Expression expression = expressions.get(column.getName());
        Object value = evaluateExpression(expression, context);
        String displayedValue = getValue(row, column, value);
        item.put(column.getName(), displayedValue);
        ColumnLength length = lengths.get(column.getName());
        length.adjustLength(displayedValue);
      }
      items.add(item);
    }
    dataStore.put("items", items);
  }
  
  /**
   * Computes the array of security flags to use for the given row. This method is intended to be overriden by subclasses for
   * cases where the access to the item commands also depend on business logic.
   * @param flags The array of flags computed based on the 
   * @param row The current row of the list
   * @return The List of flags to use for rendering.
   */
  protected List<Boolean> getItemCommandFlags(List<Boolean> flags, T row) {
    return flags;
  }
  
  /**
   * Converts the given array of security flags to a String for the datastore.
   * @param flags array of security flags
   * @return The String of flags in the form -YNYNYY
   */
  private String convertItemCommandFlags(List<Boolean> flags) {
    String result = "-";
    for (Boolean flag : flags) {
      result += (flag) ? "Y" : "N"; 
    }
    return result;
  }
  

  /**
   * Parse the value expressions for the given columns.
   * 
   * @param columns The columns to process
   * @return A Map of column names to the expressions.
   */
  private Map<String, Expression> getColumnExpressions(List<Column> columns) {
    ExpressionParser expressionParser = new SpelExpressionParser();
    Map<String, Expression> expressions = new HashMap<String, Expression>();
    for (Column column : columns) {
      if (column.getValue() != null) {
        expressions.put(column.getName(), expressionParser.parseExpression(column.getValue()));
      }
    }
    return expressions;
  }

  /**
   * Evaluate the given expression in the given context.
   * 
   * @param expression The expression to evaluate
   * @param context The evaluation context
   * @return
   */
  private Object evaluateExpression(Expression expression, EvaluationContext context) {
    if (expression == null) {
      return null;
    }
    try {
      return expression.getValue(context);
    } catch (EvaluationException e) {
      return null;
    }
  }

  /**
   * Returns the json representation of the item commands.
   * 
   * @return the json representation of the item commands
   */
  public String getItemCommands() {
    List<Map<String, Object>> commands = new ArrayList<Map<String, Object>>();
    for (Command itemCommand : table.getItemCommands()) {
      Map<String, Object> command = new HashMap<String, Object>();
      command.put("icon", itemCommand.getIconClass());
      command.put("url", itemCommand.getUrl());
      command.put("javascriptFunction", StringUtils.stripToEmpty(itemCommand.getJavascriptFunction()));
      String tooltip = messageSource.getMessage(config.getViewPrefix() + "list.command." + itemCommand.getName(), null, locale);
      command.put("tooltip", tooltip);
      commands.add(command);
    }
    return jsonSerializer.serializeCollection(commands);
  }

  /**
   * @return the config
   */
  public CRUDControllerConfig getConfig() {
    return config;
  }

  /**
   * @param config the config to set
   */
  public void setConfig(CRUDControllerConfig config) {
    this.config = config;
  }

  /**
   * @return the locale
   */
  public Locale getLocale() {
    return locale;
  }

  /**
   * @param locale the locale to set
   */
  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  /**
   * @return the messageSource
   */
  public MessageSource getMessageSource() {
    return messageSource;
  }

  /**
   * @param messageSource the messageSource to set
   */
  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }


  /**
   * @return the rows
   */
  public List<T> getRows() {
    return rows;
  }

  /**
   * @param rows the rows to set
   */
  public void setRows(List<T> rows) {
    this.rows = rows;
  }

  /**
   * {@inheritDoc}
   */
  public Table getTable() {
    return table;
  }

  /**
   * @param table the table to set
   */
  public void setTable(Table table) {
    this.table = table;
  }

  /**
   * Inner class used to calculate the colomns width.
   * 
   * @author viseem
   * 
   */
  private static class ColumnLength {
    private int maxLength;

    /**
     * Constructor.
     * 
     * @param initialLength
     */
    public ColumnLength(int initialLength) {
      maxLength = initialLength;
    }

    /**
     * @return the maxLength
     */
    public int getMaxLength() {
      return maxLength;
    }
    


    /**
     * Adjust the length from the given value.
     * 
     * @param value The value.
     */
    public void adjustLength(String value) {
      if (value != null) {
        int length = value.length();
        if (length > maxLength) {
          maxLength = length;
        }
      }
    }
  }

  /**
   * @return the privilegeEvaluator
   */
  public PrivilegeEvaluator getPrivilegeEvaluator() {
    return privilegeEvaluator;
  }

  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }

}
