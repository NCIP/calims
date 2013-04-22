/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class CRUDControllerConfigTest {

  /**
   * Test the getForwardUrl method.
   */
  @Test
  public void testGetForwardUrl() {
    CRUDControllerConfig config = new CRUDControllerConfig();
    config.setUrlPrefix("urlPrefix");
    String result = config.getForwardUrl("command");
    assertEquals("Wrong ForwardUrl returned", "urlPrefixcommand", result);
  }

  /**
   * Test the getRedirectUrl method.
   */
  @Test
  public void testGetRedirectUrl() {
    CRUDControllerConfig config = new CRUDControllerConfig();
    config.setUrlPrefix("urlPrefix");
    String result = config.getRedirectUrl("command");
    assertEquals("Wrong RedirectUrl returned", "redirect:urlPrefixcommand", result);
  }

  /**
   * Test the getFullViewName method.
   */
  @Test
  public void testGetFullViewName() {
    CRUDControllerConfig config = new CRUDControllerConfig();
    config.setViewPrefix("viewPrefix");
    String result = config.getFullViewName("viewName");
    assertEquals("Wrong full view name returned", "viewPrefixviewName", result);
  }

  /**
   * Test the getFullViewName method.
   */
  @Test
  public void testGetFull() {
    CRUDControllerConfig config = new CRUDControllerConfig();
    config.setViewPrefix("viewPrefix");
    String urlPrefix = "/module/submodule";
    config.setUrlAndViewPrefixes(urlPrefix);
    assertEquals("Wrong urlPrefix returned", urlPrefix, config.getUrlPrefix());
    assertEquals("Wrong viewPrefix returned", "module.submodule.", config.getViewPrefix());
  }

}
