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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.enumeration.LocationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
@Controller
@RequestMapping(LocationController.URL_PREFIX)
public class LocationController extends CRUDController<Location> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/location";

  /** Create location sub flow. */
  static final int LOCATION_SUBFLOW_ID = 0;
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 1;

  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public LocationController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/location/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.LOCATION,
                                        "/common/document/enterList.do",
                                        "/administration/contactinformation/enterList.do"});
    config.setAdvancedSearch(true);
  }
  
  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") LocationForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Location> parentLocations = super.getMainService().findAll(Location.class, "name");
    Location location = ((LocationForm) model.getModel().get("form")).getEntity();
    model.addObject("parentLocations", filterDescendents(parentLocations, location));
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.LOCATION.name());
    List<Type> types = typeService.findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params1);
    model.addObject("types", types);
    model.addObject("locationStatuses", I18nEnumerationHelper.getLocalizedValues(LocationStatus.class, locale));
    return model;
  }
  
  /**
   * filters the descendants of the given location from the list of locations.
   * 
   * @param locations The list of locations to filter
   * @param location The location to filter from the list (with all its descendants)
   * @return The filtered list.
   */
  List<Location> filterDescendents(List<Location> locations, Location location) {
    if (location.getId() == null) {
      return locations;
    }
    List<Location> result = new ArrayList<Location>();
    for (Location candidate : locations) {
      Location currentLocation = candidate;
      while (currentLocation != null && !currentLocation.getId().equals(location.getId())) {
        currentLocation = currentLocation.getParentLocation();
      }
      if (currentLocation == null) {
        result.add(candidate);
      }
    }
    return result;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Location location = ((LocationForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case LOCATION_SUBFLOW_ID: {
          location.setParentLocation(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          location.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") LocationForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param locationService the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> locationService) {
    super.setMainService(locationService);
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "locationFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "locationTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
