/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.ApprovalPollStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ApprovalPollStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ApprovalPollStatus.APPROVED.name(), "Approved"},
{ApprovalPollStatus.NOTAPPROVED.name(), "Not Approved"},
{ApprovalPollStatus.APPROVEDTOALTN.name(), "Approved to Altn"},
{ApprovalPollStatus.PENDING.name(), "Pending"},
{ApprovalPollStatus.REVIEWEDAPPROVED.name(), "Reviewed Approved"},
{ApprovalPollStatus.REVIEWEDNOTAPPROVED.name(), "Reviewed Not Approved"},
{ApprovalPollStatus.REVIEWEDPENDING.name(), "Reviewed Pending"},
{ApprovalPollStatus.REVIEWEDTOALTN.name(), "Reviewed to Altn"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}