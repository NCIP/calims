/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

import gov.nih.nci.calims2.ui.util.multipartfile.MultipartFileHelper;

/**
 * @author connollym
 *
 */
public class MultipartFileHelperMockup implements MultipartFileHelper {
  private File savedfile;
  private MultipartFile multipartFile;
  private File jrxmlFile;
  
  /**
   * 
   * @param mpFile The mpFile.
   * @param file The file.
   * @return returnedFile The file.
   */
  public File saveMultipart(MultipartFile mpFile, File file) {
    this.multipartFile = mpFile;
    this.savedfile = file;
    jrxmlFile = new File(file.getAbsolutePath());
    return file;
  }

 
  /**
   * @return the multipartFile
   */
  public MultipartFile getMultipartFile() {
    return multipartFile;
  }

  /**
   * @param multipartFile the multipartFile to set
   */
  public void setMultipartFile(MultipartFile multipartFile) {
    this.multipartFile = multipartFile;
  }


  /**
   * @return the savedfile
   */
  public File getSavedfile() {
    return savedfile;
  }


  /**
   * @param savedfile the savedfile to set
   */
  public void setSavedfile(File savedfile) {
    this.savedfile = savedfile;
  }

}
