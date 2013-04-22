/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.workflow.taskclient;

/**
 * Configuration class for the taskServer.
 * 
 * @author viseem
 * 
 */
public class TaskServerHostConfiguration {

  private static final String DEFAULT_HOSTNAME = "127.0.0.1";
  private static final int DEFAULT_PORT = 9123;

  private String hostName = DEFAULT_HOSTNAME;

  /**
   * @return the hostName
   */
  public String getHostName() {
    return hostName;
  }

  /**
   * @param hostName the hostName to set
   */
  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  /**
   * @return the port
   */
  public int getPort() {
    return port;
  }

  /**
   * @param port the port to set
   */
  public void setPort(int port) {
    this.port = port;
  }

  private int port = DEFAULT_PORT;

}
