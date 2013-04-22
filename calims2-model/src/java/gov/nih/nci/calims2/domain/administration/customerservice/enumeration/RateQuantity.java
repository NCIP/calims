/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.administration.customerservice.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author connollym
 *
 */
public enum RateQuantity implements I18nEnumeration {



  /**
  * RATE quantity type.
  */
  COST (8003);

     /**
      * id The id of the enum.
      */
     private int id; 
     
     /**
      * Constructor
      * @param id The id of the enum.
      */
     private RateQuantity(int id) {
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
      return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.customerservice.l10n.RateQuantityBundle.class, locale, this);
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {

      return name();
    }
  }
