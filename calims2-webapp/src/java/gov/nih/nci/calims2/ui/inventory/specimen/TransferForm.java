/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.specimen;

import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.business.inventory.specimen.SpecimenTransfer;

/**
 * @author viseem
 * 
 */
public class TransferForm {

  private Long sourceId;
  private Long targetId;
  private Long targetCategoryId;
  private Long targetSubcategoryId;
  private Long targetTypeId;
  private List<Long> container;
  private List<Long> specimen;

  /**
   * Gets the list of submitted transfers.
   * 
   * @return The list of submitted transfers.
   */
  public List<SpecimenTransfer> getTransfers() {
    List<SpecimenTransfer> transfers = new ArrayList<SpecimenTransfer>();
    if (container != null) {
      for (int i = 0; i < container.size(); i++) {
        Long containerId = container.get(i);
        if (containerId != null) {
          SpecimenTransfer transfer = new SpecimenTransfer();
          transfer.setContainerId(containerId);
          transfer.setSpecimenId(specimen.get(i));
          transfers.add(transfer);
        }
      }
    }
    return transfers;
  }

  /**
   * @return the sourceId
   */
  public Long getSourceId() {
    return sourceId;
  }

  /**
   * @param sourceId the sourceId to set
   */
  public void setSourceId(Long sourceId) {
    this.sourceId = sourceId;
  }

  /**
   * @return the targetId
   */
  public Long getTargetId() {
    return targetId;
  }

  /**
   * @param targetId the targetId to set
   */
  public void setTargetId(Long targetId) {
    this.targetId = targetId;
  }

  /**
   * @return the targetCategoryId
   */
  public Long getTargetCategoryId() {
    return targetCategoryId;
  }

  /**
   * @param targetCategoryId the targetCategoryId to set
   */
  public void setTargetCategoryId(Long targetCategoryId) {
    this.targetCategoryId = targetCategoryId;
  }

  /**
   * @return the targetSubcategoryId
   */
  public Long getTargetSubcategoryId() {
    return targetSubcategoryId;
  }

  /**
   * @param targetSubcategoryId the targetSubcategoryId to set
   */
  public void setTargetSubcategoryId(Long targetSubcategoryId) {
    this.targetSubcategoryId = targetSubcategoryId;
  }

  /**
   * @return the targetTypeId
   */
  public Long getTargetTypeId() {
    return targetTypeId;
  }

  /**
   * @param targetTypeId the targetTypeId to set
   */
  public void setTargetTypeId(Long targetTypeId) {
    this.targetTypeId = targetTypeId;
  }

  /**
   * @return the container
   */
  public List<Long> getContainer() {
    return container;
  }

  /**
   * @param container the container to set
   */
  public void setContainer(List<Long> container) {
    this.container = container;
  }

  /**
   * @return the specimen
   */
  public List<Long> getSpecimen() {
    return specimen;
  }

  /**
   * @param specimen the specimen to set
   */
  public void setSpecimen(List<Long> specimen) {
    this.specimen = specimen;
  }

}
