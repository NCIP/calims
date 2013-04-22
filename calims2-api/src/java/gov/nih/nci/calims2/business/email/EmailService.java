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

/**
 * @author viseem
 *
 */
public interface EmailService {
  /**
   * Sends the given email message using the background message sending threads.
   * @param message The message to send
   */
  void send(EmailMessage message);
}
