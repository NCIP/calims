/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.servlet.support.RequestContext;

import gov.nih.nci.calims2.taglib.TagHelper;
import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.ContentTag.ContentType;
import gov.nih.nci.calims2.uic.select.Option;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
import gov.nih.nci.calims2.util.json.JsonSerializer;

/**
 * @author viseem
 * 
 */
public class SingleSelectTag extends ValidationTextBoxTag {

  private static final long serialVersionUID = -8858374299990149368L;
  
  private SelectCollectionType collectionType = SelectCollectionType.ENTITIES;
  private OptionCreatorCallback<?> optionCreatorCallback;
  private Collection<?> options;
  private String properties;
  private Object selected;
  private boolean useDataStore;
  private Map<String, Expression> propertyMap;

  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    collectionType = SelectCollectionType.ENTITIES;
    optionCreatorCallback = null;
    properties = null;
    selected = null;
    useDataStore = false;
  }

  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_FILTERINGSELECT.getTypeName());
    if (useDataStore) {
      dojoManager.addDojoType(DojoType.DOJO_DATA_ITEM_FILE_READ_STORE.getTypeName());
    }
  }

  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    propertyMap = SingleSelectHelper.getPropertyMap(properties);
    if (useDataStore) {
      Tag divTag = new CompositeTag(HtmlElement.DIV);
      addScript(divTag);
      Tag tag = divTag.addChild(new CompositeTag(HtmlElement.DIV));
      addAttributes(tag);
      tag.addAttribute("dojoType", DojoType.DIJIT_FORM_FILTERINGSELECT.getTypeName());
      tag.addAttribute("searchAttr", "label");
      tag.addAttribute("required", Boolean.toString(isRequired()));
      tag.addAttribute("store", getId() + "Store");
      tag.addAttribute("value", getSelectedId());
      addMessages(tag);
      return divTag;
    }
    Tag tag = new CompositeTag(HtmlElement.SELECT);
    addAttributes(tag);
    tag.addAttribute("dojoType", DojoType.DIJIT_FORM_FILTERINGSELECT.getTypeName());
    tag.addAttribute("required", Boolean.toString(isRequired()));
    tag.addAttribute("value", getSelectedId());
    addMessages(tag);
    addOptions(tag);
    return tag;
  }

  private void addOptions(Tag tag) {
    for (Option option : getOptionsForRendering(TagHelper.getRequestContext(pageContext))) {
      Tag optionTag = tag.addChild(new CompositeTag(HtmlElement.OPTION));
      optionTag.addAttribute("value", option.getId());
      optionTag.addChild(new ContentTag(option.getLabel()));
    }
  }

  /**
   * Adds the invalid and prompt message to the current tag.
   * 
   * @param tag The tag to which the messages must be added.
   */
  protected void addMessages(Tag tag) {
    RequestContext rc = TagHelper.getRequestContext(pageContext);
    if (getInvalidKey() != null) {
      tag.addAttribute("missingMessage", rc.getMessage(getInvalidKey(), null, false));
    } else {
      tag.addAttribute("missingMessage", getInvalidMessage());
    }
    if (getPromptKey() != null) {
      tag.addAttribute("promptMessage", rc.getMessage(getPromptKey(), null, false));
    } else {
      tag.addAttribute("promptMessage", getPromptMessage());
    }
    tag.addAttribute("toolTipPosition", getToolTipPosition());
  }

  @SuppressWarnings("unchecked")
  private String getSelectedId() {
    if (selected == null) {
      return "";
    }
    if (collectionType == SelectCollectionType.ENUMERATIONS) {
      return ((I18nEnumeration) selected).getName();
    }
    if (optionCreatorCallback != null) {
      OptionCreatorCallback<Object> callback = (OptionCreatorCallback<Object>) optionCreatorCallback;
      return StringUtils.stripToEmpty(callback.getId(selected));
    }
    Expression idProperty = propertyMap.get("id");
    EvaluationContext context = new StandardEvaluationContext(selected);
    return StringUtils.stripToEmpty(SingleSelectHelper.evaluateExpression(idProperty, context));
  }

  private void addScript(Tag tag) {
    Tag scriptTag = tag.addChild(new CompositeTag(HtmlElement.SCRIPT));
    scriptTag.addAttribute("type", "text/javascript");
    ContentTag content = scriptTag.addChild(new ContentTag(createDataStore()));
    content.setContentType(ContentType.TEXT);
  }

  @SuppressWarnings("unchecked")
  private String createDataStore() {
    Map<String, Object> jsonObject = new TreeMap<String, Object>();
    jsonObject.put("identifier", "id");
    jsonObject.put("label", "label");
    List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
    jsonObject.put("items", items);
    if (collectionType == SelectCollectionType.ENTITIES) {
      for (Object entity : options) {
        Map<String, Object> item = new TreeMap<String, Object>();
        EvaluationContext context = new StandardEvaluationContext(entity);
        for (Map.Entry<String, Expression> entry : propertyMap.entrySet()) {
          String value = SingleSelectHelper.evaluateExpression(entry.getValue(), context);
          item.put(entry.getKey(), value);
        }
        if (optionCreatorCallback != null) {
          OptionCreatorCallback<Object> callback = (OptionCreatorCallback<Object>) optionCreatorCallback;
          item.put("id", callback.getId(entity));
          item.put("label", callback.getLabel(entity));
        }
        items.add(item);
      }
    } else {
      for (Option option : getOptionsForRendering(TagHelper.getRequestContext(pageContext))) {
        Map<String, Object> item = new TreeMap<String, Object>();
        item.put("id", option.getId());
        item.put("label", option.getLabel());
        items.add(item);
      }
    }
    return "var " + getId() + "Data = " + new JsonSerializer().serializeObject(jsonObject) + ";\n var " + getId() + "Store = new "
        + DojoType.DOJO_DATA_ITEM_FILE_READ_STORE.getTypeName() + "({data : " + getId() + "Data});";
  }

  /**
   * @param collectionType the collectionType to set
   */
  public void setCollectionType(String collectionType) {
    this.collectionType = SelectCollectionType.valueOf(collectionType);
  }

  /**
   * @param optionCreatorCallback the optionCreatorCallback to set
   */
  public void setOptionCreatorCallback(OptionCreatorCallback<?> optionCreatorCallback) {
    this.optionCreatorCallback = optionCreatorCallback;
  }

  /**
   * @param options the options to set
   */
  public void setOptions(Collection<?> options) {
    this.options = options;
  }

  /**
   * @param properties the properties to set
   */
  public void setProperties(String properties) {
    this.properties = StringUtils.stripToNull(properties);
  }

  /**
   * @param selected the selected to set
   */
  public void setSelected(Object selected) {
    this.selected = selected;
  }

  /**
   * @param useDataStore the useDataStore to set
   */
  public void setUseDataStore(boolean useDataStore) {
    this.useDataStore = useDataStore;
  }

  @SuppressWarnings("unchecked")
  private List<Option> getOptionsForRendering(RequestContext requestContext) {
    switch (collectionType) {
      case ENUMERATIONS: {
        return getOptionsFromEnums(requestContext, (Collection<I18nEnumeration>) options);
      }
      case ENTITIES: {
        return getOptionsFromEntities(options);
      }
      default: {
        throw new InternalError("Can not happen");
      }
    }
  }

  private List<Option> getOptionsFromEnums(RequestContext requestContext, Collection<I18nEnumeration> enumerations) {
    List<Option> result = new ArrayList<Option>();
    for (I18nEnumeration option : enumerations) {
      Option newOption = new Option(option.getName(), option.getLocalizedValue(requestContext.getLocale()));
      result.add(newOption);
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  private List<Option> getOptionsFromEntities(Collection<?> entities) {
    List<Option> result = new ArrayList<Option>();
    if (optionCreatorCallback != null) {
      OptionCreatorCallback<Object> callback = (OptionCreatorCallback<Object>) optionCreatorCallback;
      for (Object entity : entities) {
        result.add(new Option(callback.getId(entity), callback.getLabel(entity)));
      }
    } else {
      Expression idProperty = propertyMap.get("id");
      if (idProperty == null) {
        throw new IllegalArgumentException("Missing id property");
      }
      Expression labelProperty = propertyMap.get("label");
      if (labelProperty == null) {
        throw new IllegalArgumentException("Missing label property");
      }
      for (Object entity : entities) {
        EvaluationContext context = new StandardEvaluationContext(entity);
        result.add(new Option(SingleSelectHelper.evaluateExpression(idProperty, context), SingleSelectHelper.evaluateExpression(
            labelProperty, context)));
      }
    }
    return result;
  }

}
