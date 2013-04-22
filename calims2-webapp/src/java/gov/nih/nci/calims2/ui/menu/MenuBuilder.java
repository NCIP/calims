/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/** *
 */
package gov.nih.nci.calims2.ui.menu;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;

import gov.nih.nci.calims2.uic.menu.SubMenu;
import gov.nih.nci.calims2.uic.menu.UrlItem;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * Builder class for constructing the menu.
 * 
 * @author viseem
 * 
 */
public class MenuBuilder {

  private static final String CALIMS2_PREFIX = "menu.mainmenu.calims2";
  private static final String THEME_PREFIX = CALIMS2_PREFIX + ".themes";
  private static final String ADMIN_PREFIX = "menu.mainmenu.administration";
  private static final String LAB_PREFIX = ADMIN_PREFIX + ".laboratory";
  private static final String EQUIPMENT_PREFIX = ADMIN_PREFIX + ".equipment";
  private static final String UNIT_PREFIX = ADMIN_PREFIX + ".unit";
  private static final String CS_PREFIX = "menu.mainmenu.cs";
  private static final String CR_PREFIX = CS_PREFIX + ".cr";
  private static final String INVENTORY_PREFIX = "menu.mainmenu.inventory";
  private static final String ARTIFICIALSPECIMEN_PREFIX = INVENTORY_PREFIX + ".artificialspecimen";
  private static final String BIOSPECIMEN_PREFIX = INVENTORY_PREFIX + ".biospecimen";
  private static final String CONTAINER_PREFIX = INVENTORY_PREFIX + ".container";
  private static final String WF_PREFIX = "menu.mainmenu.workflow";
  private static final String REPORT_PREFIX = "menu.mainmenu.report";
  private static final String HOME_URL = "/home/home.do";
  private static final String UNDER_CONSTRUCTION_URL = "/home/underConstruction.do";
  private static final String CHANGE_THEME_URL = "/home/changeTheme.do?theme=";
  private static final String CHANGE_ACCESS_URL = "/home/changeAccess.do";
  private static final String MANAGE_ACCOUNT_URL = "/administration/customerservice/account/manage.do";
  private static final String MANAGE_ANTIBODY_URL = "/inventory/antibody/manage.do";
  private static final String MANAGE_ANTIGEN_URL = "/inventory/antigen/manage.do";
  private static final String MANAGE_ADDITIONALORGANISMNAME_URL = "/inventory/additionalorganismname/manage.do";
  private static final String MANAGE_BASEUNIT_URL = "/administration/baseunit/manage.do";
  private static final String MANAGE_BILLINGINFORMATION_URL = "/administration/customerservice/billinginformation/manage.do";
  private static final String MANAGE_CARBOHYDRATE_URL = "/inventory/carbohydrate/manage.do";
  private static final String MANAGE_CELLSPECIMEN_URL = "/inventory/cellspecimen/manage.do";
  private static final String MANAGE_CHEMICALCOMPOUND_URL = "/inventory/chemicalcompound/manage.do";
  private static final String MANAGE_COLLABORATION_URL = "/administration/collaboration/manage.do";
  private static final String MANAGE_CONTAINER_URL = "/inventory/container/manage.do";
  private static final String CREATE_CONTAINERCATEGORY_URL = "/common/type/directCall.do";
  private static final String MANAGE_CONTAINERTYPE_URL = "/inventory/containertype/manage.do";
  private static final String MANAGE_CONTAINERSUBCATEGORY_URL = "/inventory/containersubcategory/manage.do";
  private static final String MANAGE_CONTRACT_URL = "/administration/customerservice/contract/manage.do";
  private static final String MANAGE_CUSTOMERREQUEST_URL = "/administration/customerservice/customerrequest/manage.do";
  private static final String MANAGE_EQUIPMENT_URL = "/administration/equipment/manage.do";
  private static final String MANAGE_EXPERIMENT_URL = "/workflow/experiment/manage.do";
  private static final String MANAGE_FILLPATTERN_URL = "/inventory/fillpattern/manage.do";
  private static final String MANAGE_FLUIDSPECIMEN_URL = "/inventory/fluidspecimen/manage.do";
  private static final String MANAGE_HAZARD_URL = "/inventory/hazard/manage.do";
  private static final String MANAGE_INVOICE_URL = "/administration/customerservice/invoice/manage.do";
  private static final String MANAGE_LABORATORY_URL = "/administration/laboratory/manage.do";
  private static final String MANAGE_LABSUPPLY_URL = "/inventory/labsupply/manage.do";
  private static final String MANAGE_LAYOUT_URL = "/inventory/layout/manage.do";
  private static final String MANAGE_LIPID_URL = "/inventory/lipid/manage.do";
  private static final String MANAGE_LOCATION_URL = "/administration/location/manage.do";
  private static final String MANAGE_MESSAGE_URL = "/administration/message/create.do";
  private static final String MANAGE_NAMINGCONVENTION_URL = "/administration/namingconvention/manage.do";
  private static final String MANAGE_NANOMATERIAL_URL = "/inventory/nanomaterial/manage.do";
  private static final String MANAGE_NUCLEICACID_URL = "/inventory/nucleicacid/manage.do";
  private static final String MANAGE_ORGANIZATION_URL = "/administration/organization/manage.do";
  private static final String MANAGE_PCRPRODUCT_URL = "/inventory/pcrproduct/manage.do";
  private static final String MANAGE_PERSON_URL = "/administration/person/manage.do";
  private static final String MANAGE_PRIMER_URL = "/inventory/primer/manage.do";
  private static final String MANAGE_PROCESSDESIGN_URL = "/workflow/processdesign/manage.do";
  private static final String MANAGE_PROJECT_URL = "/workflow/project/manage.do";
  private static final String MANAGE_PROTEIN_URL = "/inventory/protein/manage.do";
  private static final String MANAGE_QUERY_URL = "/report/query/manage.do";
  private static final String MANAGE_QUOTATION_URL = "/administration/customerservice/quotation/manage.do";
  private static final String MANAGE_RATE_URL = "/administration/customerservice/rate/manage.do";
  private static final String MANAGE_REPORT_URL = "/report/report/manage.do";
  private static final String MANAGE_REPORTDESIGN_URL = "/report/reportdesign/manage.do";
  private static final String MANAGE_ROLE_URL = "/administration/role/manage.do";
  private static final String MANAGE_SERVICE_URL = "/administration/customerservice/service/manage.do";
  private static final String MANAGE_SMALLMOLECULE_URL = "/inventory/smallmolecule/manage.do";
  private static final String MANAGE_SOFTWARE_URL = "/administration/software/manage.do";
  private static final String MANAGE_STANDARDUNIT_URL = "/administration/standardunit/manage.do";
  private static final String MANAGE_STORAGESPACE_URL = "/administration/storagespace/manage.do";
  private static final String MANAGE_STORAGEDEVICE_URL = "/administration/storagedevice/manage.do";
  private static final String MANAGE_STRAIN_URL = "/inventory/strain/manage.do";
  private static final String MANAGE_TASKLIST_URL = "/workflow/tasklist/list.do";
  private static final String MANAGE_TAXON_URL = "/inventory/taxon/manage.do";
  private static final String MANAGE_TISSUESPECIMEN_URL = "/inventory/tissuespecimen/manage.do";
  private static final String MANAGE_TYPE_URL = "/common/type/manage.do";
  private static final String MANAGE_WHOLEORGANISM_URL = "/inventory/wholeorganism/manage.do";
  

