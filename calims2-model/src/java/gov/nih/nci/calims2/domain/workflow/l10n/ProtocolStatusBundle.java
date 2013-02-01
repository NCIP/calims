package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.ProtocolStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ProtocolStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ProtocolStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}