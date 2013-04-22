/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.service;

import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.FieldVisibility;
import gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;

/**
 * @author connollym
 *
 */
public class ServiceFormDecorator extends CRUDFormDecorator {
  
  /**
   * {@inheritDoc}
   */
  public FieldVisibility getFieldVisibility(StandaloneFormElement field, String requiredSelector) {
    if ("type".equals(field.getName())) {
      if (!getPrivilegeEvaluator().hasRole("ROLE_CUSTOMER_REQUEST_MANAGER_ACCESS")) {
        return FieldVisibility.INVISIBLE;
      }
      
    }
    if ("status".equals(field.getName()) && FlowContextHolder.getContext().peek().getAttribute("template") != null) {
      return FieldVisibility.INVISIBLE;
    }
    return getDefaultFieldVisibility(field.getSelector(), requiredSelector);
  } 

}
