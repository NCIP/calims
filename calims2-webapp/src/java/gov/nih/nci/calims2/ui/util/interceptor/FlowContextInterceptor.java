/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util.interceptor;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author viseem
 * 
 */
public class FlowContextInterceptor extends HandlerInterceptorAdapter {
  
  private Set<Class<?>> excludedHandlerClasses = new HashSet<Class<?>>();

  /**
   * The name of the request parameter that stores the context.
   */
  public static final String CONTEXT_PARAM = "flowContext";
  private static final String RESTORED_ATTR = FlowContextInterceptor.class.getName() + ":RESTORED";

  /**
   * {@inheritDoc}
   */
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if (excludedHandlerClasses.contains(handler.getClass())) {
      return true;
    }
    restoreContext(request);
    return true;
  }

  /**
   * {@inheritDoc}
   */
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    if (excludedHandlerClasses.contains(handler.getClass())) {
      return;
    }
    persistContext(request);
    clearContext();
  }

  /**
   * Restore the context for the incoming request.
   * 
   * @param request The current request
   */
  @SuppressWarnings("unchecked")
  void restoreContext(HttpServletRequest request) {
    if (request.getAttribute(RESTORED_ATTR) != null) {
      return;
    }
    request.setAttribute(RESTORED_ATTR, "true");
    String context = request.getParameter(CONTEXT_PARAM);
    if (context != null) {
      if (context.startsWith(FlowContextHolder.ATTRIBUTE_PREFIX)) {
        HttpSession session = request.getSession();
        FlowContextHolder.setContext((Stack<StackFrame>) session.getAttribute(context));
        session.removeAttribute(context);
      } else {
        FlowContextHolder.setSerializedContext(context);
      }
    } else {
      FlowContextHolder.newContext();
    }
    FlowContextHolder.setPersistAttribute("");
  }

  /**
   * Persist the context in the session if necessary.
   * 
   * @param request The current request
   */
  void persistContext(HttpServletRequest request) {
    String persistAttribute = FlowContextHolder.getPersistAttribute();
    if (persistAttribute != null && !"".equals(persistAttribute)) {
      HttpSession session = request.getSession();
      session.setAttribute(persistAttribute, FlowContextHolder.getContext());
    }
  }

  /**
   * Clear the context at the end of the request processing.
   */
  void clearContext() {
    FlowContextHolder.removeContext();
    FlowContextHolder.removePersistAttribute();
  }

  /**
   * @param excludedHandlerClasses the excludedHandlerClasses to set
   */
  public void setExcludedHandlerClasses(Set<Class<?>> excludedHandlerClasses) {
    this.excludedHandlerClasses = excludedHandlerClasses;
  }

}
