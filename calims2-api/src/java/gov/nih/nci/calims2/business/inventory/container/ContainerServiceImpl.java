/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
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
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
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
package gov.nih.nci.calims2.business.inventory.container;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import gov.nih.nci.calims2.business.generic.GenericServiceImpl;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;

/**
 * @author viseem
 * 
 */
public class ContainerServiceImpl extends GenericServiceImpl<Container> implements ContainerService {

  private static final String FINDBYIDS_QUERY = Container.class.getName() + ".findByIds";
  private static final String[] NOCOPY_PROPERTIES = new String[] {"id", "dateCreated", "createdBy", "dateModified", "modifiedBy",
      "fillPattern", "capacityCollection", "childContainerCollection" };

  /**
   * {@inheritDoc}
   */
  public Container create(Container container) throws ValidationException {
    Container savedContainer = super.create(container);
    createChildrenForComposite(savedContainer);
    return savedContainer;
  }

  /**
   * Create the children for composite containers.
   * 
   * @param savedContainer The new possibly composite container for which children must be created
   * @throws ValidationException If a child is not valid
   */
  void createChildrenForComposite(Container savedContainer) throws ValidationException {
    ContainerType containerType = getGenericDao().findById(ContainerType.class, savedContainer.getContainerType().getId());
    if (containerType.getComposition() == ContainerComposition.COMPOSITE) {
      ChildrenSpecification specification = new ChildrenSpecification();
      specification.setContainerTypeId(containerType.getChildContainerType().getId());
      specification.setDisplayName(savedContainer.getDisplayName());
      specification.setLayoutId(containerType.getChildContainerType().getDefaultLayout().getId());
      specification.setName(savedContainer.getName());
      specification.addParentContainerId(savedContainer.getId());
      specification.setReusable(savedContainer.getIsReusable() != null && savedContainer.getIsReusable());
      specification.setStatus(savedContainer.getStatus());
      createChildren(specification);
    }
  }

  /**
   * {@inheritDoc}
   */
  public void createChildren(ChildrenSpecification specification) throws ValidationException {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("ids", specification.getParentContainerIds());
    List<Container> parents = getGenericDao().findByNamedQuery(FINDBYIDS_QUERY, params);
    for (Container parent : parents) {
      Layout layout = getGenericDao().findById(Layout.class, parent.getLayout().getId());
      for (int i = 0; i < layout.getX_dimension(); i++) {
        for (int j = 0; j < layout.getY_dimension(); j++) {
          Coordinate coordinate = new Coordinate();
          coordinate.setX(i);
          coordinate.setY(j);
          createChild(specification, parent, layout, coordinate);
        }
      }
    }
  }

  /**
   * Creates a child container for the given specification, the given parent and coordinates.
   * 
   * @param specification The child specification
   * @param parent The parent of the child to create
   * @param parentLayout The layout of the parent
   * @param coordinate The coordinate of the child
   * @throws ValidationException
   */
  void createChild(ChildrenSpecification specification, Container parent, Layout parentLayout, Coordinate coordinate)
      throws ValidationException {
    Container child = new Container();
    String suffix = CoordinateHelper.getCoordinateSuffix(parentLayout, coordinate);
    child.setName(specification.getName() + suffix);
    child.setDisplayName(specification.getDisplayName() + suffix);
    child.setDescription(specification.getDescription());
    child.setParentContainer(parent);
    child.setContainerType(EntityWithIdHelper.createEntity(ContainerType.class, specification.getContainerTypeId()));
    child.setLayout(EntityWithIdHelper.createEntity(Layout.class, specification.getLayoutId()));
    child.setCoordinate(coordinate);
    child.setIsReusable(specification.isReusable());
    child.setIsTemplate(parent.getIsTemplate());
    child.setStatus(specification.getStatus());
    create(child);
  }

