/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.unit;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;

/**
 * API for unit conversion. This is a anti-corruption layer interface to implement for integration of third party unit converters.
 * 
 * @author viseem
 * 
 */
public interface UnitConverter {
  /**
   * Signal the creation of a new standard unit.
   * 
   * @param unit The new standard unit created.
   */
  void unitCreated(StandardUnit unit);

  /**
   * Signal the update of a standard unit.
   * 
   * @param unit The standard unit updated.
   */
  void unitUpdated(StandardUnit unit);

  /**
   * Signal the deletion of a standard unit.
   * 
   * @param unit The standard unit deleted.
   */
  void unitDeleted(StandardUnit unit);

  /**
   * Convert the given Quantity to the given unit.
   * 
   * @param from The quantity to convert
   * @param toUnit The Unit to convert to
   * @return A new Quantity object
   */
  Quantity convert(Quantity from, StandardUnit toUnit);

}
