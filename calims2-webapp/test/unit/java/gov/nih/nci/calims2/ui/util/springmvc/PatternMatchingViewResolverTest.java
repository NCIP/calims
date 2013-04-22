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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.tiles2.TilesView;

/**
 * @author viseem
 * 
 */
public class PatternMatchingViewResolverTest {
  /**
   * Test a successful match.
   * 
   * @throws Exception if an error occurs in reolution
   */
  @Test
  public void testSuccessfullMatch() throws Exception {
    PatternMatchingViewResolver resolver = initResolver();
    View view = resolver.resolveViewName("hello.test", Locale.getDefault());
    assertNotNull("No view returned", view);
    assertEquals("View does not have the right class", TilesView.class, view.getClass());
    TilesView tilesView = (TilesView) view;
    assertEquals("Wrong url", "prefix.hello.test.suffix", tilesView.getUrl());
  }

  /**
   * Test an unsuccessful match.
   * 
   * @throws Exception if an error occurs in reolution
   */

  @Test
  public void testUnsuccessfullMatch() throws Exception {
    PatternMatchingViewResolver resolver = initResolver();
    View view = resolver.resolveViewName("view name that does not match anything", Locale.getDefault());
    assertNull("No view should be returned", view);
  }

  /**
   * Creates a test resolver.
   * 
   * @return The created resolver
   */
  private PatternMatchingViewResolver initResolver() {
    PatternMatchingViewResolver resolver = new PatternMatchingViewResolver();
    resolver.setApplicationContext(new GenericWebApplicationContext());
    resolver.setDefaultViewClass(TilesView.class);
    List<MatchingRule> rules = new ArrayList<MatchingRule>();
    MatchingRule rule = new MatchingRule();
    rule.setPattern("hello\\..*");
    rule.setPrefix("prefix.");
    rule.setSuffix(".suffix");
    rules.add(rule);
    resolver.setMatchingRules(rules);
    return resolver;
  }

  
  public static void main(String[]args) {
    Set<String> ids = DateTimeZone.getAvailableIDs();
    for (String id : ids) {
      System.out.println(id);
    }
    DateTime date = new DateTime();
    DateTimeFormatter formatter = DateTimeFormat.forPattern("EEE, d MMM yyyy HH:mm:ss ZZZ").withZone(DateTimeZone.forID("GMT"));
    System.out.println(date.toString(formatter));
    System.out.println(formatter.print(date));
  }
}
