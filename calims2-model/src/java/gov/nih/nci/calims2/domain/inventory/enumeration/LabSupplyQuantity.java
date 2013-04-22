/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum LabSupplyQuantity  implements I18nEnumeration {



/**
* initialQuantity status name.
*/
INITIALQUANTITY (9001),
/**
* minimumArchivedQuantity status name.
*/
MINIMUMARCHIVEDQUANTITY (9002),
/**
* availableQuantity status name.
*/
AVAILABLEQUANTITY (9003);

/**
 * id The id of the enum.
 */
private int id; 

/**
 * Constructor
 * @param id The id of the enum.
 */
private LabSupplyQuantity(int id) {
   this.id =id;
}

/**
 * @return id The id of the enum.
 */
public int getId() {
   return id;
}

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.inventory.l10n.LabSupplyQuantityBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
