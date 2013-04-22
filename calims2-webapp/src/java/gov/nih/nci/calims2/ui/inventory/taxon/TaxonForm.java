/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.taxon;

import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.domain.inventory.enumeration.TaxonStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
public class TaxonForm extends CRUDForm<Taxon> {

  private static final long serialVersionUID = -6010765931860899363L;

  private String status;

  /**
   * Default constructor.
   */
  public TaxonForm() {
    setEntity(new Taxon());
  }

  /**
   * {@inheritDoc}
   */
  public Taxon getSubmittedEntity() {
    Taxon taxon = getEntity();
    taxon.setNotesCollection(getNotesCollection());
    taxon.setStatus(I18nEnumerationHelper.getByName(TaxonStatus.class, status));
    return taxon;
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

}
