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

import gov.nih.nci.calims2.business.generic.GenericServiceImpl;
import gov.nih.nci.calims2.business.inventory.container.CoordinateHelper;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;

/**
 * @author viseem
 *
 */
public class SpecimenServiceImpl extends GenericServiceImpl<Specimen> implements SpecimenService {

  /**
   * {@inheritDoc}
   */
  public void createForCompositeContainer(Specimen specimen, Long fillPatternId) throws ValidationException {
    Container container = getGenericDao().findById(Container.class, specimen.getContainer().getId());
    if (container.getContainerType().getComposition() != ContainerComposition.COMPOSITE) {
      throw new ValidationException("Container is not composite");
    }
    FillPattern fillPattern = getGenericDao().findById(FillPattern.class, fillPatternId);
    if (!fillPattern.getLayout().getId().equals(container.getLayout().getId())) {
      throw new ValidationException("FillPattern not applicable to the layout of the container");
    }
    String name = specimen.getName();
    String displayName = specimen.getDisplayName();
    for (Coordinate coordinate : fillPattern.getCoordinateCollection()) {
      int x = coordinate.getX();
      int y = coordinate.getY();
      String suffix = CoordinateHelper.getCoordinateSuffix(fillPattern.getLayout(), coordinate);
      specimen.setName(name + suffix);
      specimen.setDisplayName(displayName + suffix);
      specimen.setContainer(null);
      for (Container childContainer : container.getChildContainerCollection()) {
        Coordinate childCoordinate = childContainer.getCoordinate();
        int childX = childCoordinate.getX();
        int childY = childCoordinate.getY();
        if (x == childX && y == childY) {
          specimen.setContainer(childContainer);
          break;
        }
      }
      if (specimen.getContainer() == null) {
        throw new ValidationException("Missing child container at coordinate " + coordinate.getX() + " - " + coordinate.getY());
      }
      create(specimen);
    }
  }

  /**
   * {@inheritDoc}
   */
  public void createTransfers(List<SpecimenTransfer> transfers) throws ValidationException {
    for (SpecimenTransfer transfer : transfers) {
      createTransfer(transfer);
    }
  }
  
  /**
   * Create a new specimen according to the given transfer specification.
   * @param transfer The specification of the transfer to make.
   * @throws ValidationException If an error occurs
   */
  public void createTransfer(SpecimenTransfer transfer) throws ValidationException {
    Specimen source = getGenericDao().findById(Specimen.class, transfer.getSpecimenId());
    Container container = getGenericDao().findById(Container.class, transfer.getContainerId());
    Specimen aliquot = SpecimenAliquotFactory.createAliquot(source, container);
    create(aliquot);
  }


}
