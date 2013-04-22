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

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.inventory.Container;

/**
 * @author viseem
 * 
 */
public interface ContainerService extends GenericService<Container> {
  /**
   * Creates children containers automatically according to a given specification. The specification tells what the parents are,
   * what container type, layout and name to use for the children
   * 
   * @param specification The specification of children to create.
   * @throws ValidationException if the data is not valid.
   */
  void createChildren(ChildrenSpecification specification) throws ValidationException;
  
  /**
   * Creates a deep copy of a template container.
   * @param specification The specification of the copy to create
   * @throws ValidationException if the data is not valid.
   */
  void createCopy(CopySpecification specification) throws ValidationException;

}
