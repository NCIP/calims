package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ContractStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ContractStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ContractStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
