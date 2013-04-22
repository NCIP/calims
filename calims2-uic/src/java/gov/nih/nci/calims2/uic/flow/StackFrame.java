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

/**
 * Interface for stack frames to be used for page flow nesting.
 * 
 * @author viseem
 * 
 */
public interface StackFrame extends Serializable {
  /**
   * Adds an attribute to this stack frame.
   * 
   * @param key The key of the attribute
   * @param value The return value.
   */
  void addAttribute(String key, Serializable value);

  /**
   * Gets an attribute from this stack frame.
   * 
   * @param key The key of the attribute
   * @return The attribute with the given key.
   */
  Serializable getAttribute(String key);

  /**
   * Removes an attribute from this stack frame.
   * 
   * @param key The key of the attribute
   * @return The attribute with the given key.
   */
  Serializable removeAttribute(String key);

  /**
   * Clears the attributes of this stack frame.
   */
  void clearAttributes();

  /**
   * Gets the return url for this stack frame.
   * 
   * @return The return url for this stack frame.
   */
  String getReturnUrl();

  /**
   * Set the return url for this stack frame.
   * 
   * @param returnUrl tThe return url for this stack frame.
   */
  void setReturnUrl(String returnUrl);

  /**
   * Adds a return value to this stack frame.
   * 
   * @param key The key of the return value
   * @param value The return value.
   */
  void addReturnValue(String key, Serializable value);

  /**
   * Gets a return value from this stack frame.
   * 
   * @param key The key of the return value
   * @return The return value with the given key.
   */
  Serializable getReturnValue(String key);

  /**
   * Clears the return url and return values of this stack frame.
   */
  void clear();

}
