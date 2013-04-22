/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|How much there is of something that you can measure; the total amount or number.
**/

@Embeddable
public class Quantity  implements  Serializable {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|A numerical quantity measured or assigned or computed.
**/
  private String value;
  /**
* Retrieves the value of the value attribute.
* @return value
**/
  
  @Column(name = "VALUE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getValue() {
  return value;
  }
  /**
* Sets the value of value attribute.
* @param value .
**/
  public void setValue(String 
  value) {
  this.value = value;
  }

        /**
* An associated gov.nih.nci.calims2.domain.administration.StandardUnit object.
**/
        private gov.nih.nci.calims2.domain.administration.StandardUnit standardUnit;
        /**
* Retrieves the value of the standardUnit attribute.
* @return standardUnit
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "STANDARDUNIT_FK")
@org.hibernate.annotations.ForeignKey(name = "QUANTITY_STANDARDUNIT_FK")

        public gov.nih.nci.calims2.domain.administration.StandardUnit getStandardUnit() {
        return standardUnit;
        }
   
        /**
* Sets the value of standardUnit attribute.
* @param standardUnit .
**/
        public void setStandardUnit(gov.nih.nci.calims2.domain.administration.StandardUnit standardUnit) {
        this.standardUnit = standardUnit;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "QUANTITYPE_FK")

        public gov.nih.nci.calims2.domain.common.Type getType() {
        return type;
        }
   
        /**
* Sets the value of type attribute.
* @param type .
**/
        public void setType(gov.nih.nci.calims2.domain.common.Type type) {
        this.type = type;
        }
   






}
