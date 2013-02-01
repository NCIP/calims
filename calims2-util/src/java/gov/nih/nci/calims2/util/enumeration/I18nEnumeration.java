/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The caLIMS2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This caLIMS2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the caLIMS2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the caLIMS2 Software; (ii) distribute and 
 * have distributed to and by third parties the caLIMS2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
