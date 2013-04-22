/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.standardunit;

import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author katariap
 *
 */
public class StandardUnitForm extends CRUDForm<StandardUnit> {

  private static final long serialVersionUID = -6010765931860899363L;

  private Long typeId;
  private Long baseUnitId;
  
  

  /**
   * Default constructor.
   */
  public StandardUnitForm() {
    setEntity(new StandardUnit());
  }

  /**
   * {@inheritDoc}
   */
  public StandardUnit getSubmittedEntity() {
    
    StandardUnit standardUnit = getEntity();
    standardUnit.setBaseUnit(EntityWithIdHelper.createEntity(BaseUnit.class, baseUnitId));
    standardUnit.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return standardUnit;
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

  /**
   * @return the baseUnitId
   */
  public Long getBaseUnitId() {
    return baseUnitId;
  }

  /**
   * @param baseUnitId the baseUnitId to set
   */
  public void setBaseUnitId(Long baseUnitId) {
    this.baseUnitId = baseUnitId;
  }
}