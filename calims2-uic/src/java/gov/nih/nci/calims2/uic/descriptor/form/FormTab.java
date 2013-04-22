/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor.form;

/**
 * @author viseem
 *
 */
public class FormTab extends CompositeFormElement {
  
  private static final long serialVersionUID = 3061187096119878451L;
  
  private String footer;
  private String header;
  private String name;
  
  /**
   * @return the footer
   */
  public String getFooter() {
    return footer;
  }

  /**
   * @param footer the footer to set
   */
  public void setFooter(String footer) {
    this.footer = footer;
  }

  /**
   * @return the header
   */
  public String getHeader() {
    return header;
  }

  /**
   * @param header the header to set
   */
  public void setHeader(String header) {
    this.header = header;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.FORM_TAB;
  }
  
  /**
   * {@inheritDoc}
   */
  public FormTab clone() {
    return (FormTab) super.clone();
  }
}
