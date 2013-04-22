/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class RoleStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{RoleStatus.ACTIVE.name(), "Active"},
{RoleStatus.INACTIVE.name(), "Inactive"},
{RoleStatus.ALTERNATE.name(), "Alternate"},
{RoleStatus.CURRENT.name(), "Current"},
{RoleStatus.EXPIRED.name(), "Expired"},
{RoleStatus.DEFAULT.name(), "Default"},
{RoleStatus.RECOMMENDED.name(), "Recommended"},
{RoleStatus.REPLACED.name(), "Replaced"},
{RoleStatus.REQUIRED.name(), "Required"},
{RoleStatus.PRIMARY.name(), "Primary"},
{RoleStatus.SECONDARY.name(), "Secondary"},
{RoleStatus.SUPPLEMENTAL.name(), "Supplemental"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
