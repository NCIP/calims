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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;

/**
 * Specification class that encapsulate the information necessary to create children containers.
 * 
 * @author viseem
 * 
 */
public class ChildrenSpecification implements Serializable {

  private static final long serialVersionUID = 6115445510726119565L;
  
  private Long containerTypeId;
  private String description;
  private String displayName;
  private Long layoutId;
  private String name;
  private List<Long> parentContainerIds = new ArrayList<Long>();
  private Set<Quantity> quantities = new HashSet<Quantity>();
  private boolean reusable;
  private ContainerStatus status;

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
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @param displayName the displayName to set
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  /**
   * @return the layoutId
   */
  public Long getLayoutId() {
    return layoutId;
  }

  /**
   * @param layoutId the layoutId to set
   */
  public void setLayoutId(Long layoutId) {
    this.layoutId = layoutId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the parentContainerIds
   */
  public List<Long> getParentContainerIds() {
    return parentContainerIds;
  }

  /**
   * @param parentContainerIds the parentContainerIds to set
   */
  public void setParentContainerIds(List<Long> parentContainerIds) {
    this.parentContainerIds = parentContainerIds;
  }

  /**
   * Adds a parent container id to this specification.
   * 
   * @param parentContainerId The parent container id to add
   * @return The parentContainerId just added
   */
  public Long addParentContainerId(Long parentContainerId) {
    parentContainerIds.add(parentContainerId);
    return parentContainerId;
  }

  /**
   * @return the quantities
   */
  public Set<Quantity> getQuantities() {
    return quantities;
  }

  /**
   * @param quantities the quantities to set
   */
  public void setQuantities(Set<Quantity> quantities) {
    this.quantities = quantities;
  }
  
  /**
   * Adds a quantity to this specification.
   * 
   * @param quantity The quantity to add
   * @return the quantity just added
   */
  public Quantity addQuantity(Quantity quantity) {
    quantities.add(quantity);
    return quantity;
  }

  /**
   * @return the reusable
   */
  public boolean isReusable() {
    return reusable;
  }

  /**
   * @param reusable the reusable to set
   */
  public void setReusable(boolean reusable) {
    this.reusable = reusable;
  }

  /**
   * @return the status
   */
  public ContainerStatus getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(ContainerStatus status) {
    this.status = status;
  }
}
