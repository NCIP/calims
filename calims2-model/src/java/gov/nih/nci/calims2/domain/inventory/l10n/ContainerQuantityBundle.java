package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerQuantity;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ContainerQuantityBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ContainerQuantity.MAXIMUMCAPACITY.name(), "Maximum Capacity"},
{ContainerQuantity.CURRENTQUANTITY.name(), "Current Quantity"},
{ContainerQuantity.MINIMUMCAPACITY.name(), "Minimum Capacity"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}