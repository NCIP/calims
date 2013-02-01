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
