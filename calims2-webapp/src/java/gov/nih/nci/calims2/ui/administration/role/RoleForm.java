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

import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap@moxieinformatics.com
 * 
 */
public class RoleForm extends CRUDForm<Role> {

  private static final long serialVersionUID = 7760562357201800981L;
  
  private String status;
  private String type;

  /**
   * Default constructor.
   */
  public RoleForm() {
    setEntity(new Role());
  }

  /**
   * {@inheritDoc}
   */
  public Role getSubmittedEntity() {
    Role role = getEntity();
    role.setNotesCollection(getNotesCollection());
    String roleType = (String) FlowContextHolder.getContext().peek().getAttribute("roleType");
    if (roleType != null) {
      type = roleType;
    }
    role.setStatus(I18nEnumerationHelper.getByName(RoleStatus.class, status));
    role.setType(I18nEnumerationHelper.getByName(RoleType.class, type));
    return role;
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
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

}
