/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.specimen;

import gov.nih.nci.calims2.business.generic.CRUDEventListenerAdapter;
import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.inventory.Specimen;

/**
 * @author katariap
 * 
 */
public class SpecimenCRUDEventListener extends CRUDEventListenerAdapter<Specimen> {

  private GenericDao genericDao;

  /**
   * @param inputEntity The input entity
   * @return return
   */
  public Specimen beforeCreate(Specimen inputEntity) {
    long specimenId = genericDao.getNextValue("specimen_sequence");
    inputEntity.setName(inputEntity.getName() + "_" + specimenId);
    inputEntity.setDisplayName(inputEntity.getDisplayName() + "_" + specimenId);
    return inputEntity;
  }

  /**
   * @param genericDao the genericDao to set
   */
  public void setGenericDao(GenericDao genericDao) {
    this.genericDao = genericDao;
  }

}
