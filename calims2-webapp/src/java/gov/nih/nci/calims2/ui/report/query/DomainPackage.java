/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.query;

import java.util.Locale;

import gov.nih.nci.calims2.ui.report.l10n.DomainPackageBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * Packages to present in the query management.
 * 
 * @author viseem
 * 
 */
public enum DomainPackage implements I18nEnumeration {
  /** administration package. */
  ADMIN("gov.nih.nci.calims2.domain.administration"),

  /** common package. */
  COMMON("gov.nih.nci.calims2.domain.common"),

  /** customer service package. */
  CUSTOMER_SERVICE("gov.nih.nci.calims2.domain.administration.customerservice"),

  /** inventory package. */
  INVENTORY("gov.nih.nci.calims2.domain.inventory"),

  /** report package. */
  REPORT("gov.nih.nci.calims2.domain.report");

  private String packageName;

  private DomainPackage(String packageName) {
    this.packageName = packageName;
  }

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(DomainPackageBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }

  /**
   * @return the packageName
   */
  public String getPackageName() {
    return packageName;
  }

}
