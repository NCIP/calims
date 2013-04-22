/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.container;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gov.nih.nci.calims2.business.inventory.container.CoordinateHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.table.Column;

/**
 * @author viseem
 * 
 */
public class ContainerTableDecorator extends CRUDTableDecorator<Container> {
  /**
   * {@inheritDoc}
   */
  public String getValue(Container row, Column column, Object value) {
    if ("coordinateX".equals(column.getName())) {
      return getCoordinateX(row);
    }
    if ("coordinateY".equals(column.getName())) {
      return getCoordinateY(row);
    }
    return getDefaultValue(row, column, value);
  }

  private String getCoordinateX(Container container) {
    if (container.getParentContainer() != null) {
      Layout layout = container.getParentContainer().getLayout();
      Coordinate coordinate = container.getCoordinate();
      return CoordinateHelper.getCoordinateString(layout.getX_dimensionLabel(), layout.getX_dimension(), coordinate.getX());
    }
    return "";
  }

  private String getCoordinateY(Container container) {
    if (container.getParentContainer() != null) {
      Layout layout = container.getParentContainer().getLayout();
      Coordinate coordinate = container.getCoordinate();
      return CoordinateHelper.getCoordinateString(layout.getY_dimensionLabel(), layout.getY_dimension(), coordinate.getY());
    }
    return "";
  }
  
  /**
   * {@inheritDoc}
   */
  protected List<Boolean> getItemCommandFlags(List<Boolean> flags, Container row) {
    List<Boolean> result = new ArrayList<Boolean>();
    int i = 0;
    for (Command command : getTable().getItemCommands()) {
      boolean flag = flags.get(i);
      boolean hasNoChildren = CollectionUtils.isEmpty(row.getChildContainerCollection());
      i++;
      String commandName = command.getName();
      if ("viewChildren".equals(commandName)) {
        result.add(flag && !hasNoChildren);
        continue;
      }
      if ("createChild".equals(commandName)) {
        result.add(flag && hasNoChildren && row.getContainerType().getComposition() == ContainerComposition.COMPLEX);
        continue;
      }
      if ("copy".equals(commandName)) {
        result.add(flag && row.getIsTemplate() != null && row.getIsTemplate());
        continue;
      }
      result.add(flag);
    }
    return result;
  }

}
