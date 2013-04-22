/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.container;

/**
 * Helper class for layout dependent select box.
 * 
 * @author viseem
 * 
 */
public class LayoutOption {
  private String id;
  private String name;
  private String parentId;

  /**
   * @param id The id of the layout
   * @param name The name of the layout
   * @param parentId The id of the container Type
   */
  public LayoutOption(String id, String name, String parentId) {
    this.id = id;
    this.name = name;
    this.parentId = parentId;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the parentId
   */
  public String getParentId() {
    return parentId;
  }

}
