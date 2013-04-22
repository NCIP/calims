/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.pcrproduct;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.PCRProduct;
import gov.nih.nci.calims2.domain.inventory.Primer;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author connollym
 *
 */
public class PCRProductFormTest {
  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    PCRProductForm form = new PCRProductForm();
    form.setLocationIds(IDS);
    form.setOrganizationIds(IDS);
    form.setSpecimenId(1L);
    form.setTaxonId(1L);
    form.setTypeId(1L);
    form.setReversePrimerId(1L);
    form.setForwardPrimerId(1L);
    form.setContainerId(1L);
    form.setPersonId(1L);
    CRUDFormTestHelper.setNotes(form);
    PCRProduct entity = form.getSubmittedEntity();
    CRUDFormAssert.assertEntities(Location.class, entity.getSamplingLocationCollection(), IDS);
    CRUDFormAssert.assertEntities(Organization.class, entity.getOrganizationCollection(), IDS);
    CRUDFormAssert.assertEntity(Taxon.class, entity.getTaxon(), 1L);
    CRUDFormAssert.assertEntity(Person.class, entity.getContactPerson(), 1L);
    CRUDFormAssert.assertEntity(Specimen.class, entity.getParentSpecimen(), 1L);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    CRUDFormAssert.assertEntity(Primer.class, entity.getReversePrimer(), 1L);
    CRUDFormAssert.assertEntity(Container.class, entity.getContainer(), 1L);
    CRUDFormAssert.assertEntity(Primer.class, entity.getForwardPrimer(), 1L);
    CRUDFormTestHelper.assertNotes(entity);
  }
}

