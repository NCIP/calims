package gov.nih.nci.calims2.domain.workflow.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.workflow.enumeration.DataStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class DataStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{DataStatus.DEFAULT.name(), "Default"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}