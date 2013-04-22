/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.ContactInformationStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ContactInformationStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ContactInformationStatus.ACTIVE.name(), "Active"},
{ContactInformationStatus.ALTERNATE.name(), "Alternate"},
{ContactInformationStatus.INACTIVE.name(), "Inactive"},
{ContactInformationStatus.ADDITIONAL.name(), "Additional"},
{ContactInformationStatus.CURRENT.name(), "Current"},
{ContactInformationStatus.DEFAULT.name(), "Default"},
{ContactInformationStatus.EXPIRED.name(), "Expired"},
{ContactInformationStatus.INVALID.name(), "Invalid"},
{ContactInformationStatus.PERMANENT.name(), "Permanent"},
{ContactInformationStatus.PRIMARY.name(), "Primary"},
{ContactInformationStatus.SECONDARY.name(), "Secondary"},
{ContactInformationStatus.REQUIRED.name(), "Required"},
{ContactInformationStatus.TEMPORARY.name(), "Temporary"},
{ContactInformationStatus.UNPUBLISHED.name(), "Unpublished"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
