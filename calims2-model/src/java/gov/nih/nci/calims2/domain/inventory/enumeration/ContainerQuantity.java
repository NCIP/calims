package gov.nih.nci.calims2.domain.inventory.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum ContainerQuantity  implements I18nEnumeration {



/**
* MINIMUMCAPACITY quantity type.
*/
MINIMUMCAPACITY (3),
/**
* MAXIMUMCAPACITY quantity type.
*/
MAXIMUMCAPACITY (1),
/**
* CURRENTQUANTITY quantity type.
*/
CURRENTQUANTITY (2);


   /**
    * id The id of the enum.
    */
   private int id; 
   
   /**
    * Constructor
    * @param id The id of the enum.
    */
   private ContainerQuantity(int id) {
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
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.inventory.l10n.ContainerQuantityBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}