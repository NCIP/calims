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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "BIOCHEMICALREACTIONMIXTURE")

public class BiochemicalReactionMixture extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.workflow.enumeration.BiochemicalReactionMixtureStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.workflow.enumeration.BiochemicalReactionMixtureStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.workflow.enumeration.BiochemicalReactionMixtureStatus 
  status) {
  this.status = status;
  }
/*    
        *//**
* An associated gov.nih.nci.calims2.domain.inventory.Container object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.inventory.Container> containerCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Container>();
        *//**
* Retrieves the value of the containerCollection attribute.
* @return containerCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTAIBIOCHE_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Container> getContainerCollection() {
        return containerCollection;
        }

        *//**
* Sets the value of containerCollection attribute.
* @param containerCollection .
**//*
        public void setContainerCollection(Set<gov.nih.nci.calims2.domain.inventory.Container> containerCollection) {
        this.containerCollection = containerCollection;
        }*/
    
    
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
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVBIOCHE_FK")

        
       
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
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "LABSUPBIOCHE_FK")

        
       
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
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "SPECIMBIOCHE_FK")

        
       
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

        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "BIOCHEMICAL_TYPE_FK")

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
    
        /**
* An associated gov.nih.nci.calims2.domain.inventory.event.Event object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.event.Event> eventCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.event.Event>();
        /**
* Retrieves the value of the eventCollection attribute.
* @return eventCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "EVENTCBIOCHE_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.event.Event> getEventCollection() {
        return eventCollection;
        }

        /**
* Sets the value of eventCollection attribute.
* @param eventCollection .
**/
        public void setEventCollection(Set<gov.nih.nci.calims2.domain.inventory.event.Event> eventCollection) {
        this.eventCollection = eventCollection;
        }
    
    
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
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "WORKSHBIOCHE_FK")

        
       
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
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "PERSONBIOCHE_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Person> getPersonCollection() {
        return personCollection;
        }

        *//**
* Sets the value of personCollection attribute.
* @param personCollection .
**//*
        public void setPersonCollection(Set<gov.nih.nci.calims2.domain.administration.Person> personCollection) {
        this.personCollection = personCollection;
        }
    */
/*    
        *//**
* An associated gov.nih.nci.calims2.domain.inventory.Hazard object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.inventory.Hazard> hazardCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Hazard>();
        *//**
* Retrieves the value of the hazardCollection attribute.
* @return hazardCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "HAZARDBIOCHE_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Hazard> getHazardCollection() {
        return hazardCollection;
        }

        *//**
* Sets the value of hazardCollection attribute.
* @param hazardCollection .
**//*
        public void setHazardCollection(Set<gov.nih.nci.calims2.domain.inventory.Hazard> hazardCollection) {
        this.hazardCollection = hazardCollection;
        }
    */
        private Set<gov.nih.nci.calims2.domain.administration.Quantity> quantityCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Quantity>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="QUANTITY_BIOCHEMICALREACT",joinColumns=@JoinColumn(name="ID_QUANTITY_BIOCHEMICALRE"))
        @ForeignKey(name="FK_QUANTITY_BIOCHEMICALRE")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.administration.Quantity> getQuantityCollection() {
        return quantityCollection;
        }
        public void setQuantityCollection(Set<gov.nih.nci.calims2.domain.administration.Quantity> quantityCollection) {
             this.quantityCollection = quantityCollection;
        }

    
        /**
* An associated gov.nih.nci.calims2.domain.common.environmentalcondition.EnvironmentalCondition object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.environmentalcondition.EnvironmentalCondition> environmentalConditionCollection = new HashSet<gov.nih.nci.calims2.domain.common.environmentalcondition.EnvironmentalCondition>();
        /**
* Retrieves the value of the environmentalConditionCollection attribute.
* @return environmentalConditionCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "ENVIROBIOCHE_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.common.environmentalcondition.EnvironmentalCondition> getEnvironmentalConditionCollection() {
        return environmentalConditionCollection;
        }

        /**
* Sets the value of environmentalConditionCollection attribute.
* @param environmentalConditionCollection .
**/
        public void setEnvironmentalConditionCollection(Set<gov.nih.nci.calims2.domain.common.environmentalcondition.EnvironmentalCondition> environmentalConditionCollection) {
        this.environmentalConditionCollection = environmentalConditionCollection;
        }
    
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_BIOCHEMICALREACTION",joinColumns=@JoinColumn(name="ID_NOTES_BIOCHEMICALREACT"))
        @ForeignKey(name="FK_NOTES_BIOCHEMICALREACT")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }







}
