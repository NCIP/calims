/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.WordStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class WordStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{WordStatus.ALTERNATE.name(), "Alternate"},
{WordStatus.APPROVALPENDING.name(), "Approval Pending"},
{WordStatus.APPROVED.name(), "Approved"},
{WordStatus.CURRENT.name(), "Current"},
{WordStatus.DEFAULT.name(), "Default"},
{WordStatus.OBSOLETE.name(), "Obsolete"},
{WordStatus.RECOMMENDED.name(), "Recommended"},
{WordStatus.REPLACED.name(), "Replaced"},
{WordStatus.REQUIRED.name(), "Required"},
{WordStatus.UNVALIDATED.name(), "Unvalidated"},
{WordStatus.VALIDATED.name(), "Validated"},
{WordStatus.VALIDATIONINPROGRESS.name(), "Validation In Progress"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
