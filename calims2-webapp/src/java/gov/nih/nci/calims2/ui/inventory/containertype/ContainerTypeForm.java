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

import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 *
 */
public class ContainerTypeForm extends CRUDForm<ContainerType> {

  private static final long serialVersionUID = 5456414526754038046L;
  
  private String composition;
  private Long containerCategoryId;
  private Long containerSubcategoryId;
  private Long containerTypeId;
  private Long defaultLayoutId;
  private Long[] layoutIds;
  
  /**
   * Default constructor.
   */
  public ContainerTypeForm() {
    setEntity(new ContainerType());
  }

  /**
   * {@inheritDoc}
   */
  public ContainerType getSubmittedEntity() {
    ContainerType containerType = getEntity();
    containerType.setComposition(I18nEnumerationHelper.getByName(ContainerComposition.class, composition));
    containerType.setChildContainerType(EntityWithIdHelper.createEntity(ContainerType.class, containerTypeId));
    containerType.setContainerSubcategory(EntityWithIdHelper.createEntity(ContainerSubcategory.class, containerSubcategoryId));
    containerType.setDefaultLayout(EntityWithIdHelper.createEntity(Layout.class, defaultLayoutId));
    containerType.setLayoutCollection(EntityWithIdHelper.createEntities(Layout.class, layoutIds));
    return containerType;
  }

  /**
   * @return the composition
   */
  public String getComposition() {
    return composition;
  }

  /**
   * @param composition the composition to set
   */
  public void setComposition(String composition) {
    this.composition = composition;
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
   * @return the defaultLayoutId
   */
  public Long getDefaultLayoutId() {
    return defaultLayoutId;
  }

  /**
   * @param defaultLayoutId the defaultLayoutId to set
   */
  public void setDefaultLayoutId(Long defaultLayoutId) {
    this.defaultLayoutId = defaultLayoutId;
  }

  /**
   * @return the layoutIds
   */
  public Long[] getLayoutIds() {
    return layoutIds;
  }

  /**
   * @param layoutIds the layoutIds to set
   */
  public void setLayoutIds(Long[] layoutIds) {
    this.layoutIds = layoutIds;
  }

}
