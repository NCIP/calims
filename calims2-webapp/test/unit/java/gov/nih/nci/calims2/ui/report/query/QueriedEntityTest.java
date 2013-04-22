/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import gov.nih.nci.calims2.domain.report.Query;

/**
 * @author viseem
 *
 */
public class QueriedEntityTest {
  /**
   * Test the getByDomainPackage method.
   */
  @Test
  public void testGetByDomainPackage() {
    List<QueriedEntity> result = QueriedEntity.getByDomainPackage(DomainPackage.REPORT);
    assertNotNull("No result returned", result);
    assertEquals("Wrong number of QueriedEntity", 2, result.size());
    assertEquals("Wrong QueriedEntity returned", QueriedEntity.QUERY, result.get(0));
    assertEquals("Wrong QueriedEntity returned", QueriedEntity.REPORT, result.get(1));
  }
  
  /**
   * Test the getByPersistentClass method.
   */
  @Test
  public void testGetByPersistentClassFound() {
    QueriedEntity entity = QueriedEntity.getByPersistentClass(Query.class.getName());
    assertEquals("Wrong QueriedEntity returned", QueriedEntity.QUERY, entity);
  }
  
  /**
   * Test the getByPersistentClass method.
   */
  @Test
  public void testGetByPersistentClassNotFound() {
    QueriedEntity entity = QueriedEntity.getByPersistentClass("1234");
    assertNull("QueriedEntity returned", entity);
  }
  
  /**
   * Test the getByPersistentClass method.
   */
  @Test
  public void testGetByPersistentClassNull() {
    QueriedEntity entity = QueriedEntity.getByPersistentClass(null);
    assertNull("QueriedEntity returned", entity);
  }

}
