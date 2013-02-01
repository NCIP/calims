package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountNumberStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class AccountNumberStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{AccountNumberStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
