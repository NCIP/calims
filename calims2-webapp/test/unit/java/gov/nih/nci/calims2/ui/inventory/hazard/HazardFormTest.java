/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.hazard;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Hazard;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author viseem
 * 
 */
public class HazardFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    HazardForm form = new HazardForm();
    form.setContainerId(1L);
    form.setLabSupplyId(1L);
    CRUDFormTestHelper.setNotes(form);
    form.setSpecimenId(1L);
    form.setTypeId(1L);
    Hazard entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Container.class, entity.getContainer(), 1L);
    CRUDFormAssert.assertEntity(LabSupply.class, entity.getLabSupply(), 1L);
    CRUDFormTestHelper.assertNotes(entity);
    CRUDFormAssert.assertEntity(Specimen.class, entity.getSpecimen(), 1L);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
  }
}