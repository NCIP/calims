/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ContainerCompositionBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ContainerComposition.SIMPLE.name(), "Simple"},
{ContainerComposition.COMPOSITE.name(), "Composite"},
{ContainerComposition.COMPLEX.name(), "Complex"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}