/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
