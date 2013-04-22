/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.l10n;


import java.util.ListResourceBundle;
import gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class EquipmentStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{EquipmentStatus.MALFUNCTION.name(), "Malfunction"},
{EquipmentStatus.ONLINE.name(), "Online"},
{EquipmentStatus.ACTIVE.name(), "Active"},
{EquipmentStatus.ALTERNATE.name(), "Alternative"},
{EquipmentStatus.AVAILABLE.name(), "Available"},
{EquipmentStatus.DAMAGED.name(), "Damaged"},
{EquipmentStatus.DEFAULT.name(), "Default"},
{EquipmentStatus.DELIVERED.name(), "Delivered"},
{EquipmentStatus.DISCARDED.name(), "Discarded"},
{EquipmentStatus.DONATED.name(), "Donated"},
{EquipmentStatus.INACTIVE.name(), "Inactive"},
{EquipmentStatus.INMAINTENANCE.name(), "In Maintenance"},
{EquipmentStatus.INREPAIR.name(), "In Repair"},
{EquipmentStatus.INSTALLED.name(), "Installed"},
{EquipmentStatus.NOTAPPROVED.name(), "Not Approved"},
{EquipmentStatus.OBSOLETE.name(), "Obsolete"},
{EquipmentStatus.OFFLINE.name(), "Off Line"},
{EquipmentStatus.ORDERED.name(), "Ordered"},
{EquipmentStatus.REPLACED.name(), "Replaced"},
{EquipmentStatus.SURPLUSED.name(), "Surplused"},
{EquipmentStatus.UNAVAILABLE.name(), "Unavailable"},
{EquipmentStatus.UNVALIDATED.name(), "Unvalidated"},
{EquipmentStatus.VALIDATED.name(), "Validated"},
{EquipmentStatus.VALIDATIONINPROGRESS.name(), "Validation In Progress"},
{EquipmentStatus.WARNING.name(), "Warning"},
{EquipmentStatus.RESERVED.name(), "Reserved"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
