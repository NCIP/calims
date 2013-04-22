/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.workflow.project;

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
import gov.nih.nci.calims2.domain.administration.Equipment;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Software;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.Worksheet;
import gov.nih.nci.calims2.domain.report.Report;
import gov.nih.nci.calims2.domain.workflow.Approval;
import gov.nih.nci.calims2.domain.workflow.Method;
import gov.nih.nci.calims2.domain.workflow.Project;
import gov.nih.nci.calims2.domain.workflow.enumeration.ProjectStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 *
 */
@Controller
@RequestMapping(ProjectController.URL_PREFIX)
public class ProjectController extends CRUDController<Project> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/workflow/project";

  /** Create approval sub flow. */
  static final int APPROVAL_SUBFLOW_ID = 0;
  
  /** Create collaboration sub flow. */
  static final int COLLABORATION_SUBFLOW_ID = 1;
  
  /** Create equipment sub flow. */
  static final int EQUIPMENT_SUBFLOW_ID = 2;
  
  /** Create laboratory sub flow. */
  static final int LABORATORY_SUBFLOW_ID = 3;
  
  /** Create labsupply sub flow. */
  static final int LABSUPPLY_SUBFLOW_ID = 4;
  
  /** Create method sub flow. */
  static final int METHOD_SUBFLOW_ID = 5;
  
  /** Create organization sub flow. */
  static final int ORGANIZATION_SUBFLOW_ID = 6;
  
  /** Create person sub flow. */
  static final int PERSON_SUBFLOW_ID = 7;
  
  /** Create report sub flow. */
  static final int REPORT_SUBFLOW_ID = 8;
  
  /** Create labsupply sub flow. */
  static final int SOFTWARE_SUBFLOW_ID = 9;
  
  /** Create labsupply sub flow. */
  static final int SPECIMEN_SUBFLOW_ID = 10;
  
  /** Create worksheet sub flow. */
  static final int WORKSHEET_SUBFLOW_ID = 11;
  
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 12;

  
  private GenericService<Approval> approvalService;
  private GenericService<Collaboration> collaborationService;
  private GenericService<Equipment> equipmentService;
  private GenericService<Laboratory> laboratoryService;
  private GenericService<LabSupply> labSupplyService;
  private GenericService<Method> methodService;
  private GenericService<Report> reportService;
  private GenericService<Organization> organizationService;
  private GenericService<Person> personService;
  private GenericService<Software> softwareService;
  private GenericService<Specimen> specimenService;
  private GenericService<Worksheet> worksheetService;
  private GenericService<Type> typeService;
  

  /**
   * Default constructor.
   */
  public ProjectController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/workflow/approval/create.do", 
                                        "/administration/collaboration/create.do",
                                        "/administration/equipment/create.do", 
                                        "/administration/laboratory/create.do", 
                                        "/inventory/labsupply/create.do",
                                        "/workflow/method/create.do", 
                                        "/administration/organization/create.do",
                                        "/administration/person/create.do",
                                        "/report/report/create.do",
                                        "/administration/software/create.do", 
                                        "/inventory/specimen/create.do",
                                        "/inventory/worksheet/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.PROJECT,
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
  public ModelAndView call(@ModelAttribute("form") ProjectForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Worksheet> worksheets = worksheetService.findAll(Worksheet.class, "name");
    model.addObject("worksheets", worksheets);
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.PROJECT.name());
    List<Type> types = typeService.findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params1);
    model.addObject("types", types);
    model.addObject("projectStatuses", I18nEnumerationHelper.getLocalizedValues(ProjectStatus.class, locale));
    List<Approval> approvals = approvalService.findAll(Approval.class, "name");
    model.addObject("approvals", approvals);
    List<Collaboration> collaborations = collaborationService.findAll(Collaboration.class, "name");
    model.addObject("collaborations", collaborations);
    List<Equipment> equipments = equipmentService.findAll(Equipment.class, "name");
    model.addObject("equipments", equipments);
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    List<Laboratory> laboratories = laboratoryService.findAll(Laboratory.class, "name");
    model.addObject("laboratories", laboratories);
    List<LabSupply> labsupplies = labSupplyService.findAll(LabSupply.class, "name");
    model.addObject("labSupplies", labsupplies);
    List<Method> methods = methodService.findAll(Method.class, "name");
    model.addObject("methods", methods);
    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
    List<Report> reports = reportService.findAll(Report.class, "name");
    model.addObject("reports", reports);
    List<Software> softwares = softwareService.findAll(Software.class, "name");
    model.addObject("softwares", softwares);
    List<Specimen> specimens = specimenService.findAll(Specimen.class, "name");
    model.addObject("specimens", specimens);
    return model;
  }

  /**
   * {@inheritDoc}
   */
