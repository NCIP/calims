/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util.springmvc;


import java.util.List;
import java.util.Locale;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractCachingViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * ViewResolver that resolves the view names based on a list of matching rules.
 * 
 * @author viseem
 * 
 */
public class PatternMatchingViewResolver extends AbstractCachingViewResolver implements Ordered {
  
  private Class<? extends AbstractUrlBasedView> defaultViewClass;
  private List<MatchingRule> matchingRules;
  private int order = Integer.MAX_VALUE;
  
  /**
   * {@inheritDoc}
   */
  protected Object getCacheKey(String viewName, Locale locale) {
    return viewName;
  }

  /**
   * {@inheritDoc}
   */
  protected View loadView(String viewName, Locale locale) throws Exception {
    for (MatchingRule rule : matchingRules) {
      if (rule.getCompiledPattern().matcher(viewName).matches()) {
        AbstractUrlBasedView view = getViewClass(rule.getViewClass()).newInstance();
        view.setUrl(rule.getPrefix() + viewName + rule.getSuffix());
        view.setApplicationContext(getApplicationContext());
        return view;
      }
    }
    return null;
  }

  /**
   * Gets the class of the view to instantiate. If the rule does not specify the class the default view class is used
   * 
   * @param viewClass The view class specified in the rule
   * @return The class of the view to instantiate.
   */

  Class<? extends AbstractUrlBasedView> getViewClass(Class<? extends AbstractUrlBasedView> viewClass) {
    if (viewClass != null) {
      return viewClass;
    }
    if (defaultViewClass != null) {
      return defaultViewClass;
    }
    throw new IllegalArgumentException("Property 'defaultViewClass' is required for rules without viewClass");
  }

  /**
   * SetThe view class to use when no one is specified in the rules.
   * 
   * @param defaultViewClass the defaultViewClass to set
   */
  public void setDefaultViewClass(Class<? extends AbstractUrlBasedView> defaultViewClass) {
    this.defaultViewClass = defaultViewClass;
  }

  /**
   * The list of matching rules.
   * 
   * @param matchingRules the matchingRules to set
   */
  public void setMatchingRules(List<MatchingRule> matchingRules) {
    this.matchingRules = matchingRules;
  }

  /**
   * @return the order
   */
  public int getOrder() {
    return order;
  }

  /**
   * @param order the order to set
   */
  public void setOrder(int order) {
    this.order = order;
  }

}
