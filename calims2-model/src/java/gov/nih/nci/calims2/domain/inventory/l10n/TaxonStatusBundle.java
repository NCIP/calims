/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.inventory.enumeration.TaxonStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class TaxonStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{TaxonStatus.REQUIRESREPORT.name(), "Requires Report"},
{TaxonStatus.PRELIMINARY.name(), "Preliminary"},
{TaxonStatus.FINAL.name(), "Final"},
{TaxonStatus.REPLACED.name(), "Replaced"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
