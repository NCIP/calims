/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
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
