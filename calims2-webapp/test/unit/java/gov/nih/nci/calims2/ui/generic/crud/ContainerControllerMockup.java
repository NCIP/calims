/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.ui.inventory.container.ContainerForm;

/**
 * @author viseem
 *
 */
public class ContainerControllerMockup extends CRUDController<Container> {
  private static final String URL_PREFIX = "/inventory/container";

  /**
   * Default constructor.
   */
  public ContainerControllerMockup() {
    CRUDControllerConfig config = getConfig();
    config.setUrlAndViewPrefixes(URL_PREFIX);
    config.setOrderByClause("order");
    setPersistentClass(Container.class);
    setFormClass(ContainerForm.class);
    config.setSubFlowUrls(new String[]{"testurl"});
  }
}
