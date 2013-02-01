package gov.nih.nci.calims2.domain.common;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|A writing that contains information; used here to represent any thing that is categorized by writing.
**/

@Entity
@Table(name = "DOCUMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Document extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String endPage;
  /**
* Retrieves the value of the endPage attribute.
* @return endPage
**/
  
  @Column(name = "ENDPAGE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getEndPage() {
  return endPage;
  }
  /**
* Sets the value of endPage attribute.
* @param endPage .
**/
  public void setEndPage(String 
  endPage) {
  this.endPage = endPage;
  }
  /**
* 
**/
  private String keywordCode;
  /**
* Retrieves the value of the keywordCode attribute.
* @return keywordCode
**/
  
  @Column(name = "KEYWORDCODE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getKeywordCode() {
  return keywordCode;
  }
  /**
* Sets the value of keywordCode attribute.
* @param keywordCode .
**/
  public void setKeywordCode(String 
  keywordCode) {
  this.keywordCode = keywordCode;
  }
  /**
* 
**/
  private String keywordText;
  /**
* Retrieves the value of the keywordText attribute.
* @return keywordText
**/
  
  @Column(name = "KEYWORDTEXT", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getKeywordText() {
  return keywordText;
  }
  /**
* Sets the value of keywordText attribute.
* @param keywordText .
**/
  public void setKeywordText(String 
  keywordText) {
  this.keywordText = keywordText;
  }
  /**
* 
**/
  private String startPage;
  /**
* Retrieves the value of the startPage attribute.
* @return startPage
**/
  
  @Column(name = "STARTPAGE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getStartPage() {
  return startPage;
  }
  /**
* Sets the value of startPage attribute.
* @param startPage .
**/
  public void setStartPage(String 
  startPage) {
  this.startPage = startPage;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.common.Document.status}")
  public gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus 
  status) {
  this.status = status;
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
  private String universalResourceLocator;
  /**
* Retrieves the value of the universalResourceLocator attribute.
* @return universalResourceLocator
**/
  
  @Column(name = "UNIVERSALRESOURCELOCATOR", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getUniversalResourceLocator() {
  return universalResourceLocator;
  }
  /**
* Sets the value of universalResourceLocator attribute.
* @param universalResourceLocator .
**/
  public void setUniversalResourceLocator(String 
  universalResourceLocator) {
  this.universalResourceLocator = universalResourceLocator;
  }
  /**
* 
**/
  private String version;
  /**
* Retrieves the value of the version attribute.
* @return version
**/
  
  @Column(name = "VERSION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getVersion() {
  return version;
  }
  /**
* Sets the value of version attribute.
* @param version .
**/
  public void setVersion(String 
  version) {
  this.version = version;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.workflow.Data object.
**/
        private gov.nih.nci.calims2.domain.workflow.Data data;
        /**
* Retrieves the value of the data attribute.
* @return data
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "DATA_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEDATA_FK")

        public gov.nih.nci.calims2.domain.workflow.Data getData() {
        return data;
        }
   
        /**
* Sets the value of data attribute.
* @param data .
**/
        public void setData(gov.nih.nci.calims2.domain.workflow.Data data) {
        this.data = data;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Contract object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Contract contract;
        /**
* Retrieves the value of the contract attribute.
* @return contract
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTRACT_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMECONTRA_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Contract getContract() {
        return contract;
        }
   
        /**
* Sets the value of contract attribute.
* @param contract .
**/
        public void setContract(gov.nih.nci.calims2.domain.administration.customerservice.Contract contract) {
        this.contract = contract;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person person;
        /**
* Retrieves the value of the person attribute.
* @return person
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEPERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getPerson() {
        return person;
        }
   
        /**
* Sets the value of person attribute.
* @param person .
**/
        public void setPerson(gov.nih.nci.calims2.domain.administration.Person person) {
        this.person = person;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest customerRequest;
        /**
* Retrieves the value of the customerRequest attribute.
* @return customerRequest
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CUSTOMERREQUEST_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMECUSTOM_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest getCustomerRequest() {
        return customerRequest;
        }
   
        /**
* Sets the value of customerRequest attribute.
* @param customerRequest .
**/
        public void setCustomerRequest(gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest customerRequest) {
        this.customerRequest = customerRequest;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.workflow.BiochemicalReactionMixture object.
**/
        private gov.nih.nci.calims2.domain.workflow.BiochemicalReactionMixture biochemicalReactionMix;
        /**
* Retrieves the value of the biochemicalReactionMix attribute.
* @return biochemicalReactionMix
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "BIOCHEMICALREACTIONMIXTURE_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEBIOCHE_FK")

        public gov.nih.nci.calims2.domain.workflow.BiochemicalReactionMixture getBiochemicalReactionMix() {
        return biochemicalReactionMix;
        }
   
        /**
* Sets the value of biochemicalReactionMix attribute.
* @param biochemicalReactionMix .
**/
        public void setBiochemicalReactionMix(gov.nih.nci.calims2.domain.workflow.BiochemicalReactionMixture biochemicalReactionMix) {
        this.biochemicalReactionMix = biochemicalReactionMix;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Account object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Account account;
        /**
* Retrieves the value of the account attribute.
* @return account
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ACCOUNT_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEACCOUNT_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Account getAccount() {
        return account;
        }
   
        /**
* Sets the value of account attribute.
* @param account .
**/
        public void setAccount(gov.nih.nci.calims2.domain.administration.customerservice.Account account) {
        this.account = account;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Hazard object.
**/
        private gov.nih.nci.calims2.domain.inventory.Hazard hazard;
        /**
* Retrieves the value of the hazard attribute.
* @return hazard
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "HAZARD_FK")
@org.hibernate.annotations.ForeignKey(name = "REFRENCE_HAZARD_FK")

        public gov.nih.nci.calims2.domain.inventory.Hazard getHazard() {
        return hazard;
        }
   
        /**
* Sets the value of hazard attribute.
* @param hazard .
**/
        public void setHazard(gov.nih.nci.calims2.domain.inventory.Hazard hazard) {
        this.hazard = hazard;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Location object.
**/
        private gov.nih.nci.calims2.domain.administration.Location location;
        /**
* Retrieves the value of the location attribute.
* @return location
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMELOCATI_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.Equipment object.
**/
        private gov.nih.nci.calims2.domain.administration.Equipment equipment;
        /**
* Retrieves the value of the equipment attribute.
* @return equipment
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "EQUIPMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEEQUIPM_FK")

        public gov.nih.nci.calims2.domain.administration.Equipment getEquipment() {
        return equipment;
        }
   
        /**
* Sets the value of equipment attribute.
* @param equipment .
**/
        public void setEquipment(gov.nih.nci.calims2.domain.administration.Equipment equipment) {
        this.equipment = equipment;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.LabSupply object.
**/
        private gov.nih.nci.calims2.domain.inventory.LabSupply labSupply;
        /**
* Retrieves the value of the labSupply attribute.
* @return labSupply
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABSUPPLY_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMELABSUP_FK")

        public gov.nih.nci.calims2.domain.inventory.LabSupply getLabSupply() {
        return labSupply;
        }
   
        /**
* Sets the value of labSupply attribute.
* @param labSupply .
**/
        public void setLabSupply(gov.nih.nci.calims2.domain.inventory.LabSupply labSupply) {
        this.labSupply = labSupply;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.event.Event object.
**/
        private gov.nih.nci.calims2.domain.inventory.event.Event event;
        /**
* Retrieves the value of the event attribute.
* @return event
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "EVENT_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEEVENT_FK")

        public gov.nih.nci.calims2.domain.inventory.event.Event getEvent() {
        return event;
        }
   
        /**
* Sets the value of event attribute.
* @param event .
**/
        public void setEvent(gov.nih.nci.calims2.domain.inventory.event.Event event) {
        this.event = event;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.administration.FileFormatSpecification object.
**/
        private gov.nih.nci.calims2.domain.administration.FileFormatSpecification fileFormatSpecification;
        /**
* Retrieves the value of the fileFormatSpecification attribute.
* @return fileFormatSpecification
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FILEFORMATSPECIFICATION_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMENT_FILEFORMATS_FK")

        public gov.nih.nci.calims2.domain.administration.FileFormatSpecification getFileFormatSpecification() {
        return fileFormatSpecification;
        }
   
        /**
* Sets the value of fileFormatSpecification attribute.
* @param fileFormatSpecification .
**/
        public void setFileFormatSpecification(gov.nih.nci.calims2.domain.administration.FileFormatSpecification fileFormatSpecification) {
        this.fileFormatSpecification = fileFormatSpecification;
        }

        /**
* An associated gov.nih.nci.calims2.domain.administration.Unit object.
**/
        private gov.nih.nci.calims2.domain.administration.Unit unit;
        /**
* Retrieves the value of the unit attribute.
* @return unit
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "UNIT_FK")
@org.hibernate.annotations.ForeignKey(name = "REFERENCE_UNIT_FK")

        public gov.nih.nci.calims2.domain.administration.Unit getUnit() {
        return unit;
        }
   
        /**
* Sets the value of unit attribute.
* @param unit .
**/
        public void setUnit(gov.nih.nci.calims2.domain.administration.Unit unit) {
        this.unit = unit;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Specimen object.
**/
        private gov.nih.nci.calims2.domain.inventory.Specimen specimen;
        /**
* Retrieves the value of the specimen attribute.
* @return specimen
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SPECIMEN_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMESPECIM_FK")

        public gov.nih.nci.calims2.domain.inventory.Specimen getSpecimen() {
        return specimen;
        }
   
        /**
* Sets the value of specimen attribute.
* @param specimen .
**/
        public void setSpecimen(gov.nih.nci.calims2.domain.inventory.Specimen specimen) {
        this.specimen = specimen;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Quotation object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Quotation quotation;
        /**
* Retrieves the value of the quotation attribute.
* @return quotation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "QUOTATION_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEQUOTAT_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Quotation getQuotation() {
        return quotation;
        }
   
        /**
* Sets the value of quotation attribute.
* @param quotation .
**/
        public void setQuotation(gov.nih.nci.calims2.domain.administration.customerservice.Quotation quotation) {
        this.quotation = quotation;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Organization object.
**/
        private gov.nih.nci.calims2.domain.administration.Organization organization;
        /**
* Retrieves the value of the organization attribute.
* @return organization
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ORGANIZATION_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEORGANI_FK")

        public gov.nih.nci.calims2.domain.administration.Organization getOrganization() {
        return organization;
        }
   
        /**
* Sets the value of organization attribute.
* @param organization .
**/
        public void setOrganization(gov.nih.nci.calims2.domain.administration.Organization organization) {
        this.organization = organization;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Collaboration object.
**/
        private gov.nih.nci.calims2.domain.administration.Collaboration collaboration;
        /**
* Retrieves the value of the collaboration attribute.
* @return collaboration
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "COLLABORATION_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMECOLLAB_FK")

        public gov.nih.nci.calims2.domain.administration.Collaboration getCollaboration() {
        return collaboration;
        }
   
        /**
* Sets the value of collaboration attribute.
* @param collaboration .
**/
        public void setCollaboration(gov.nih.nci.calims2.domain.administration.Collaboration collaboration) {
        this.collaboration = collaboration;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Invoice object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Invoice invoice;
        /**
* Retrieves the value of the invoice attribute.
* @return invoice
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "INVOICE_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEINVOICE_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Invoice getInvoice() {
        return invoice;
        }
   
        /**
* Sets the value of invoice attribute.
* @param invoice .
**/
        public void setInvoice(gov.nih.nci.calims2.domain.administration.customerservice.Invoice invoice) {
        this.invoice = invoice;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.ChemicalCompound object.
**/
        private gov.nih.nci.calims2.domain.inventory.ChemicalCompound chemicalCompound;
        /**
* Retrieves the value of the chemicalCompound attribute.
* @return chemicalCompound
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CHEMICALCOMPOUND_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMECHEMIC_FK")

        public gov.nih.nci.calims2.domain.inventory.ChemicalCompound getChemicalCompound() {
        return chemicalCompound;
        }
   
        /**
* Sets the value of chemicalCompound attribute.
* @param chemicalCompound .
**/
        public void setChemicalCompound(gov.nih.nci.calims2.domain.inventory.ChemicalCompound chemicalCompound) {
        this.chemicalCompound = chemicalCompound;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.workflow.Procedure object.
**/
        private gov.nih.nci.calims2.domain.workflow.Procedure procedure;
        /**
* Retrieves the value of the procedure attribute.
* @return procedure
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PROCEDURE_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEPROCED_FK")

        public gov.nih.nci.calims2.domain.workflow.Procedure getProcedure() {
        return procedure;
        }
   
        /**
* Sets the value of procedure attribute.
* @param procedure .
**/
        public void setProcedure(gov.nih.nci.calims2.domain.workflow.Procedure procedure) {
        this.procedure = procedure;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Service object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Service service;
        /**
* Retrieves the value of the service attribute.
* @return service
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SERVICE_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMESERVICE_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Service getService() {
        return service;
        }
   
        /**
* Sets the value of service attribute.
* @param service .
**/
        public void setService(gov.nih.nci.calims2.domain.administration.customerservice.Service service) {
        this.service = service;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.workflow.Project object.
**/
        private gov.nih.nci.calims2.domain.workflow.Project project;
        /**
* Retrieves the value of the project attribute.
* @return project
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PROJECT_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEPROJECT_FK")

        public gov.nih.nci.calims2.domain.workflow.Project getProject() {
        return project;
        }
   
        /**
* Sets the value of project attribute.
* @param project .
**/
        public void setProject(gov.nih.nci.calims2.domain.workflow.Project project) {
        this.project = project;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.inventory.characteristics.Characteristics object.
**/
        private gov.nih.nci.calims2.domain.inventory.characteristics.Characteristics characteristics;
        /**
* Retrieves the value of the characteristics attribute.
* @return characteristics
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CHARACTERISTICS_FK")
@org.hibernate.annotations.ForeignKey(name = "REFERENCE_CHARACTERIS_FK")

        public gov.nih.nci.calims2.domain.inventory.characteristics.Characteristics getCharacteristics() {
        return characteristics;
        }
   
        /**
* Sets the value of characteristics attribute.
* @param characteristics .
**/
        public void setCharacteristics(gov.nih.nci.calims2.domain.inventory.characteristics.Characteristics characteristics) {
        this.characteristics = characteristics;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.NamingConvention object.
**/
        private gov.nih.nci.calims2.domain.administration.NamingConvention namingConvention;
        /**
* Retrieves the value of the namingConvention attribute.
* @return namingConvention
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "NAMINGCONVENTION_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMENAMING_FK")

        public gov.nih.nci.calims2.domain.administration.NamingConvention getNamingConvention() {
        return namingConvention;
        }
   
        /**
* Sets the value of namingConvention attribute.
* @param namingConvention .
**/
        public void setNamingConvention(gov.nih.nci.calims2.domain.administration.NamingConvention namingConvention) {
        this.namingConvention = namingConvention;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Worksheet object.
**/
        private gov.nih.nci.calims2.domain.inventory.Worksheet worksheet;
        /**
* Retrieves the value of the worksheet attribute.
* @return worksheet
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "WORKSHEET_FK")
@org.hibernate.annotations.ForeignKey(name = "DOCUMEWORKSH_FK")

        public gov.nih.nci.calims2.domain.inventory.Worksheet getWorksheet() {
        return worksheet;
        }
   
        /**
* Sets the value of worksheet attribute.
* @param worksheet .
**/
        public void setWorksheet(gov.nih.nci.calims2.domain.inventory.Worksheet worksheet) {
        this.worksheet = worksheet;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.workflow.DigitalSignature object.
**/
        private gov.nih.nci.calims2.domain.workflow.DigitalSignature digitalSignature;
        /**
* Retrieves the value of the digitalSignature attribute.
* @return digitalSignature
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "DIGITALSIGNATURE_FK")
@org.hibernate.annotations.ForeignKey(name = "IMAGEFILE_DIGITALSIGN_FK")

        public gov.nih.nci.calims2.domain.workflow.DigitalSignature getDigitalSignature() {
        return digitalSignature;
        }
   
        /**
* Sets the value of digitalSignature attribute.
* @param digitalSignature .
**/
        public void setDigitalSignature(gov.nih.nci.calims2.domain.workflow.DigitalSignature digitalSignature) {
        this.digitalSignature = digitalSignature;
        }

}