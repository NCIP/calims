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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 * 
 */
public class SelectHelperImpl implements SelectHelper {

  /**
   * {@inheritDoc}
   */
  public <T> List<Option> getOptions(Collection<? extends T> entities, OptionCreatorCallback<T> callback, String selectKey) {
    List<Option> options = new ArrayList<Option>();
    if (selectKey != null) {
      Option option = new Option("-1", null);
      option.setLabelKey(selectKey);
      options.add(option);
    }
    for (T entity : entities) {
      options.add(new Option(callback.getId(entity), callback.getLabel(entity)));
    }
    return options;
  }

  /**
   * {@inheritDoc}
   */
  public <T> List<Option> getEnumOptions(Collection<? extends I18nEnumeration> enumValues,
      OptionCreatorCallback<I18nEnumeration> cb, String selectKey, Locale locale) {
    OptionCreatorCallback<I18nEnumeration> callback = (cb == null) ? new I18nEnumerationOptionCreatorCallback(locale) : cb;
    return getOptions(enumValues, callback, selectKey);
  }

}
