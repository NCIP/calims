/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common.environmentalcondition;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import gov.nih.nci.calims2.domain.common.visitor.EnvironmentalConditionVisitor;
/**
* 
**/

@Entity
@DiscriminatorValue("AirFiltration")

public class AirFiltration extends EnvironmentalCondition {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
/** Accepts the EnvironmentalConditionVisitor.
 * @param environmentalConditionVisitor The EnvironmentalConditionVisitor to accept.
 **/ public void accept(EnvironmentalConditionVisitor environmentalConditionVisitor) {
       environmentalConditionVisitor.visitAirFiltration(this);
}






}
