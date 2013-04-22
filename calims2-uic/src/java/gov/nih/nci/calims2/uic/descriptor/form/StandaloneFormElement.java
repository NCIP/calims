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

import java.util.List;


/**
 * @author viseem
 * 
 */
public abstract class StandaloneFormElement implements FormElement {

  private static final long serialVersionUID = 847471470493394726L;
  
  private String access;
  private String id;
  private String name;
  private String selector;
  private String style;
  private String styleClass;

  /**
   * {@inheritDoc}
   */
  public <T extends FormElement> T addChild(T child) {
    return child;
  }

  /**
   * {@inheritDoc}
   */
  public List<FormElement> getChildren() {
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
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
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
   * @return the style
   */
  public String getStyle() {
    return style;
  }

  /**
   * @param style the style to set
   */
  public void setStyle(String style) {
    this.style = style;
  }

  /**
   * @return the styleClass
   */
  public String getStyleClass() {
    return styleClass;
  }

  /**
   * @param styleClass the styleClass to set
   */
  public void setStyleClass(String styleClass) {
    this.styleClass = styleClass;
  }

  /**
   * {@inheritDoc}
   */
  public StandaloneFormElement clone() {
    try {
      return (StandaloneFormElement) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Subclasses supports clone.");
    }
  }

}
