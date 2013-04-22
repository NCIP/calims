/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.flow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Base implementation of StackFrame. It should be extended by subclasses that need to statically define context attributes.
 * 
 * @author viseem
 * 
 */
public class BaseStackFrame implements StackFrame {

  private static final long serialVersionUID = 1723583534782875753L;
  
  private Map<String, Serializable> attributes = new HashMap<String, Serializable>();
  private String returnUrl;
  private Map<String, Serializable> returnValues = new HashMap<String, Serializable>();

  /**
   * {@inheritDoc}
   */
  public void addAttribute(String key, Serializable value) {
    attributes.put(key, value);
  }

  /**
   * {@inheritDoc}
   */
  public Serializable getAttribute(String key) {
    return attributes.get(key);
  }

  /**
   * {@inheritDoc}
   */
  public Serializable removeAttribute(String key) {
    return attributes.remove(key);
  }

  /**
   * {@inheritDoc}
   */
  public void clearAttributes() {
    attributes.clear();
  }

  /**
   * @return the returnUrl
   */
  public String getReturnUrl() {
    return returnUrl;
  }

  /**
   * @param returnUrl the returnUrl to set
   */
  public void setReturnUrl(String returnUrl) {
    this.returnUrl = returnUrl;
  }

  /**
   * {@inheritDoc}
   */
  public void addReturnValue(String key, Serializable value) {
    returnValues.put(key, value);
  }

  /**
   * {@inheritDoc}
   */
  public Serializable getReturnValue(String key) {
    return returnValues.get(key);
  }

  /**
   * {@inheritDoc}
   */
  public void clear() {
    returnUrl = null;
    returnValues.clear();
  }

}
