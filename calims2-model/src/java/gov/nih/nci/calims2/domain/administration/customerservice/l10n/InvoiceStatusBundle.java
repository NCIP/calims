package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.InvoiceStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class InvoiceStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{InvoiceStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
