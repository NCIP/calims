/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.reportdesign;

import gov.nih.nci.calims2.business.generic.AuditableCRUDEventListener;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.report.ReportDesign;

/**
 * @author connollym
 * 
 */
public class ReportDesignCRUDEventListener extends AuditableCRUDEventListener<ReportDesign> {

  private static final String[] EXCLUDED_PROPERTIES = new String[] {"document" };
  private GenericService<Document> documentService;

  /**
   * 
   */
  public ReportDesignCRUDEventListener() {
    setAdditionalExcludedProperties(EXCLUDED_PROPERTIES);
  }

  /**
   * {@inheritDoc}
   */
  public ReportDesign beforeCreate(ReportDesign inputEntity) {
    ReportDesign reportDesign = super.beforeCreate(inputEntity);
    try {
      Document inputDocument = inputEntity.getDocument();
      reportDesign.setDocument(documentService.create(inputDocument));
    } catch (ValidationException e) {
      throw new InternalError("This cannot happen");
    }
    return reportDesign;
  }

  /**
   * {@inheritDoc}
   */
  public ReportDesign beforeUpdate(ReportDesign inputEntity, ReportDesign existingEntity) {
    ReportDesign reportDesign = super.beforeUpdate(inputEntity, existingEntity);
    Document inputDocument = inputEntity.getDocument();
    if (inputDocument != null) {
      try {
        documentService.delete(Document.class, existingEntity.getDocument().getId());
        existingEntity.setDocument(documentService.create(inputDocument));
      } catch (ValidationException e) {
        throw new InternalError("This cannot happen");
      }
    }
    return reportDesign;
  }

  /**
   * @param documentService the documentService to set
   */
  public void setDocumentService(GenericService<Document> documentService) {
    this.documentService = documentService;
  }

}
