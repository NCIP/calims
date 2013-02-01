package gov.nih.nci.calims2.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|Something distinguishable as an identifiable class based on common qualities.
**/

@Entity
@Table(name = "TYPE")

public class Type extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String dataElementCollection;
  /**
* Retrieves the value of the dataElementCollection attribute.
* @return dataElementCollection
**/
  
  @Column(name = "DATAELEMENTCOLLECTION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDataElementCollection() {
  return dataElementCollection;
  }
  /**
* Sets the value of dataElementCollection attribute.
* @param dataElementCollection .
**/
  public void setDataElementCollection(String 
  dataElementCollection) {
  this.dataElementCollection = dataElementCollection;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.common.enumeration.TypeStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.common.Type.status}")
  public gov.nih.nci.calims2.domain.common.enumeration.TypeStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.common.enumeration.TypeStatus 
  status) {
  this.status = status;
  }
   
        
       
   
    
    
       
    






}
