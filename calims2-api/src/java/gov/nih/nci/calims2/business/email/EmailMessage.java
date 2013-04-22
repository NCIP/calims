/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.email;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.mail.Message;

import org.apache.commons.lang.StringUtils;

/**
 * @author viseem
 *
 */
public class EmailMessage implements Cloneable {
  private String body;
  private String from;
  private String subject;
  private Map<Message.RecipientType, Set<String>> recipients = new HashMap<Message.RecipientType, Set<String>>();

  /**
   * Get the body.
   * @return Returns the body
   */
  public String getBody() {
    return body;
  }

  /**
   * Set the body.
   * @param body The body to set
   */
  public void setBody(String body) {
    this.body = body;
  }

  /**
   * Get the from.
   * @return Returns the from
   */
  public String getFrom() {
    return from;
  }

  /**
   * Set the from.
   * @param from The from to set
   */
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * Get the subject.
   * @return Returns the subject
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Set the subject.
   * @param subject The subject to set
   */
  public void setSubject(String subject) {
    this.subject = subject;
  }

  /**
   * Get the to.
   * @return Returns the to
   */
  public Map<Message.RecipientType, Set<String>> getRecipients() {
    return recipients;
  }

  /**
   * Adds a recipient email address.
   * @param recipientType The type of recipient
   * @param address The recipient email address
   */
  public void addRecipient(Message.RecipientType recipientType, String address) {
    if (StringUtils.isNotBlank(address)) {
      Set<String> addresses = recipients.get(recipientType);
      if (addresses == null) {
        addresses = new HashSet<String>();
        recipients.put(recipientType, addresses);
      }
      addresses.add(address);
    }
  }

  /**
   * Clears the to addresses Map.
   */
  public void clearRecipients() {
    recipients.clear();
  }

  /**
   * {@inheritDoc}
   */
  public EmailMessage clone() {
    try {
      EmailMessage clone = (EmailMessage) super.clone();
      if (recipients != null) {
        Map<Message.RecipientType, Set<String>> newRecipients = new HashMap<Message.RecipientType, Set<String>>();
        for (Map.Entry<Message.RecipientType, Set<String>> entry : recipients.entrySet()) {
          recipients.put(entry.getKey(), new HashSet<String>(entry.getValue()));
        }
        clone.recipients = newRecipients;
      }
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen - we support clone");
    }
  }
}