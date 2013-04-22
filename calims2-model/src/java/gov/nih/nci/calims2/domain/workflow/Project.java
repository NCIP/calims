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
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* 
**/

@Entity
@Table(name = "PROJECT")

public class Project extends DisplayableEntity implements EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private org.joda.time.DateTime actualEndDate;
  /**
* Retrieves the value of the actualEndDate attribute.
* @return actualEndDate
**/
  
  @Column(name = "ACTUALENDDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getActualEndDate() {
  return actualEndDate;
  }
  /**
* Sets the value of actualEndDate attribute.
* @param actualEndDate .
**/
  public void setActualEndDate(org.joda.time.DateTime 
  actualEndDate) {
  this.actualEndDate = actualEndDate;
  }
  /**
* 
**/
  private org.joda.time.DateTime actualStartDate;
  /**
* Retrieves the value of the actualStartDate attribute.
* @return actualStartDate
**/
  
  @Column(name = "ACTUALSTARTDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getActualStartDate() {
  return actualStartDate;
  }
  /**
* Sets the value of actualStartDate attribute.
* @param actualStartDate .
**/
  public void setActualStartDate(org.joda.time.DateTime 
  actualStartDate) {
  this.actualStartDate = actualStartDate;
  }
  /**
* 
**/
  private org.joda.time.DateTime expectedEndDate;
  /**
* Retrieves the value of the expectedEndDate attribute.
* @return expectedEndDate
**/
  
  @Column(name = "EXPECTEDENDDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getExpectedEndDate() {
  return expectedEndDate;
  }
  /**
* Sets the value of expectedEndDate attribute.
* @param expectedEndDate .
**/
  public void setExpectedEndDate(org.joda.time.DateTime 
  expectedEndDate) {
  this.expectedEndDate = expectedEndDate;
  }
  /**
* 
**/
  private org.joda.time.DateTime expectedStartDate;
  /**
* Retrieves the value of the expectedStartDate attribute.
* @return expectedStartDate
**/
  
  @Column(name = "EXPECTEDSTARTDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getExpectedStartDate() {
  return expectedStartDate;
  }
  /**
* Sets the value of expectedStartDate attribute.
* @param expectedStartDate .
**/
  public void setExpectedStartDate(org.joda.time.DateTime 
  expectedStartDate) {
  this.expectedStartDate = expectedStartDate;
  }
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
  private gov.nih.nci.calims2.domain.workflow.enumeration.ProjectStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.workflow.enumeration.ProjectStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.workflow.enumeration.ProjectStatus 
  status) {
  this.status = status;
  }
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
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "SOFTWAPROJECT_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Software> getSoftwareCollection() {
        return softwareCollection;
        }

        *//**
* Sets the value of softwareCollection attribute.
* @param softwareCollection .
**//*
        public void setSoftwareCollection(Set<gov.nih.nci.calims2.domain.administration.Software> softwareCollection) {
        this.softwareCollection = softwareCollection;
        }*/
    
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_PROJECT",joinColumns=@JoinColumn(name="ID_NOTES_PROJECT"))
        @ForeignKey(name="FK_NOTES_PROJECT")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
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
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "SPECIMPROJECT_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Specimen> getSpecimenCollection() {
        return specimenCollection;
        }

        *//**
* Sets the value of specimenCollection attribute.
* @param specimenCollection .
**//*
        public void setSpecimenCollection(Set<gov.nih.nci.calims2.domain.inventory.Specimen> specimenCollection) {
        this.specimenCollection = specimenCollection;
        }
    */
    
    
/*    
        *//**
* An associated gov.nih.nci.calims2.domain.administration.Collaboration object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Collaboration> collaborationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Collaboration>();
        *//**
* Retrieves the value of the collaborationCollection attribute.
* @return collaborationCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "COLLABPROJECT_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Collaboration> getCollaborationCollection() {
        return collaborationCollection;
        }

        *//**
* Sets the value of collaborationCollection attribute.
* @param collaborationCollection .
**//*
        public void setCollaborationCollection(Set<gov.nih.nci.calims2.domain.administration.Collaboration> collaborationCollection) {
        this.collaborationCollection = collaborationCollection;
        }
    */
    
   /*     *//**
* An associated gov.nih.nci.calims2.domain.inventory.LabSupply object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.inventory.LabSupply> labSupplyCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.LabSupply>();
        *//**
* Retrieves the value of the labSupplyCollection attribute.
* @return labSupplyCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "LABSUPPROJECT_FK")

        
       
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
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "PERSONPROJECT_FK")

        
       
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
* An associated gov.nih.nci.calims2.domain.administration.Laboratory object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Laboratory> laboratoryCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Laboratory>();
        *//**
* Retrieves the value of the laboratoryCollection attribute.
* @return laboratoryCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "LABORAPROJECT_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Laboratory> getLaboratoryCollection() {
        return laboratoryCollection;
        }

        *//**
* Sets the value of laboratoryCollection attribute.
* @param laboratoryCollection .
**//*
        public void setLaboratoryCollection(Set<gov.nih.nci.calims2.domain.administration.Laboratory> laboratoryCollection) {
        this.laboratoryCollection = laboratoryCollection;
        }*/
    
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
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "EQUIPMPROJECT_FK")

        
       
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
    /*
        *//**
* An associated gov.nih.nci.calims2.domain.administration.Organization object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Organization>();
        *//**
* Retrieves the value of the organizationCollection attribute.
* @return organizationCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "ORGANIPROJECT_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Organization> getOrganizationCollection() {
        return organizationCollection;
        }

        *//**
* Sets the value of organizationCollection attribute.
* @param organizationCollection .
**//*
        public void setOrganizationCollection(Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
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
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "WORKSHPROJECT_FK")

        
       
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
    
    
        /**
* An associated gov.nih.nci.calims2.domain.workflow.Method object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.workflow.Method> methodCollection = new HashSet<gov.nih.nci.calims2.domain.workflow.Method>();
        /**
* Retrieves the value of the methodCollection attribute.
* @return methodCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "METHODPROJECT_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.workflow.Method> getMethodCollection() {
        return methodCollection;
        }

        /**
* Sets the value of methodCollection attribute.
* @param methodCollection .
**/
        public void setMethodCollection(Set<gov.nih.nci.calims2.domain.workflow.Method> methodCollection) {
        this.methodCollection = methodCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
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
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVPROJECT_FK")

        
       
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
    






}
