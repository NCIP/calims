/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class DocumentStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{DocumentStatus.DRAFT.name(), "Draft"},
{DocumentStatus.PENDING.name(), "Pending"},
{DocumentStatus.APPROVED.name(), "Approved"},
{DocumentStatus.APPROVALPENDING.name(), "Approval Pending"},
{DocumentStatus.CURRENT.name(), "Current"},
{DocumentStatus.OBSOLETE.name(), "Obsolete"},
{DocumentStatus.DEFAULT.name(), "Default"},
{DocumentStatus.EXPIRED.name(), "Expired"},
{DocumentStatus.INPROGRESS.name(), "In Progress"},
{DocumentStatus.FINAL.name(), "Final"},
{DocumentStatus.NOTAPPROVED.name(), "Not Approved"},
{DocumentStatus.PRELIMINARY.name(), "Preliminary"},
{DocumentStatus.REVIEWED.name(), "Reviewed"},
{DocumentStatus.TEMPORARY.name(), "Temporary"},
{DocumentStatus.REQUIRESREVIEW.name(), "Requires Review"},
{DocumentStatus.SUPPLEMENTAL.name(), "Supplemental"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
