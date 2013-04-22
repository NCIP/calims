/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.reportdesign;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.report.ReportDesign;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.report.query.QueriedEntity;

/**
 * @author connollym
 *
 */
public class ReportDesignControllerTest {
  
  private String tempfiledir;
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    ReportDesignController controller = new ReportDesignController();
    CRUDAssert.assertControllerConstructor(controller, ReportDesignController.URL_PREFIX, "report.reportdesign.", "name", 
        ReportDesign.class,
        ReportDesignForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    ReportDesignController controller = new ReportDesignController();
    ModelAndView model = new ModelAndView();
    ReportDesignForm form = new ReportDesignForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "mainEntities", QueriedEntity.class);
  }
  
  /**
   * @param tempfiledir the tempfiledir to set
   */
  @Resource(name = "tempfiledir")
  public void setTempfiledir(String tempfiledir) {
    this.tempfiledir = tempfiledir;
  }
}
