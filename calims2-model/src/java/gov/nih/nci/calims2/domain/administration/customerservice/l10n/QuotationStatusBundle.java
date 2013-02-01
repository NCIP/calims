package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class QuotationStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{QuotationStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
