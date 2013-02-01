package gov.nih.nci.calims2.domain.administration.customerservice.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum CustomerRequestStatus  implements I18nEnumeration {



/**
* APPROVED status name.
*/
APPROVED,
/**
* APPROVALPENDING status name.
*/
APPROVALPENDING,
/**
* CANCELLED status name.
*/
CANCELLED,
/**
* COMPLETED status name.
*/
COMPLETED,
/**
* MODIFIED status name.
*/
MODIFIED,
/**
* REJECTED status name.
*/
REJECTED,
/**
* SUBMITTED status name.
*/
SUBMITTED,
/**
* INQUIRY status name.
*/
INQUIRY,
/**
* LABRESPONSE status name.
*/
LABRESPONSE,
/**
* CUSTOMERRESPONSE status name.
*/
CUSTOMERRESPONSE,
/**
* INQUIRYSUBMITTED status name.
*/
INQUIRYSUBMITTED,
/**
* LABAPPROVED status name.
*/
LABAPPROVED,
/**
* CUSTOMERAPPROVED status name.
*/
CUSTOMERAPPROVED,
/**
* CUSTOMERREQUESTSUBMITTED status name.
*/
CUSTOMERREQUESTSUBMITTED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.customerservice.l10n.CustomerRequestStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}