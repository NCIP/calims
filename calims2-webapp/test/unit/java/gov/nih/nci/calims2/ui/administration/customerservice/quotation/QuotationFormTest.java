/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.quotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.customerservice.Quotation;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 *
 */
public class QuotationFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    QuotationForm form = new QuotationForm();
    CRUDFormTestHelper.setNotes(form);
    form.setRateId(1L);
    form.setStatus(QuotationStatus.DEFAULT.name());
    form.setTypeId(1L);
    Quotation entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormTestHelper.assertNotes(entity);
    CRUDFormAssert.assertEntity(Rate.class, entity.getRate(), 1L);
    assertEquals("Wrong status in the entity", QuotationStatus.DEFAULT, entity.getStatus());
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
  }
}
