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

/**
 * Callback interface for the option creation done in SelectHelper.
 * 
 * @author viseem
 * @param <T> The type of the options.
 * 
 */
public interface OptionCreatorCallback<T> {
  /**
   * Gets the id of a given option.
   * 
   * @param option The option object.
   * @return The id of the option.
   */
  String getId(T option);

  /**
   * Gets the label of a given option.
   * 
   * @param option The option object.
   * @return The label of the option.
   */
  String getLabel(T option);

}
