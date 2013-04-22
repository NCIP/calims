/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.strain;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Strain;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author connollym
 * 
 */
public class StrainForm extends CRUDForm<Strain> {

  private static final long serialVersionUID = -6010765931860899363L;

  private Long taxonId;
  private Long typeId;

  /**
   * Default constructor.
   */
  public StrainForm() {
    setEntity(new Strain());
  }

  /**
   * {@inheritDoc}
   */
  public Strain getSubmittedEntity() {
    Strain strain = getEntity();
    strain.setNotesCollection(getNotesCollection());
    strain.setTaxon(EntityWithIdHelper.createEntity(Taxon.class, taxonId));
    strain.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return strain;
  }

  /**
   * @return the taxonId
   */
  public Long getTaxonId() {
    return taxonId;
  }

  /**
   * @param taxonId the taxonId to set
   */
  public void setTaxonId(Long taxonId) {
    this.taxonId = taxonId;
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

}
