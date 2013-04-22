/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.common.enumeration.NotesStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class NotesStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{NotesStatus.DEFAULT.name(), "Default"},
{NotesStatus.WARNING.name(), "Warning"},
{NotesStatus.REQUIRED.name(), "Required"},
{NotesStatus.OBSOLETE.name(), "Obsolete"},
{NotesStatus.REPLACED.name(), "Replaced"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
