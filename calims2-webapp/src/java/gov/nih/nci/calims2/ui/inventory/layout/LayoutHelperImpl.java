/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.layout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.util.json.JsonSerializer;

/**
 * @author viseem
 * 
 */
public class LayoutHelperImpl implements LayoutHelper {

  private JsonSerializer serializer = new JsonSerializer();

  /**
   * {@inheritDoc}
   */
  public String getLayoutMap(List<Layout> layouts) {
    Map<String, Object> jsonObject = new TreeMap<String, Object>();
    for (Layout layout : layouts) {
      Map<String, Object> l = new TreeMap<String, Object>();
      l.put("x", layout.getX_dimension());
      l.put("labelX", layout.getX_dimensionLabel().getName());
      l.put("y", layout.getY_dimension());
      l.put("labelY", layout.getY_dimensionLabel().getName());
      jsonObject.put(layout.getId().toString(), l);
    }
    return serializer.serializeObject(jsonObject);
  }

  /**
   * {@inheritDoc}
   */
  public String getContainerLayoutMap(List<Container> containers) {
    Map<String, Object> jsonObject = new TreeMap<String, Object>();
    for (Container container : containers) {
      jsonObject.put(container.getId().toString(), container.getLayout().getId());
    }
    return serializer.serializeObject(jsonObject);
  }

  /**
   * {@inheritDoc}
   */
  public String getCoordinates(List<Coordinate> coordinates) {
    List<Map<String, Object>> jsonObject = new ArrayList<Map<String, Object>>();
    for (Coordinate coordinate : coordinates) {
      Map<String, Object> c = new TreeMap<String, Object>();
      c.put("x", coordinate.getX());
      c.put("y", coordinate.getY());
      jsonObject.add(c);
    }
    return serializer.serializeCollection(jsonObject);
  }
}
