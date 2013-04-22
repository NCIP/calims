/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class AccountStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{AccountStatus.ACTIVE.name(), "Active"},
{AccountStatus.ALTERNATE.name(), "Alternate"},
{AccountStatus.APPROVALPENDING.name(), "Approval Pending"},
{AccountStatus.APPROVED.name(), "Approved"},
{AccountStatus.AVAILABLE.name(), "Avaliable"},
{AccountStatus.CURRENT.name(), "Current"},
{AccountStatus.DEFAULT.name(), "Default"},
{AccountStatus.EXPIRED.name(), "Expired"},
{AccountStatus.INACTIVE.name(), "Inactive"},
{AccountStatus.NOTAPPROVED.name(), "Not Approved"},
{AccountStatus.PENDING.name(), "Pending"},
{AccountStatus.REPLACED.name(), "Replaced"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
