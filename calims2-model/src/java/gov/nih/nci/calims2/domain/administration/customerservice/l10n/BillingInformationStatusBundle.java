package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.BillingInformationStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class BillingInformationStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{BillingInformationStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
