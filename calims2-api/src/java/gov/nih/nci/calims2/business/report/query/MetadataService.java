/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.query;

/**
 * @author viseem
 * 
 */
public interface MetadataService {
  /**
   * Gets the descritor of the given persistent class.
   * 
   * @param persistentClass The class to describe
   * @return the descritor of the given persistent class
   */
  EntityDescriptor getEntityDescriptor(Class<?> persistentClass);

}
