package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.SoftwareStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class SoftwareStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{SoftwareStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
