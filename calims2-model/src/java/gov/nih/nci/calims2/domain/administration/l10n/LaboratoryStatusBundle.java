/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.LaboratoryStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class LaboratoryStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{LaboratoryStatus.ACTIVE.name(), "Active"},
{LaboratoryStatus.ALTERNATE.name(), "Alternate"},
{LaboratoryStatus.APPROVALPENDING.name(), "Approval Pending"},
{LaboratoryStatus.APPROVED.name(), "Approved"},
{LaboratoryStatus.NOTAPPROVED.name(), "Not Approved"},
{LaboratoryStatus.AVAILABLE.name(), "Available"},
{LaboratoryStatus.DEFAULT.name(), "Default"},
{LaboratoryStatus.INACTIVE.name(), "Inactive"},
{LaboratoryStatus.PRIMARY.name(), "Primary"},
{LaboratoryStatus.PRIVATE.name(), "Private"},
{LaboratoryStatus.PUBLIC.name(), "Public"},
{LaboratoryStatus.UNAVAILABLE.name(), "Unavailable"},
{LaboratoryStatus.UNVALIDATED.name(), "Unvalidated"},
{LaboratoryStatus.VALIDATED.name(), "Validated"},
{LaboratoryStatus.VALIDATIONINPROGRESS.name(), "Validation Progress"},
{LaboratoryStatus.LEAD.name(), "Lead"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
