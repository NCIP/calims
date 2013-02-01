package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class LayoutLabelTypeBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{LayoutLabelType.ALL_LOWER_CASE.name(), "All Lower Case"},
{LayoutLabelType.ALL_UPPER_CASE.name(), "All Upper Case"},
{LayoutLabelType.DIGITS.name(), "Digits"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}