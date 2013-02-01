package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.StorageDeviceStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class StorageDeviceStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{StorageDeviceStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
