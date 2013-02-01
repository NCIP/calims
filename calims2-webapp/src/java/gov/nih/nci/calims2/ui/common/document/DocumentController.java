/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
