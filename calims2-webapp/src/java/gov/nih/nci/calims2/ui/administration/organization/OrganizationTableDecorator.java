/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.organization;

import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.uic.descriptor.command.Command;

/**
 * @author connollym
 *
 */
public class OrganizationTableDecorator extends CRUDTableDecorator<Organization> {

  
  /**
   * {@inheritDoc}
   */

  protected List<Boolean> getItemCommandFlags(List<Boolean> flags, Organization row) {
    List<Boolean> result = new ArrayList<Boolean>();
    boolean hasDocuments = true;
    if (row.getDocumentCollection().size() == 0) {
      hasDocuments = false;
    }
    int i = 0;
    for (Command command : getTable().getItemCommands()) {
      boolean flag = flags.get(i);
      i++;
      String commandName = command.getName();
    
      if ("document".equals(commandName)) {
        result.add(flag && hasDocuments);
        continue;
      }
      if ("nodocument".equals(commandName)) {
        result.add(flag && !hasDocuments);
        continue;
      }
      result.add(flag);
    }
    return result;
  }
}

