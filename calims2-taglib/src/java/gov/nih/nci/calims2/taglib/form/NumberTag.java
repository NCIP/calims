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
package gov.nih.nci.calims2.taglib.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * @author viseem
 *
 */
public class NumberTag extends ValidationTextBoxTag {
  
  private static final long serialVersionUID = -2139617105422546556L;

  private static final String DEFAULT_NUMBER_TYPE = "decimal";
  
  private String min;
  private String max;
  private String numberType = DEFAULT_NUMBER_TYPE;
  private Integer places;
  
  
  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    min = null;
    max = null;
    numberType = DEFAULT_NUMBER_TYPE;
    places = null;
  }

  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_NUMBER_TEXTBOX.getTypeName());
  }
  
  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    Tag tag = new CompositeTag(HtmlElement.DIV);
    tag.addAttribute("dojoType", DojoType.DIJIT_FORM_NUMBER_TEXTBOX.getTypeName());
    addAttributes(tag);
    addConstraints(tag);
    tag.addAttribute("trim", "true");
    addMessages(tag);
    return tag;
  }

  /**
   * {@inheritDoc}
   */
  protected void addConstraints(Tag tag) {
    if (getConstraints() != null) {
      tag.addAttribute("constraints", getConstraints());
    } else {
      List<String> constraints = new ArrayList<String>();
      if (min != null) {
        constraints.add("min:" + min);
      }
      if (max != null) {
        constraints.add("max:" + max);
      }
      if (getPattern() != null) {
        constraints.add("pattern:'" + getPattern() + "'");
      }
      if (places != null) {
        constraints.add("places:" + places);
      }
//      if (numberType != null) {
//        constraints.add("type:" + numberType);
//      }
      if (!constraints.isEmpty()) {
        StringBuilder constraint = new StringBuilder("{");
        for (int i = 0; i < constraints.size(); i++) {
          if (i > 0) {
            constraint.append(", ");
          }
          constraint.append(constraints.get(i));
        }
        constraint.append("}");
        tag.addAttribute("constraints", constraint.toString());
      }
    }
    tag.addAttribute("required", Boolean.toString(isRequired()));
    if (getMaxLength() != null) {
      tag.addAttribute("maxLength", getMaxLength().toString());
    }
  }

  /**
   * @return the min
   */
  public String getMin() {
    return min;
  }

  /**
   * @param min the min to set
   */
  public void setMin(String min) {
    this.min = StringUtils.stripToNull(min);
  }

  /**
   * @return the max
   */
  public String getMax() {
    return max;
  }

  /**
   * @param max the max to set
   */
  public void setMax(String max) {
    this.max = StringUtils.stripToNull(max);
  }

  /**
   * @return the numberType
   */
  public String getNumberType() {
    return numberType;
  }

  /**
   * @param numberType the numberType to set
   */
  public void setNumberType(String numberType) {
    this.numberType = StringUtils.stripToNull(numberType);
  }

  /**
   * @return the places
   */
  public Integer getPlaces() {
    return places;
  }

  /**
   * @param places the places to set
   */
  public void setPlaces(Integer places) {
    this.places = places;
  }

}
