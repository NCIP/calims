/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.select;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * OptionCreatorCallback for I18nEnumerations.
 * 
 * @author viseem
 * 
 */
public class I18nEnumerationOptionCreatorCallback implements OptionCreatorCallback<I18nEnumeration> {

  private Locale locale;

  /**
   * Constructor.
   * 
   * @param locale The locale to use for the enumeration labels
   */
  public I18nEnumerationOptionCreatorCallback(Locale locale) {
    this.locale = locale;
  }

  /**
   * {@inheritDoc}
   */
  public String getId(I18nEnumeration option) {
    return option.getName();
  }

  /**
   * {@inheritDoc}
   */
  public String getLabel(I18nEnumeration option) {
    return option.getLocalizedValue(locale);
  }

}
