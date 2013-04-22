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
public interface MultipartFileHelper {
  /**
   * @param file The file to save.
   * @param dir The file to save the multipart file data to.
   * @return dir The saved file.
   * @throws IOException Throws IOException.
   */
   File saveMultipart(MultipartFile file, File dir) throws IOException;

}