package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class NamingConventionTypeBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{NamingConventionType.EQUIPMENTNAME.name(), "Equipment Name"},
{NamingConventionType.SPECIMENNAME.name(), "Specimen Name"},
{NamingConventionType.CONTAINERNAME.name(), "Container Name"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
