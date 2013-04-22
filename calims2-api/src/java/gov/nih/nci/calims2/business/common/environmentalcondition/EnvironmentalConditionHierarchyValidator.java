/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.common.environmentalcondition;

import java.util.Collection;

import javax.validation.ConstraintViolation;

import gov.nih.nci.calims2.domain.common.environmentalcondition.AirFiltration;
import gov.nih.nci.calims2.domain.common.environmentalcondition.AirFlow;
import gov.nih.nci.calims2.domain.common.environmentalcondition.Dessication;
import gov.nih.nci.calims2.domain.common.environmentalcondition.EnvironmentalCondition;
import gov.nih.nci.calims2.domain.common.environmentalcondition.Humidity;
import gov.nih.nci.calims2.domain.common.environmentalcondition.LightCycle;
import gov.nih.nci.calims2.domain.common.environmentalcondition.LightExposure;
import gov.nih.nci.calims2.domain.common.environmentalcondition.Temperature;
import gov.nih.nci.calims2.domain.common.environmentalcondition.UltravioletExposure;
import gov.nih.nci.calims2.domain.common.environmentalcondition.Ventilation;
import gov.nih.nci.calims2.domain.common.environmentalcondition.pH;
import gov.nih.nci.calims2.domain.common.environmentalcondition.percentCO2;
import gov.nih.nci.calims2.domain.common.environmentalcondition.percentO2;
import gov.nih.nci.calims2.domain.common.visitor.EnvironmentalConditionVisitor;

/**
 * @author connollym
 * 
 */
public class EnvironmentalConditionHierarchyValidator implements EnvironmentalConditionVisitor {

  @SuppressWarnings("unused")
  private Collection<ConstraintViolation<EnvironmentalCondition>> violations;

  /**
   * {@inheritDoc}
   */
  public void visitAirFiltration(AirFiltration airFiltration) {
    visitEnvironmentalCondition(airFiltration);
  }

  /**
   * {@inheritDoc}
   */
  public void visitAirFlow(AirFlow airFlow) {
    visitEnvironmentalCondition(airFlow);
  }

  /**
   * {@inheritDoc}
   */
  public void visitDessication(Dessication dessication) {
    visitEnvironmentalCondition(dessication);
  }

  /**
   * {@inheritDoc}
   */
  public void visitEnvironmentalCondition(EnvironmentalCondition environmentalCondition) {
    // nothing to do here
  }

  /**
   * {@inheritDoc}
   */
  public void visitHumidity(Humidity humidity) {
    visitEnvironmentalCondition(humidity);
  }

  /**
   * {@inheritDoc}
   */
  public void visitLightCycle(LightCycle lightCycle) {
    visitEnvironmentalCondition(lightCycle);
  }

  /**
   * {@inheritDoc}
   */
  public void visitLightExposure(LightExposure lightExposure) {
    visitEnvironmentalCondition(lightExposure);
  }

  /**
   * {@inheritDoc}
   */
  public void visitTemperature(Temperature temperature) {
    visitEnvironmentalCondition(temperature);
  }

  /**
   * {@inheritDoc}
   */
  public void visitUltravioletExposure(UltravioletExposure ultravioletExposure) {
    visitEnvironmentalCondition(ultravioletExposure);
  }

  /**
   * {@inheritDoc}
   */
  public void visitVentilation(Ventilation ventilation) {
    visitEnvironmentalCondition(ventilation);
  }

  /**
   * {@inheritDoc}
   */
  public void visitpH(pH pH) {
    visitEnvironmentalCondition(pH);
  }

  /**
   * {@inheritDoc}
   */
  public void visitpercentCO2(percentCO2 percentCO2) {
    visitEnvironmentalCondition(percentCO2);
  }

  /**
   * {@inheritDoc}
   */
  public void visitpercentO2(percentO2 percentO2) {
    visitEnvironmentalCondition(percentO2);
  }

  /**
   * The violations to be set.
   * 
   * @param violations the violations to be set.
   */
  public void setViolations(Collection<ConstraintViolation<EnvironmentalCondition>> violations) {
    this.violations = violations;
  }

}
