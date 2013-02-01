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
package gov.nih.nci.calims2.business.report.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class EntityDescriptorTest {
  private static final int LIST_LENGTH = 5;
  private static final String PROPERTY = "property";
  private static final String RELATIONSHIP = "relationship";

  /**
   * Test the getPropertyDescriptor method for success with a main property.
   */
  @Test
  public void testGetPropertyDescriptorMainSuccess() {
    String expectedName = PROPERTY + "2";
    PropertyDescriptor result = testGetPropertyDescriptor(expectedName);
    assertNotNull("No result returned", result);
    assertEquals("Wrong descriptor returned", expectedName, result.getName());
  }

  /**
   * Test the getPropertyDescriptor method for failure with a main property.
   */
  @Test
  public void testGetPropertyDescriptorMainFailure() {
    try {
      testGetPropertyDescriptor("xyz");
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Nothing to do
    }
  }

  /**
   * Test the getPropertyDescriptor method for success with a dependent property.
   */
  @Test
  public void testGetPropertyDescriptorDependentSuccess() {
    String expectedName = RELATIONSHIP + "2." + RELATIONSHIP + "2" + PROPERTY + "2";
    PropertyDescriptor result = testGetPropertyDescriptor(expectedName);
    assertNotNull("No result returned", result);
    assertEquals("Wrong descriptor returned", RELATIONSHIP + "2" + PROPERTY + "2", result.getName());
  }

  /**
   * Test the getPropertyDescriptor method for failure with a dependent property.
   */
  @Test
  public void testGetPropertyDescriptorDependentFailure() {
    try {
      testGetPropertyDescriptor(RELATIONSHIP + "2.xyz");
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Nothing to do
    }
  }

  private PropertyDescriptor testGetPropertyDescriptor(String propertyName) {
    EntityDescriptor descriptor = new EntityDescriptor();
    descriptor.setProperties(createPropertyList(PROPERTY));
    descriptor.setRelationships(createRelationshipList());
    for (RelationshipDescriptor rd : descriptor.getRelationships()) {
      rd.setProperties(createPropertyList(rd.getName() + PROPERTY));
    }
    return descriptor.getPropertyDescriptor(propertyName);
  }

  /**
   * Test the getPropertyDescriptorInList method for success.
   */
  @Test
  public void testGetPropertyDescriptorInListSuccess() {
    String expectedName = PROPERTY + "2";
    PropertyDescriptor result = testGetPropertyDescriptorInList(expectedName);
    assertNotNull("No result returned", result);
    assertEquals("Wrong descriptor returned", expectedName, result.getName());
  }

  /**
   * Test the getPropertyDescriptorInList method for failure.
   */
  @Test
  public void testGetPropertyDescriptorInListFailure() {
    try {
      testGetPropertyDescriptorInList("xyz");
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Nothing to do
    }

  }

  private PropertyDescriptor testGetPropertyDescriptorInList(String propertyName) {
    EntityDescriptor descriptor = new EntityDescriptor();
    List<PropertyDescriptor> properties = createPropertyList(PROPERTY);
    return descriptor.getPropertyDescriptorInList(properties, propertyName);
  }

  /**
   * test the getRelationshipDescriptor method for success.
   */
  @Test
  public void testgetRelationshipDescriptorSuccess() {
    String expectedName = RELATIONSHIP + "2";
    RelationshipDescriptor result = testGetRelationshipDescriptor(expectedName);
    assertNotNull("No result returned", result);
    assertEquals("Wrong descriptor returned", expectedName, result.getName());
  }

  /**
   * test the getRelationshipDescriptor method for failure.
   */
  @Test
  public void testgetRelationshipDescriptorFailure() {
    try {
      testGetRelationshipDescriptor("xyz");
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Nothing to do
    }
  }

  private RelationshipDescriptor testGetRelationshipDescriptor(String relationshipName) {
    EntityDescriptor descriptor = new EntityDescriptor();
    descriptor.setRelationships(createRelationshipList());
    return descriptor.getRelationshipDescriptor(relationshipName);
  }

  /**
   * Create a list of property descriptors.
   * @param name The property names prefix
   * 
   * @return The created list
   */
  List<PropertyDescriptor> createPropertyList(String name) {
    List<PropertyDescriptor> list = new ArrayList<PropertyDescriptor>();
    for (int i = 0; i < LIST_LENGTH; i++) {
      PropertyDescriptor p = new PropertyDescriptor();
      p.setName(name + i);
      list.add(p);
    }
    return list;
  }

  /**
   * Create a list of relationship descriptors.
   * 
   * @return The created list
   */
  List<RelationshipDescriptor> createRelationshipList() {
    List<RelationshipDescriptor> list = new ArrayList<RelationshipDescriptor>();
    for (int i = 0; i < LIST_LENGTH; i++) {
      RelationshipDescriptor r = new RelationshipDescriptor();
      r.setName(RELATIONSHIP + i);
      list.add(r);
    }
    return list;
  }

}
