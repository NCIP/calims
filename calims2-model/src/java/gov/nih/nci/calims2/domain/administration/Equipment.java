package gov.nih.nci.calims2.domain.administration;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|An object needed to perform a diagnostic, therapeutic or research activity.
**/

@Entity
@Table(name = "EQUIPMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Equipment extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String model;
  /**
* Retrieves the value of the model attribute.
* @return model
**/
  
  @Column(name = "MODEL", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.Equipment.model}")
  public String getModel() {
  return model;
  }
  /**
* Sets the value of model attribute.
* @param model .
**/
  public void setModel(String 
  model) {
  this.model = model;
  }
  /**
* 
**/
  private String propertyId;
  /**
* Retrieves the value of the propertyId attribute.
* @return propertyId
**/
  
  @Column(name = "PROPERTYID", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPropertyId() {
  return propertyId;
  }
  /**
* Sets the value of propertyId attribute.
* @param propertyId .
**/
  public void setPropertyId(String 
  propertyId) {
  this.propertyId = propertyId;
  }
  /**
* 
**/
  private String serialNumber;
  /**
* Retrieves the value of the serialNumber attribute.
* @return serialNumber
**/
  
  @Column(name = "SERIALNUMBER", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSerialNumber() {
  return serialNumber;
  }
  /**
* Sets the value of serialNumber attribute.
* @param serialNumber .
**/
  public void setSerialNumber(String 
  serialNumber) {
  this.serialNumber = serialNumber;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Equipment.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus 
  status) {
  this.status = status;
  }

        /**
* An associated gov.nih.nci.calims2.domain.administration.Location object.
**/
        private gov.nih.nci.calims2.domain.administration.Location location;
        /**
* Retrieves the value of the location attribute.
* @return location
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "EQUIPMENT_LOCATION_FK")

        public gov.nih.nci.calims2.domain.administration.Location getLocation() {
        return location;
        }
   
        /**
* Sets the value of location attribute.
* @param location .
**/
        public void setLocation(gov.nih.nci.calims2.domain.administration.Location location) {
        this.location = location;
        }
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipment")
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
* An associated gov.nih.nci.calims2.domain.common.ElectronicDocument object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.ElectronicDocument> manualCollection = new HashSet<gov.nih.nci.calims2.domain.common.ElectronicDocument>();
        /**
* Retrieves the value of the manualCollection attribute.
* @return manualCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "EQUIPMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "MANUALEQUIPM_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.common.ElectronicDocument> getManualCollection() {
        return manualCollection;
        }

        /**
* Sets the value of manualCollection attribute.
* @param manualCollection .
**/
        public void setManualCollection(Set<gov.nih.nci.calims2.domain.common.ElectronicDocument> manualCollection) {
        this.manualCollection = manualCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Software object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Software> softwareCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Software>();
        /**
* Retrieves the value of the softwareCollection attribute.
* @return softwareCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "EQUIPMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "SOFTWAEQUIPM_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Software> getSoftwareCollection() {
        return softwareCollection;
        }

        /**
* Sets the value of softwareCollection attribute.
* @param softwareCollection .
**/
        public void setSoftwareCollection(Set<gov.nih.nci.calims2.domain.administration.Software> softwareCollection) {
        this.softwareCollection = softwareCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Laboratory object.
**/
        private gov.nih.nci.calims2.domain.administration.Laboratory laboratory;
        /**
* Retrieves the value of the laboratory attribute.
* @return laboratory
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Equipment.laboratory}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABORATORY_FK")
@org.hibernate.annotations.ForeignKey(name = "EQUIPMLABORA_FK")

        public gov.nih.nci.calims2.domain.administration.Laboratory getLaboratory() {
        return laboratory;
        }
   
        /**
* Sets the value of laboratory attribute.
* @param laboratory .
**/
        public void setLaboratory(gov.nih.nci.calims2.domain.administration.Laboratory laboratory) {
        this.laboratory = laboratory;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Person> personCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Person>();
        /**
* Retrieves the value of the personCollection attribute.
* @return personCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Equipment_Person",
joinColumns = @JoinColumn(name = "EQUIPMENT_ID"),
inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
@org.hibernate.annotations.ForeignKey(name = "EQUIPMENT_PERSON_ID", inverseName = "PERSON_EQUIPMENT_ID")
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Equipment.personCollection}")
        public Set<gov.nih.nci.calims2.domain.administration.Person> getPersonCollection() {
        return personCollection;
        }
    
        /**
* Sets the value of personCollection attribute.
* @param personCollection .
**/
        public void setPersonCollection(Set<gov.nih.nci.calims2.domain.administration.Person> personCollection) {
        this.personCollection = personCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Equipment.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "EQUIPMTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.inventory.Hazard object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.Hazard> hazardCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Hazard>();
        /**
* Retrieves the value of the hazardCollection attribute.
* @return hazardCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Equipment_Hazard",
joinColumns = @JoinColumn(name = "EQUIPMENT_ID"),
inverseJoinColumns = @JoinColumn(name = "HAZARD_ID"))
@org.hibernate.annotations.ForeignKey(name = "EQUIPMENT_HAZARD_ID", inverseName = "HAZARD_EQUIPMENT_ID")
        
        public Set<gov.nih.nci.calims2.domain.inventory.Hazard> getHazardCollection() {
        return hazardCollection;
        }
    
        /**
* Sets the value of hazardCollection attribute.
* @param hazardCollection .
**/
        public void setHazardCollection(Set<gov.nih.nci.calims2.domain.inventory.Hazard> hazardCollection) {
        this.hazardCollection = hazardCollection;
        }
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Organization object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Organization>();
        /**
* Retrieves the value of the organizationCollection attribute.
* @return organizationCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Equipment_Organization",
joinColumns = @JoinColumn(name = "EQUIPMENT_ID"),
inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID"))
@org.hibernate.annotations.ForeignKey(name = "EQUIPMENT_ORGANIZATION_ID", inverseName = "ORGANIZATION_EQUIPMENT_ID")
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Equipment.organizationCollection}")
        public Set<gov.nih.nci.calims2.domain.administration.Organization> getOrganizationCollection() {
        return organizationCollection;
        }
    
        /**
* Sets the value of organizationCollection attribute.
* @param organizationCollection .
**/
        public void setOrganizationCollection(Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
        }
    






}
