/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.util.enumeration;

/**
 * @author connollym
 *
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Interface to implement by internationalized enumerations. T
 * This interface or its extension I18nEnumerationWithId should be implemented 
 * by java5 enums to support internationalization.
 * @author connollym@moxieinformatics.com
 */
public interface I18nEnumeration {

  /**
   * Gets the localized string representation of the enumeration value for the given locale.
   * @param locale The locale for which the display value must be generated.
   * @return The localized string representation of the enumeration value for the given locale.
   */
  String getLocalizedValue(Locale locale);

  /**
   * Gets the name of the enumeration value. 
   * It is present here to conform to java beans convention. 
   * The method delegates to the
   * name method of the enumeration.
   * @return the name of the enumeration value
   */
  String getName();

  /**
   * Helper class to use to manage I18nEnumerations. 
   * This helper class provides convenience methods for common tasks related to
   * I18nEnumerations
   * @author mvisee@vecna.com
   */
  public class I18nEnumerationHelper {

    private static <T extends Enum<T>> String[] namesOf(Collection<T> enumValues) {
      String[] result = new String[enumValues.size()];
      int i = 0;
      for (Enum<T> enumvalue : enumValues) {
        result[i] = enumvalue.name();
        i++;
      }
      return result;
    }

    /**
     * Convert an Collection of enums into an array of Strings containing the value names.
     * @param <T> The type of the enum
     * @param enumValues The collection of values to convert
     * @return The array of names of the enum values in the given collection
     */
    public static <T extends Enum<T>> String[] getNamesOf(Collection<T> enumValues) {
      return (enumValues == null) ? new String[0] : namesOf(enumValues);
    }
    
    /**
     * Converts a name into an enumeration value of the given emumeration class.
     * @param <T> The type of the enum
     * @param enumClass The Enumeration Class
     * @param name The name to convert
     * @return The converted value or null if the name can not be converted
     */
    public static <T extends Enum<T>> T getByName(Class<T> enumClass, String name) {
      T result = null;
      if (name != null) {
        try {
          result = Enum.valueOf(enumClass, name);
        } catch (IllegalArgumentException e) {
          // Nothing to do - Names that do not exist are not converted.
          assert true;
        }
      }
      return result;
    }

    /**
     * Converts an array of names into a List of enumeration values of the given emumeration class.
     * @param <T> The type of the enum
     * @param enumClass The Enumeration Class
     * @param names The array of names to convert
     * @return The array of enum values whose names are in the given array. Names that do not exist are not converted.
     */
    public static <T extends Enum<T>> List<T> getByNames(Class<T> enumClass, String[] names) {
      List<T> result = new ArrayList<T>();
      if (names != null && names.length > 0) {
        for (String name : names) {
          try {
            T enumValue = Enum.valueOf(enumClass, name);
            result.add(enumValue);
          } catch (IllegalArgumentException e) {
            // Nothing to do - Names that do not exist are not converted.
            assert true;
          }
        }
      }
      return result;
    }

    /**
     * Gets the localized string representation of the enumeration value for the given locale.
     * @param bundleClass The class of the resource bundle to use.
     * @param locale The locale for which the localized string representation must be generated.
     * @param enumValue The enumeration value to translate.
     * @return the localized string representation of the enumeration value for the given locale
     */
    public static String getLocalizedValue(Class<? extends ResourceBundle> bundleClass, Locale locale, I18nEnumeration enumValue) {
      ResourceBundle bundle = ResourceBundle.getBundle(bundleClass.getName(), locale);
      return bundle.getString(enumValue.getName());
    }

    /**
     * Gets the localized string representation of a dependent value for 
     * the given enumeration value and for the given locale.
     * @param bundleClass The class of the resource bundle to use.
     * @param locale The locale for which the localized string representation must be generated.
     * @param enumValue The enumeration value to translate.
     * @param keySuffix the key suffix for the dependent value in the bundle.
     * @return the localized string representation of the enumeration value for the given locale.
     */
    public static String getLocalizedDependantValue(Class<? extends ResourceBundle> bundleClass, Locale locale,
                                                    I18nEnumeration enumValue, String keySuffix) {
      ResourceBundle bundle = ResourceBundle.getBundle(bundleClass.getName(), locale);
      return bundle.getString(enumValue.getName() + keySuffix);
    }

