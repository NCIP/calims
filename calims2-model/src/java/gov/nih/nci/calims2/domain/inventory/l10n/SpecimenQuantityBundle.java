package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.inventory.enumeration.SpecimenQuantity;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class SpecimenQuantityBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{SpecimenQuantity.AVAILABLEQUANTITY.name(), "Avaliable Quantity"},
{SpecimenQuantity.CURRENTQUANTITY.name(), "Current Quantity"},
{SpecimenQuantity.MINIMUMRESERVEQUANTITY.name(), "Minimum Reserve Quantity"},
{SpecimenQuantity.STARTINGQUANTITY.name(), "Starting Quantity"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}