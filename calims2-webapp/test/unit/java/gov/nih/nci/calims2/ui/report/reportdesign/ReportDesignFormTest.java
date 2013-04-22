/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.reportdesign;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.report.ReportDesign;
import gov.nih.nci.calims2.ui.report.query.QueriedEntity;

/**
 * @author connollym
 *
 */
public class ReportDesignFormTest {
  
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    ReportDesignForm form = new ReportDesignForm();
    form.setMainEntity(QueriedEntity.CONTAINER.name());
    ReportDesign entity = form.getSubmittedEntity();
    assertEquals("Main entity is not equal", entity.getMainEntity(), QueriedEntity.CONTAINER.getPersistentClass().getName());
    assertNotNull("No submitted Entity", entity);    
  }
}

