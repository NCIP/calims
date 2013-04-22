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

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityFormHelper;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 * 
 */
public class ContainerForm extends CRUDForm<Container> {

  private static final long serialVersionUID = 280046568835712054L;
  
  private String coordinateX;
  private String coordinateY;
  private Long layoutId;
  private Long locationId;
  private Long parentContainerId;
  private Long containerTypeId;
  private Long containerSubcategoryId;
  private Long containerCategoryId;
  private QuantityFormHelper quantities = new QuantityFormHelper();
  private String status;
  private boolean updatable;
  
  /**
   * Default constructor.
   */
  public ContainerForm() {
    setEntity(new Container());
  }

  /**
   * {@inheritDoc}
   */
  public Container getSubmittedEntity() {
    Container container = getEntity();
    container.setIsReusable(checkBoolean(container.getIsReusable()));
    container.setIsTemplate(checkBoolean(container.getIsTemplate()));
    container.setLayout(EntityWithIdHelper.createEntity(Layout.class, layoutId));
    container.setLocation(EntityWithIdHelper.createEntity(Location.class, locationId));
    container.setParentContainer(EntityWithIdHelper.createEntity(Container.class, parentContainerId));
    container.setCapacityCollection(quantities.getQuantities());
    container.setStatus(I18nEnumerationHelper.getByName(ContainerStatus.class, status));
    container.setContainerType(EntityWithIdHelper.createEntity(ContainerType.class, containerTypeId));
    return container;
  }

  /**
   * @return the coordinateX
   */
  public String getCoordinateX() {
    return coordinateX;
  }

  /**
   * @param coordinateX the coordinateX to set
   */
  public void setCoordinateX(String coordinateX) {
    this.coordinateX = coordinateX;
  }

  /**
   * @return the coordinateY
   */
  public String getCoordinateY() {
    return coordinateY;
  }

  /**
   * @param coordinateY the coordinateY to set
   */
  public void setCoordinateY(String coordinateY) {
    this.coordinateY = coordinateY;
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
   * @return the locationId
   */
  public Long getLocationId() {
    return locationId;
  }

  /**
   * @param locationId the locationId to set
   */
  public void setLocationId(Long locationId) {
    this.locationId = locationId;
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
   * @return the updatable
   */
  public boolean isUpdatable() {
    return updatable;
  }

  /**
   * @param updatable the updatable to set
   */
  public void setUpdatable(boolean updatable) {
    this.updatable = updatable;
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

}
