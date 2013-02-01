package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.PostalAddressStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class PostalAddressStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{PostalAddressStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
