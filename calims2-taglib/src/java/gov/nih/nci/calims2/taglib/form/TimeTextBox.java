/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib.form;

import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * @author viseem
 *
 */
public class TimeTextBox extends ValidationTextBoxTag {
  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_TIME_TEXTBOX.getTypeName());
  }
  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    // TODO Auto-generated method stub
    return null;
  }

}
