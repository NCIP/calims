package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.ProcessedDataStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ProcessedDataStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ProcessedDataStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}