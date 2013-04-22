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

import java.io.Serializable;
import java.util.List;

import gov.nih.nci.calims2.business.inventory.container.CopySpecification;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.inventory.Container;

/**
 * @author viseem
 * 
 */
public class ContainerCopyForm implements Serializable {
  
  private static final long serialVersionUID = -1997869230880211686L;
  
  private List<String> basename;
  private String coordinateX;
  private String coordinateY;
  private String currentView;
  private String displayName;
  private Long id;
  private Long locationId;
  private Location location;
  private Long parentContainerId;
  private Container parentContainer;
  
  /**
   * Gets the copy specification object from the form. The coordinate object is not filled.
   * @return the copy specification object from the form.
   */
  public CopySpecification getSpecification() {
    CopySpecification specification = new CopySpecification();
    specification.setBaseNames(basename);
    if (locationId != null && locationId > 0) {
      specification.setLocationId(locationId);
    }
    if (parentContainerId != null && parentContainerId > 0) {
      specification.setParentContainerId(parentContainerId);
    }
    specification.setTemplateId(id);
    return specification;
  }

  /**
   * @return the basename
   */
  public List<String> getBasename() {
    return basename;
  }

  /**
   * @param basename the basename to set
   */
  public void setBasename(List<String> basename) {
    this.basename = basename;
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
   * @param currentView the currentView to set
   */
  public void setCurrentView(String currentView) {
    this.currentView = currentView;
  }

  /**
   * @return the currentView
   */
  public String getCurrentView() {
    return currentView;
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
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
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
   * @return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(Location location) {
    this.location = location;
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
   * @return the parentContainer
   */
  public Container getParentContainer() {
    return parentContainer;
  }

  /**
   * @param parentContainer the parentContainer to set
   */
  public void setParentContainer(Container parentContainer) {
    this.parentContainer = parentContainer;
  }
}
