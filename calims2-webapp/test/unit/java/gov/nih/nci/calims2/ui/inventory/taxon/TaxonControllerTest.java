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

import org.junit.Test;

import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;

/**
 * @author katariap
 *
 */
public class TaxonControllerTest {
  
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    TaxonController controller = new TaxonController();
    CRUDAssert.assertControllerConstructor(controller, TaxonController.URL_PREFIX, "inventory.taxon.", "name",
        Taxon.class, TaxonForm.class, CRUDTableDecorator.class);
  }

}
