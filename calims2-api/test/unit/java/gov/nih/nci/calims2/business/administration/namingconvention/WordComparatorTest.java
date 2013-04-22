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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.domain.administration.Word;

/**
 * @author viseem
 *
 */
@RunWith(Parameterized.class)
public class WordComparatorTest {
  
  private String testCase;
  private Integer rank1;
  private Integer rank2;
  private int expected;
  
  /**
   * Constructor.
   * @param testCase The name of the test case
   * @param rank1 the rank of the first word
   * @param rank2 the rank of the second word
   * @param expected the expected result of the comparison
   */
  public WordComparatorTest(String testCase, Integer rank1, Integer rank2, int expected) {
    this.testCase = testCase;
    this.rank1 = rank1;
    this.rank2 = rank2;
    this.expected = expected;
  }
  
  /**
   * Gets the parameterized test data.
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][]{{"case 1: null - null", null, null, 0}, 
        {"case 2: null - 1", null, 1, -1},
        {"case 3: 1 - null", 1, null, 1},
        {"case 4: 0 - 1", 0, 1, -1},
        {"case 5: 1 - 1", 1, 1, 0},
        {"case 6: 1 - 0", 1, 0, 1}};
    return Arrays.asList(data);
  }

  /**
   * Test the compare method.
   */
  @Test
  public void testCompare() {
    WordComparator comparator = new WordComparator();
    Word word1 = new Word();
    word1.setRank(rank1);
    Word word2 = new Word();
    word2.setRank(rank2);
    int result = comparator.compare(word1, word2);
    assertEquals("Wrong result for test case " + testCase, expected, result);
  }

}
