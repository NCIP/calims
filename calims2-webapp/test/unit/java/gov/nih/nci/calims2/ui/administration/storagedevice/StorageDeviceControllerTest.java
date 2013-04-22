/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.storagedevice;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Software;
import gov.nih.nci.calims2.domain.administration.StorageDevice;
import gov.nih.nci.calims2.domain.administration.StorageSpace;
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
public class StorageDeviceControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    StorageDeviceController controller = new StorageDeviceController();
    CRUDAssert.assertControllerConstructor(controller, StorageDeviceController.URL_PREFIX, "administration.storagedevice.", "name",
        StorageDevice.class, StorageDeviceForm.class, CRUDTableDecorator.class);
  }
  
  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    
    StorageDeviceController controller = new StorageDeviceController();
    GenericServiceMockup<Laboratory> laboratoryService = new GenericServiceMockup<Laboratory>();
    controller.setLaboratoryService(laboratoryService);
    GenericServiceMockup<Location> locationService = new GenericServiceMockup<Location>();
    controller.setLocationService(locationService);
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setPersonService(personService);
    GenericServiceMockup<StorageSpace> storageSpaceService = new GenericServiceMockup<StorageSpace>();
    controller.setStorageSpaceService(storageSpaceService);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    NamingConventionHelperMockup namingConventionHelper = new NamingConventionHelperMockup();
    controller.setNamingConventionHelper(namingConventionHelper);
    GenericServiceMockup<Software> softwareService = new GenericServiceMockup<Software>();
    controller.setSoftwareService(softwareService);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    controller.setOrganizationService(organizationService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "equipmentStatuses", EquipmentStatus.class);
    CRUDAssert.assertFindAll(laboratoryService, Laboratory.class, "name", "laboratories", result);
    CRUDAssert.assertFindAll(locationService, Location.class, "name", "locations", result);
    assertEquals("Wrong type passed to naming convention helper", NamingConventionType.EQUIPMENTNAME, 
        namingConventionHelper.getTypeParam());
    assertEquals("Wrong naming conventions returned in the model", "NamingConvention", result.getModel().get("namingConventions"));
    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "organizations", result);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
    CRUDAssert.assertFindAll(storageSpaceService, StorageSpace.class, "name", "storageSpaces", result);
    CRUDAssert.assertFindAll(softwareService, Software.class, "name", "softwares", result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.STORAGEDEVICE, "types", result);
  }
  
}