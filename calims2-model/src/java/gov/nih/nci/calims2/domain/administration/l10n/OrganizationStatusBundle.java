/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class OrganizationStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{OrganizationStatus.ACTIVE.name(), "Active"},
{OrganizationStatus.INACTIVE.name(), "Inactive"},
{OrganizationStatus.ALTERNATE.name(), "Alternative"},
{OrganizationStatus.INTERNAL.name(), "Internal"},
{OrganizationStatus.EXTERNAL.name(), "External"},
{OrganizationStatus.PRIVATE.name(), "Private"},
{OrganizationStatus.PUBLIC.name(), "Public"},
{OrganizationStatus.RETIRED.name(), "Retired"},
{OrganizationStatus.LEAD.name(), "Lead"},
{OrganizationStatus.RECOMMENDED.name(), "Recommended"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
