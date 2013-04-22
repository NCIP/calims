/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.fillpattern;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author connollym
 *
 */
public class FillPatternFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    FillPatternForm form = new FillPatternForm();

    form.setPersonId(1L);
    

    FillPattern entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Person.class, entity.getContactPerson(), 1L);
   
  }
  }
