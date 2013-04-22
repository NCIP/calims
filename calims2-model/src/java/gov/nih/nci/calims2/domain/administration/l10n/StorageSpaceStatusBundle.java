/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.StorageSpaceStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class StorageSpaceStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{StorageSpaceStatus.ACTIVE.name(), "Active"},
{StorageSpaceStatus.ALTERNATE.name(), "Alternate"},
{StorageSpaceStatus.APPROVALPENDING.name(), "Approval Pending"},
{StorageSpaceStatus.APPROVED.name(), "Approved"},
{StorageSpaceStatus.NOTAPPROVED.name(), "Not Approved"},
{StorageSpaceStatus.CURRENT.name(), "Current"},
{StorageSpaceStatus.DEFAULT.name(), "Default"},
{StorageSpaceStatus.OBSOLETE.name(), "Obsolete"},
{StorageSpaceStatus.PRIMARY.name(), "Primary"},
{StorageSpaceStatus.RECOMMENDED.name(), "Recommended"},
{StorageSpaceStatus.SECONDARY.name(), "Secondary"},
{StorageSpaceStatus.TEMPORARY.name(), "Temporary"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
