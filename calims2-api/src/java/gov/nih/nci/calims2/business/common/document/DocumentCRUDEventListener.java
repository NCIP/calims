/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.common.document;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.business.generic.AuditableCRUDEventListener;
import gov.nih.nci.calims2.business.storage.StorageService;
import gov.nih.nci.calims2.business.storage.StorageServiceException;
import gov.nih.nci.calims2.domain.common.Document;

/**
 * @author viseem
 * @param <T>
 * 
 */
public class DocumentCRUDEventListener<T> extends AuditableCRUDEventListener<Document> {
  
  private static final String[] EXCLUDED_PROPERTIES = new String[] {"universalResourceLocator" };

  private StorageService storageService;
  
  /**
   * Default constructor.
   */
  public DocumentCRUDEventListener() {
    setAdditionalExcludedProperties(EXCLUDED_PROPERTIES);
  }

  /**
   * {@inheritDoc}
   */
  public Document beforeCreate(Document inputEntity) {
    Document document = super.beforeCreate(inputEntity);
    try {
      File file = new File(inputEntity.getUniversalResourceLocator());
      Document temDocument = storageService.save(file);
      document.setUniversalResourceLocator(temDocument.getUniversalResourceLocator());
      file.delete();
    } catch (StorageServiceException e) {
      throw new RuntimeException(e);
    }
    return document;
  }

  /**
   * {@inheritDoc}
   */
  public Document beforeUpdate(Document inputEntity, Document existingEntity) {
    Document document = super.beforeUpdate(inputEntity, existingEntity);
    try {
      if (StringUtils.isNotBlank(inputEntity.getUniversalResourceLocator())) {
        File file = new File(inputEntity.getUniversalResourceLocator());
        Document tempDocument = storageService.save(file);
        file.delete();
        document.setUniversalResourceLocator(tempDocument.getUniversalResourceLocator());
      }
    } catch (StorageServiceException e) {
      throw new RuntimeException(e);
    }
    return document;
  }

  /**
   * @param storageService the storageService to set
   */
  public void setStorageService(StorageService storageService) {
    this.storageService = storageService;
  }

}
