/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.namingconvention;

import java.util.Comparator;

import gov.nih.nci.calims2.domain.administration.Word;

/**
 * @author viseem
 *
 */
public class WordComparator implements Comparator<Word> {

  /**
   * {@inheritDoc}
   */
  public int compare(Word word1, Word word2) {
    if (word1.getRank()  == null) {
      return (word2.getRank() == null) ? 0 : -1;
    }
    if (word2.getRank() == null) {
      return 1;
    }
    return word1.getRank().compareTo(word2.getRank());
  }

}
