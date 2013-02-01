package gov.nih.nci.calims2.domain.administration;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.ElectronicDocument;
import gov.nih.nci.calims2.domain.common.FileExtension;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.common.Type;

import org.joda.time.DateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.AttributeOverrides;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AssociationOverride;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import gov.nih.nci.calims2.domain.interfaces.EntityWithExternalId;
import java.util.ArrayList;
import java.io.Serializable;



import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "FILEFORMATSPECIFICATION")

public class FileFormatSpecification extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
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
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person contactPerson;
        /**
* Retrieves the value of the contactPerson attribute.
* @return contactPerson
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "FILEFORMATS_PERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getContactPerson() {
        return contactPerson;
        }
   
        /**
* Sets the value of contactPerson attribute.
* @param contactPerson .
**/
        public void setContactPerson(gov.nih.nci.calims2.domain.administration.Person contactPerson) {
        this.contactPerson = contactPerson;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.FileTransporter object.
**/
        private gov.nih.nci.calims2.domain.administration.FileTransporter fileTransporter;
        /**
* Retrieves the value of the fileTransporter attribute.
* @return fileTransporter
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FILETRANSPORTER_FK")
@org.hibernate.annotations.ForeignKey(name = "FILEFOFILETR_FK")

        public gov.nih.nci.calims2.domain.administration.FileTransporter getFileTransporter() {
        return fileTransporter;
        }
   
        /**
* Sets the value of fileTransporter attribute.
* @param fileTransporter .
**/
        public void setFileTransporter(gov.nih.nci.calims2.domain.administration.FileTransporter fileTransporter) {
        this.fileTransporter = fileTransporter;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.common.FileExtension object.
**/
        private gov.nih.nci.calims2.domain.common.FileExtension fileExtension;
        /**
* Retrieves the value of the fileExtension attribute.
* @return fileExtension
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FILEEXTENSION_FK")
@org.hibernate.annotations.ForeignKey(name = "FILEFORMATS_FILEEXTENSI_FK")

        public gov.nih.nci.calims2.domain.common.FileExtension getFileExtension() {
        return fileExtension;
        }
   
        /**
* Sets the value of fileExtension attribute.
* @param fileExtension .
**/
        public void setFileExtension(gov.nih.nci.calims2.domain.common.FileExtension fileExtension) {
        this.fileExtension = fileExtension;
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
@org.hibernate.annotations.ForeignKey(name = "FILEFOTYPE_FK")

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
