/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

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