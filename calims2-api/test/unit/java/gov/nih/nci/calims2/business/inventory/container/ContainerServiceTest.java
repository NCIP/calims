/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.container;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerType;

/**
 * @author viseem
 *
 */
public class ContainerServiceTest {
  /**
   * Test the createChildrenForComposite method.
   * @throws ValidationException if an error occurs
   */
  @Test
  public void testCreateChildrenForComposite() throws ValidationException {
    ContainerServiceMockupForCreate service = new ContainerServiceMockupForCreate();
    ContainerDaoMockup dao = new ContainerDaoMockup();
    service.setGenericDao(dao);
    Container container = new Container();
    ContainerType containerType = new ContainerType();
    container.setContainerType(containerType);
    containerType.setId(1L);
//    ContainerType childContainerType = new ContainerType();
//    service.createChildrenForComposite(container);
//    ChildrenSpecification specification = service.getSpecification();
    
  }

}
