package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class CharacterSetBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{CharacterSet.ALL_LOWER_CASE.name(), "All Lower Case"},
{CharacterSet.ALL_UPPER_CASE.name(), "All Upper Case"},
{CharacterSet.MIXED_CASE.name(), "Mixed Case"},
{CharacterSet.DIGITS.name(), "Digits"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
