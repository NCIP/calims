/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.menu;

/**
 * Item implementation for calling a Url.
 * 
 * @author viseem
 *
 */
public class UrlItem extends MenuItem {

  private static final long serialVersionUID = -4693278054776630693L;
  
  private String url;

  /**
   * Default constructor.
   */
  public UrlItem() {
    super();
  }
  
  /**
   * Constructor.
   * 
   * @param displayName The display name of the item
   * @param url The url to go to
   */
  public UrlItem(String displayName, String url) {
    super(displayName);
    this.url = url;
  }

  /**
   * Constructor.
   * 
   * @param displayName The display name of the item
   * @param enabled true if enabled
   * @param url The url to go to
   */
  public UrlItem(String displayName, boolean enabled, String url) {
    super(displayName, enabled);
    this.url = url;
  }

  /**
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(MenuVisitor visitor) {
    visitor.visitUrlItem(this);
  }

}
