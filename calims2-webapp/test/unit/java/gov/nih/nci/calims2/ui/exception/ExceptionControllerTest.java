/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author viseem
 *
 */
public class ExceptionControllerTest {
  
  private ExceptionController exceptionController = new ExceptionController();
  
  /**
   * Test the exception page controller.
   */
  @Test
  public void testException() {
    String result = exceptionController.exception();
    assertEquals("Wrong view name for exception page", ExceptionController.EXCEPTION_VIEW, result);
  }
  
  /**
   * Test the access denied page controller.
   */
  @Test
  public void testAccessDenied() {
    String result = exceptionController.accessDenied();
    assertEquals("Wrong view name for access denied page", ExceptionController.ACCESS_DENIED_VIEW, result);
  }
  
  /**
   * Test the not found page controller.
   */
  @Test
  public void testNotFound() {
    String result = exceptionController.notFound();
    assertEquals("Wrong view name for not found page", ExceptionController.NOT_FOUND_VIEW, result);
  }

}
