/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.account;

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
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountStatus;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(AccountController.URL_PREFIX)
public class AccountController extends CRUDController<Account> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/customerservice/account";

  /** Create laboratory sub flow. */
  static final int LABORATORY_SUBFLOW_ID = 0;
  
  /** Create organization sub flow. */
  static final int ORGANIZATION_SUBFLOW_ID = 1;
  
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 2;

  private GenericService<Document> documentService;
  private GenericService<Laboratory> laboratoryService;
  private GenericService<Organization> organizationService;
  private GenericService<Type> typeService;
  

  /**
   * Default constructor.
   */
  public AccountController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/laboratory/create.do", 
                                        "/administration/organization/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.ACCOUNT,
                                        "/administration/customerservice/accountnumber/enterList.do", 
                                        "/common/document/enterList.do",
                                        "/common/externalidentifier/enterList.do"});
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
  public ModelAndView call(@ModelAttribute("form") AccountForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Document> documents = documentService.findAll(Document.class, "name");
    model.addObject("documents", documents);
    List<Laboratory> laboratories = laboratoryService.findAll(Laboratory.class, "name");
    model.addObject("laboratories", laboratories);
    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.ACCOUNT.name());
    List<Type> types = typeService.findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params1);
    model.addObject("types", types);
    model.addObject("accountStatuses", I18nEnumerationHelper.getLocalizedValues(AccountStatus.class, locale));
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Account account = ((AccountForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case LABORATORY_SUBFLOW_ID: {
          account.setLaboratory(EntityWithIdHelper.createEntity(Laboratory.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          account.setOrganization(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          account.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") AccountForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param accountService the accountService to set
   */
  @Resource(name = "accountService")
  public void setAccountService(GenericService<Account> accountService) {
    super.setMainService(accountService);
  }

  /**
   * @param documentService the documentService to set
   */
  @Resource(name = "documentService")
  public void setDocumentService(GenericService<Document> documentService) {
    this.documentService = documentService;
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
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
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "accountFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "accountTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
