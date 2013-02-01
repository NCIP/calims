package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ServiceStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ServiceStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
