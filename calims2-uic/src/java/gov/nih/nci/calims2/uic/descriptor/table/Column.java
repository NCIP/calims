/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor.table;

import java.io.Serializable;

import gov.nih.nci.calims2.uic.descriptor.ColumnVisibility;

/**
 * @author viseem
 * 
 */
public class Column implements Cloneable, Serializable {

  private static final long serialVersionUID = -1479364016109084396L;

  private static final int DEFAULT_MAXLENGTH = 30;

  private String access;
  private String name;
  private String value;
  private String format;
  private String formatter;
  private int minLength;
  private int maxLength = DEFAULT_MAXLENGTH;
  private ColumnVisibility visibility;
  private boolean sortable = true;

  /**
   * @return the access
   */
  public String getAccess() {
    return access;
  }

  /**
   * @param access the access to set
   */
  public void setAccess(String access) {
    this.access = access;
  }

  /**
   * Get the name of the column.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the column. It must be unique in the table and is used as the field name in the grid.
   * 
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the Spel expression used to calculate the displayed value.
   * 
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * Set the Spel expression used to calculate the displayed value.
   * 
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * @return the format
   */
  public String getFormat() {
    return format;
  }

  /**
   * @param format the format to set
   */
  public void setFormat(String format) {
    this.format = format;
  }

  /**
   * @return the formatter
   */
  public String getFormatter() {
    return formatter;
  }

  /**
   * @param formatter the formatter to set
   */
  public void setFormatter(String formatter) {
    this.formatter = formatter;
  }

  /**
   * @return the minLength
   */
  public int getMinLength() {
    return minLength;
  }

  /**
   * @param minLength the minLength to set
   */
  public void setMinLength(int minLength) {
    this.minLength = minLength;
  }

  /**
   * @return the maxLength
   */
  public int getMaxLength() {
    return maxLength;
  }

  /**
   * @param maxLength the maxLength to set
   */
  public void setMaxLength(int maxLength) {
    this.maxLength = maxLength;
  }

  /**
   * Get the visibility of the column.
   * 
   * @return the visibility
   */
  public ColumnVisibility getVisibility() {
    return visibility;
  }

  /**
   * Set the visibility of the column.
   * 
   * @param visibility the visibility to set
   */
  public void setVisibility(ColumnVisibility visibility) {
    this.visibility = visibility;
  }

  /**
   * @return the sortable
   */
  public boolean isSortable() {
    return sortable;
  }

  /**
   * @param sortable the sortable to set
   */
  public void setSortable(boolean sortable) {
    this.sortable = sortable;
  }

  /**
   * {@inheritDoc}
   */
  public Column clone() {
    try {
      return (Column) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Subclasses supports clone.");
    }
  }

}
