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

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * This class helps to transform an object structure into its corresponding json representation.
 * The object structure is as follows:
 * An object is represented by a Map<String, Object> where the keys are the field names.
 * An array is represented by a Collection.
 * Atomic values are represented as String of obtained by the toString method.
 * 
 * This class is stateless so it is thread-safe
 * 
 * @author viseem
 * 
 */
public class JsonSerializer {
  /**
   * Serialize the given Map object representation.
   * 
   * @param input The object to serialize
   * @return The serialized object
   */
  public String serializeObject(Map<String, Object> input) {
    StringBuilder builder = new StringBuilder();
    serializeObject(builder, input);
    return builder.toString();
  }

  /**
   * Serialize the given object collection representation.
   * @param <T> 
   * 
   * @param input The collection to serialize
   * @return The serialized object
   */
  public <T> String serializeCollection(Collection<T> input) {
    StringBuilder builder = new StringBuilder();
    serializeObject(builder, input);
    return builder.toString();
  }

  /**
   * Serialize the given map into the builder.
   * 
   * @param out The builder
   * @param input The map to serialize
   */
  void serializeMap(StringBuilder out, Map<String, Object> input) {
    boolean firstProperty = true;
    out.append("{");
    for (Map.Entry<String, Object> entry : input.entrySet()) {
      if (!firstProperty) {
        out.append(", ");
      }
      firstProperty = false;
      out.append("\"");
      out.append(entry.getKey());
      out.append("\" : ");
      serializeObject(out, entry.getValue());
    }
    out.append("}");
  }

  /**
   * Serialize the given object into the builder.
   * 
   * @param out The builder
   * @param input The Object to serialize
   */
  @SuppressWarnings("unchecked")
  void serializeObject(StringBuilder out, Object input) {
    if (input instanceof Map) {
      serializeMap(out, (Map<String, Object>) input);
      return;
    }
    if (input instanceof Collection) {
      out.append("[");
      boolean firstElement = true;
      for (Object element : (Collection<Object>) input) {
        if (!firstElement) {
          out.append(", ");
        }
        firstElement = false;
        serializeObject(out, element);
      }
      out.append("]");
      return;
    }
    out.append("\"");
    out.append(StringEscapeUtils.escapeJavaScript(input.toString()));
    out.append("\"");
  }

}
