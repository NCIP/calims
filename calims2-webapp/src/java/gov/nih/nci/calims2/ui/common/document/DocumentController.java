/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.storage.StorageService;
import gov.nih.nci.calims2.business.storage.StorageServiceException;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.util.multipartfile.MultipartFileHelper;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(DocumentController.URL_PREFIX)
public class DocumentController extends CRUDController<Document> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/common/document";
  
  private String tempfiledir;
  private MultipartFileHelper multipartFileHelper;
  private StorageService storageService;

  /**
   * Default constructor.
   */
  public DocumentController() {
    super(URL_PREFIX, "name");
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("documentStatuses", I18nEnumerationHelper.getLocalizedValues(DocumentStatus.class, locale));
    return model;
  }
  
  /**
   * {@inheritDoc}
   */
  public void completeExtraction(CRUDForm<Document> pform) {
    DocumentForm form = (DocumentForm) pform;
    File file;
    try {
      file = multipartFileHelper.saveMultipart(form.getFileData(), new File(tempfiledir));
      if (file != null) {
        form.getEntity().setUniversalResourceLocator(file.getAbsolutePath());
        form.getEntity().setName(form.getFileData().getOriginalFilename());
        form.getEntity().setDisplayName(form.getFileData().getOriginalFilename());   
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public List<Document> createList() {
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithId> persistentClass = (Class<? extends EntityWithId>) frame.getAttribute("persistentClass");
    String queryName = Document.class.getName() + ".findBy" + persistentClass.getSimpleName() + "Id";
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", frame.getAttribute("id"));
    return getMainService().findByNamedQuery(queryName, params);
  }
  
  /**
   * 
   * @param response The servlet response.
   * @param id The id of the filledreport to view.
   */
  @RequestMapping("/download.do")
  public void download(HttpServletResponse response, @RequestParam("id") Long id) {
    try {
      Document document = getMainService().findById(Document.class, id);
      ServletOutputStream servletOutputStream = response.getOutputStream();
      File downloadedFile = storageService.get(document, new File(tempfiledir));
      response.setContentType("application/octet-stream");
      response.setHeader("Content-Disposition", "attachment;filename=" + document.getName());
      FileInputStream fileInputStream = new FileInputStream(downloadedFile);
      IOUtils.copyLarge(fileInputStream, servletOutputStream);
      IOUtils.closeQuietly(fileInputStream);
      servletOutputStream.flush();
      servletOutputStream.close();
      downloadedFile.delete();
    } catch (IOException e1) {
      throw new RuntimeException("IOException in download", e1);
    } catch (StorageServiceException e) {
      throw new RuntimeException("StorageServiceException in download", e);
    }
  }

  /**
   * Saves an entity and returns a refreshed list page.
   * 
   * @param form The object containing the values of the type entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") DocumentForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param documentService the documentService to set
   */
  @Resource(name = "documentService")
  public void setMainService(GenericService<Document> documentService) {
    super.setMainService(documentService);
  }
  
  /**
   * @param storageService the storageService to set
   */
  @Resource(name = "storageService")
  public void setStorageService(StorageService storageService) {
    this.storageService = storageService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "documentFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "documentTable")
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
