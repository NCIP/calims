/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util.select;

import gov.nih.nci.calims2.domain.interfaces.Displayable;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;

/**
 * @author viseem
 * 
 */
public class NameOptionCreatorCallback implements OptionCreatorCallback<Displayable> {

  /**
   * {@inheritDoc}
   */
  public String getId(Displayable option) {
    return option.getId().toString();
  }

  /**
   * {@inheritDoc}
   */
  public String getLabel(Displayable option) {
    return option.getName();
  }

}
