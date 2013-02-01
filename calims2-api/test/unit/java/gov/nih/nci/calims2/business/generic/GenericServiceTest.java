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
 * sub licenses of modifications of the Software, or any derivative works of the 
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
package gov.nih.nci.calims2.business.generic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.Person;

/**
 * @author connollym@moxieinformatics.com
 */
public class GenericServiceTest {

  private GenericServiceImpl<Person> testService = new GenericServiceImpl<Person>();
  private CRUDEventListenerMockup<Person> crudEventListener = new CRUDEventListenerMockup<Person>();
  private DaoMockup daomockup = new DaoMockup();
  private ValidatorMockup validatormockup = new ValidatorMockup();

  /**
   * Test The createDefault method.
   */
  @Test
  public void testCreateDefault() {
    initMockups(true, false);
    Person result = testService.createDefault(Person.class);
    assertEquals("Wrong person passed to afterCreateDefault", crudEventListener.getAfterCreateDefaultEntity(), result);
    assertEquals("Wrong person returned", crudEventListener.getCreateDefaultResult(), result);
  }

  /**
   * Test a successful creation.
   * 
   * @throws ValidationException Throws validation exception.
   */
  @Test
  public void testSuccessfulCreate() throws ValidationException {
    initMockups(true, false);
    Person person = new Person();
    Person result = testService.create(person);
    assertEquals("Wrong Person passed to validator", person, validatormockup.getEntity());
    assertEquals("Wrong Person passed to CRUDEventListener.beforeCreate", person, crudEventListener.getInputEntity());
    assertEquals("Wrong Person passed to CRUDEventListener.afterCreate", crudEventListener.getCreateResult(), crudEventListener
        .getAfterCreateEntity());
    assertEquals("Wrong Person returned", crudEventListener.getAfterCreateEntity(), result);
  }

  /**
   * Test an unsuccessful creation.
   * 
   * @throws ValidationException Throws validation exception.
   */
  @Test
  public void testUnsuccessfulCreate() throws ValidationException {
    initMockups(false, true);
    Person person = new Person();
    person.setFamilyName("Smith");
    try {
      testService.create(person);
      fail("Update method should have failed");
    } catch (ValidationException e) {
      assertEquals("Wrong exception thrown", validatormockup.getException(), e);
    }
  }

  /**
   * Test a successful update.
   * 
   * @throws ValidationException Throws validation exception.
   */
  @Test
  public void testSuccessfulUpdate() throws ValidationException {
    initMockups(true, false);
    Person person = new Person();
    person.setFamilyName("Smith");
    Person result = testService.update(person);
    assertEquals("Wrong Person passed to validator", person, validatormockup.getEntity());
    assertEquals("Wrong input Person passed to CRUDEventListener.beforeUpdate", person, crudEventListener.getInputEntity());
    assertEquals("Wrong existing Person passed to CRUDEventListener.beforeUpdate", daomockup.getEntityFoundById(),
        crudEventListener.getExistingEntity());
    assertEquals("Wrong Person passed to CRUDEventListener.afterUpdate", crudEventListener.getUpdateResult(), crudEventListener
        .getAfterUpdateEntity());
    assertEquals("Wrong Person returned", crudEventListener.getAfterUpdateEntity(), result);
    assertEquals("Person family name is not equal", person.getFamilyName(), result.getFamilyName());
  }

  /**
   * Test an unsuccessful update due to validation error.
   * 
   * @throws ValidationException Throws validation exception.
   */
  @Test
  public void testUnsuccessfulUpdateValidation() throws ValidationException {
    initMockups(true, true);
    Person person = new Person();
    person.setFamilyName("Smith");
    try {
      testService.update(person);
      fail("Update method should have failed");
    } catch (ValidationException e) {
      assertEquals("Wrong exception thrown", validatormockup.getException(), e);
    }
  }

  /**
   * Test an unsuccessful update due to object not found.
   * 
   * @throws ValidationException Throws validation exception.
   */
  @Test
  public void testUnsuccessfulUpdateNotFound() throws ValidationException {
    initMockups(false, false);
    Person person = new Person();
    person.setFamilyName("Smith");
    try {
      testService.update(person);
      fail("Update method should have failed");
    } catch (ValidationException e) {
      // List<ValidationViolation> violations = e.getViolations();
      // assertEquals("Wrong number of violations.", 1, violations.size());
      // assertTrue("Wrong violation.", violations.get(0).getViolation() == GenericViolation.ORIGINAL_NOT_FOUND);
    }
  }

  /**
   * Test a successful delete.
   * 
   * @throws ValidationException Throws validation exception.
   */
  @Test
  public void testSuccessfulDelete() throws ValidationException {
    initMockups(true, false);
    Person result = testService.delete(Person.class, 1L);
    assertEquals("Wrong entity deleted.", daomockup.getEntityFoundById(), result);
    assertEquals("Wrong Person passed to CRUDEventListener.beforeDelete", daomockup.getEntityFoundById(), crudEventListener
        .getExistingEntity());
    assertEquals("Wrong Person passed to CRUDEventListener.afterDelete", daomockup.getEntityFoundById(), crudEventListener
        .getAfterDeleteEntity());
  }