  private static final String[] THEMES = {"claro", "nihilo", "soria", "tundra" };

  private Authentication authentication;
  private Locale locale;
  private MessageSource messageSource;
  private PrivilegeEvaluator privilegeEvaluator;

  /**
   * @param locale the current locale
   * @param messageSource the current message source
   * @param privilegeEvaluator the privilege evaluator
   */
  public MenuBuilder(Locale locale, MessageSource messageSource, PrivilegeEvaluator privilegeEvaluator) {
    this.authentication = privilegeEvaluator.getCurrentUser();
    this.locale = locale;
    this.messageSource = messageSource;
    this.privilegeEvaluator = privilegeEvaluator;
  }

  /**
   * Builds the application menu.
   * 
   * @return the application menu.
   */
  public SubMenu getMenu() {
    SubMenu rootMenu = new SubMenu();
    addSubMenu(rootMenu, createCaLimsMenu());
    addSubMenu(rootMenu, createAdminMenu());
    addSubMenu(rootMenu, createCustomerServiceMenu());
    addSubMenu(rootMenu, createInventoryMenu());
    //addSubMenu(rootMenu, createWorkflowMenu());
    addSubMenu(rootMenu, createReportMenu());
    return rootMenu;
  }

  /**
   * Adds the given subMenu to the root menu.
   * 
   * @param rootMenu The root menu under construction
   * @param subMenu The submenu to add
   */
  private void addSubMenu(SubMenu rootMenu, SubMenu subMenu) {
    if (!subMenu.getChildren().isEmpty()) {
      rootMenu.addChild(subMenu);
    }
  }

