/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.CollaborationStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class CollaborationStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{CollaborationStatus.ACTIVE.name(), "Active"},
{CollaborationStatus.INACTIVE.name(), "Inactive"},
{CollaborationStatus.PENDING.name(), "Pending"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
