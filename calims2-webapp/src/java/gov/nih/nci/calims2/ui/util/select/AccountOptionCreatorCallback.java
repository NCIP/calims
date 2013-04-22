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

import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;

/**
 * @author connollym
 *
 */
public class AccountOptionCreatorCallback implements OptionCreatorCallback<Account> {

  /**
   * {@inheritDoc}
   */
  public String getId(Account option) {
    return option.getId().toString();
  }

  /**
   * {@inheritDoc}
   */
  public String getLabel(Account option) {
    return option.getOrganization().getDisplayName() + "," + option.getDisplayName();
  }
}
