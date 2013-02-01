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