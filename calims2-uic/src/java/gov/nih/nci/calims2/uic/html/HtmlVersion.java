/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.html;

/**
 * Enumeration of Html versions.
 * 
 * @author viseem
 *
 */
public enum HtmlVersion {
  /** XHTML 1.0 strict. */
  XHTML10_STRICT("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "
                 + "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
  
  private String dtd;
  
  HtmlVersion(String dtd) {
    this.dtd = dtd;
  }

  /**
   * @return the dtd
   */
  public String getDtd() {
    return dtd;
  }

}
