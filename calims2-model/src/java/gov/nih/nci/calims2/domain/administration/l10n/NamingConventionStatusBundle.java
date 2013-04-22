/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class NamingConventionStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{NamingConventionStatus.DEFAULT.name(), "Default"},
{NamingConventionStatus.ACTIVE.name(), "Active"},
{NamingConventionStatus.APPROVED.name(), "Approved"},
{NamingConventionStatus.RECOMMENDED.name(), "Recommended"},
{NamingConventionStatus.OBSOLETE.name(), "Obsolete"},
{NamingConventionStatus.APPROVALPENDING.name(), "Approval Pending"},
{NamingConventionStatus.REQUIRED.name(), "Required"},
{NamingConventionStatus.REPLACED.name(), "Replaced"},
{NamingConventionStatus.ALTERNATE.name(), "Alternate"},
{NamingConventionStatus.NOTAPPROVED.name(), "Not Approved"},
{NamingConventionStatus.WARNING.name(), "Warning"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
