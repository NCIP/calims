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
package gov.nih.nci.calims2.uic.menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class MenuItemTest {

  /**
   * Test the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    MenuItem item = new TestItem();
    assertNull("Display name not set correctly", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Wrong children collection", item.getChildren());
  }

  /**
   * Test the 1 parameter constructor.
   */
  @Test
  public void test1ParamConstructor() {
    MenuItem item = new TestItem("dn");
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Wrong children collection", item.getChildren());
  }

  /**
   * Test the 2 parameters constructor.
   */
  @Test
  public void test2ParamConstructor() {
    MenuItem item = new TestItem("dn", false);
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertFalse("Enabled flag not set correctly", item.isEnabled());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Wrong children collection", item.getChildren());
  }

  /**
   * Test the addChild method.
   */
  @Test
  public void testAddChild() {
    MenuItem item = new TestItem();
    MenuItem child = new TestItem("child", true);
    MenuItem result = item.addChild(child);
    assertEquals("Wrong child returned from addChild", child, result);
    assertNull("Wrong children collection", item.getChildren());
  }
  
  /**
   * Test the isComposite method.
   */
  @Test
  public void testIsComposite() {
    MenuItem item = new TestItem();
    assertFalse("MenuItem reported as composite", item.isComposite());
  }

  /**
   * Test the enabled getter/setter methods.
   */
  @Test
  public void testEnabled() {
    MenuItem item = new TestItem();
    item.setEnabled(false);
    assertFalse("Enabled flag not set correctly", item.isEnabled());
  }

  /**
   * Static subclass of MenuItem to test the default implementations.
   * 
   * @author viseem
   * 
   */
  private class TestItem extends MenuItem {

    private static final long serialVersionUID = -5746212522924772465L;

    /**
     * Constructor.
     */
    public TestItem() {
      super();
    }

    /**
     * Constructor.
     * 
     * @param displayName The display name of the item
     */
    public TestItem(String displayName) {
      super(displayName);
    }

    /**
     * Constructor.
     * 
     * @param displayName The display name of the item
     * @param enabled true if enabled
     */
    public TestItem(String displayName, boolean enabled) {
      super(displayName, enabled);
    }

    /**
     * {@inheritDoc}
     */
    public void accept(MenuVisitor visitor) {
      // Nothing to do
    }

  }

}
