package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.ExperimentalResultStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ExperimentalResultStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ExperimentalResultStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}