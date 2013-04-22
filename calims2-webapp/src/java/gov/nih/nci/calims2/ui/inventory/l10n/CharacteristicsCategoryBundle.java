/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.l10n;

import java.util.ListResourceBundle;

import gov.nih.nci.calims2.ui.inventory.characteristics.CharacteristicsCategory;

/**
 * @author viseem
 *
 */
public class CharacteristicsCategoryBundle extends ListResourceBundle {

  private static final Object[][] CONTENTS = {
    {CharacteristicsCategory.BIO.name(), "Biological Characteristics"},
    {CharacteristicsCategory.CHEMICAL.name(), "Chemical Characteristics"},
    {CharacteristicsCategory.PHYSICAL.name(), "Physical Characteristics"}
  };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
