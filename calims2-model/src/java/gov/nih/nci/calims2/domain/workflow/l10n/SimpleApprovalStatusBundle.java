package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.SimpleApprovalStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class SimpleApprovalStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{SimpleApprovalStatus.APPROVED.name(), "Approved"},
{SimpleApprovalStatus.NOTAPPROVED.name(), "Not Approved"},
{SimpleApprovalStatus.APPROVEDTOALTN.name(), "Approved to Altn"},
{SimpleApprovalStatus.PENDING.name(), "Pending"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}