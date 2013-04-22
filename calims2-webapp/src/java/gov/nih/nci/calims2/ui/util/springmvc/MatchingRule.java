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

import java.util.regex.Pattern;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * Data holder class for the matching rules applying in the PatternMatchingViewResolver.
 * 
 * The rule specifies a pattern against which the view name is matched. If a match is found, the view is resolved to a view
 * of the given type with the prefix + viewName + suffix URL.
 * 
 * @author viseem
 * 
 */
public class MatchingRule {

  private String pattern;
  private String prefix = "";
  private String suffix = "";
  private Class<? extends AbstractUrlBasedView> viewClass;
  private Pattern compiledPattern;
  

  /**
   * @return the pattern
   */
  public String getPattern() {
    return pattern;
  }

  /**
   * @param pattern the pattern to set
   */
  public void setPattern(String pattern) {
    this.pattern = pattern;
    compiledPattern = Pattern.compile(pattern);
  }

  /**
   * @return the prefix
   */
  public String getPrefix() {
    return prefix;
  }

  /**
   * @param prefix the prefix to set
   */
  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  /**
   * @return the suffix
   */
  public String getSuffix() {
    return suffix;
  }

  /**
   * @param suffix the suffix to set
   */
  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  /**
   * @return the viewClass
   */
  public Class<? extends AbstractUrlBasedView> getViewClass() {
    return viewClass;
  }

  /**
   * @param viewClass the viewClass to set
   */
  public void setViewClass(Class<? extends AbstractUrlBasedView> viewClass) {
    this.viewClass = viewClass;
  }

  /**
   * @return the compiledPattern
   */
  public Pattern getCompiledPattern() {
    return compiledPattern;
  }

}
