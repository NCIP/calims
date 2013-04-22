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

import java.util.List;

import gov.nih.nci.calims2.domain.inventory.Coordinate;

/**
 * @author viseem
 * 
 */
public class CopySpecification {
  private List<String> baseNames;
  private Coordinate coordinate;
  private Long locationId;
  private Long parentContainerId;
  private Long templateId;

  /**
   * @return the baseNames
   */
  public List<String> getBaseNames() {
    return baseNames;
  }

  /**
   * @param baseNames the baseNames to set
   */
  public void setBaseNames(List<String> baseNames) {
    this.baseNames = baseNames;
  }

  /**
   * @return the coordinate
   */
  public Coordinate getCoordinate() {
    return coordinate;
  }

  /**
   * @param coordinate the coordinate to set
   */
  public void setCoordinate(Coordinate coordinate) {
    this.coordinate = coordinate;
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
   * @return the templateId
   */
  public Long getTemplateId() {
    return templateId;
  }

  /**
   * @param templateId the templateId to set
   */
  public void setTemplateId(Long templateId) {
    this.templateId = templateId;
  }

}
