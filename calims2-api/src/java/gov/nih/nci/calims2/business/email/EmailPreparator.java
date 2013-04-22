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

import java.util.Map;
import java.util.Set;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * @author viseem
 *
 */
public class EmailPreparator implements MimeMessagePreparator {

private EmailMessage message;
  
  /**
   * Constructor.
   * @param message The EmailMessage containing the data of the message to prepare
   */
  public EmailPreparator(EmailMessage message) {
    this.message = message;
  }

  /**
   * {@inheritDoc}
   */
  public void prepare(MimeMessage email) throws Exception {
    email.setFrom(new InternetAddress(message.getFrom()));
    email.setSubject(message.getSubject());
    email.setText(message.getBody());
    for (Map.Entry<Message.RecipientType, Set<String>> entry : message.getRecipients().entrySet()) {
      for (String address : entry.getValue()) {
        email.addRecipient(entry.getKey(), new InternetAddress(address));
      }
    }
  }

}
