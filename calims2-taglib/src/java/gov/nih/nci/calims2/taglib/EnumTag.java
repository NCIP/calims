/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringEscapeUtils;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * Custom tag for rendering of I18nEnumerations and their optional properties.
 * 
 * @author viseem
 */
public class EnumTag extends TagSupport {
  
  private static final long serialVersionUID = -3006638793663509544L;
  
  private I18nEnumeration value;
  private String propertyName;

  /**
   * {@inheritDoc}
   */
  public int doStartTag() throws JspException {
    try {
      Locale locale = TagHelper.getRequestContext(pageContext).getLocale();
      if (value != null) {
        String message = (propertyName == null) ? value.getLocalizedValue(locale) : getPropertyValue(locale);
        pageContext.getOut().print(StringEscapeUtils.escapeHtml(message));
      }
      return SKIP_BODY;
    } catch (IOException e) {
      throw new JspException(e);
    } catch (Exception e) {
      throw new JspTagException(e);
    }
  }
  
  /**
   * Gets the value of the optional property in the specified locale.
   * @param locale The locale
   * @return The optional property in the specified locale
   */
  private String getPropertyValue(Locale locale) throws Exception {
    try {
      String methodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
      Method m = value.getClass().getMethod(methodName, Locale.class);
      return (String) m.invoke(value, locale);
    } catch (IllegalArgumentException e) {
      throw new InternalError("Could not happen. Method take a locale argument");
    } 
  }
  
  /**
   * {@inheritDoc}
   */
  public int doEndTag() {
    propertyName = null;
    return EVAL_PAGE;
  }

  /**
   * @return the value
   */
  public I18nEnumeration getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(I18nEnumeration value) {
    this.value = value;
  }

  /**
   * @return the propertyName
   */
  public String getPropertyName() {
    return propertyName;
  }

  /**
   * @param propertyName the propertyName to set
   */
  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

}
