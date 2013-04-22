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
import java.util.Date;
import java.util.Stack;

import gov.nih.nci.calims2.util.serialization.SerializationHelper;

/**
 * @author viseem
 * 
 */
public class FlowContextHolder {
  
  /**
   * The prefix used in the persist attribute.
   */
  public static final String ATTRIBUTE_PREFIX = "context:";

  private static ThreadLocal<Stack<StackFrame>> holder = new ThreadLocal<Stack<StackFrame>>();
  private static ThreadLocal<String> persistFlagHolder = new ThreadLocal<String>();

  /**
   * Sets the context of the current thread.
   * 
   * @param context The context to bind to the current thread
   */
  public static void setContext(Stack<StackFrame> context) {
    holder.set(context);
  }

  /**
   * Gets the context bounded to the current thread.
   * 
   * @return The context bounded to the current thread.
   */
  public static Stack<StackFrame> getContext() {
    return holder.get();
  }
  
  /**
   * lookUp for an attribute in the stack. The value returned is the last value pushed under the given name.
   * 
   * @param attributeName The name of the attribute
   * @return The value of the attribute or null if it does not exist in any stack frame.
   */
  public static Serializable lookUpAttribute(String attributeName) {
    Stack<StackFrame> context = getContext();
    for (int i = context.size() - 1; i >= 0; i--) {
      StackFrame frame = context.get(i);
      Serializable value = frame.getAttribute(attributeName);
      if (value != null) {
        return value;
      }
    }
    return null;
  }

  /**
   * Sets the context of the current thread.
   * 
   * @param serializedContext The context to bind to the current thread in serialized form
   */
  @SuppressWarnings("unchecked")
  public static void setSerializedContext(String serializedContext) {
    Stack<StackFrame> context = (Stack<StackFrame>) SerializationHelper.deserializeFromHex(serializedContext);
    setContext(context);
  }

  /**
   * Gets the context bounded to the current thread.
   * 
   * @return The context bounded to the current thread in serialized form.
   */
  public static String getSerializedContext() {
    return SerializationHelper.serializeToHex(getContext());
  }

  /**
   * Creates a new context and binds it to the current thread.
   * 
   * @return The new context.
   */
  public static Stack<StackFrame> newContext() {
    Stack<StackFrame> context = new Stack<StackFrame>();
    setContext(context);
    return context;
  }

  /**
   * Removes the context bound to the current thread.
   */
  public static void removeContext() {
    holder.remove();
  }

  /**
   * Return a unique string value of the persist attribute for the given persisterClient and persists it.
   * 
   * @param persisterClient The client instance
   * @return a unique string value of the persist attribute for the given persisterClient.
   */
  public static String setPersistAttributeForClient(Object persisterClient) {
    String persistAttribute = ATTRIBUTE_PREFIX + persisterClient.getClass().getName() + new Date().getTime();
    setPersistAttribute(persistAttribute);
    return persistAttribute;
  }

  /**
   * Sets the new value of the persist attribute.
   * 
   * @param persistAttribute The persist attribute value
   */
  public static void setPersistAttribute(String persistAttribute) {
    persistFlagHolder.set(persistAttribute);
  }

  /**
   * Gets the persist attribute value.
   * 
   * @return The persist attribute value
   */
  public static String getPersistAttribute() {
    return persistFlagHolder.get();
  }

  /**
   * Removes the persist attribute.
   */
  public static void removePersistAttribute() {
    persistFlagHolder.remove();
  }

}
