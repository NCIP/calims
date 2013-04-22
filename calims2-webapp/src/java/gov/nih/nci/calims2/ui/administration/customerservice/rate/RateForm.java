/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.rate;

import java.util.Set;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.RateStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityFormHelper;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class RateForm extends CRUDForm<Rate> {

  private static final long serialVersionUID = 2035585417095028305L;

  private Long typeId;
  private Long personId;
  private String status;
  private QuantityFormHelper quantities = new QuantityFormHelper();

  /**
   * Default constructor.
   */
  public RateForm() {
    setEntity(new Rate());
  }

  /**
   * {@inheritDoc}
   */
  public Rate getSubmittedEntity() {
    Rate rate = getEntity();
    rate.setContactPerson(EntityWithIdHelper.createEntity(Person.class, personId));
    rate.setNotesCollection(getNotesCollection());
    rate.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    rate.setStatus(I18nEnumerationHelper.getByName(RateStatus.class, status));
    Set<Quantity> quantitySet = quantities.getQuantities();
    if (!quantitySet.isEmpty()) {
      rate.setQuantity(quantities.getQuantities().iterator().next());
    }
    return rate;
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
   * @return the personId
   */
  public Long getPersonId() {
    return personId;
  }

  /**
   * @param personId the personId to set
   */
  public void setPersonId(Long personId) {
    this.personId = personId;
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

}
