/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.util.json;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @author viseem
 *
 */
public class JsonSerializerTest {
  
  /**
   * test the serializeObject method.
   */
  @Test
  public void testSerializeObject() {
    Map<String, Object> object1 = new TreeMap<String, Object>();
    object1.put("property1", "value1");
    Map<String, Object> object2 = new TreeMap<String, Object>();
    object2.put("property1", "value1");
    object2.put("property2", "value2");
    object1.put("property2", object2);
    List<Map<String, Object>> col = new ArrayList<Map<String, Object>>();
    object1.put("property3", col);
    Map<String, Object> colObject1 = new TreeMap<String, Object>();
    colObject1.put("property1", "value1.1");
    colObject1.put("property2", "value1.2");
    col.add(colObject1);
    Map<String, Object> colObject2 = new TreeMap<String, Object>();
    colObject2.put("property1", "value2.1");
    colObject2.put("property2", "value2.2");
    col.add(colObject2);
    JsonSerializer serializer = new JsonSerializer();
    String result = serializer.serializeObject(object1);
    String expected = "{\"property1\" : \"value1\", \"property2\" : {\"property1\" : \"value1\", \"property2\" : \"value2\"}, \""
      + "property3\" : [{\"property1\" : \"value1.1\", \"property2\" : \"value1.2\"}, {\"property1\" : \"value2.1\", \""
      + "property2\" : \"value2.2\"}]}";
    assertEquals("Wrong serialized result", expected, result);
  }

}
