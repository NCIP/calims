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

import java.util.regex.Pattern;

/**
 * @author viseem
 * 
 */
public class ExpirationRule {
  
  private String pattern;
  private Pattern compiledPattern;
  private int delayInSeconds = 0;

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
   * @return the compiledPattern
   */
  public Pattern getCompiledPattern() {
    return compiledPattern;
  }

  /**
   * @return the delayInSeconds
   */
  public int getDelayInSeconds() {
    return delayInSeconds;
  }

  /**
   * @param delayInSeconds the delayInSeconds to set
   */
  public void setDelayInSeconds(int delayInSeconds) {
    this.delayInSeconds = delayInSeconds;
  }

}
