/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor.command;

import java.util.List;


/**
 * @author viseem
 * 
 */
public class Command implements CommandElement {

  private static final long serialVersionUID = 4433010559216391829L;
  
  private String access;
  private String iconClass;
  private String javascriptFunction;
  private String name;
  private String selector;
  private String tab;
  private String type = "submit";
  private String url;
  private boolean validate;
  
  /**
   * {@inheritDoc}
   */
  public <T extends CommandElement> T addChild(T child) {
    return child;
  }

  /**
   * {@inheritDoc}
   */
  public List<CommandElement> getChildren() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isComposite() {
    return false;
  }

  /**
   * @return the access
   */
  public String getAccess() {
    return access;
  }

  /**
   * @param access the access to set
   */
  public void setAccess(String access) {
    this.access = access;
  }

  /**
   * @return the iconClass
   */
  public String getIconClass() {
    return iconClass;
  }

  /**
   * @param iconClass the iconClass to set
   */
  public void setIconClass(String iconClass) {
    this.iconClass = iconClass;
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
   * @return the selector
   */
  public String getSelector() {
    return selector;
  }

  /**
   * @param selector the selector to set
   */
  public void setSelector(String selector) {
    this.selector = selector;
  }

  /**
   * @return the tab
   */
  public String getTab() {
    return tab;
  }

  /**
   * @param tab the tab to set
   */
  public void setTab(String tab) {
    this.tab = tab;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
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
   * @return the validate
   */
  public boolean isValidate() {
    return validate;
  }

  /**
   * @param validate the validate to set
   */
  public void setValidate(boolean validate) {
    this.validate = validate;
  }

  /**
   * {@inheritDoc}
   */
  public Command clone() {
    try {
      return (Command) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Subclasses supports clone.");
    }
  }

 
}
