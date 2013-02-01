package gov.nih.nci.calims2.ui.hello;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author connollym
 * 
 */
public class UploadItem {

private String name;
private MultipartFile fileData;

/**
 * @return name Name of the file.
 * 
 */
public String getName() {
  return name;
}

/**
 * @param name Name of the file.
 * 
 */
 public void setName(String name) {
   this.name = name;
}
 /**
  * @return fileData The MultipartFile.
  * 
  */ 
public MultipartFile getFileData() {
  return fileData;
  }
/**
 * @param fileData The MultipartFile
 * 
 */
public void setFileData(MultipartFile fileData) {
  this.fileData = fileData;
  }
}