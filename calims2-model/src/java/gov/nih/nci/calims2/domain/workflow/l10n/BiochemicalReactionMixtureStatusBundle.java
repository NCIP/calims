package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.BiochemicalReactionMixtureStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class BiochemicalReactionMixtureStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{BiochemicalReactionMixtureStatus.AVAILABLE.name(), "Available"},
{BiochemicalReactionMixtureStatus.UNAVAILABLE.name(), "Unavailable"},
{BiochemicalReactionMixtureStatus.APPROVED.name(), "Approved"},
{BiochemicalReactionMixtureStatus.NOTAPPROVED.name(), "Not Approved"},
{BiochemicalReactionMixtureStatus.APPROVALPENDING.name(), "Approval Pending"},
{BiochemicalReactionMixtureStatus.INTERNAL.name(), "Internal"},
{BiochemicalReactionMixtureStatus.CURRENT.name(), "Current"},
{BiochemicalReactionMixtureStatus.VALIDATIONINPROGRESS.name(), "Validation In Progress"},
{BiochemicalReactionMixtureStatus.COMPLETED.name(), "Completed"},
{BiochemicalReactionMixtureStatus.CANCELLED.name(), "Cancelled"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}