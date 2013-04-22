/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.common.visitor;

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

/**
 * @author connollym
 *
 */
public interface EnvironmentalConditionVisitor {

  /**
   * @param airFiltration
   */
  void visitAirFiltration(AirFiltration airFiltration);

  /**
   * @param ventilation
   */
  void visitVentilation(Ventilation ventilation);

  /**
   * @param ultravioletExposure
   */
  void visitUltravioletExposure(UltravioletExposure ultravioletExposure);

  /**
   * @param temperature
   */
  void visitTemperature(Temperature temperature);

  /**
   * @param pH
   */
  void visitpH(pH pH);

  /**
   * @param percentO2
   */
  void visitpercentO2(percentO2 percentO2);

  /**
   * @param percentCO2
   */
  void visitpercentCO2(percentCO2 percentCO2);

  /**
   * @param lightExposure
   */
  void visitLightExposure(LightExposure lightExposure);

  /**
   * @param environmentalCondition
   */
  void visitEnvironmentalCondition(EnvironmentalCondition environmentalCondition);

  /**
   * @param lightCycle
   */
  void visitLightCycle(LightCycle lightCycle);

  /**
   * @param humidity
   */
  void visitHumidity(Humidity humidity);

  /**
   * @param dessication
   */
  void visitDessication(Dessication dessication);

  /**
   * @param airFlow
   */
  void visitAirFlow(AirFlow airFlow);

}
