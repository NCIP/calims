/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */

package gov.nih.nci.calims2.business.generic.l10n;


import gov.nih.nci.calims2.business.generic.GenericViolation;

import java.util.ListResourceBundle;

/**
 * ListResourceBundle for the PersonViolation enumeration.
 * @author connollym@moxieinformatics.com
 */
public class GenericViolationBundle extends ListResourceBundle {
  private static final Object[][] CONTENTS = {
    {GenericViolation.ORIGINAL_NOT_FOUND.name(), "The original object was not found"}
    };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}