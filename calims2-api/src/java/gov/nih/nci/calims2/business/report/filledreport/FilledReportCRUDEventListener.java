/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.filledreport;

import java.io.File;

import gov.nih.nci.calims2.business.generic.AuditableCRUDEventListener;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.storage.StorageService;
import gov.nih.nci.calims2.business.storage.StorageServiceException;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.report.FilledReport;

/**
 * @author connollym
 *
 */
public class FilledReportCRUDEventListener extends AuditableCRUDEventListener<FilledReport> {
  
  private static final String[] EXCLUDED_PROPERTIES = new String[] {"document"};
  private StorageService storageService;
  private GenericService<Document> documentService;
  
  /**
   * 
   */
  public FilledReportCRUDEventListener() {
    setAdditionalExcludedProperties(EXCLUDED_PROPERTIES);
  }
  
  /**
   * {@inheritDoc}
   */
  public FilledReport beforeCreate(FilledReport inputEntity) {
   
    FilledReport filledReport = super.beforeCreate(inputEntity);
    try {
      Document inputDocument = inputEntity.getDocument();
      File file = new File(inputDocument.getUniversalResourceLocator());
      Document document = storageService.save(file);
      inputDocument.setUniversalResourceLocator(document.getUniversalResourceLocator());
      file.delete();
      filledReport.setDocument(documentService.create(inputDocument));
    } catch (ValidationException e) {
        throw new InternalError("This cannot happen");
    } catch (StorageServiceException e) {
      e.printStackTrace();
    }
    return filledReport;
  }
  
  /**
   * @param storageService the storageService to set
   */
  public void setStorageService(StorageService storageService) {
    this.storageService = storageService;
  }

  /**
   * @param documentService the documentService to set
   */
  public void setDocumentService(GenericService<Document> documentService) {
    this.documentService = documentService;
  }
}
