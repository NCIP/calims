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
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import gov.nih.nci.calims2.domain.common.Document;

/**
 * @author connollym
 * 
 */
public class StorageServiceImpl implements StorageService {

  private String filesystemrootdir;

  /**
   * {@inheritDoc}
   * 
   * @throws StorageServiceException
   */

  public File get(Document document, File dir) throws StorageServiceException {
    File inputFile = new File(document.getUniversalResourceLocator());
    File outputFile;
    try {
      outputFile = File.createTempFile("LPGLIMS", "", dir);
      FileUtils.copyFile(inputFile, outputFile);
    } catch (IOException e) {
      throw new StorageServiceException("Error saving file from storage" + e.getMessage());
    }
    return outputFile;
  }

  /**
   * {@inheritDoc}
   * 
   * @throws StorageServiceException
   */

  public Document save(File file) throws StorageServiceException {
    File dir = new File(filesystemrootdir);
    File outputFile = null;
    try {
      outputFile = File.createTempFile("LPGLIMS", "", dir);
      FileUtils.copyFile(file, outputFile);
    } catch (IOException e) {
      throw new StorageServiceException("Error saving file from storage" + e.getMessage());
    }

    Document document = new Document();
    document.setUniversalResourceLocator(outputFile.getAbsolutePath());
    return document;
  }

  /**
   * @param filesystemrootdir the filesystemrootdir to set
   */
  public void setFilesystemrootdir(String filesystemrootdir) {
    this.filesystemrootdir = filesystemrootdir;
  }

}
