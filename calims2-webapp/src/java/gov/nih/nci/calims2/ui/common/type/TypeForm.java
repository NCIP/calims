/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.type;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.common.enumeration.TypeStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class TypeForm extends CRUDForm<Type> {

  private static final long serialVersionUID = -5620873889040508102L;
  private String status;
  /**
   * Default constructor.
   */
  public TypeForm() {
    setEntity(new Type());
  }

  /**
   * {@inheritDoc}
   */
  public Type getSubmittedEntity() {
    Type type = getEntity();
    StackFrame frame = FlowContextHolder.getContext().peek();
    type.setDataElementCollection((String) frame.getAttribute("dataElementCollection"));
    type.setStatus(I18nEnumerationHelper.getByName(TypeStatus.class, status));
    return type;
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
