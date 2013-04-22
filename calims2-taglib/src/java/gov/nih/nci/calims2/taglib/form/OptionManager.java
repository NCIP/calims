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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.web.servlet.support.RequestContext;

import gov.nih.nci.calims2.uic.select.Option;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;
import gov.nih.nci.calims2.uic.select.SelectHelper;
import gov.nih.nci.calims2.uic.select.SelectHelperImpl;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem Option manager for the select custom tags. The Collection of options passed to the tag can be of any type. The
 *         manager will process them according to the following rules:
 * 
 *         For Option, The id and label of the option are used directly. For I18nEnumeration, the id is the name of the enumeration
 *         value and the label is the translated value of the enumeration value. For other classes, the manager uses reflection to
 *         get the id and label properties.
 * 
 */
public class OptionManager implements Serializable {

  private static final long serialVersionUID = 7861137997595108579L;
  
  private String idProperty;
  private String labelProperty;
  private Collection<?> options;
  private Collection<?> selectedOptions;
  private Object selectedOption;
  private boolean multiple;
  private OptionCreatorCallback<?> optionCreatorCallback;
  private String selectKey;

  /**
   * Constructor.
   * 
   * @param multiple True if multiple selection is allowed.
   */
  public OptionManager(boolean multiple) {
    this.multiple = multiple;
  }

  /**
   * Return the set of id properties of the selected options.
   * 
   * @return the set of id properties of the selected options.
   */
  public Set<String> getSelectedIds() {
    Set<String> result = new HashSet<String>();
    if (multiple) {
      for (Object option : selectedOptions) {
        result.add(getIdForOption(option));
      }
    } else {
      if (selectedOption != null) {
        result.add(getIdForOption(selectedOption));
      }
    }
    return result;
  }

  /**
   * Gets the id of the given option.
   * 
   * @param option The option rom which the id should be gotten
   * @return Gets the id of the given option.
   */
  String getIdForOption(Object option) {
    if (option instanceof Option) {
      return ((Option) option).getId();
    }
    if (option instanceof I18nEnumeration) {
      return ((I18nEnumeration) option).getName();
    }
    BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(option);
    return wrapper.getPropertyValue(idProperty).toString();
  }

  /**
   * Gets the collection of options to render in the select.
   * 
   * @param requestContext The current request context.
   * @return the collection of options to render in the select.
   */
  public List<Option> getOptionsForRendering(RequestContext requestContext) {
    Set<String> ids = getSelectedIds();
    List<Option> result = new ArrayList<Option>(options.size());
    for (Object option : options) {
      Option newOption = getOptionForOption(option, requestContext);
      newOption.setSelected(ids.contains(newOption.getId()));
      result.add(newOption);
    }
    return result;
  }

  /**
   * Generates a new Option object for the given option that may be of any class.
   * 
   * @param option The given option
   * @param requestContext The current request context.
   * @return The new Option generated.
   */
  Option getOptionForOption(Object option, RequestContext requestContext) {
    if (option instanceof Option) {
      Option newOption = ((Option) option).clone();
      if (newOption.getLabelKey() != null) {
        newOption.setLabel(requestContext.getMessage(newOption.getLabelKey()));
      }
      return newOption;
    }
    if (option instanceof I18nEnumeration) {
      I18nEnumeration enumValue = (I18nEnumeration) option;
      return new Option(enumValue.getName(), enumValue.getLocalizedValue(requestContext.getLocale()));
    }
    BeanWrapper wrapper = PropertyAccessorFactory.forBeanPropertyAccess(option);
    return new Option(wrapper.getPropertyValue(idProperty).toString(), wrapper.getPropertyValue(labelProperty).toString());
  }

