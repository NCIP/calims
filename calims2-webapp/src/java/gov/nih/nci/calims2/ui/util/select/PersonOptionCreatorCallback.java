/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util.select;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;

/**
 * @author viseem
 * 
 */
public class PersonOptionCreatorCallback implements OptionCreatorCallback<Person> {

  /**
   * {@inheritDoc}
   */
  public String getId(Person person) {
    return person.getId().toString();
  }

  /**
   * {@inheritDoc}
   */
  public String getLabel(Person person) {
    return person.getFamilyName() + "," + person.getGivenName() + " " + person.getMiddleName();
  }

}
