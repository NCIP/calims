package gov.nih.nci.calims2.business.generic;

import java.util.Collection;

import javax.validation.ConstraintViolation;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.Validator;
import gov.nih.nci.calims2.domain.administration.Person;

/**
 * @author connollym@moxieinformatics.com
 * 
 */

public class ValidatorMockup implements Validator<Person> {

  private boolean throwException;
  private ValidationException exception;
  private Person testEntity;
  private ValidationOperation testOperation;

  /**
   * @param throwException the throwException to set
   */
  public void setThrowException(boolean throwException) {
    this.throwException = throwException;
  }

  /**
   * @return the exception
   */
  public ValidationException getException() {
    return exception;
  }

  /**
   * @return testEntity The entity to return.
   */
  public Person getEntity() {
    return testEntity;
  }

  /**
   * @param entity the person to set.
   */
  public void setEntity(Person entity) {
    this.testEntity = entity;
  }

  /**
   * @return the operation
   */
  public ValidationOperation getOperation() {
    return testOperation;
  }

  /**
   * @param operation the operation to set.
   */
  public void setOperation(ValidationOperation operation) {
    this.testOperation = operation;
  }

  /**
   * {@inheritDoc}
   */
  public void validate(Person person, ValidationOperation operation) throws ValidationException {
    setEntity(person);
    setOperation(operation);
    if (throwException) {
      exception = new ValidationException("Throwing exception in validate.");
      throw exception;
    }

  }

  /**
   * {@inheritDoc}
   */
  public Collection<ConstraintViolation<Person>> doValidate(Person entity, ValidationOperation operation) {
    return null;
  }
}
