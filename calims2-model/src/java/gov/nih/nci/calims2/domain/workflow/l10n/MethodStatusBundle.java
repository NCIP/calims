/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.MethodStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class MethodStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{MethodStatus.APPROVALPENDING.name(), "Approval Pending"},
{MethodStatus.APPROVED.name(), "Approved"},
{MethodStatus.NOTAPPROVED.name(), "Not Approved"},
{MethodStatus.INPROGRESS.name(), "In Progress"},
{MethodStatus.COMPLETED.name(), "Completed"},
{MethodStatus.INREVIEW.name(), "In Review"},
{MethodStatus.REVIEWED.name(), "Reviewed"},
{MethodStatus.PUBLISHED.name(), "Published"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}