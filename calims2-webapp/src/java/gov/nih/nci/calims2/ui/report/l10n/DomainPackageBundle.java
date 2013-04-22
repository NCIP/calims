/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.l10n;

import java.util.ListResourceBundle;

import gov.nih.nci.calims2.ui.report.query.DomainPackage;

/**
 * @author viseem
 *
 */
public class DomainPackageBundle extends ListResourceBundle {

  private static final Object[][] CONTENTS = {
    {DomainPackage.ADMIN.name(), "Administration"},
    {DomainPackage.COMMON.name(), "Common"},
    {DomainPackage.CUSTOMER_SERVICE.name(), "Customer Service"},
    {DomainPackage.INVENTORY.name(), "Inventory"},
    {DomainPackage.REPORT.name(), "Report"}
  };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }

}
