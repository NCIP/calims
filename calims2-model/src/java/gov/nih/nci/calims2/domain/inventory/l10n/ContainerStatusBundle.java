/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class ContainerStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{ContainerStatus.ACTIVE.name(), "Active"},
{ContainerStatus.AVAILABLE.name(), "Available"},
{ContainerStatus.INACTIVE.name(), "Inactive"},
{ContainerStatus.UNAVAILABLE.name(), "Unavailable"},
{ContainerStatus.CURRENT.name(), "Current"},
{ContainerStatus.DAMAGED.name(), "Damaged"},
{ContainerStatus.DEFAULT.name(), "Default"},
{ContainerStatus.DISCARDED.name(), "Discarded"},
{ContainerStatus.FAILED.name(), "Failed"},
{ContainerStatus.INSTOCK.name(), "In Stock"},
{ContainerStatus.OBSOLETE.name(), "Obsolete"},
{ContainerStatus.OUTOFSTOCK.name(), "Out Of Stock"},
{ContainerStatus.PENDING.name(), "Pending"},
{ContainerStatus.RECEIVED.name(), "Received"},
{ContainerStatus.RECOMMENDED.name(), "Recommended"},
{ContainerStatus.REPLACED.name(), "Replaced"},
{ContainerStatus.REQUIRED.name(), "Required"},
{ContainerStatus.SCHEDULED.name(), "Scheduled"},
{ContainerStatus.SECONDARY.name(), "Secondary"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
