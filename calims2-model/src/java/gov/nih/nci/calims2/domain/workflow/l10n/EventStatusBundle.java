package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.EventStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class EventStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{EventStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}