  /**
   * Test an unsuccessful delete due to validation error.
   * 
   * @throws ValidationException Throws validation exception.
   */
  @Test
  public void testUnssuccessfulDeleteValidation() throws ValidationException {
    initMockups(true, true);
    try {
      testService.delete(Person.class, 1L);
      fail("Delete Method Should Have Failed");
    } catch (ValidationException e) {
      assertEquals("Wrong exception.", validatormockup.getException(), e);
    }
  }

  /**
   * Test an unsuccessful delete due to object not found.
   * 
   * @throws ValidationException Throws validation exception.
   */
  @Test
  public void testUnssuccessfulDeleteNotFound() throws ValidationException {
    initMockups(false, false);
    try {
      testService.delete(Person.class, 1L);
      fail("Delete Method Should Have Failed");
    } catch (ValidationException e) {
      // List<ValidationViolation> violations = e.getViolations();
      // assertEquals("Wrong number of violations.", 1, violations.size());
      // assertTrue("Wrong violation.", violations.get(0).getViolation() == GenericViolation.ORIGINAL_NOT_FOUND);
    }
  }

  /**
   * Test the findById method.
   */
  @Test
  public void testFindById() {
    initMockups(true, false);
    Person result = testService.findById(Person.class, 1L);
    assertEquals("Wrong person found", daomockup.getEntityFoundById(), result);
    assertEquals("Wrong person id passed to the Dao", new Long(1), ((Person) daomockup.getEntityFoundById()).getId());
  }

  /**
   * Test the findAll method.
   */
  @Test
  public void testFindAll() {
    initMockups(true, false);
    String orderByClause = "orderBy";
    List<Person> result = testService.findAll(Person.class, orderByClause);
    assertEquals("Wrong class passed to the dao", Person.class, daomockup.getFindAllClass());
    assertEquals("Wrong orderByClause passed to the dao", orderByClause, daomockup.getOrderByClause());
    assertEquals("Wrong result returned", daomockup.getQueryResult(), result);
  }

  /**
   * Test the findEntityByNamedQuery method.
   */
  @Test
  public void testFindEntityByNamedQuery() {
    initMockups(true, false);
    Person entityFoundByQuery = new Person();
    daomockup.setEntityFoundByQuery(entityFoundByQuery);
    String queryName = "prefix.xyz";
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    Person result = testService.findEntityByNamedQuery(queryName, parameterValues);
    assertEquals("Wrong query name passed to the Dao", queryName, daomockup.getQueryName());
    assertEquals("Wrong parameters passed to the Dao", parameterValues, daomockup.getParameterValues());
    assertEquals("Wrong result returned", entityFoundByQuery, result);
  }

  /**
   * Test the findByNamedQuery with an unauthorized query name.
   */
  @Test
  public void testFindEntityByNamedQueryForbiddenQuery() {
    try {
      initMockups(true, false);
      Map<String, Object> parameterValues = new HashMap<String, Object>();
      testService.findEntityByNamedQuery("NotAllowed", parameterValues);
      fail("findEntityByNamedQuery Method Should Have Failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Wrong exception message", "Query not allowed in this service", e.getMessage());
    }
  }

  /**
   * Test a successful findByNamedQuery.
   */
  @Test
  public void testFindByNamedQuery() {
    initMockups(true, false);
    String queryName = "prefix.xyz";
    Map<String, Object> parameterValues = new HashMap<String, Object>();
    List<Person> result = testService.findByNamedQuery(queryName, parameterValues);
    assertEquals("Wrong query name passed to the Dao", queryName, daomockup.getQueryName());
    assertEquals("Wrong parameters passed to the Dao", parameterValues, daomockup.getParameterValues());
    assertEquals("Wrong result returned", daomockup.getQueryResult(), result);
  }

  /**
   * Test the findByNamedQuery with an unauthorized query name.
   */
  @Test
  public void testFindByNamedQueryForbiddenQuery() {
    try {
      initMockups(true, false);
      Map<String, Object> parameterValues = new HashMap<String, Object>();
      testService.findByNamedQuery("NotAllowed", parameterValues);
      fail("findByNamedQuery Method Should Have Failed");
    } catch (IllegalArgumentException e) {
      assertEquals("Wrong exception message", "Query not allowed in this service", e.getMessage());
    }
  }

  /**
   * Initialize the testbean with the mockuos according to the given flags.
   * 
   * @param daoReturnObject true if the daomockup must return an object in findById
   * @param validatorThrosException true if the validatorMockup must throw a validationException
   */
  private void initMockups(boolean daoReturnObject, boolean validatorThrowsException) {
    testService.setAllowedQueryNamePrefix("prefix");
    testService.setCrudEventListener(crudEventListener);
    daomockup.setReturnOject(daoReturnObject);
    testService.setGenericDao(daomockup);
    validatormockup.setThrowException(validatorThrowsException);
    testService.setValidator(validatormockup);
  }

}
