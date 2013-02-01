package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.ReviewApprovalStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ReviewApprovalStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ReviewApprovalStatus.REVIEWEDAPPROVED.name(), "Reviewed Approved"},
{ReviewApprovalStatus.REVIEWEDNOTAPPROVED.name(), "ReviewedNot Approved"},
{ReviewApprovalStatus.REVIEWEDPENDING.name(), "Reviewed Pending"},
{ReviewApprovalStatus.REVIEWEDTOALTN.name(), "Reviewed to Altn"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}