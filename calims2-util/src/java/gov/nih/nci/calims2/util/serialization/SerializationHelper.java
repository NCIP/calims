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

import java.io.Serializable;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.SerializationUtils;

/**
 * @author connollym@moxieinformatics.com
 *
 */

/**
 * This class serializes an object  in to a hexadecimal String and de-serializes a hexadecimal back into a String.
 */
public class SerializationHelper {
  
  /**
     * Serialize the given object into an hexadecimal string.
     * @param object The object to serialize
     * @return The serialized string
     */
    public static String serializeToHex(Serializable object) {
      return new String(Hex.encodeHex(SerializationUtils.serialize(object)));
    }

    /**
     * Deserialize an object from an hexadecimal string.
     * @param s The string to deserialize
     * @return The deserialized object
     */
    public static Serializable deserializeFromHex(String s) {
      try {
        return (Serializable) SerializationUtils.deserialize(Hex.decodeHex(s.toCharArray()));
      } catch (DecoderException e) {
        throw new RuntimeException("String is probably not hexadecimal", e);
      }
    }
}
