/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.message;

import java.util.HashSet;
import java.util.Set;

import gov.nih.nci.calims2.domain.administration.ContactInformation;

/**
 * @author viseem
 * 
 */
public class MessageForm {
  private Long[] contactInformationIds;
  private String errorKey;
  private String subject;
  private String message;
  private Set<ContactInformation> contactInformations = new HashSet<ContactInformation>();

  /**
   * @return the contactInformationIds
   */
  public Long[] getContactInformationIds() {
    return contactInformationIds;
  }

  /**
   * @param contactInformationIds the contactInformationIds to set
   */
  public void setContactInformationIds(Long[] contactInformationIds) {
    this.contactInformationIds = contactInformationIds;
  }

  /**
   * @return the subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * @param subject the subject to set
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * @return the errorKey
   */
  public String getErrorKey() {
    return errorKey;
  }

  /**
   * @param errorKey the errorKey to set
   */
  public void setErrorKey(String errorKey) {
    this.errorKey = errorKey;
  }

  /**
   * @return the contactInformations
   */
  public Set<ContactInformation> getContactInformations() {
    return contactInformations;
  }

  /**
   * @param contactInformations the contactInformations to set
   */
  public void setContactInformations(Set<ContactInformation> contactInformations) {
    this.contactInformations = contactInformations;
  }
}
