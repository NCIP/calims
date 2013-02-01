package gov.nih.nci.calims2.domain.common.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.common.enumeration.ReferredClass;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ReferredClassBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ReferredClass.CONTAINER.name(), "Container"},
{ReferredClass.SPECIMEN.name(), "Specimen"},
{ReferredClass.LABSUPPLY.name(), "Lab Supply"},
{ReferredClass.REPORT.name(), "Report"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}