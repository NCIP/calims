package gov.nih.nci.calims2.domain.interfaces;

import java.io.Serializable;

/**
 * Interface defining a primary key for all persistent entities.
 */
public interface EntityWithId extends Serializable {
  /**
   * Default maximum column length for String fields.
   */
  int COLUMNLENGTH = 100;

  /**
   * Returns the identifier for this object.
   * 
   * @return id
   */
  Long getId();

  /**
   * 
   * @param id identifier.
   */
  void setId(Long id);
  
  
  
  
}
