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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Word;
import gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet;

/**
 * @author viseem
 *
 */
@RunWith(Parameterized.class)
public class NameValidatorValidateTest {
  
  private static final long TOTAL_MAX_LENGTH = 11L;
  private static final int WORD_MIN_LENGTH = 3;
  private static final int WORD_MAX_LENGTH = 5;
  
  private String testCase;
  private String input;
  private boolean expected;

  /**
   * Constructor.
   * @param testCase The test case name
   * @param input the input string
   * @param expected The expected result of validation
   */
  public NameValidatorValidateTest(String testCase, String input, boolean expected) {
    this.testCase = testCase;
    this.input = input;
    this.expected = expected;
  }
  
  /**
   * Gets the parameterized test data.
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][]{{"case 1: more then 11 chars", "123456789012", false}, 
        {"case 2: no delimiter", "12345", false},
        {"case 3: word1 too short", "12_1234", false},
        {"case 4: word1 too long", "123456_1234", false},
        {"case 5: word1 not uppercase", "ABC1_ABC", false},
        {"case 6: wrong padding in word 2", "ABCD_ AAA", false},
        {"case 7: ok string", "ABCD_0AAA", true}};
    return Arrays.asList(data);
  }

  /**
   * Test the validate method.
   */
  @Test
  public void testValidate() {
    NameValidator validator = new NameValidator();
    NamingConvention namingConvention = createNamingConvention();
    boolean result = validator.validate(input, namingConvention);
    assertEquals(testCase + " Wrong validation result for input " + input, expected, result);
  }

  /**
   * Creates a naming convention for the test.
   * It is made of 2 words
   * word 1: 3 to 5 upper case letters followed by underscore - no padding
   * word 2: 3 to 5 upper case letters - no delimiter - padding 0
   * 
   * @return The test naming convention
   */
  public NamingConvention createNamingConvention() {
    NamingConvention nc = new NamingConvention();
    nc.setMaximumLength(TOTAL_MAX_LENGTH);
    Word word1 = new Word();
    word1.setDelimiter("_");
    word1.setMinimumLength(WORD_MIN_LENGTH);
    word1.setMaximumLength(WORD_MAX_LENGTH);
    word1.setCharacterSet(CharacterSet.ALL_UPPER_CASE);
    word1.setRank(1);
    Word word2 = new Word();
    word2.setMinimumLength(WORD_MIN_LENGTH);
    word2.setMaximumLength(WORD_MAX_LENGTH);
    word2.setCharacterSet(CharacterSet.ALL_UPPER_CASE);
    word2.setPadCharacter("0");
    word2.setRank(2);
    Set<Word> words = nc.getWordCollection();
    words.add(word1);
    words.add(word2);
    return nc;
  }

}
