/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.namingconvention;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.business.administration.namingconvention.WordComparator;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Word;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.util.json.JsonSerializer;

/**
 * 
 * 
 * @author viseem
 * 
 */
public class NamingConventionHelperImpl implements NamingConventionHelper {

  private static final String NAMING_CONVENTION_QUERY = NamingConvention.class.getName() + ".findByType";

  private GenericService<NamingConvention> namingConventionService;
  private JsonSerializer serializer = new JsonSerializer();

  /**
   * Get the naming conventions as a json string.
   * 
   * @param type The type of entity
   * @return The applicable naming conventions as a json object
   */
  public String getNamingConventions(NamingConventionType type) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("type", type);
    List<NamingConvention> namingConventions = namingConventionService.findByNamedQuery(NAMING_CONVENTION_QUERY, params);
    Map<String, Object> jsonObject = new HashMap<String, Object>();
    for (NamingConvention nc : namingConventions) {
      String laboratoryId = (nc.getLaboratory() != null) ? nc.getLaboratory().getId().toString() : "global";
      Map<String, Object> namingConvention = new HashMap<String, Object>();
      if (nc.getMaximumLength() != null) {
        namingConvention.put("maxLength", nc.getMaximumLength());
      }
      if (StringUtils.isNotEmpty(nc.getExample())) {
        namingConvention.put("example", nc.getExample());
      }
      namingConvention.put("name", nc.getName());
      List<Map<String, Object>> words = new ArrayList<Map<String, Object>>();
      for (Word word : getWords(nc)) {
        Map<String, Object> wordData = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(word.getDelimiter())) {
          wordData.put("delimiter", word.getDelimiter());
        }
        wordData.put("minLength", word.getMinimumLength());
        wordData.put("maxLength", word.getMaximumLength());
        if (StringUtils.isNotEmpty(word.getPadCharacter())) {
          wordData.put("padCharacter", word.getPadCharacter());
        }
        wordData.put("characterSet", word.getCharacterSet().getName());
        words.add(wordData);
      }
      namingConvention.put("words", words);
      jsonObject.put(laboratoryId, namingConvention);
    }
    return serializer.serializeObject(jsonObject);
  }
  
  private List<Word> getWords(NamingConvention namingConvention) {
    List<Word> words = new ArrayList<Word>();
    words.addAll(namingConvention.getWordCollection());
    Collections.sort(words, new WordComparator());
    return words;
  }

  /**
   * @param namingConventionService the namingConventionService to set
   */
  public void setNamingConventionService(GenericService<NamingConvention> namingConventionService) {
    this.namingConventionService = namingConventionService;
  }
}
