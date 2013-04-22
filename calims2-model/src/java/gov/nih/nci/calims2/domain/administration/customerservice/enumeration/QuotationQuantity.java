/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.customerservice.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum QuotationQuantity  implements I18nEnumeration {



/**
* QUANTITY quantity type.
*/
QUANTITY (8001);

   /**
    * id The id of the enum.
    */
   private int id; 
   
   /**
    * Constructor
    * @param id The id of the enum.
    */
   private QuotationQuantity(int id) {
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
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.customerservice.l10n.QuotationQuantityBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}