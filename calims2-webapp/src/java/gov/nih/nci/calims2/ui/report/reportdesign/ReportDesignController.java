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

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus;
import gov.nih.nci.calims2.domain.report.ReportDesign;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.report.query.QueriedEntity;
import gov.nih.nci.calims2.ui.util.multipartfile.MultipartFileHelper;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 * 
 */
@Controller
@RequestMapping(ReportDesignController.URL_PREFIX)
public class ReportDesignController extends CRUDController<ReportDesign> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/report/reportdesign";

  private String tempfiledir;
  private MultipartFileHelper multipartFileHelper;

  /**
   * Default constructor.
   */
  public ReportDesignController() {
    super(URL_PREFIX, "name");
  }

  /**
   * {@inheritDoc}
   */
  public void completeEditForm(CRUDForm<ReportDesign> form, ReportDesign entity) {
    ((ReportDesignForm) form).setQueriedEntity(QueriedEntity.getByPersistentClass(entity.getMainEntity()));
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("mainEntities", I18nEnumerationHelper.getLocalizedValues(QueriedEntity.class, locale));
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void completeExtraction(CRUDForm<ReportDesign> pform) {
    ReportDesignForm form = (ReportDesignForm) pform;
    File jrxmlFile;
    try {
      jrxmlFile = multipartFileHelper.saveMultipart(form.getFileData(), new File(tempfiledir));
      if (jrxmlFile != null) {
        Document document = new Document();
        document.setName(form.getFileData().getOriginalFilename());
        document.setDisplayName(form.getFileData().getOriginalFilename());
        document.setUniversalResourceLocator(jrxmlFile.getAbsolutePath());
        document.setStatus(DocumentStatus.CURRENT);
        form.getEntity().setDocument(document);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @param request The servlet request.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") ReportDesignForm form, Locale locale, HttpServletRequest request) {
    return doSave(form, locale);
  }

  /**
   * @param reportDesignService the reportDesignService to set
   */
  @Resource(name = "reportDesignService")
  public void setMainService(GenericService<ReportDesign> reportDesignService) {
    super.setMainService(reportDesignService);
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "reportDesignFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "reportDesignTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

  /**
   * @param tempfiledir the tempfiledir to set
   */
  @Resource(name = "tempfiledir")
  public void setTempfiledir(String tempfiledir) {
    this.tempfiledir = tempfiledir;
  }

  /**
   * @param multipartFileHelper the multipartFileHelper to set
   */
  @Resource(name = "multipartFileHelper")
  public void setMultipartFileHelper(MultipartFileHelper multipartFileHelper) {
    this.multipartFileHelper = multipartFileHelper;
  }

}
