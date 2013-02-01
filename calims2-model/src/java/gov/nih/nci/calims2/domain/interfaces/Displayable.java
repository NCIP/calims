package gov.nih.nci.calims2.domain.interfaces;

/**
 * Interface for entities having standard descriptive fields.
 * 
 * @author viseem
 * 
 */
public interface Displayable extends Auditable {
  /**
   * Get the description of the entity.
   * 
   * @return The description of the entity.
   */
  String getDescription();

  /**
   * Set the description of the entity.
   * 
   * @param description The description of the entity.
   * 
   */
  void setDescription(String description);

  /**
   * Get the display name of the entity.
   * 
   * @return The display name of the entity.
   */
  String getDisplayName();

  /**
   * Set the display name of the entity.
   * 
   * @param displayName The display name of the entity.
   * 
   */
  void setDisplayName(String displayName);

  /**
   * Get the name of the entity.
   * 
   * @return The name of the entity.
   */
  String getName();

  /**
   * Set the name of the entity.
   * 
   * @param name The name of the entity.
   * 
   */
  void setName(String name);
}
