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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author viseem
 *
 */
public class EmailServiceImpl implements EmailService {

  private static Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);
  
  private static final int DEFAULT_POOL_SIZE = 5;
  private static final int DEFAULT_NUMBER_OF_RETRY = 1;
  private static final int DEFAULT_RETRY_PERIOD_IN_SECONDS = 30;
  private static final int DEFAULT_TERMINATION_PERIOD_IN_SECONDS = 60;
  
  private JavaMailSender mailSender;
  private int poolSize = DEFAULT_POOL_SIZE;
  private int numberOfRetry = DEFAULT_NUMBER_OF_RETRY;
  private int retryPeriodInSeconds = DEFAULT_RETRY_PERIOD_IN_SECONDS;
  private ScheduledExecutorService executor;
  
  /**
   * Initialize the engine.
   */
  public synchronized void init() {
    executor = Executors.newScheduledThreadPool(poolSize);
  }
  
  /**
   * Shutdown the engine.
   */
  public void shutdown() {
    log.debug("Starting email engine shutdown");
    executor.shutdownNow();
    try {
      executor.awaitTermination(DEFAULT_TERMINATION_PERIOD_IN_SECONDS, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      log.debug("Main thread Interrupted during email engine shutdown");
    }
    log.debug("Ending email engine shutdown");
  }
  
  /**
   * {@inheritDoc}
   */
  public void send(EmailMessage message) {
    log.debug("Received Message to send");
    if (executor.isShutdown()) {
      log.debug("Engine is Shot Down - Message will not be processed");
      return;
    }
    EmailSenderTask  task = new EmailSenderTask(this, mailSender, numberOfRetry, message);
    executor.schedule(task, 0, TimeUnit.SECONDS);
  }
  
  /**
   * Reschedule the given task.
   * @param task The task to reschedule
   */
  public void reschedule(EmailSenderTask task) {
    if (executor.isShutdown()) {
      log.debug("Engine is Shot Down - Message resend will not be processed");
      return;
    }
    executor.schedule(task, retryPeriodInSeconds, TimeUnit.SECONDS);
  }

  /**
   * Set the mailSender.
   * @param mailSender The mailSender to set
   */
  public void setMailSender(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  /**
   * Set the poolSize.
   * @param poolSize The poolSize to set
   */
  public void setPoolSize(int poolSize) {
    this.poolSize = poolSize;
  }

  /**
   * Set the numberOfRetry.
   * @param numberOfRetry The numberOfRetry to set
   */
  public void setNumberOfRetry(int numberOfRetry) {
    if (numberOfRetry >= 0) {
      this.numberOfRetry = numberOfRetry;
    }
  }

  /**
   * Set the retryPeriodInSeconds.
   * @param retryPeriodInSeconds The retryPeriodInSeconds to set
   */
  public void setRetryPeriodInSeconds(int retryPeriodInSeconds) {
    if (retryPeriodInSeconds >= 0) {
      this.retryPeriodInSeconds = retryPeriodInSeconds;
    }
  }

}
