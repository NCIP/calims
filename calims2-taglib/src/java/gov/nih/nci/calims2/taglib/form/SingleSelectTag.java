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