    /**
     * Gets the ordered list of localized string representation of the enum values 
     * in the given collection for the given locale.
     * @param <T> The type of enumeration
     * @param enumValues The collection of enumeration values to consider
     * @param locale The locale for which the localized string representations must be generated
     * @return The ordered list of localized string representation of the given values
     */
    public static <T extends Enum<T> & I18nEnumeration> List<String> getLocalizedValuesAsStrings(Collection<T> enumValues,
                                                                                                 Locale locale) {
      List<String> result = new ArrayList<String>();
      if (enumValues != null && !enumValues.isEmpty()) {
        for (T enumValue : enumValues) {
          result.add(enumValue.getLocalizedValue(locale));
        }
        Collections.sort(result);
      }
      return result;
    }

    /**
     * Gets the List of values of the Enumeration ordered by localized string representation in the given Locale.
     * @param <T> The type of enumeration
     * @param enumClass The Enumeration Class
     * @param locale The locale for which the localized string representation must be generated
     * @return The List of values of the Enumeration ordered by translated values in the given Locale
     */
    @SuppressWarnings("unchecked")
    public static <T extends Enum<T> & I18nEnumeration> List<T> getLocalizedValues(Class<T> enumClass, Locale locale) {
      try {
        Method m = enumClass.getMethod("values");
        List<TranslatedValue<T>> translatedValues = new ArrayList<TranslatedValue<T>>();
        for (T value : (T[]) m.invoke(enumClass, (Object[]) null)) {
          translatedValues.add(new TranslatedValue<T>(value.getLocalizedValue(locale), value));
        }
        return sortTranslatedValues(translatedValues);
      } catch (NoSuchMethodException e) {
        throw new InternalError("Can not happen - Enum class has a values() method");
      } catch (IllegalArgumentException e) {
        throw new InternalError("Can not happen - values() method takes no argument");
      } catch (IllegalAccessException e) {
        throw new InternalError("Can not happen - values() method is public");
      } catch (InvocationTargetException e) {
        throw new InternalError("Can not happen - values() does not trow any exception");
      }
    }

    /**
     * Sorts a given collection of I18nEnumeration by their localized string representation in the specified locale.
     * @param <T> The type of enumeration
     * @param enumValues The collection to sort
     * @param locale The locale for which the localized string representation must be generated
     * @return The List of values of the Enumeration ordered according to the given Locale
     */
    public static <T extends Enum<T> & I18nEnumeration> List<T> sortByLocalizedValues(Collection<T> enumValues, Locale locale) {
      if (enumValues != null) {
        List<TranslatedValue<T>> translatedValues = new ArrayList<TranslatedValue<T>>();
        for (T value : enumValues) {
          translatedValues.add(new TranslatedValue<T>(value.getLocalizedValue(locale), value));
        }
        return sortTranslatedValues(translatedValues);
      }
      return new ArrayList<T>();
    }

    private static <T extends Enum<T> & I18nEnumeration> List<T> sortTranslatedValues(List<TranslatedValue<T>> translatedValues) {
      Collections.sort(translatedValues);
      List<T> result = new ArrayList<T>();
      for (TranslatedValue<T> translatedValue : translatedValues) {
        result.add(translatedValue.getEnumValue());
      }
      return result;
    }

    /**
     * Holder class representing an I18nEnumeration value with its translated String for a given locale.
     * @author connollym@moxieinformatics.com
     */
    private static class TranslatedValue<T extends I18nEnumeration> implements Comparable<TranslatedValue<T>> {

      private String translatedValue;
      private T enumValue;

      public TranslatedValue(String incomingTranslatedValue, T incomingEnumValue) {
        translatedValue = incomingTranslatedValue;
        enumValue = incomingEnumValue;
      }

      public int compareTo(TranslatedValue<T> other) {
        return translatedValue.compareTo(other.translatedValue);
      }

      /**
       * Get the enumValue.
       * @return Returns the enumValue
       */
      public T getEnumValue() {
        return enumValue;
      }
    }
  }

}