  /**
   * {@inheritDoc}
   */
  public void createCopy(CopySpecification specification) throws ValidationException {
    Container template = validateCopySpecification(specification);
    Container copy = copyTemplate(template);
    copy.setName(specification.getBaseNames().get(0));
    copy.setDisplayName(specification.getBaseNames().get(0));
    if (specification.getParentContainerId() != null) {
      copy.setParentContainer(EntityWithIdHelper.createEntity(Container.class, specification.getParentContainerId()));
      copy.setCoordinate(specification.getCoordinate());
      copy.setLocation(null);
    } else {
      copy.setParentContainer(null);
      Coordinate coordinate = new Coordinate();
      coordinate.setX(0);
      coordinate.setY(0);
      copy.setCoordinate(coordinate);
      copy.setLocation(EntityWithIdHelper.createEntity(Location.class, specification.getLocationId()));
    }
    copy = create(copy);
    if (template.getContainerType().getComposition() == ContainerComposition.COMPLEX
        && template.getChildContainerCollection() != null) {
      copyChildren(template, copy, specification.getBaseNames(), 1);
    }
  }

  /**
   * Recusrsively copy the children of a template.
   * 
   * @param parentTemplate The parent template
   * @param parent The parent copy
   * @param baseNames The list of base names
   * @param level The level to use in the list of base names
   * @throws ValidationException if data is not valid
   */
  void copyChildren(Container parentTemplate, Container parent, List<String> baseNames, int level) throws ValidationException {
    for (Container childTemplate : parentTemplate.getChildContainerCollection()) {
      Container copy = copyTemplate(childTemplate);
      String suffix = CoordinateHelper.getCoordinateSuffix(parentTemplate.getLayout(), copy.getCoordinate());
      String name = baseNames.get(level) + suffix;
      copy.setName(name);
      copy.setDisplayName(name);
      copy.setParentContainer(parent);
      copy.setLocation(null);
      copy = create(copy);
      if (childTemplate.getContainerType().getComposition() == ContainerComposition.COMPLEX
          && childTemplate.getChildContainerCollection() != null) {
        copyChildren(childTemplate, copy, baseNames, level + 1);
      }
    }
  }

  /**
   * Copy an existing container in a new object.
   * 
   * @param template The template to copy
   * @return The copy of the template
   */
  Container copyTemplate(Container template) {
    Container copy = new Container();
    BeanUtils.copyProperties(template, copy, NOCOPY_PROPERTIES);
    copy.setIsTemplate(false);
    Set<Quantity> quantities = new HashSet<Quantity>();
    if (template.getCapacityCollection() != null) {
      for (Quantity quantity : template.getCapacityCollection()) {
        Quantity newQuantity = new Quantity();
        BeanUtils.copyProperties(quantity, newQuantity);
        quantities.add(newQuantity);
      }
    }
    copy.setCapacityCollection(quantities);
    return copy;
  }

  private Container validateCopySpecification(CopySpecification specification) throws ValidationException {
    if (specification == null) {
      throw new ValidationException("No specification");
    }
    if (specification.getTemplateId() == null) {
      throw new ValidationException("No template Id");
    }
    Container template = getGenericDao().findById(Container.class, specification.getTemplateId());
    if (template.getIsTemplate() == null || !template.getIsTemplate()) {
      throw new ValidationException("Specified container is not a template");
    }
    if (specification.getLocationId() == null && specification.getParentContainerId() == null) {
      throw new ValidationException("No parent or location specified");
    }
    if (specification.getLocationId() == null) {
      Container parentContainer = getGenericDao().findById(Container.class, specification.getParentContainerId());
      Layout layout = parentContainer.getLayout();
      Coordinate coordinate = specification.getCoordinate();
      if (coordinate.getX() == null || coordinate.getX() < 0 || coordinate.getX() >= layout.getX_dimension()) {
        throw new ValidationException("Invalid X coordinate");
      }
      if (coordinate.getY() == null || coordinate.getY() < 0 || coordinate.getY() >= layout.getY_dimension()) {
        throw new ValidationException("Invalid Y coordinate");
      }
    }
    return template;
  }

}
