package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.LocationStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class LocationStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{LocationStatus.ACTIVE.name(), "Active"},
{LocationStatus.ALTERNATE.name(), "Alternate"},
{LocationStatus.APPROVALPENDING.name(), "Approval Pending"},
{LocationStatus.APPROVED.name(), "Approved"},
{LocationStatus.NOTAPPROVED.name(), "Not Approved"},
{LocationStatus.CURRENT.name(), "Current"},
{LocationStatus.DEFAULT.name(), "Default"},
{LocationStatus.OBSOLETE.name(), "Obsolete"},
{LocationStatus.PRIMARY.name(), "Primary"},
{LocationStatus.RECOMMENDED.name(), "Recommended"},
{LocationStatus.SECONDARY.name(), "Secondary"},
{LocationStatus.TEMPORARY.name(), "Temporary"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
