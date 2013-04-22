/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.ui.administration.person.PersonForm;

/**
 * @author viseem
 * 
 */
public class PersonControllerMockup extends CRUDController<Person> {

  private static final String URL_PREFIX = "/administration/person";

  /**
   * Default constructor.
   */
  public PersonControllerMockup() {
    CRUDControllerConfig config = getConfig();
    config.setUrlAndViewPrefixes(URL_PREFIX);
    config.setOrderByClause("order");
    setPersistentClass(Person.class);
    setFormClass(PersonForm.class);
    config.setSubFlowUrls(new String[]{"testurl"});
  }
}
