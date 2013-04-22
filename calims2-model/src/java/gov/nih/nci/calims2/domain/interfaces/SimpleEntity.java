/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.interfaces;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Default implementation of EntityWithId interface.
 * @author viseem
 *
 */
@MappedSuperclass
public class SimpleEntity implements EntityWithId {

  private static final long serialVersionUID = -885906954742625604L;
  
  private Long id;

  /**
   * {@inheritDoc}
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  /**
   * {@inheritDoc}
   */
  public void setId(Long id) {
    this.id = id;
  }

}
