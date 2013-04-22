/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

/**
 * @author viseem
 * 
 */
public class ExpirationFilter implements Filter {

  private static final String EXPIRES_HEADER = "Expires";
  private static final String CACHE_CONTROL_HEADER = "Cache-Control";
  private static final String NOCACHE_HEADER = "max-age=0, must-revalidate, no-cache";

  private List<ExpirationRule> rules;

  /**
   * {@inheritDoc}
   */
  public void init(FilterConfig filterConfig) throws ServletException {
    // Nothing to do
  }

  /**
   * {@inheritDoc}
   */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    String uri = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
    boolean unmatched = true;
    for (ExpirationRule rule : rules) {
      if (rule.getCompiledPattern().matcher(uri).matches()) {
        DateTime expirationDate = new DateTime().plusSeconds(rule.getDelayInSeconds());
        httpResponse.setDateHeader(EXPIRES_HEADER, expirationDate.getMillis());
        unmatched = false;
        break;
      }
    }
    if (unmatched) {
      httpResponse.setHeader(CACHE_CONTROL_HEADER, NOCACHE_HEADER);
    }
    chain.doFilter(request, response);
  }

  /**
   * {@inheritDoc}
   */
  public void destroy() {
    // Nothing to do
  }

  /**
   * @return the rules
   */
  public List<ExpirationRule> getRules() {
    return rules;
  }

  /**
   * @param rules the rules to set
   */
  public void setRules(List<ExpirationRule> rules) {
    this.rules = rules;
  }

}
