package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.RunStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class RunStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{RunStatus.APPROVALPENDING.name(), "Approval Pending"},
{RunStatus.APPROVED.name(), "Approved"},
{RunStatus.NOTAPPROVED.name(), "Not Approved"},
{RunStatus.INPROGRESS.name(), "In Progress"},
{RunStatus.COMPLETED.name(), "Completed"},
{RunStatus.INREVIEW.name(), "In Review"},
{RunStatus.REVIEWED.name(), "Reviewed"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}