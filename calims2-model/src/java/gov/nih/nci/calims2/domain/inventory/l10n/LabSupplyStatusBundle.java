package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class LabSupplyStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{LabSupplyStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
