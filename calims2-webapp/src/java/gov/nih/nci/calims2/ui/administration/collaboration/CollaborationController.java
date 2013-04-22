/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.collaboration;

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
import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.CollaborationStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxienformatics.com
 * 
 */
@Controller
@RequestMapping(CollaborationController.URL_PREFIX)
public class CollaborationController extends CRUDController<Collaboration> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/collaboration";

  /** Create laboratory subflow id.*/ 
  static final int LABORATORY_SUBFLOW_ID = 0;
  /** Create organization subflow id.*/ 
  static final int ORGANIZATION_SUBFLOW_ID = 1;
  /** Create person subflow id.*/ 
  static final int PERSON_SUBFLOW_ID = 2;
  /** Create type subflow id.*/ 
  static final int TYPE_SUBFLOW_ID = 3;

  private GenericService<Laboratory> laboratoryService;
  private GenericService<Organization> organizationService;
  private GenericService<Person> personService;
  private GenericService<Role> roleService;
  private GenericService<Type> typeService;


  /**
   * Default constructor.
   */
  public CollaborationController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/laboratory/create.do", 
                                         "/administration/organization/create.do",
                                         "/administration/person/create.do",
                                         "/common/type/create.do?dataElementCollection=" + TypeEnumeration.COLLABORATION,
                                         "/administration/contactinformation/enterList.do",
                                         "/common/document/enterList.do"});
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
  public ModelAndView call(@ModelAttribute("form") CollaborationForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
   
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.COLLABORATION.name());
    List<Type> types = typeService.findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params1);
    model.addObject("types", types);
    List<Laboratory> laboratories = laboratoryService.findAll(Laboratory.class, "name");
    model.addObject("laboratories", laboratories);
    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("roleType", RoleType.COLLABORATION);
    List<Role> roles = roleService.findByNamedQuery(Role.class.getName() + ".findByRoleType", params);
    model.addObject("roles", roles);
    model.addObject("collaborationStatuses", I18nEnumerationHelper.getLocalizedValues(CollaborationStatus.class, locale));
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Collaboration collaboration = ((CollaborationForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case PERSON_SUBFLOW_ID: {
          collaboration.getPersonCollection().add(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        case LABORATORY_SUBFLOW_ID: {
          collaboration.getLaboratoryCollection().add(EntityWithIdHelper.createEntity(Laboratory.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          collaboration.getOrganizationCollection().add(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          collaboration.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") CollaborationForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param collaborationService the collaborationService to set
   */
  @Resource(name = "collaborationService")
  public void setCollaborationService(GenericService<Collaboration> collaborationService) {
    super.setMainService(collaborationService);
  }

  /**
   * @param laboratoryService the laboratoryService to set
   */
  @Resource(name = "laboratoryService")
  public void setLaboratoryService(GenericService<Laboratory> laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  /**
   * @param organizationService the organizationService to set
   */
  @Resource(name = "organizationService")
  public void setOrganizationService(GenericService<Organization> organizationService) {
    this.organizationService = organizationService;
  }

  /**
   * @param personService the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> personService) {
    this.personService = personService;
  }

  /**
   * @param roleService the roleService to set
   */
  @Resource(name = "roleService")
  public void setRoleService(GenericService<Role> roleService) {
    this.roleService = roleService;
  }

  /**
   * @param typeService the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> typeService) {
    this.typeService = typeService;
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "collaborationFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "collaborationTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
