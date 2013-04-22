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

import gov.nih.nci.calims2.business.inventory.container.ChildrenSpecification;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.inventory.container.LayoutOption;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityFormHelper;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 *
 */
public class ContainerForm extends CRUDForm<Container> {

  private static final long serialVersionUID = -5707411584882387941L;
  
 
  private Long layoutId;
  private Long parentContainerId;
  private Long containerTypeId;
  private Long containerSubcategoryId;
  private Long containerCategoryId;
  private QuantityFormHelper quantities = new QuantityFormHelper();
  private String status;
  private Type containerCategory;
  private ContainerSubcategory containerSubcategory;
  private ChildrenSpecification specification = new ChildrenSpecification();
  private Boolean isReusable = false;
  private boolean createForAll;

  /**
   * Default constructor.
   */
  public ContainerForm() {
    setEntity(new Container());
  }

  /**
   * Gets the children specification for this creation.
   * @return the children specification for this creation.
   */
  public ChildrenSpecification getSubmittedSpecification() {
    specification.setStatus(I18nEnumerationHelper.getByName(ContainerStatus.class, status));
    specification.setReusable(checkBoolean(isReusable));
    specification.setLayoutId(layoutId);
    specification.setContainerTypeId(containerTypeId);
    specification.setQuantities(quantities.getQuantities());
    return specification;
  }
  
 
  /**
   * @param layoutId the layoutId to set
   */
  public void setLayoutId(String layoutId) {
    this.layoutId = new Long(layoutId.split("-")[0]);
  }
  
  /**
   * Gets the selected option for the layout select box.
   * 
   * @return the selected option for the layout select box
   */
  public LayoutOption getLayoutOption() {
    Container container = getEntity();
    if (container.getLayout() != null && container.getContainerType() != null) {
      String id = container.getLayout().getId().toString() + "-" + container.getContainerType().getId().toString();
      return new LayoutOption(id, container.getLayout().getName(), container.getContainerType().getId().toString());
    }
    return null;
  }

  /**
   * @return the parentContainerId
   */
  public Long getParentContainerId() {
    return parentContainerId;
  }

  /**
   * @param parentContainerId the parentContainerId to set
   */
  public void setParentContainerId(Long parentContainerId) {
    this.parentContainerId = parentContainerId;
  }

  /**
   * @return the quantities
   */
  public QuantityFormHelper getQuantities() {
    return quantities;
  }

  /**
   * @param quantities the quantities to set
   */
  public void setQuantities(QuantityFormHelper quantities) {
    this.quantities = quantities;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return the containerTypeId
   */
  public Long getContainerTypeId() {
    return containerTypeId;
  }

  /**
   * @param containerTypeId the containerTypeId to set
   */
  public void setContainerTypeId(Long containerTypeId) {
    this.containerTypeId = containerTypeId;
  }

  /**
   * @return the containerSubcategoryId
   */
  public Long getContainerSubcategoryId() {
    return containerSubcategoryId;
  }

  /**
   * @param containerSubcategoryId the containerSubcategoryId to set
   */
  public void setContainerSubcategoryId(Long containerSubcategoryId) {
    this.containerSubcategoryId = containerSubcategoryId;
  }

  /**
   * @return the containerCategoryId
   */
  public Long getContainerCategoryId() {
    return containerCategoryId;
  }

  /**
   * @param containerCategoryId the containerCategoryId to set
   */
  public void setContainerCategoryId(Long containerCategoryId) {
    this.containerCategoryId = containerCategoryId;
  }

  /**
   * @return the containerCategory
   */
  public Type getContainerCategory() {
    return containerCategory;
  }

  /**
   * @param containerCategory the containerCategory to set
   */
  public void setContainerCategory(Type containerCategory) {
    this.containerCategory = containerCategory;
  }

  /**
   * @return the containerSubcategory
   */
  public ContainerSubcategory getContainerSubcategory() {
    return containerSubcategory;
  }

  /**
   * @param containerSubcategory the containerSubcategory to set
   */
  public void setContainerSubcategory(ContainerSubcategory containerSubcategory) {
    this.containerSubcategory = containerSubcategory;
  }

  /**
   * @param specification the specification to set
   */
  public void setSpecification(ChildrenSpecification specification) {
    this.specification = specification;
  }

  /**
   * @return the specification
   */
  public ChildrenSpecification getSpecification() {
    return specification;
  }

  /**
   * @return the isReusable
   */
  public Boolean getIsReusable() {
    return isReusable;
  }

  /**
   * @param isReusable the isReusable to set
   */
  public void setIsReusable(Boolean isReusable) {
    this.isReusable = isReusable;
  }

  /**
   * @return the createForAll
   */
  public boolean isCreateForAll() {
    return createForAll;
  }

  /**
   * @param createForAll the createForAll to set
   */
  public void setCreateForAll(boolean createForAll) {
    this.createForAll = createForAll;
  }

}

