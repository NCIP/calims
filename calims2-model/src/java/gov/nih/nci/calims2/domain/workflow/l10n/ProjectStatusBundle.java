package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.ProjectStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ProjectStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ProjectStatus.APPROVALPENDING.name(), "Approval Pending"},
{ProjectStatus.APPROVED.name(), "Approved"},
{ProjectStatus.NOTAPPROVED.name(), "Not Approved"},
{ProjectStatus.INPROGRESS.name(), "In Progress"},
{ProjectStatus.COMPLETED.name(), "Completed"},
{ProjectStatus.INREVIEW.name(), "In Review"},
{ProjectStatus.REVIEWED.name(), "Reviewed"},
{ProjectStatus.PUBLISHED.name(), "Published"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}