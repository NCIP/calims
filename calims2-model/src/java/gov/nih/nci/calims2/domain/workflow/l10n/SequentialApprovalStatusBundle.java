/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.SequentialApprovalStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class SequentialApprovalStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{SequentialApprovalStatus.APPROVED.name(), "Approved"},
{SequentialApprovalStatus.NOTAPPROVED.name(), "Not Approved"},
{SequentialApprovalStatus.APPROVEDTOALTN.name(), "Approved to Altn"},
{SequentialApprovalStatus.PENDING.name(), "Pending"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}