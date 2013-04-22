/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.additionalorganismname;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author connollym
 *
 */
public class AdditionalOrganismNameFormTest  {
/**
 * Test the controller getSubmittedEntity method.
 */
@Test
public void testGetSubmittedEntity() {
  AdditionalOrganismNameForm form = new AdditionalOrganismNameForm();
  form.setTypeId(1L);
  CRUDFormTestHelper.setNotes(form);
  AdditionalOrganismName entity = form.getSubmittedEntity();
  assertNotNull("No submitted Entity", entity);
  CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
  CRUDFormTestHelper.assertNotes(entity);
}
}
