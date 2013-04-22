/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.equipment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Equipment;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Software;
import gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.administration.namingconvention.NamingConventionHelperMockup;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class EquipmentControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    EquipmentController controller = new EquipmentController();
    CRUDAssert.assertControllerConstructor(controller, EquipmentController.URL_PREFIX, "administration.equipment.", "name",
        Equipment.class, EquipmentForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    EquipmentController controller = new EquipmentController();
    GenericServiceMockup<Laboratory> laboratoryService = new GenericServiceMockup<Laboratory>();
    controller.setLaboratoryService(laboratoryService);
    GenericServiceMockup<Location> locationService = new GenericServiceMockup<Location>();
    controller.setLocationService(locationService);
    NamingConventionHelperMockup namingConventionHelper = new NamingConventionHelperMockup();
    controller.setNamingConventionHelper(namingConventionHelper);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    controller.setOrganizationService(organizationService);
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setPersonService(personService);
    GenericServiceMockup<Software> softwareService = new GenericServiceMockup<Software>();
    controller.setSoftwareService(softwareService);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(laboratoryService, Laboratory.class, "name", "laboratories", result);
    CRUDAssert.assertFindAll(locationService, Location.class, "name", "locations", result);
    assertEquals("Wrong type passed to naming convention helper", NamingConventionType.EQUIPMENTNAME, 
                 namingConventionHelper.getTypeParam());
    assertEquals("Wrong naming conventions returned in the model", "NamingConvention", result.getModel().get("namingConventions"));
    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "organizations", result);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
    CRUDAssert.assertFindAll(softwareService, Software.class, "name", "softwares", result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.EQUIPMENT, "types", result);
    CRUDAssert.assertEnumerationCollection(result, "equipmentStatuses", EquipmentStatus.class);
  }

  /**
   * Test the controller createDefaultList method.
   */
  @Test
  public void testCreateDefaultList() {
    EquipmentController controller = new EquipmentController();
    GenericServiceMockup<Equipment> equipmentService = new GenericServiceMockup<Equipment>();
    controller.setMainService(equipmentService);
    List<Equipment> result = controller.createDefaultList();
    String queryName = Equipment.class.getName() + ".findByName";
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, equipmentService.getFindByQueryName());
    Map<String, Object> params = equipmentService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong number of paramters", 0, params.size());
    assertEquals("Wrong result returned", equipmentService.getFindByQueryNameResult(), result);
  }
}