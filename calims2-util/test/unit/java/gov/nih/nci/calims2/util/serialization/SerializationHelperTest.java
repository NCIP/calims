/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.util.serialization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author connollym@moxieinformatics.com
 * 
 */

public class SerializationHelperTest {

  /**
   * Test of the Serialization serializeToHex(String string) method.
   */
  @Test
  public void testserializeToHex() {
    String expectedResult = new String("aced000574000c4d7954657374537472696e67");
    String testString = new String("MyTestString");
    String serializedString = SerializationHelper.serializeToHex(testString);
    assertEquals("Serialized string does not match control string.", expectedResult, serializedString);

  }

  /**
   * Test of the Serialization deserializeFromHex(String string) method when a hex value is passed in.
   */
  @Test
  public void testdeserializeFromHex() {
    String expectedResult = new String("MyTestString");
    String testString = new String("aced000574000c4d7954657374537472696e67");
    String deserializedString = (String) SerializationHelper.deserializeFromHex(testString);
    assertEquals("Deserialized string does not match control string.", expectedResult, deserializedString);
  }

  /**
   * Test of the Serialization deserializeFromHex(String string) method when a non hex value is passed in. This test expects the
   * SerializationHelper class to throw an exception.
   */
  @Test
  public void testdeserializeFromHexExcpetion() {
    String testString = new String("MyTestString");
    try {
      SerializationHelper.deserializeFromHex(testString);
      fail("deserializeFromHex method should have failed");
    } catch (RuntimeException e) {
      assertEquals("Wrong exception thrown", "String is probably not hexadecimal", e.getMessage());
    }
  }
}
