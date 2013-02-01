package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.RateStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class RateStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{RateStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
