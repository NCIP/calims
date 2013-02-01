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
package gov.nih.nci.calims2.taglib.page;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.ContentTag.ContentType;

/**
 * Helper class to manage dojo include and imports in the PageTag.
 * 
 * @author viseem
 * 
 */
public class PageDojoManager implements Serializable {

  private static final long serialVersionUID = 5853094421029044359L;
  
  private boolean includeDojo = false;
  private String config;
  private Set<String> dojoTypes = new TreeSet<String>();
  private Set<String> layers = new LinkedHashSet<String>();

  /**
   * Adds a type to the collection of dojo types to require.
   * 
   * @param type The dojo type to require
   */
  public void addDojoType(String type) {
    dojoTypes.add(type);
  }

  /**
   * Adds a collection of types to the collection of dojo types to require.
   * 
   * @param types The collection of dojo types to require
   */
  public void addDojoTypes(Collection<String> types) {
    dojoTypes.addAll(types);
  }

  /**
   * Adds a layer to the collection of layers to load.
   * 
   * @param layer The name of the layer
   */
  public void addLayer(String layer) {
    layers.add(layer);
  }

  /**
   * Renders the scripts in the given head tag.
   * 
   * @param headTag The head tag in which the rendering must be included.
   * @param context The name of the application context.
   * @param dojoPath The path to the dojo folder in the application
   */
  public void renderDojo(Tag headTag, String context, String dojoPath) {
    if (includeDojo) {
      renderScript(headTag, context, dojoPath);
      renderLayers(headTag, context, dojoPath);
      renderRequire(headTag);
    }
  }

  /**
   * Adds the script that include dojo.
   * 
   * @param headTag The head tag in which the rendering must be included.
   * @param context The name of the application context.
   * @param dojoPath The path to the dojo folder in the application
   */
  private void renderScript(Tag headTag, String context, String dojoPath) {
    Tag scriptTag = headTag.addChild(new CompositeTag(HtmlElement.SCRIPT));
    scriptTag.addAttribute("type", "text/javascript");
    scriptTag.addAttribute("src", context + dojoPath + "/dojo/dojo.js");
    scriptTag.addAttribute("djConfig", config);
  }

  /**
   * Adds the scripts that load the layers.
   * 
   * @param headTag The head tag in which the rendering must be included.
   * @param context The name of the application context.
   * @param dojoPath The path to the dojo folder in the application
   */
  private void renderLayers(Tag headTag, String context, String dojoPath) {
    for (String layer : layers) {
      Tag scriptTag = headTag.addChild(new CompositeTag(HtmlElement.SCRIPT));
      scriptTag.addAttribute("type", "text/javascript");
      scriptTag.addAttribute("src", context + dojoPath + "/" + layer);
    }
  }

  /**
   * Generates the dojo.require statements.
   * 
   * @param headTag The head tag in which the rendering must be included.
   */
  private void renderRequire(Tag headTag) {
    if (!dojoTypes.isEmpty()) {
      Tag scriptTag = headTag.addChild(new CompositeTag(HtmlElement.SCRIPT));
      scriptTag.addAttribute("type", "text/javascript");
      StringBuilder body = new StringBuilder();
      for (String type : dojoTypes) {
        body.append("  dojo.require(\"");
        body.append(type);
        body.append("\");\n");
      }
      ContentTag contentTag = scriptTag.addChild(new ContentTag(body.toString()));
      contentTag.setContentType(ContentType.COMMENTED_CDATA);
    }
  }

  /**
   * @param includeDojo the includeDojo to set
   */
  public void setIncludeDojo(boolean includeDojo) {
    this.includeDojo = includeDojo;
  }

  /**
   * @param config the config to set
   */
  public void setConfig(String config) {
    this.config = config;
  }

}