  /**
   * Wrap the options if necessary.
   * 
   * @param <T> The type of options.
   * @param readOnly True if the tag is readOnly
   * @param requestContext The current request context.
   */
  @SuppressWarnings("unchecked")
  public <T> void wrapOptions(boolean readOnly, RequestContext requestContext) {
    String finalSelectKey = (readOnly) ? null : selectKey;
    if (optionCreatorCallback != null || finalSelectKey != null) {
      SelectHelper helper = new SelectHelperImpl();
      boolean enumeration = !options.isEmpty() && options.iterator().next() instanceof I18nEnumeration;
      if (enumeration) {
        options = helper.getEnumOptions((Collection<? extends I18nEnumeration>) options, null, finalSelectKey, 
                                        requestContext.getLocale());
      } else {
        options = helper.getOptions((Collection<T>) options, (OptionCreatorCallback<T>) optionCreatorCallback, finalSelectKey);
      }
    }
  }

  /**
   * Gets the selected option for viewing.
   * 
   * @param requestContext The current request context.
   * @return The selected option for viewing.
   */
  public Option getSelectedOptionForView(RequestContext requestContext) {
    if (selectedOption != null) {
    return getOptionForOption(selectedOption, requestContext);
    }
    return new Option(null, "");
  }

  /**
   * Gets the list of selected options for viewing.
   * 
   * @param requestContext The current request context.
   * @return The list of selected options for viewing.
   */
  public List<Option> getSelectedOptionsForView(RequestContext requestContext) {
    List<Option> result = new ArrayList<Option>(selectedOptions.size());
    if (selectedOptions != null) {
      for (Object option : selectedOptions) {
        Option newOption = getOptionForOption(option, requestContext);
        result.add(newOption);
      }
    }
    return result;
  }

  /**
   * @return the idProperty
   */
  public String getIdProperty() {
    return idProperty;
  }

  /**
   * @param idProperty the idProperty to set
   */
  public void setIdProperty(String idProperty) {
    this.idProperty = StringUtils.stripToNull(idProperty);
  }

  /**
   * @return the labelProperty
   */
  public String getLabelProperty() {
    return labelProperty;
  }

  /**
   * @param labelProperty the labelProperty to set
   */
  public void setLabelProperty(String labelProperty) {
    this.labelProperty = StringUtils.stripToNull(labelProperty);
  }

  /**
   * @return the options
   */
  public Collection<?> getOptions() {
    return options;
  }

  /**
   * @param options the options to set
   */
  public void setOptions(Collection<?> options) {
    this.options = options;
  }

  /**
   * @return the selectedOptions
   */
  public Collection<?> getSelectedOptions() {
    return selectedOptions;
  }

  /**
   * @param selectedOptions the selectedOptions to set
   */
  public void setSelectedOptions(Collection<?> selectedOptions) {
    this.selectedOptions = selectedOptions;
  }

  /**
   * @return the selectedOption
   */
  public Object getSelectedOption() {
    return selectedOption;
  }

  /**
   * @param selectedOption the selectedOption to set
   */
  public void setSelectedOption(Object selectedOption) {
    this.selectedOption = selectedOption;
  }

  /**
   * @return the multiple
   */
  public boolean isMultiple() {
    return multiple;
  }

  /**
   * @param multiple the multiple to set
   */
  public void setMultiple(boolean multiple) {
    this.multiple = multiple;
  }

  /**
   * @return the optionCreatorCallback
   */
  public OptionCreatorCallback<?> getOptionCreatorCallback() {
    return optionCreatorCallback;
  }

  /**
   * @param optionCreatorCallback the optionCreatorCallback to set
   */
  public void setOptionCreatorCallback(OptionCreatorCallback<?> optionCreatorCallback) {
    this.optionCreatorCallback = optionCreatorCallback;
  }

  /**
   * @return the selectKey
   */
  public String getSelectKey() {
    return selectKey;
  }

  /**
   * @param selectKey the selectKey to set
   */
  public void setSelectKey(String selectKey) {
    this.selectKey = StringUtils.stripToNull(selectKey);
  }

}
