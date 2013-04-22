/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.word;

import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Word;
import gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet;
import gov.nih.nci.calims2.domain.administration.enumeration.WordStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
public class WordForm extends CRUDForm<Word> {

  private static final long serialVersionUID = -5253052802254652206L;

  private String status;
  private String characterSet;

  /**
   * Default constructor.
   */
  public WordForm() {
    setEntity(new Word());
  }

  /**
   * {@inheritDoc}
   */
  public Word getSubmittedEntity() {
    Word word = getEntity();
    Long namingConventionId = (Long) (FlowContextHolder.getContext().peek()).getAttribute("id");
    word.setNamingConvention(EntityWithIdHelper.createEntity(NamingConvention.class, namingConventionId));
    word.setStatus(I18nEnumerationHelper.getByName(WordStatus.class, status));
    word.setCharacterSet(I18nEnumerationHelper.getByName(CharacterSet.class, characterSet));
    return word;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return the characterSet
   */
  public String getCharacterSet() {
    return characterSet;
  }

  /**
   * @param characterSet the characterSet to set
   */
  public void setCharacterSet(String characterSet) {
    this.characterSet = characterSet;
  }
}
