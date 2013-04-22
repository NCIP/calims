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
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;


/**
 * @author connollym
 *
 */
public class MultipartFileMockup implements MultipartFile {
  
  private String contentType;
  private InputStream inputStream;
  private byte[] bytes;
  private String name;
  private String originalFileName;
  private long size;
  private boolean isEmpty;
  
  /**
   * {@inheritDoc}
   */
  public byte[] getBytes() throws IOException {    
    return bytes;
  }

  /**
   * {@inheritDoc}
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * {@inheritDoc}
   */
  public InputStream getInputStream() throws IOException {
    return inputStream;
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  public String getOriginalFilename() {
    return originalFileName;
  }

  /**
   * {@inheritDoc}
   */
  public long getSize() {
    return size;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isEmpty() {
    
    return isEmpty;
  }

  /**
   * {@inheritDoc}
   */
  public void transferTo(File dest) throws IOException {
    // TODO Auto-generated method stub
    
  }

  /**
   * @return the originalFileName
   */
  public String getOriginalFileName() {
    return originalFileName;
  }

  /**
   * @param originalFileName the originalFileName to set
   */
  public void setOriginalFileName(String originalFileName) {
    this.originalFileName = originalFileName;
  }

  /**
   * @param contentType the contentType to set
   */
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  /**
   * @param inputStream the inputStream to set
   */
  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  /**
   * @param bytes the bytes to set
   */
  public void setBytes(byte[] bytes) {
    this.bytes = bytes;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param size the size to set
   */
  public void setSize(long size) {
    this.size = size;
  }

  /**
   * @param isEmpty the isEmpty to set
   */
  public void setEmpty(boolean isEmpty) {
    this.isEmpty = isEmpty;
  }
 
}
