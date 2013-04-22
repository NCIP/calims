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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Word;
import gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;

/**
 * Validates a given String given The String to validate and the Naming convention.
 * 
 * @author viseem
 * 
 */
public class NameValidator {
  
  private static final Map<CharacterSet, String> PATTERNS = patternMap();

  private GenericDao genericDao;

  /**
   * Builds the map of patterns per Character Set.
   * 
   * @return the map of patterns per Character Set.
   */
  private static Map<CharacterSet, String> patternMap() {
    Map<CharacterSet, String> patterns = new HashMap<CharacterSet, String>();
    patterns.put(CharacterSet.ALL_LOWER_CASE, "\\p{Lower}");
    patterns.put(CharacterSet.ALL_UPPER_CASE, "\\p{Upper}");
    patterns.put(CharacterSet.MIXED_CASE, "\\p{Alpha}");
    patterns.put(CharacterSet.DIGITS, "\\p{Digit}");
    return patterns;
  }

  /**
   * Gets the naming convention applicable to a given laboratory and entity type.
   * 
   * @param laboratoryId The id of the laboratory
   * @param type The type of entity
   * @return The applicable naming convention or null if none is found.
   */
  public NamingConvention getNamingConvention(Long laboratoryId, NamingConventionType type) {
    String queryName = NamingConvention.class.getName() + ".findByLaboratoryIdAndType";
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("laboratoryId", laboratoryId);
    params.put("type", type);
    List<NamingConvention> namingConventions = genericDao.findByNamedQuery(queryName, params);
    if (namingConventions.size() == 1) {
      return namingConventions.get(0);
    }
    NamingConvention allLabConvention = null;
    for (NamingConvention nc : namingConventions) {
      Laboratory laboratory = nc.getLaboratory();
      if (laboratory != null && laboratory.getId().equals(laboratoryId)) {
        return nc;
      }
      if (laboratory == null) {
        allLabConvention = nc;
      }
    }
    return allLabConvention;
  }

  /**
   * Test if the given string follows the given naming convention.
   * 
   * @param input The input string to test
   * @param namingConvention The naming convention
   * @return true if the input string is valid according to the naming convention
   */
  public boolean validate(String input, NamingConvention namingConvention) {
    if (input == null || (namingConvention.getMaximumLength() != null && input.length() > namingConvention.getMaximumLength())) {
      return false;
    }
    String toValidate = input;
    for (Word word : getWords(namingConvention)) {
      String wordToValidate = null;
      if (StringUtils.isNotEmpty(word.getDelimiter())) {
        int pos = toValidate.indexOf(word.getDelimiter());
        if (pos < 0) {
          return false;
        }
        wordToValidate = toValidate.substring(0, pos);
        toValidate = toValidate.substring(pos + word.getDelimiter().length());
      } else {
        wordToValidate = toValidate;
        toValidate = "";
      }
      if (testAll(wordToValidate, word)) {
        return false;
      }
    }
    return true;
  }

  private boolean testAll(String input, Word word) {
    return testMinLength(input, word) || testMaxLength(input, word) || testCharset(input, word);
  }

  private boolean testCharset(String input, Word word) {
    String pattern = "^";
    if (StringUtils.isNotEmpty(word.getPadCharacter())) {
      pattern += word.getPadCharacter() + "*";
    }
    pattern += PATTERNS.get(word.getCharacterSet()) + "*$";
    boolean result = !input.matches(pattern);
    return result;
  }

  private boolean testMinLength(String input, Word word) {
    return word.getMinimumLength() != null && input.length() < word.getMinimumLength();
  }

  private boolean testMaxLength(String input, Word word) {
    return word.getMaximumLength() != null && input.length() > word.getMaximumLength();
  }

  private List<Word> getWords(NamingConvention namingConvention) {
    List<Word> words = new ArrayList<Word>();
    words.addAll(namingConvention.getWordCollection());
    Collections.sort(words, new WordComparator());
    return words;
  }

  /**
   * @param genericDao the genericDao to set
   */
  public void setGenericDao(GenericDao genericDao) {
    this.genericDao = genericDao;
  }

}
