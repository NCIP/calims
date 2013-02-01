package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationQuantity;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class QuotationQuantityBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{QuotationQuantity.QUANTITY.name(), "Quantity"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}