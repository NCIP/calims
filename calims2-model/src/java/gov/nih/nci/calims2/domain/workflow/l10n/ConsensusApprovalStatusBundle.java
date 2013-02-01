package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.ConsensusApprovalStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ConsensusApprovalStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ConsensusApprovalStatus.APPROVED.name(), "Approved"},
{ConsensusApprovalStatus.NOTAPPROVED.name(), "Not Approved"},
{ConsensusApprovalStatus.APPROVEDTOALTN.name(), "Approved to Altn"},
{ConsensusApprovalStatus.PENDING.name(), "Pending"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}