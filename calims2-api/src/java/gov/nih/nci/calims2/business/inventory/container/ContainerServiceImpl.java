/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
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
