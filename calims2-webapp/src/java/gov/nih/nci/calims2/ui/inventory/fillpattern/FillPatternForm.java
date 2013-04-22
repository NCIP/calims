/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.fillpattern;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author connollym
 * 
 */
public class FillPatternForm extends CRUDForm<FillPattern> {
  
  private static Logger log = LoggerFactory.getLogger(FillPatternForm.class);

  private static final long serialVersionUID = -2466277621349733905L;
  
  private String coordinates;
  private Long layoutId;
  private Long personId;

  /**
   * Default constructor.
   */
  public FillPatternForm() {
    setEntity(new FillPattern());
  }

  /**
   * {@inheritDoc}
   */
  public FillPattern getSubmittedEntity() {
    FillPattern fillPattern = getEntity();
    fillPattern.setLayout(EntityWithIdHelper.createEntity(Layout.class, layoutId));
    fillPattern.setContactPerson(EntityWithIdHelper.createEntity(Person.class, personId));
    fillPattern.setCoordinateCollection(decodeCoordinates());
    return fillPattern;
  }
  /**
   * Decode the list of coordinates. It comes in as a comma separated string of ids. Each id is in the form x_y.
   * @return the list of coordinates.
   */
  private List<Coordinate> decodeCoordinates() {
    log.debug("decodeCoordinates = {}", coordinates);
    List<Coordinate> result = new ArrayList<Coordinate>();
    if (StringUtils.isNotBlank(coordinates)) {
      for (String id : coordinates.split(",")) {
        String[] idElements = id.split("_");
        Coordinate coordinate = new Coordinate();
        coordinate.setX(new Integer(idElements[0]));
        coordinate.setY(new Integer(idElements[1]));
        result.add(coordinate);
        log.debug("coordinate = {}, {}", coordinate.getX(), coordinate.getY());
      }
    }
    return result;
  }

  /**
   * @return the coordinates
   */
  public String getCoordinates() {
    return coordinates;
  }

  /**
   * @param coordinates the coordinates to set
   */
  public void setCoordinates(String coordinates) {
    this.coordinates = coordinates;
  }

  /**
   * @return the layoutId
   */
  public Long getLayoutId() {
    return layoutId;
  }

  /**
   * @param layoutId the layoutId to set
   */
  public void setLayoutId(Long layoutId) {
    this.layoutId = layoutId;
  }

  /**
   * @return the personId
   */
  public Long getPersonId() {
    return personId;
  }

  /**
   * @param personId the personId to set
   */
  public void setPersonId(Long personId) {
    this.personId = personId;
  }

}