//  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
//    if (entityId != null) {
//      Project project = ((ProjectForm) model.getModel().get("form")).getEntity();
//      switch (subFlowId) {
//        case LABORATORY_SUBFLOW_ID: {
//          project.getLaboratoryCollection().add(EntityWithIdHelper.createEntity(Laboratory.class, entityId));
//          break;
//        }
//        case TYPE_SUBFLOW_ID: {
//          project.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
//          break;
//        }
//        case APPROVAL_SUBFLOW_ID: {
//          project.getApprovalCollection().add(EntityWithIdHelper.createEntity(Approval.class, entityId));
//          break;
//        }
//        case COLLABORATION_SUBFLOW_ID: {
//          project.getCollaborationCollection().add(EntityWithIdHelper.createEntity(Collaboration.class, entityId));
//          break;
//        }
//        case EQUIPMENT_SUBFLOW_ID: {
//          project.getEquipmentCollection().add(EntityWithIdHelper.createEntity(Equipment.class, entityId));
//          break;
//        }
//        case PERSON_SUBFLOW_ID: {
//          project.getPersonCollection().add(EntityWithIdHelper.createEntity(Person.class, entityId));
//          break;
//        }
//        case LABSUPPLY_SUBFLOW_ID: {
//          project.getLabSupplyCollection().add(EntityWithIdHelper.createEntity(LabSupply.class, entityId));
//          break;
//        }
//        case METHOD_SUBFLOW_ID: {
//          project.getMethodCollection().add(EntityWithIdHelper.createEntity(Method.class, entityId));
//          break;
//        }
//        case REPORT_SUBFLOW_ID: {
//          project.getReportCollection().add(EntityWithIdHelper.createEntity(Report.class, entityId));
//          break;
//        }
//        case SOFTWARE_SUBFLOW_ID: {
//          project.getSoftwareCollection().add(EntityWithIdHelper.createEntity(Software.class, entityId));
//          break;
//        }
//        case SPECIMEN_SUBFLOW_ID: {
//          project.getSpecimenCollection().add(EntityWithIdHelper.createEntity(Specimen.class, entityId));
//          break;
//        }
//        case WORKSHEET_SUBFLOW_ID: {
//          project.getWorksheetCollection().add(EntityWithIdHelper.createEntity(Worksheet.class, entityId));
//          break;
//        }
//        default: {
//          throw new IllegalArgumentException("Wrong subFlowId");
//        }
//      }
//    }
//  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") ProjectForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param approvalService the approvalService to set
   */
  @Resource(name = "approvalService")
  public void setApprovalService(GenericService<Approval> approvalService) {
    this.approvalService = approvalService;
  }

  /**
   * @param collaborationService the collaborationService to set
   */
  @Resource(name = "collaborationService")
  public void setCollaborationService(GenericService<Collaboration> collaborationService) {
    this.collaborationService = collaborationService;
  }

  /**
   * @param equipmentService the equipmentService to set
   */
  @Resource(name = "equipmentService")
  public void setEquipmentService(GenericService<Equipment> equipmentService) {
    this.equipmentService = equipmentService;
  }

  /**
   * @param laboratoryService the laboratoryService to set
   */
  @Resource(name = "laboratoryService")
  public void setLaboratoryService(GenericService<Laboratory> laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  /**
   * @param labSupplyService the labSupplyService to set
   */
  @Resource(name = "labSupplyService")
  public void setLabSupplyService(GenericService<LabSupply> labSupplyService) {
    this.labSupplyService = labSupplyService;
  }

  /**
   * @param methodService the methodService to set
   */
  /*
  @Resource(name = "methodService")
  public void setMethodService(GenericService<Method> methodService) {
    this.methodService = methodService;
  }*/

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
   * @param projectService the projectService to set
   */
  @Resource(name = "projectService")
  public void setProjectService(GenericService<Project> projectService) {
    super.setMainService(projectService);
  }

  /**
   * @param reportService the reportService to set
   */
  @Resource(name = "reportService")
  public void setReportService(GenericService<Report> reportService) {
    this.reportService = reportService;
  }

  /**
   * @param softwareService the softwareService to set
   */
  @Resource(name = "softwareService")
  public void setSoftwareService(GenericService<Software> softwareService) {
    this.softwareService = softwareService;
  }

  /**
   * @param specimenService the specimenService to set
   */
  @Resource(name = "specimenService")
  public void setSpecimenService(GenericService<Specimen> specimenService) {
    this.specimenService = specimenService;
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }

  /**
   * @param worksheetService the worksheetService to set
   */
  @Resource(name = "worksheetService")
  public void setWorksheetService(GenericService<Worksheet> worksheetService) {
    this.worksheetService = worksheetService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "projectFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "projectTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
