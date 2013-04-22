/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author connollym
 * 
 */
public class LayoutFormTest {
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    LayoutForm form = new LayoutForm();
    form.setPersonId(1L);
    CRUDFormTestHelper.setNotes(form);
    form.setLabelTypeX(LayoutLabelType.DIGITS.getName());
    form.setLabelTypeY(LayoutLabelType.DIGITS.getName());
    Layout entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Person.class, entity.getPerson(), 1L);
    CRUDFormTestHelper.assertNotes(entity);
    assertEquals("Wrong X dimension label in the entity", LayoutLabelType.DIGITS, entity.getX_dimensionLabel());
    assertEquals("Wrong Y dimension label in the entity", LayoutLabelType.DIGITS, entity.getY_dimensionLabel());
  }
}
