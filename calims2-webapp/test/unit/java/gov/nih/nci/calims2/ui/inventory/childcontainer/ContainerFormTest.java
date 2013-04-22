/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.childcontainer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.business.inventory.container.ChildrenSpecification;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityFormHelper;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 *
 */
public class ContainerFormTest {
  
  private QuantityFormHelper quantities = new QuantityFormHelper();
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    ContainerForm form = new ContainerForm();
    
    form.setLayoutId("1-123");
    form.setParentContainerId(1L);
    form.setIsReusable(Boolean.TRUE);
    form.setContainerTypeId(1L);
    form.setParentContainerId(1L);
    form.setStatus("ACTIVE");

    form.setStatus(ContainerStatus.ACTIVE.name());
    ChildrenSpecification specification = new ChildrenSpecification();
    specification.setStatus(I18nEnumerationHelper.getByName(ContainerStatus.class, form.getStatus()));
    specification.setReusable(form.getIsReusable());
    specification.setContainerTypeId(form.getContainerTypeId());
    specification.addParentContainerId(form.getParentContainerId());
    specification.setQuantities(quantities.getQuantities());
    form.setSpecification(specification);
    
    assertNotNull("No submitted Entity", form.getSpecification());
    assertEquals("Wrong status in the entity", ContainerStatus.ACTIVE, form.getSpecification().getStatus());
  }
}
