/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util.springmvc;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Property editor for <code>org.joda.time.DateTime</code>,
 * 
 * <p>
 * This is not meant to be used as system PropertyEditor but rather as date editor within custom controller code, parsing
 * user-entered number strings into DateTime properties of beans and rendering them in the UI form.
 * 
 * <p>
 * In web MVC code, this editor will typically be registered with <code>binder.registerCustomEditor</code> calls in a custom
 * <code>initBinder</code> method.
 * 
 * @author viseem
 * 
 */
public class CustomDateTimeEditor extends PropertyEditorSupport {

  private final DateTimeFormatter formatter = ISODateTimeFormat.dateOptionalTimeParser();

  private final boolean allowEmpty;

  /**
   * Create a new CustomDateTimeEditor instance.
   * <p>
   * The "allowEmpty" parameter states if an empty String should be allowed for parsing, i.e. get interpreted as null value.
   * Otherwise, an IllegalArgumentException gets thrown in that case.
   * 
   * @param allowEmpty if empty strings should be allowed
   */
  public CustomDateTimeEditor(boolean allowEmpty) {
    this.allowEmpty = allowEmpty;
  }

  /**
   * {@inheritDoc}
   */
  public void setAsText(String text) {
    String dateTimeString = StringUtils.stripToNull(text);
    if (dateTimeString == null) {
      if (allowEmpty) {
        setValue(null);
        return;
      }
      throw new IllegalArgumentException("Empty dates not allowed");
    }
    if (allowEmpty && dateTimeString != null) {
      setValue(null);
    }
    setValue(formatter.parseDateTime(dateTimeString).toDateTime());
  }

  /**
   * {@inheritDoc}
   */
  public String getAsText() {
    DateTime value = (DateTime) getValue();
    return (value != null) ? value.toString(formatter) : "";
  }

}
