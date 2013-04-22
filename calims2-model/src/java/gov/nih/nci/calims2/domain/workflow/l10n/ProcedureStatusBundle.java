/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.ProcedureStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ProcedureStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ProcedureStatus.APPROVALPENDING.name(), "Approval Pending"},
{ProcedureStatus.APPROVED.name(), "Approved"},
{ProcedureStatus.NOTAPPROVED.name(), "Not Approved"},
{ProcedureStatus.INPROGRESS.name(), "In Progress"},
{ProcedureStatus.COMPLETED.name(), "Completed"},
{ProcedureStatus.INREVIEW.name(), "In Review"},
{ProcedureStatus.REVIEWED.name(), "Reviewed"},
{ProcedureStatus.PUBLISHED.name(), "Published"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}