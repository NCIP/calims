/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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

import gov.nih.nci.calims2.domain.interfaces.AuditableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|A single human being.
**/

@Entity
@Table(name = "PERSON")

public class Person extends AuditableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
*  
**/
  private String academicDegree;
  /**
* Retrieves the value of the academicDegree attribute.
* @return academicDegree
**/
  
  @Column(name = "ACADEMICDEGREE", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.Person.acacdemicDegree}")
  public String getAcademicDegree() {
  return academicDegree;
  }
  /**
* Sets the value of academicDegree attribute.
* @param academicDegree .
**/
  public void setAcademicDegree(String 
  academicDegree) {
  this.academicDegree = academicDegree;
  }
  /**
* 
**/
  private String certification;
  /**
* Retrieves the value of the certification attribute.
* @return certification
**/
  
  @Column(name = "CERTIFICATION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCertification() {
  return certification;
  }
  /**
* Sets the value of certification attribute.
* @param certification .
**/
  public void setCertification(String 
  certification) {
  this.certification = certification;
  }
  /**
* 
**/
  private String clinicalLicense;
  /**
* Retrieves the value of the clinicalLicense attribute.
* @return clinicalLicense
**/
  
  @Column(name = "CLINICALLICENSE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getClinicalLicense() {
  return clinicalLicense;
  }
  /**
* Sets the value of clinicalLicense attribute.
* @param clinicalLicense .
**/
  public void setClinicalLicense(String 
  clinicalLicense) {
  this.clinicalLicense = clinicalLicense;
  }
  /**
* 
**/
  private String displayName;
  /**
* Retrieves the value of the displayName attribute.
* @return displayName
**/
  
  @Column(name = "DISPLAYNAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDisplayName() {
  return displayName;
  }
  /**
* Sets the value of displayName attribute.
* @param displayName .
**/
  public void setDisplayName(String 
  displayName) {
  this.displayName = displayName;
  }
  /**
* 
**/
  private String familyName;
  /**
* Retrieves the value of the familyName attribute.
* @return familyName
**/
  
  @Column(name = "FAMILYNAME", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.Person.familyName}")
  public String getFamilyName() {
  return familyName;
  }
  /**
* Sets the value of familyName attribute.
* @param familyName .
**/
  public void setFamilyName(String 
  familyName) {
  this.familyName = familyName;
  }
  /**
* 
**/
  private String givenName;
  /**
* Retrieves the value of the givenName attribute.
* @return givenName
**/
  
  @Column(name = "GIVENNAME", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.Person.givenName}")
  public String getGivenName() {
  return givenName;
  }
  /**
* Sets the value of givenName attribute.
* @param givenName .
**/
  public void setGivenName(String 
  givenName) {
  this.givenName = givenName;
  }
  /**
* 
**/
  private String individualGeneologySuffix;
  /**
* Retrieves the value of the individualGeneologySuffix attribute.
* @return individualGeneologySuffix
**/
  
  @Column(name = "INDIVIDUALGENEOLOGYSUFFIX", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getIndividualGeneologySuffix() {
  return individualGeneologySuffix;
  }
  /**
* Sets the value of individualGeneologySuffix attribute.
* @param individualGeneologySuffix .
**/
  public void setIndividualGeneologySuffix(String 
  individualGeneologySuffix) {
  this.individualGeneologySuffix = individualGeneologySuffix;
  }
  /**
* 
**/
  private String maidenName;
  /**
* Retrieves the value of the maidenName attribute.
* @return maidenName
**/
  
  @Column(name = "MAIDENNAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getMaidenName() {
  return maidenName;
  }
  /**
* Sets the value of maidenName attribute.
* @param maidenName .
**/
  public void setMaidenName(String 
  maidenName) {
  this.maidenName = maidenName;
  }
  /**
* 
**/
  private String middleName;
  /**
* Retrieves the value of the middleName attribute.
* @return middleName
**/
  
  @Column(name = "MIDDLENAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getMiddleName() {
  return middleName;
  }
  /**
* Sets the value of middleName attribute.
* @param middleName .
**/
  public void setMiddleName(String 
  middleName) {
  this.middleName = middleName;
  }
  /**
* 
**/
  private String namePrefix;
  /**
* Retrieves the value of the namePrefix attribute.
* @return namePrefix
**/
  
  @Column(name = "NAMEPREFIX", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getNamePrefix() {
  return namePrefix;
  }
  /**
* Sets the value of namePrefix attribute.
* @param namePrefix .
**/
  public void setNamePrefix(String 
  namePrefix) {
  this.namePrefix = namePrefix;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.PersonStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{Pattern.gov.nih.nci.calims2.domain.administration.Person.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.PersonStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.PersonStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private String suffix;
  /**
* Retrieves the value of the suffix attribute.
* @return suffix
**/
  
  @Column(name = "SUFFIX", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSuffix() {
  return suffix;
  }
  /**
* Sets the value of suffix attribute.
* @param suffix .
**/
  public void setSuffix(String 
  suffix) {
  this.suffix = suffix;
  }
  /**
* 
**/
  private String title;
  /**
* Retrieves the value of the title attribute.
* @return title
**/
  
  @Column(name = "TITLE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getTitle() {
  return title;
  }
  /**
* Sets the value of title attribute.
* @param title .
**/
  public void setTitle(String 
  title) {
  this.title = title;
  }
  /**
* 
**/
  private String trainingAndEducationSuffixAbreviationText;
  /**
* Retrieves the value of the trainingAndEducationSuffixAbreviationText attribute.
* @return trainingAndEducationSuffixAbreviationText
**/
  
  @Column(name = "TRAININGANDEDUCATIONSUFFIXABR", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getTrainingAndEducationSuffixAbreviationText() {
  return trainingAndEducationSuffixAbreviationText;
  }
  /**
* Sets the value of trainingAndEducationSuffixAbreviationText attribute.
* @param trainingAndEducationSuffixAbreviationText .
**/
  public void setTrainingAndEducationSuffixAbreviationText(String 
  trainingAndEducationSuffixAbreviationText) {
  this.trainingAndEducationSuffixAbreviationText = trainingAndEducationSuffixAbreviationText;
  }
  /**
* 
**/
  private String userName;
  /**
* Retrieves the value of the userName attribute.
* @return userName
**/
  
  @Column(name = "USERNAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getUserName() {
  return userName;
  }
  /**
* Sets the value of userName attribute.
* @param userName .
**/
  public void setUserName(String 
  userName) {
  this.userName = userName;
  }
  /**
* 
**/
  private String USmilitaryRankPrefix;
  /**
* Retrieves the value of the USmilitaryRankPrefix attribute.
* @return USmilitaryRankPrefix
**/
  
  @Column(name = "USMILITARYRANKPREFIX", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getUSmilitaryRankPrefix() {
  return USmilitaryRankPrefix;
  }
  /**
* Sets the value of USmilitaryRankPrefix attribute.
* @param USmilitaryRankPrefix .
**/
  public void setUSmilitaryRankPrefix(String 
  USmilitaryRankPrefix) {
  this.USmilitaryRankPrefix = USmilitaryRankPrefix;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation serviceItemBillingInformation;
        /**
* Retrieves the value of the serviceItemBillingInformation attribute.
* @return serviceItemBillingInformation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SERVICEITEMBILLINGINFORMATION_FK")
@org.hibernate.annotations.ForeignKey(name = "SERVICBILLIN_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation getServiceItemBillingInformation() {
        return serviceItemBillingInformation;
        }
   
        /**
* Sets the value of serviceItemBillingInformation attribute.
* @param serviceItemBillingInformation .
**/
        public void setServiceItemBillingInformation(gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation serviceItemBillingInformation) {
        this.serviceItemBillingInformation = serviceItemBillingInformation;
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
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "ROLECOPERSON_FK")

        
       
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
* An associated gov.nih.nci.calims2.domain.administration.Organization object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Organization>();
        /**
* Retrieves the value of the organizationCollection attribute.
* @return organizationCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Person_Organization",
joinColumns = @JoinColumn(name = "PERSON_ID"),
inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID"))
@org.hibernate.annotations.ForeignKey(name = "PERSON_ORGANIZATION_ID", inverseName = "ORGANIZATION_PERSON_ID")
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Person.organizationCollection}")
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
    
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation personBillingInformation;
        /**
* Retrieves the value of the personBillingInformation attribute.
* @return personBillingInformation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSONBILLINGINFORMATION_FK")
@org.hibernate.annotations.ForeignKey(name = "PERSONBILLIN_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation getPersonBillingInformation() {
        return personBillingInformation;
        }
   
        /**
* Sets the value of personBillingInformation attribute.
* @param personBillingInformation .
**/
        public void setPersonBillingInformation(gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation personBillingInformation) {
        this.personBillingInformation = personBillingInformation;
        }
   
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.ContactInformation object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.ContactInformation> contactInformationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.ContactInformation>();
        /**
* Retrieves the value of the contactInformationCollection attribute.
* @return contactInformationCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
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
    

        /**
* An associated gov.nih.nci.calims2.domain.common.ExternalIdentifier object.
**/
        private gov.nih.nci.calims2.domain.common.ExternalIdentifier externalIdentifier;
        /**
* Retrieves the value of the externalIdentifier attribute.
* @return externalIdentifier
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "EXTERNALIDENTIFIER_FK")
@org.hibernate.annotations.ForeignKey(name = "PERSON_EXTERNALIDE_FK")

        public gov.nih.nci.calims2.domain.common.ExternalIdentifier getExternalIdentifier() {
        return externalIdentifier;
        }
   
        /**
* Sets the value of externalIdentifier attribute.
* @param externalIdentifier .
**/
        public void setExternalIdentifier(gov.nih.nci.calims2.domain.common.ExternalIdentifier externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
        }
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
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
    






}