  private SubMenu createCaLimsMenu() {
    SubMenu caLims = new SubMenu(messageSource.getMessage(CALIMS2_PREFIX, null, locale));
    if (privilegeEvaluator.isAllowed(HOME_URL, authentication)) {
      caLims.addChild(createItem(CALIMS2_PREFIX + ".home", HOME_URL));
    }
    caLims.addChild(createThemeMenu());
    return caLims;
  }

  private SubMenu createThemeMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(THEME_PREFIX, null, locale));
    for (String theme : THEMES) {
      menu.addChild(createItem(THEME_PREFIX + "." + theme, CHANGE_THEME_URL + theme));
    }
    menu.addChild(createItem(THEME_PREFIX + ".access", CHANGE_ACCESS_URL));
    return menu;
  }

  private SubMenu createAdminMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(ADMIN_PREFIX, null, locale));
    addChild(menu, ADMIN_PREFIX + ".person", MANAGE_PERSON_URL);
    addChild(menu, ADMIN_PREFIX + ".organization", MANAGE_ORGANIZATION_URL);
    addChild(menu, ADMIN_PREFIX + ".role", MANAGE_ROLE_URL);
    addSubMenu(menu, createLaboratoryMenu());
    addSubMenu(menu, createEquipmentMenu());
    addChild(menu, ADMIN_PREFIX + ".software", MANAGE_SOFTWARE_URL);
    addChild(menu, ADMIN_PREFIX + ".storagespace", MANAGE_STORAGESPACE_URL);
    addChild(menu, ADMIN_PREFIX + ".namingconvention", MANAGE_NAMINGCONVENTION_URL);
    addChild(menu, ADMIN_PREFIX + ".location", MANAGE_LOCATION_URL);
    addChild(menu, ADMIN_PREFIX + ".type", MANAGE_TYPE_URL);
    addSubMenu(menu, createUnitMenu());
    addChild(menu, ADMIN_PREFIX + ".message", MANAGE_MESSAGE_URL);

    return menu;
  }

  private SubMenu createEquipmentMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(EQUIPMENT_PREFIX, null, locale));
    addChild(menu, EQUIPMENT_PREFIX + ".equipment", MANAGE_EQUIPMENT_URL);
    addChild(menu, EQUIPMENT_PREFIX + ".storagedevice", MANAGE_STORAGEDEVICE_URL);
    return menu;
  }

  private SubMenu createLaboratoryMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(LAB_PREFIX, null, locale));
    addChild(menu, LAB_PREFIX + ".laboratory", MANAGE_LABORATORY_URL);
    addChild(menu, LAB_PREFIX + ".collaboration", MANAGE_COLLABORATION_URL);
    return menu;
  }

  private SubMenu createUnitMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(UNIT_PREFIX, null, locale));
    addChild(menu, UNIT_PREFIX + ".baseunit", MANAGE_BASEUNIT_URL);
    addChild(menu, UNIT_PREFIX + ".standardunit", MANAGE_STANDARDUNIT_URL);
    return menu;
  }

  private SubMenu createCustomerServiceMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(CS_PREFIX, null, locale));
    addSubMenu(menu, createCustomerRequestMenu());
    addChild(menu, CS_PREFIX + ".account", MANAGE_ACCOUNT_URL);
    addChild(menu, CS_PREFIX + ".billinginformation", MANAGE_BILLINGINFORMATION_URL);
    addChild(menu, CS_PREFIX + ".contract", MANAGE_CONTRACT_URL);
    addChild(menu, CS_PREFIX + ".rate", MANAGE_RATE_URL);
    return menu;
  }

  private SubMenu createCustomerRequestMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(CR_PREFIX, null, locale));
    addChild(menu, CR_PREFIX + ".customerrequest", MANAGE_CUSTOMERREQUEST_URL);
    addChild(menu, CR_PREFIX + ".invoice", MANAGE_INVOICE_URL);
    addChild(menu, CR_PREFIX + ".service", MANAGE_SERVICE_URL);
    
    return menu;
  }

  private SubMenu createInventoryMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(INVENTORY_PREFIX, null, locale));
    addSubMenu(menu, createBioSpecimenMenu());
    addSubMenu(menu, createContainerMenu());
    addChild(menu, INVENTORY_PREFIX + ".strain", MANAGE_STRAIN_URL);
    addChild(menu, INVENTORY_PREFIX + ".hazard", MANAGE_HAZARD_URL);
    addChild(menu, INVENTORY_PREFIX + ".taxon", MANAGE_TAXON_URL);
    addChild(menu, INVENTORY_PREFIX + ".additionalorganismname", MANAGE_ADDITIONALORGANISMNAME_URL);
    addChild(menu, INVENTORY_PREFIX + ".antigen", MANAGE_ANTIGEN_URL);
    addChild(menu, INVENTORY_PREFIX + ".chemicalcompound", MANAGE_CHEMICALCOMPOUND_URL);
    addChild(menu, INVENTORY_PREFIX + ".labsupply", MANAGE_LABSUPPLY_URL);
    addSubMenu(menu, createArtificialSpecimenMenu());
    return menu;
  }

  private SubMenu createArtificialSpecimenMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(ARTIFICIALSPECIMEN_PREFIX, null, locale));
    addChild(menu, ARTIFICIALSPECIMEN_PREFIX + ".nanomaterial", MANAGE_NANOMATERIAL_URL);
    return menu;
  }

  private SubMenu createContainerMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(CONTAINER_PREFIX, null, locale));
    addChild(menu, CONTAINER_PREFIX + ".container", MANAGE_CONTAINER_URL);
    //addChild(menu, CONTAINER_PREFIX + ".containercategory", CREATE_CONTAINERCATEGORY_URL);
    addChild(menu, CONTAINER_PREFIX + ".containersubcategory", MANAGE_CONTAINERSUBCATEGORY_URL);
    addChild(menu, CONTAINER_PREFIX + ".containertype", MANAGE_CONTAINERTYPE_URL);
    addChild(menu, CONTAINER_PREFIX + ".layout", MANAGE_LAYOUT_URL);
    addChild(menu, CONTAINER_PREFIX + ".fillpattern", MANAGE_FILLPATTERN_URL);
    return menu;
  }

  private SubMenu createBioSpecimenMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(BIOSPECIMEN_PREFIX, null, locale));
    addChild(menu, BIOSPECIMEN_PREFIX + ".antibody", MANAGE_ANTIBODY_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".carbohydrate", MANAGE_CARBOHYDRATE_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".cellspecimen", MANAGE_CELLSPECIMEN_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".fluidspecimen", MANAGE_FLUIDSPECIMEN_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".protein", MANAGE_PROTEIN_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".lipid", MANAGE_LIPID_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".nucleicacid", MANAGE_NUCLEICACID_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".pcrproduct", MANAGE_PCRPRODUCT_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".primer", MANAGE_PRIMER_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".smallmolecule", MANAGE_SMALLMOLECULE_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".tissuespecimen", MANAGE_TISSUESPECIMEN_URL);
    addChild(menu, BIOSPECIMEN_PREFIX + ".wholeorganism", MANAGE_WHOLEORGANISM_URL);
    return menu;
  }

  private SubMenu createWorkflowMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(WF_PREFIX, null, locale));
    addChild(menu, WF_PREFIX + ".experiment", MANAGE_EXPERIMENT_URL);
    addChild(menu, WF_PREFIX + ".processdesign", MANAGE_PROCESSDESIGN_URL);
    addChild(menu, WF_PREFIX + ".project", MANAGE_PROJECT_URL);
    addChild(menu, WF_PREFIX + ".tasklist", MANAGE_TASKLIST_URL);
    return menu;
  }

  private SubMenu createReportMenu() {
    SubMenu menu = new SubMenu(messageSource.getMessage(REPORT_PREFIX, null, locale));
    addChild(menu, REPORT_PREFIX + ".query", MANAGE_QUERY_URL);
    addChild(menu, REPORT_PREFIX + ".report", MANAGE_REPORT_URL);
    addChild(menu, REPORT_PREFIX + ".reportdesign", MANAGE_REPORTDESIGN_URL);
    return menu;
  }

  /**
   * Add a child to the given menu.
   * 
   * @param menu The menu to which the item must be added.
   * @param authentication The current user
   * @param locale The current locale
   * @param key The key of the message
   * @param url The url of the item.
   */
  private void addChild(SubMenu menu, String key, String url) {
    if (privilegeEvaluator.isAllowed(url, authentication)) {
      menu.addChild(createItem(key, url));
    }
  }

  /**
   * Creates an UrlItem.
   * 
   * @param key The key of the message
   * @param locale The current locale
   * @param url The url of the item.
   * @return The new UrlItem
   */
  private UrlItem createItem(String key, String url) {
    return new UrlItem(messageSource.getMessage(key, null, locale), url);
  }
}
