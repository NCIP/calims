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

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * Helper interface for the creation of option lists for select tags.
 * 
 * @author viseem
 * 
 */
public interface SelectHelper {

  /**
   * Creates a list of options from a collection of entities and a callback with the given select optional message.
   * 
   * @param <T> The Type of entities.
   * @param entities The collection to convert.
   * @param callback The callback
   * @param selectKey The key for the message to use as the first option
   * @return a list of options corresponding to the given entities processed by the callback.
   */
  <T> List<Option> getOptions(Collection<? extends T> entities, OptionCreatorCallback<T> callback, String selectKey);

  /**
   * Creates a list of options from a collection of entities and a callback.
   * 
   * @param <T> The Type of entities.
   * @param enumValues The collection of enumeration values to convert.
   * @param callback The callback
   * @param selectKey The key for the message to use as the first option
   * @param locale The locale to use for the enumeration labels
   * @return a list of options corresponding to the given entities processed by the callback.
   */
  <T> List<Option> getEnumOptions(Collection<? extends I18nEnumeration> enumValues, OptionCreatorCallback<I18nEnumeration> callback,
      String selectKey, Locale locale);

}
