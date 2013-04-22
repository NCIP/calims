/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.containertype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author connollym
 * 
 */
public class ContainerTypeFormTest {
  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    ContainerTypeForm form = new ContainerTypeForm();
    form.setComposition(ContainerComposition.COMPOSITE.name());
    form.setContainerSubcategoryId(1L);
    form.setContainerTypeId(1L);
    form.setDefaultLayoutId(1L);
    form.setLayoutIds(IDS);
    ContainerType entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    assertEquals("Wrong composition in the entity", ContainerComposition.COMPOSITE, entity.getComposition());
    CRUDFormAssert.assertEntity(ContainerType.class, entity.getChildContainerType(), 1L);
    CRUDFormAssert.assertEntity(ContainerSubcategory.class, entity.getContainerSubcategory(), 1L);
    CRUDFormAssert.assertEntity(Layout.class, entity.getDefaultLayout(), 1L);
    CRUDFormAssert.assertEntities(Layout.class, entity.getLayoutCollection(), IDS);
  }
}