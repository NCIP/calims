/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.common.enumeration.TypeStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class TypeStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{TypeStatus.ALTERNATE.name(), "Alternate"},
{TypeStatus.CURRENT.name(), "Current"},
{TypeStatus.DEFAULT.name(), "Default"},
{TypeStatus.OBSOLETE.name(), "Obsolete"},
{TypeStatus.OPTIONAL.name(), "Optional"},
{TypeStatus.RECOMMENDED.name(), "Recommended"},
{TypeStatus.REPLACED.name(), "Replaced"},
{TypeStatus.REQUIRED.name(), "Required"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
