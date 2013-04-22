/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.container;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author connollym
 *
 */
public class ContainerFormTest {
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    ContainerForm form = new ContainerForm();
    form.setLocationId(1L);
    form.setLayoutId("1-123");
    form.setParentContainerId(1L);
    form.setStatus(ContainerStatus.ACTIVE.name());
    Container entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Layout.class, entity.getLayout(), 1L);
    CRUDFormAssert.assertEntity(Location.class, entity.getLocation(), 1L);
    CRUDFormAssert.assertEntity(Container.class, entity.getParentContainer(), 1L);
    assertEquals("Wrong status in the entity", ContainerStatus.ACTIVE, entity.getStatus());
  }
}