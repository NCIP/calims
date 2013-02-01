package gov.nih.nci.calims2.domain.common.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.common.enumeration.ExternalIdentifierStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ExternalIdentifierStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ExternalIdentifierStatus.ALTERNATE.name(), "Alternate"},
{ExternalIdentifierStatus.AVAILABLE.name(), "Available"},
{ExternalIdentifierStatus.CURRENT.name(), "Current"},
{ExternalIdentifierStatus.DEFAULT.name(), "Default"},
{ExternalIdentifierStatus.INVALID.name(), "Invalid"},
{ExternalIdentifierStatus.OBSOLETE.name(), "Obsolete"},
{ExternalIdentifierStatus.PRIVATE.name(), "Private"},
{ExternalIdentifierStatus.PUBLIC.name(), "Public"},
{ExternalIdentifierStatus.REPLACED.name(), "Replaced"},
{ExternalIdentifierStatus.REQUIRED.name(), "Required"},
{ExternalIdentifierStatus.UNAVAILABLE.name(), "Unavailable"},
{ExternalIdentifierStatus.UNKNOWN.name(), "Unknown"},
{ExternalIdentifierStatus.VALIDATED.name(), "Validated"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}