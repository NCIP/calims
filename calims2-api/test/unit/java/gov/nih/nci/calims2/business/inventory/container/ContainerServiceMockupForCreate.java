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

import gov.nih.nci.calims2.business.util.validation.ValidationException;

/**
 * @author viseem
 * 
 */
public class ContainerServiceMockupForCreate extends ContainerServiceImpl {

  private ChildrenSpecification specification;

  /**
   * {@inheritDoc}
   */
  public void createChildren(ChildrenSpecification spec) throws ValidationException {
    this.specification = spec;
  }

  /**
   * @return the specification
   */
  public ChildrenSpecification getSpecification() {
    return specification;
  }

}
