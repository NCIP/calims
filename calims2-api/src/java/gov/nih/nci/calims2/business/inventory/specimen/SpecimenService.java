/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.specimen;

import java.util.List;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.inventory.Specimen;

/**
 * @author viseem
 * 
 */
public interface SpecimenService extends GenericService<Specimen> {
  /**
   * Create new specimen and assigns them to the children of a composite container according to a fillPattern.
   * 
   * @param specimen The data of the new specimen. This should be a non persistent object containing the data of the new Entity and
   *          the container provided in it must be composite
   * @param fillPatternId The id of the fill pattern to apply. The fill pattern must apply to the layout associated with the
   *          specified container
   * @throws ValidationException If an error occurs
   */
  void createForCompositeContainer(Specimen specimen, Long fillPatternId) throws ValidationException;

  /**
   * Create new specimen according to the given transfer specifications.
   * 
   * @param transfers The specification of the transfers to make.
   * @throws ValidationException If an error occurs
   */
  void createTransfers(List<SpecimenTransfer> transfers) throws ValidationException;

}
