package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.TelephoneNumberStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class TelephoneNumberStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{TelephoneNumberStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
