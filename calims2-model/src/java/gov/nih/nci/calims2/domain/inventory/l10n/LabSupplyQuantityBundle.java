package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyQuantity;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class LabSupplyQuantityBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{LabSupplyQuantity.MINIMUMARCHIVEDQUANTITY.name(), "Minimum Archived Quantity"},
{LabSupplyQuantity.INITIALQUANTITY.name(), "Initial Quantity"},
{LabSupplyQuantity.AVAILABLEQUANTITY.name(), "Available Quantity"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
