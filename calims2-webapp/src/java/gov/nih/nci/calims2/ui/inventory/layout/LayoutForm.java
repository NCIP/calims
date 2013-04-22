/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.layout;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 * 
 */
public class LayoutForm extends CRUDForm<Layout> {

  private static final long serialVersionUID = -6324626658231309595L;
  
  private Long personId;
  private String labelTypeX;
  private String labelTypeY;

  /**
   * Default constructor.
   */
  public LayoutForm() {
    setEntity(new Layout());
  }

  /**
   * {@inheritDoc}
   */
  
  public Layout getSubmittedEntity() {
    Layout layout = getEntity();
    layout.setNotesCollection(getNotesCollection());
    layout.setPerson(EntityWithIdHelper.createEntity(Person.class, personId));
    layout.setX_dimensionLabel(I18nEnumerationHelper.getByName(LayoutLabelType.class, labelTypeX));
    layout.setY_dimensionLabel(I18nEnumerationHelper.getByName(LayoutLabelType.class, labelTypeY));
    return layout;
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
   * @return the labelTypeX
   */
  public String getLabelTypeX() {
    return labelTypeX;
  }

  /**
   * @param labelTypeX the labelTypeX to set
   */
  public void setLabelTypeX(String labelTypeX) {
    this.labelTypeX = labelTypeX;
  }

  /**
   * @return the labelTypeY
   */
  public String getLabelTypeY() {
    return labelTypeY;
  }

  /**
   * @param labelTypeY the labelTypeY to set
   */
  public void setLabelTypeY(String labelTypeY) {
    this.labelTypeY = labelTypeY;
  }

}
