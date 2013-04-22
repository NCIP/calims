/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.enumeration.LocationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class LocationControllerTest {

  private static final Long[] LOC_IDS = new Long[] {1L, 5L, 6L };

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    LocationController controller = new LocationController();
    CRUDAssert.assertControllerConstructor(controller, LocationController.URL_PREFIX, "administration.location.", "name",
        Location.class, LocationForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    LocationController controller = new LocationController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    GenericServiceMockup<Location> locationService = new GenericServiceMockup<Location>();
    controller.setLocationService(locationService);
    ModelAndView model = new ModelAndView();
    LocationForm form = new LocationForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.LOCATION, "types", result);
    CRUDAssert.assertFindAll(locationService, Location.class, "name", "parentLocations", result);
    CRUDAssert.assertEnumerationCollection(result, "locationStatuses", LocationStatus.class);
  }

  /**
   * Test the controller filterDescendants method.
   */
  @Test
  public void tesFilterDescendants() {
    int[] parent = new int[] {-1, 0, 1, 1, 0, -1 };
    List<Location> locations = new ArrayList<Location>();
    for (int i = 1; i <= parent.length; i++) {
      Location location = new Location();
      location.setId(new Long(i));
      locations.add(location);
    }
    for (int i = 0; i < locations.size(); i++) {
      if (parent[i] >= 0) {
        locations.get(i).setParentLocation(locations.get(parent[i]));
      }
    }
    LocationController controller = new LocationController();
    List<Location> result = controller.filterDescendents(locations, locations.get(1));
    assertNotNull("No result returned", result);
    assertEquals("Result has the wrong size", LOC_IDS.length, result.size());
    for (int i = 0; i < result.size(); i++) {
      assertEquals("Wrong location returned", LOC_IDS[i], result.get(i).getId());
    }
  }

}
