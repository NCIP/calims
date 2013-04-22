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

public enum SpecimenQuantity  implements I18nEnumeration {



/**
* AVAILABLEQUANTITY quantity type.
*/
AVAILABLEQUANTITY (1003),
/**
* MINIMUMRESERVEQUANTITY quantity type.
*/
MINIMUMRESERVEQUANTITY (1002),
/**
* CURRENTQUANTITY quantity type.
*/
CURRENTQUANTITY (1001),
/**
* STARTINGQUANTITY quantity type.
*/
STARTINGQUANTITY (1004);

   /**
    * id The id of the enum.
    */
   private int id; 
   
   /**
    * Constructor
    * @param id The id of the enum.
    */
   private SpecimenQuantity(int id) {
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
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.inventory.l10n.SpecimenQuantityBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}