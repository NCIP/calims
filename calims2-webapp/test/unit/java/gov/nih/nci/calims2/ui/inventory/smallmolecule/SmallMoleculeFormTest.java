/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.smallmolecule;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.SmallMolecule;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 *
 */
public class SmallMoleculeFormTest {
  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    SmallMoleculeForm form = new SmallMoleculeForm();
    form.setSpecimenId(1L);
    form.setLocationIds(IDS);
    form.setOrganizationIds(IDS);
    form.setTaxonId(1L);
    form.setTypeId(1L);
    form.setContainerId(1L);
    form.setPersonId(1L);
    CRUDFormTestHelper.setNotes(form);
    SmallMolecule entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntities(Location.class, entity.getSamplingLocationCollection(), IDS);
    CRUDFormAssert.assertEntities(Organization.class, entity.getOrganizationCollection(), IDS);
    CRUDFormAssert.assertEntity(Person.class, entity.getContactPerson(), 1L);
    CRUDFormAssert.assertEntity(Taxon.class, entity.getTaxon(), 1L);
    CRUDFormAssert.assertEntity(Specimen.class, entity.getParentSpecimen(), 1L);
    CRUDFormAssert.assertEntity(Container.class, entity.getContainer(), 1L);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    CRUDFormTestHelper.assertNotes(entity);
  }
}
