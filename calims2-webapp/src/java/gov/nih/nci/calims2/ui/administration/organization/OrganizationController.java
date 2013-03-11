/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The caLIMS2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This caLIMS2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the caLIMS2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the caLIMS2 Software; (ii) distribute and 
 * have distributed to and by third parties the caLIMS2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.nih.nci.calims2.ui.administration.organization;

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
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
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
@RequestMapping(OrganizationController.URL_PREFIX)
public class OrganizationController extends CRUDController<Organization> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/organization";

  /** Create location sub flow. */
  static final int LOCATION_SUBFLOW_ID = 0;
  
  /** Create role sub flow. */
  static final int ROLE_SUBFLOW_ID = 1;
  
  /** Create organization sub flow. */
  static final int ORGANIZATION_SUBFLOW_ID = 2;
  
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 3;
  
  private GenericService<Location> locationService;
  private GenericService<Role> roleService;
  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */

  public OrganizationController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/location/create.do",
                                        "/administration/role/create.do?roleType=" + RoleType.ORGANIZATION,
                                        "/administration/organization/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.ORGANIZATION,
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
  public ModelAndView call(@ModelAttribute("form") OrganizationForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.ORGANIZATION.name());
    List<Type> types = typeService.findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params1);
    model.addObject("types", types);
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("roleType", RoleType.ORGANIZATION);
    List<Role> roles = roleService.findByNamedQuery(Role.class.getName() + ".findByRoleType", params);
    model.addObject("roles", roles);
    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);
    List<Organization> parentOrganizations = getMainService().findAll(Organization.class, "name");
    Organization organization = ((OrganizationForm) model.getModel().get("form")).getEntity();
    model.addObject("parentOrganizations", filterDescendents(parentOrganizations, organization));
    model.addObject("organizationStatuses", I18nEnumerationHelper.getLocalizedValues(OrganizationStatus.class, locale));
    return model;
  }
  
  /**
   * filters the descendants of the given organization from the list of organizations.
   * 
   * @param organizations The list of organizations to filter
   * @param organization The organization to filter from the list (with all its descendants)
   * @return The filtered list.
   */
  List<Organization> filterDescendents(List<Organization> organizations, Organization organization) {
    if (organization.getId() == null) {
      return organizations;
    }
    List<Organization> result = new ArrayList<Organization>();
    for (Organization candidate : organizations) {
      Organization currentOrganization = candidate;
      while (currentOrganization != null && !currentOrganization.getId().equals(organization.getId())) {
        currentOrganization = currentOrganization.getParentOrganization();
      }
      if (currentOrganization == null) {
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
      Organization organization = ((OrganizationForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case LOCATION_SUBFLOW_ID: {
          organization.setLocation(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case ROLE_SUBFLOW_ID: {
          organization.getRoleCollection().add(EntityWithIdHelper.createEntity(Role.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          organization.setParentOrganization(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          organization.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
   * @return The list type view.
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") OrganizationForm form, Locale locale) {
    return doSave(form, locale);

  }

  /**
   * @param organizationService the organizationService to set
   */
  @Resource(name = "organizationService")
  public void setOrganizationService(GenericService<Organization> organizationService) {
    super.setMainService(organizationService);
  }

  /**
   * @param locationService the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> locationService) {
    this.locationService = locationService;
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
  @Resource(name = "organizationFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "organizationTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}