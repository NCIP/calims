/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
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
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
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
package gov.nih.nci.calims2.business.inventory.container;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;

/**
 * @author viseem
 * 
 */
public class CoordinateHelper {

  private static final int DIGIT_BASE = 10;
  private static final int LETTER_BASE = 26;

  /**
   * Converts a given integer into a coordinate label according to the label type.
   * 
   * @param labelType The label type
   * @param maximum The maximum number of values in the dimension
   * @param value The value to convert
   * @return The label corresponding to the given value
   */
  public static String getCoordinateString(LayoutLabelType labelType, int maximum, int value) {
    switch (labelType) {
      case DIGITS: {
        String result = Integer.toString(value + 1);
        while (result.length() < 2) {
          result = "0" + result;
        }
        return result;
      }
      case ALL_LOWER_CASE: {
        return convertValue('a', maximum, value);
      }
      case ALL_UPPER_CASE: {
        return convertValue('A', maximum, value);
      }
      default: {
        throw new InternalError("Can not happen");
      }
    }
  }

  private static String convertValue(char firstCharacter, int maximum, int value) {
    int length = (int) Math.floor(Math.log(maximum) / Math.log(LETTER_BASE)) + 1;
    if (value == 0) {
      return StringUtils.repeat(Character.toString(firstCharacter), length);
    }
    String result = "";
    int remaining = value;
    while (remaining > 0) {
      result = Character.toString((char) (firstCharacter + remaining % LETTER_BASE)) + result;
      remaining /= LETTER_BASE;
    }
    while (result.length() < length) {
      result = firstCharacter + result;
    }
    return result;
  }

  /**
   * Converts a given String into the integer coordinate according to the label type.
   * 
   * @param labelType The label type
   * @param value The string to convert
   * @return The coordinate corresponding to the given label.
   */
  public static int getCoordinateValue(LayoutLabelType labelType, String value) {
    if (StringUtils.isBlank(value)) {
      return 0;
    }
    switch (labelType) {
      case DIGITS: {
        return Integer.parseInt(value) - 1;
      }
      case ALL_LOWER_CASE: {
        return convertString('a', value);
      }
      case ALL_UPPER_CASE: {
        return convertString('A', value);
      }
      default: {
        throw new InternalError("Can not happen");
      }
    }
  }

  private static int convertString(char firstCharacter, String value) {
    int result = 0;
    for (int i = 0; i < value.length(); i++) {
      result = result * LETTER_BASE + value.charAt(i) - firstCharacter;
    }
    return result;
  }

  /**
   * Converts a given coordinate in the corresponding coordinate label string.
   * 
   * @param layout The layout
   * @param coordinate The coordinate to convert
   * @return The coordinate label string
   */
  public static String getCoordinateLabel(Layout layout, Coordinate coordinate) {
    String x = getCoordinateString(layout.getX_dimensionLabel(), layout.getX_dimension(), coordinate.getX());
    String y = getCoordinateString(layout.getY_dimensionLabel(), layout.getY_dimension(), coordinate.getY());
    return x + ", " + y;
  }

  /**
   * Converts a given coordinate in the corresponding coordinate suffix string.
   * 
   * @param layout The layout
   * @param coordinate The coordinate to convert
   * @return The coordinate suffix string.
   */
  public static String getCoordinateSuffix(Layout layout, Coordinate coordinate) {
    String x = getCoordinateString(layout.getX_dimensionLabel(), layout.getX_dimension(), coordinate.getX());
    String y = getCoordinateString(layout.getY_dimensionLabel(), layout.getY_dimension(), coordinate.getY());
    return "_" + x + y;
  }

  /**
   * Converts a given list of coordinates in the corresponding list of coordinate label string.
   * 
   * @param layout The layout
   * @param coordinates The coordinates to convert
   * @return The converted coordinates
   */
  public static List<String> getCoordinateLabels(Layout layout, List<Coordinate> coordinates) {
    List<String> labels = new ArrayList<String>();
    for (Coordinate coordinate : coordinates) {
      labels.add(getCoordinateLabel(layout, coordinate));
    }
    return labels;
  }

  /**
   * Calculates the maximum possible length of a suffix for the given layout.
   * 
   * @param layout The layout
   * @return The maximum possible length of a suffix for the given layout.
   */
  public static int getMaximumSuffixLength(Layout layout) {
    return 1 + getMaximumLength(layout.getX_dimensionLabel(), layout.getX_dimension())
        + getMaximumLength(layout.getY_dimensionLabel(), layout.getY_dimension());
  }

  private static int getMaximumLength(LayoutLabelType labelType, int maximum) {
    if (labelType == LayoutLabelType.DIGITS) {
      int length = (int) Math.floor(Math.log(maximum) / Math.log(DIGIT_BASE)) + 1;
      return (length > 1) ? length : 2;
    }
    return (int) Math.floor(Math.log(maximum) / Math.log(LETTER_BASE)) + 1;
  }
}
