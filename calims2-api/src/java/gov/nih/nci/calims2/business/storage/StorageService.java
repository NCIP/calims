/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.storage;

import java.io.File;

import gov.nih.nci.calims2.domain.common.Document;

/**
 * @author connollym
 *
 */
public interface StorageService {
  
  /**
   * @param document The document object used to retrieve the actual file.
   * @param dir The File to retrieve.
   * @return the file being returned.
   * @throws StorageServiceException The exception thrown if the file retrieval fails.
   */

  File get(Document document, File dir) throws StorageServiceException;

  /**
   * @param file The actual file being saved.
   * @return the file being saved.
   * @throws StorageServiceException The exception thrown if the file save fails.
   */
  Document save(File file) throws StorageServiceException;

}