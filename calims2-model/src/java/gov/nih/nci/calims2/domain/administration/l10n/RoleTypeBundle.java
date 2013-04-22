/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class RoleTypeBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{RoleType.COLLABORATION.name(), "Collaboration"},
{RoleType.PERSON.name(), "Person"},
{RoleType.ORGANIZATION.name(), "Organization"},
{RoleType.LABORATORY.name(), "Laboratory"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}