package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ServiceItemStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ServiceItemStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
