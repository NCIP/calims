package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.FindingStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class FindingStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{FindingStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}