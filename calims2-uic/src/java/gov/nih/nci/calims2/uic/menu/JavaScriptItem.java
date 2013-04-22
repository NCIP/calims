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
 * Item implementation for calling a javascript function.
 * 
 * @author viseem
 * 
 */
public class JavaScriptItem extends MenuItem {

  private static final long serialVersionUID = 2767367221139594043L;
  
  private String javascriptFunction;
  
  /**
   * Default constructor.
   */
  public JavaScriptItem() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param displayName The display name of the item
   * @param javascriptFunction The javascript function to call
   */
  public JavaScriptItem(String displayName, String javascriptFunction) {
    super(displayName);
    this.javascriptFunction = javascriptFunction;
  }

  /**
   * Constructor.
   * 
   * @param displayName The display name of the item
   * @param enabled true if enabled
   * @param javascriptFunction The javascript function to call
   */
  public JavaScriptItem(String displayName, boolean enabled, String javascriptFunction) {
    super(displayName, enabled);
    this.javascriptFunction = javascriptFunction;
  }

  /**
   * @return the javascriptFunction
   */
  public String getJavascriptFunction() {
    return javascriptFunction;
  }

  /**
   * @param javascriptFunction the javascriptFunction to set
   */
  public void setJavascriptFunction(String javascriptFunction) {
    this.javascriptFunction = javascriptFunction;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(MenuVisitor visitor) {
    visitor.visitJavaScriptItem(this);
  }

}
