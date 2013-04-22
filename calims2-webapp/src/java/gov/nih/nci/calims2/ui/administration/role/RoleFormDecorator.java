/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.role;

import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.FieldVisibility;
import gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;

/**
 * 
 * Form decorator for the role CRUD use case.
 * It is used to make the roleType field invisible when the role creation is invoked in a nested manner.
 * 
 * @author viseem
 *
 */
public class RoleFormDecorator extends CRUDFormDecorator {
  
  /**
   * {@inheritDoc}
   */
  public FieldVisibility getFieldVisibility(StandaloneFormElement field, String requiredSelector) {
    if ("type".equals(field.getName()) && FlowContextHolder.getContext().peek().getAttribute("roleType") != null) {
      return FieldVisibility.INVISIBLE;
    }
    return getDefaultFieldVisibility(field.getSelector(), requiredSelector);
  } 
}
