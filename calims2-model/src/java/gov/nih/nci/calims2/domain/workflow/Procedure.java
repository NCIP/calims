/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.workflow;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "PROCEDURE")

public class Procedure extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Boolean isTemplate;
  /**
* Retrieves the value of the isTemplate attribute.
* @return isTemplate
**/
  
  @Column(name = "ISTEMPLATE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsTemplate() {
  return isTemplate;
  }
  /**
* Sets the value of isTemplate attribute.
* @param isTemplate .
**/
  public void setIsTemplate(Boolean 
  isTemplate) {
  this.isTemplate = isTemplate;
  }
  /**
* 
**/
  private Long orderOfExecution;
  /**
* Retrieves the value of the orderOfExecution attribute.
* @return orderOfExecution
**/
  
  @Column(name = "ORDEROFEXECUTION", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getOrderOfExecution() {
  return orderOfExecution;
  }
  /**
* Sets the value of orderOfExecution attribute.
* @param orderOfExecution .
**/
  public void setOrderOfExecution(Long 
  orderOfExecution) {
  this.orderOfExecution = orderOfExecution;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.workflow.enumeration.ProcedureStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.workflow.enumeration.ProcedureStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.workflow.enumeration.ProcedureStatus 
  status) {
  this.status = status;
  }
    /*
        *//**
* An associated gov.nih.nci.calims2.domain.inventory.LabSupply object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.inventory.LabSupply> labSupplyCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.LabSupply>();
        *//**
* Retrieves the value of the labSupplyCollection attribute.
* @return labSupplyCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "LABSUPPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.LabSupply> getLabSupplyCollection() {
        return labSupplyCollection;
        }

        *//**
* Sets the value of labSupplyCollection attribute.
* @param labSupplyCollection .
**//*
        public void setLabSupplyCollection(Set<gov.nih.nci.calims2.domain.inventory.LabSupply> labSupplyCollection) {
        this.labSupplyCollection = labSupplyCollection;
        }
    
   */
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
@org.hibernate.annotations.ForeignKey(name = "PROCEDTYPE_FK")

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
   /*
    
        *//**
* An associated gov.nih.nci.calims2.domain.administration.Person object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Person> personCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Person>();
        *//**
* Retrieves the value of the personCollection attribute.
* @return personCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "PERSONPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Person> getPersonCollection() {
        return personCollection;
        }

        *//**
* Sets the value of personCollection attribute.
* @param personCollection .
**//*
        public void setPersonCollection(Set<gov.nih.nci.calims2.domain.administration.Person> personCollection) {
        this.personCollection = personCollection;
        }*/
    
    /*
        *//**
* An associated gov.nih.nci.calims2.domain.administration.Software object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Software> softwareCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Software>();
        *//**
* Retrieves the value of the softwareCollection attribute.
* @return softwareCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "SOFTWAPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Software> getSoftwareCollection() {
        return softwareCollection;
        }

        *//**
* Sets the value of softwareCollection attribute.
* @param softwareCollection .
**//*
        public void setSoftwareCollection(Set<gov.nih.nci.calims2.domain.administration.Software> softwareCollection) {
        this.softwareCollection = softwareCollection;
        }
    
    */
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Worksheet object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.Worksheet> worksheetCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Worksheet>();
        /**
* Retrieves the value of the worksheetCollection attribute.
* @return worksheetCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "WORKSHPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Worksheet> getWorksheetCollection() {
        return worksheetCollection;
        }

        /**
* Sets the value of worksheetCollection attribute.
* @param worksheetCollection .
**/
        public void setWorksheetCollection(Set<gov.nih.nci.calims2.domain.inventory.Worksheet> worksheetCollection) {
        this.worksheetCollection = worksheetCollection;
        }
    
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_PROCEDURE",joinColumns=@JoinColumn(name="ID_NOTES_PROCEDURE"))
        @ForeignKey(name="FK_NOTES_PROCEDURE")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

   /* 
        *//**
* An associated gov.nih.nci.calims2.domain.administration.Equipment object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Equipment> equipmentCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Equipment>();
        *//**
* Retrieves the value of the equipmentCollection attribute.
* @return equipmentCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "EQUIPMPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Equipment> getEquipmentCollection() {
        return equipmentCollection;
        }

        *//**
* Sets the value of equipmentCollection attribute.
* @param equipmentCollection .
**//*
        public void setEquipmentCollection(Set<gov.nih.nci.calims2.domain.administration.Equipment> equipmentCollection) {
        this.equipmentCollection = equipmentCollection;
        }
    
    */
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "procedure")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.common.Document> getDocumentCollection() {
        return documentCollection;
        }

        /**
* Sets the value of documentCollection attribute.
* @param documentCollection .
**/
        public void setDocumentCollection(Set<gov.nih.nci.calims2.domain.common.Document> documentCollection) {
        this.documentCollection = documentCollection;
        }
    
/*    
        *//**
* An associated gov.nih.nci.calims2.domain.administration.Laboratory object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Laboratory> laboratoryCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Laboratory>();
        *//**
* Retrieves the value of the laboratoryCollection attribute.
* @return laboratoryCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "LABORAPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Laboratory> getLaboratoryCollection() {
        return laboratoryCollection;
        }

        *//**
* Sets the value of laboratoryCollection attribute.
* @param laboratoryCollection .
**//*
        public void setLaboratoryCollection(Set<gov.nih.nci.calims2.domain.administration.Laboratory> laboratoryCollection) {
        this.laboratoryCollection = laboratoryCollection;
        }
    */
    
        /**
* An associated gov.nih.nci.calims2.domain.workflow.Approval object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.workflow.Approval> approvalCollection = new HashSet<gov.nih.nci.calims2.domain.workflow.Approval>();
        /**
* Retrieves the value of the approvalCollection attribute.
* @return approvalCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.workflow.Approval> getApprovalCollection() {
        return approvalCollection;
        }

        /**
* Sets the value of approvalCollection attribute.
* @param approvalCollection .
**/
        public void setApprovalCollection(Set<gov.nih.nci.calims2.domain.workflow.Approval> approvalCollection) {
        this.approvalCollection = approvalCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Parameter object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Parameter> parameterCollection = new HashSet<gov.nih.nci.calims2.domain.common.Parameter>();
        /**
* Retrieves the value of the parameterCollection attribute.
* @return parameterCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "PARAMEPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.common.Parameter> getParameterCollection() {
        return parameterCollection;
        }

        /**
* Sets the value of parameterCollection attribute.
* @param parameterCollection .
**/
        public void setParameterCollection(Set<gov.nih.nci.calims2.domain.common.Parameter> parameterCollection) {
        this.parameterCollection = parameterCollection;
        }
    
    /*
        *//**
* An associated gov.nih.nci.calims2.domain.inventory.Specimen object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.inventory.Specimen> specimenCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Specimen>();
        *//**
* Retrieves the value of the specimenCollection attribute.
* @return specimenCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "SPECIMPROCED_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Specimen> getSpecimenCollection() {
        return specimenCollection;
        }

        *//**
* Sets the value of specimenCollection attribute.
* @param specimenCollection .
**//*
        public void setSpecimenCollection(Set<gov.nih.nci.calims2.domain.inventory.Specimen> specimenCollection) {
        this.specimenCollection = specimenCollection;
        }*/
 






}
