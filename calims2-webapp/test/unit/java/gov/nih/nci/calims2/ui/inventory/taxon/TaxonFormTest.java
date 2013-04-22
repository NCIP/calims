/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.taxon;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 * 
 */
public class TaxonFormTest {
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    TaxonForm form = new TaxonForm();
    CRUDFormTestHelper.setNotes(form);
    Taxon entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormTestHelper.assertNotes(entity);
  }
}
