/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.characteristics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.inventory.characteristics.Characteristics;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;

/**
 * @author viseem
 *
 */
//@Controller
//@RequestMapping(CharacteristicsController.URL_PREFIX)
public class CharacteristicsController extends CRUDController<Characteristics> {
  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/inventory/characteristics";
  
  /**
   * Default constructor.
   */
  public CharacteristicsController() {
    super(URL_PREFIX, "familyName");
//    CRUDControllerConfig config = getConfig();
//    config.setSubFlowUrls(new String[] {"/administration/organization/create.do",
//                                        "/administration/role/create.do?roleType=" + RoleType.PERSON, 
//                                        "/common/document/enterList.do", 
//                                        "/administration/contactinformation/enterList.do" });
  }
  
  /**
   * {@inheritDoc}
   */
  public List<Characteristics> createList() {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("accountId", (FlowContextHolder.getContext().peek()).getAttribute("id"));
    return getMainService().findByNamedQuery(Characteristics.class.getName() + ".findBySpecimenId", params);
  }
  
  /**
   * @param characteristicsService the accountNumberService to set
   */
  @Resource(name = "characteristicsService")
  public void setAccountNumberService(GenericService<Characteristics> characteristicsService) {
    super.setMainService(characteristicsService);
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "characteristicsFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "characteristicsTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
