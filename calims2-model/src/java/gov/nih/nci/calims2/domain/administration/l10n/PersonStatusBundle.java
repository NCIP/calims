package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.PersonStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class PersonStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{PersonStatus.ABSENT.name(), "Absent"},
{PersonStatus.ACTIVE.name(), "Active"},
{PersonStatus.INACTIVE.name(), "Inactive"},
{PersonStatus.ALTERNATE.name(), "Alternate"},
{PersonStatus.AVAILABLE.name(), "Available"},
{PersonStatus.UNAVAILABLE.name(), "Unavailable"},
{PersonStatus.CHILD.name(), "Child"},
{PersonStatus.CURRENT.name(), "Current"},
{PersonStatus.DEFAULT.name(), "Default"},
{PersonStatus.ONLEAVE.name(), "On Leave"},
{PersonStatus.ONSABBATICAL.name(), "On Sabbatical"},
{PersonStatus.PARENT.name(), "Parent"},
{PersonStatus.PERMANENT.name(), "Permanent"},
{PersonStatus.RETIRED.name(), "Retired"},
{PersonStatus.TEMPORARY.name(), "Temporary"},
{PersonStatus.LEAD.name(), "Lead"},
{PersonStatus.SEPERATED.name(), "Seperated"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
