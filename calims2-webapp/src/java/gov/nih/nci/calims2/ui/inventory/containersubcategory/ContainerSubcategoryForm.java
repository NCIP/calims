/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.containersubcategory;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author connollym
 *
 */
public class ContainerSubcategoryForm extends CRUDForm<ContainerSubcategory> {

  private static final long serialVersionUID = -5620873889040508102L;
  private Long typeId;
  /**
   * Default constructor.
   */
  public ContainerSubcategoryForm() {
    setEntity(new ContainerSubcategory());
  }

  /**
   * {@inheritDoc}
   */
  public ContainerSubcategory getSubmittedEntity() {
    ContainerSubcategory subcategoryType = getEntity();
    subcategoryType.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return subcategoryType;
  }

  /**
   * @return the typeId
   */
  public Long getTypeId() {
    return typeId;
  }

  /**
   * @param typeId the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

}
