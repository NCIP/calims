package gov.nih.nci.calims2.domain.administration;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|Professional Organization or Group;  NCI|A formal group of people with one or more shared goals.
**/

@Entity
@Table(name = "ORGANIZATION")

public class Organization extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String DUNSNumber;
  /**
* Retrieves the value of the DUNSNumber attribute.
* @return DUNSNumber
**/
  
  @Column(name = "DUNSNUMBER", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDUNSNumber() {
  return DUNSNumber;
  }
  /**
* Sets the value of DUNSNumber attribute.
* @param DUNSNumber .
**/
  public void setDUNSNumber(String 
  DUNSNumber) {
  this.DUNSNumber = DUNSNumber;
  }
  /**
* 
**/
  private String identifierNumber;
  /**
* Retrieves the value of the identifierNumber attribute.
* @return identifierNumber
**/
  
  @Column(name = "IDENTIFIERNUMBER", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getIdentifierNumber() {
  return identifierNumber;
  }
  /**
* Sets the value of identifierNumber attribute.
* @param identifierNumber .
**/
  public void setIdentifierNumber(String 
  identifierNumber) {
  this.identifierNumber = identifierNumber;
  }
  /**
* 
**/
  private Boolean isTaxExempt;
  /**
* Retrieves the value of the isTaxExempt attribute.
* @return isTaxExempt
**/
  
  @Column(name = "ISTAXEXEMPT", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsTaxExempt() {
  return isTaxExempt;
  }
  /**
* Sets the value of isTaxExempt attribute.
* @param isTaxExempt .
**/
  public void setIsTaxExempt(Boolean 
  isTaxExempt) {
  this.isTaxExempt = isTaxExempt;
  }
  /**
* 
**/
  private String legalCategoryType;
  /**
* Retrieves the value of the legalCategoryType attribute.
* @return legalCategoryType
**/
  
  @Column(name = "LEGALCATEGORYTYPE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getLegalCategoryType() {
  return legalCategoryType;
  }
  /**
* Sets the value of legalCategoryType attribute.
* @param legalCategoryType .
**/
  public void setLegalCategoryType(String 
  legalCategoryType) {
  this.legalCategoryType = legalCategoryType;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Organization.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private String taxIdentifierNumber;
  /**
* Retrieves the value of the taxIdentifierNumber attribute.
* @return taxIdentifierNumber
**/
  
  @Column(name = "TAXIDENTIFIERNUMBER", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getTaxIdentifierNumber() {
  return taxIdentifierNumber;
  }
  /**
* Sets the value of taxIdentifierNumber attribute.
* @param taxIdentifierNumber .
**/
  public void setTaxIdentifierNumber(String 
  taxIdentifierNumber) {
  this.taxIdentifierNumber = taxIdentifierNumber;
  }
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
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
* An associated gov.nih.nci.calims2.domain.administration.Location object.
**/
        private gov.nih.nci.calims2.domain.administration.Location location;
        /**
* Retrieves the value of the location attribute.
* @return location
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "ORGANIZATION_LOCATION_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.Organization object.
**/
        private gov.nih.nci.calims2.domain.administration.Organization parentOrganization;
        /**
* Retrieves the value of the parentOrganization attribute.
* @return parentOrganization
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ORGANIZATION_FK")
@org.hibernate.annotations.ForeignKey(name = "CHILDOORGANI_FK")

        public gov.nih.nci.calims2.domain.administration.Organization getParentOrganization() {
        return parentOrganization;
        }
   
        /**
* Sets the value of parentOrganization attribute.
* @param parentOrganization .
**/
        public void setParentOrganization(gov.nih.nci.calims2.domain.administration.Organization parentOrganization) {
        this.parentOrganization = parentOrganization;
        }
   
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Role object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Role> roleCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Role>();
        /**
* Retrieves the value of the roleCollection attribute.
* @return roleCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "ORGANIZATION_FK")
@org.hibernate.annotations.ForeignKey(name = "ROLECOORGANI_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Role> getRoleCollection() {
        return roleCollection;
        }

        /**
* Sets the value of roleCollection attribute.
* @param roleCollection .
**/
        public void setRoleCollection(Set<gov.nih.nci.calims2.domain.administration.Role> roleCollection) {
        this.roleCollection = roleCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Organization.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "ORGANITYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.ContactInformation object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.ContactInformation> contactInformationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.ContactInformation>();
        /**
* Retrieves the value of the contactInformationCollection attribute.
* @return contactInformationCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.ContactInformation> getContactInformationCollection() {
        return contactInformationCollection;
        }

        /**
* Sets the value of contactInformationCollection attribute.
* @param contactInformationCollection .
**/
        public void setContactInformationCollection(Set<gov.nih.nci.calims2.domain.administration.ContactInformation> contactInformationCollection) {
        this.contactInformationCollection = contactInformationCollection;
        }
    






}