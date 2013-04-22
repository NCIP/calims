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

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.SendFailedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author viseem
 * 
 */
public class EmailSenderTask implements Runnable {
  private static Logger log = LoggerFactory.getLogger(EmailSenderTask.class);

  private EmailServiceImpl emailBean;
  private JavaMailSender mailSender;
  private int numberOfRetry;
  private EmailMessage message;

  /**
   * Constructor.
   * 
   * @param emailBean The Email Bean implementation
   * @param mailSender The mail sender
   * @param numberOfRetry The number of retry for this sending task;
   * @param message The message to send
   */
  public EmailSenderTask(EmailServiceImpl emailBean, JavaMailSender mailSender, int numberOfRetry, EmailMessage message) {
    this.emailBean = emailBean;
    this.mailSender = mailSender;
    this.numberOfRetry = numberOfRetry;
    this.message = message;
  }

  /**
   * {@inheritDoc}
   */
  public void run() {
    boolean retry = sendMessage();
    if (retry) {
      if (numberOfRetry > 0) {
        numberOfRetry--;
        emailBean.reschedule(this);
      } else {
        log.error("All Message sending attempts have failed - Nothing will be sent");
      }
    }
  }

  /**
   * Tries to send the message. If the first attempt fails because of some invalid address, the send is retried with only valid
   * addresses
   * 
   * @return true if the sending should be retried later
   */
  private boolean sendMessage() {
    boolean retry = false;
    try {
      mailSender.send(new EmailPreparator(message));
    } catch (MailSendException e) {
      log.debug("Exception sending Email", e);
      Exception[] exceptions = e.getMessageExceptions();
      if (exceptions != null && exceptions.length > 0 && exceptions[0] instanceof SendFailedException) {
        SendFailedException sf = (SendFailedException) exceptions[0];
        Address[] remainingAddresses = sf.getValidUnsentAddresses();
        if (remainingAddresses == null || remainingAddresses.length == 0) {
          log.error("Message does not contain any valid address - Nothing will be sent");
          retry = false;
        } else {
          EmailMessage email = message.clone();
          email.clearRecipients();
          for (Address address : remainingAddresses) {
            email.addRecipient(Message.RecipientType.BCC, address.toString());
          }
          try {
            mailSender.send(new EmailPreparator(message));
          } catch (MailSendException e2) {
            retry = true;
          }
        }
      } else {
        retry = true;
      }
    }
    return retry;
  }

}
