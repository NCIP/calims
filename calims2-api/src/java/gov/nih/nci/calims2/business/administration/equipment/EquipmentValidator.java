/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.equipment;

import java.util.Collection;

import javax.validation.ConstraintViolation;

import gov.nih.nci.calims2.business.administration.namingconvention.NameValidator;
import gov.nih.nci.calims2.business.util.validation.ConstraintViolationImpl;
import gov.nih.nci.calims2.business.util.validation.DefaultValidator;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.domain.administration.Equipment;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class EquipmentValidator extends DefaultValidator<Equipment> {
  
  private NameValidator nameValidator;

  /**
   * {@inheritDoc}
   */
  public Collection<ConstraintViolation<Equipment>> doValidate(Equipment equipment, ValidationOperation operation) {

    Collection<ConstraintViolation<Equipment>> violations = super.doValidate(equipment, operation);
    if (equipment.getLaboratory() != null) {
      NamingConvention namingConvention = nameValidator.getNamingConvention(equipment.getLaboratory().getId(),
          NamingConventionType.EQUIPMENTNAME);
      if (namingConvention != null && !nameValidator.validate(equipment.getName(), namingConvention)) {
        violations.add(new ConstraintViolationImpl<Equipment>());
      }
    }
    return violations;
  }

  /**
   * @param nameValidator the nameValidator to set
   */
  public void setNameValidator(NameValidator nameValidator) {
    this.nameValidator = nameValidator;
  }
}
