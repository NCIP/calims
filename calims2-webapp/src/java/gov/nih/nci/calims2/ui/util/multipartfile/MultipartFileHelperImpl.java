/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util.multipartfile;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author connollym
 *
 */
public class MultipartFileHelperImpl implements MultipartFileHelper {
  
  /**
   * 
   * {@inheritDoc}
   */
  public File saveMultipart(MultipartFile file, File dir) throws IOException {
      if (file.isEmpty()) {
        return null;
      }
        File tempFile = File.createTempFile("LPGLIMS", ".jrxml", dir);
        file.transferTo(tempFile);
        return tempFile;
  }
}
