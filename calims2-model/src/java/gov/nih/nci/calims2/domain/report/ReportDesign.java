package gov.nih.nci.calims2.domain.report;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;

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
@Table(name = "REPORTDESIGN")

public class ReportDesign extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String mainEntity;
  /**
* Retrieves the value of the mainEntity attribute.
* @return mainEntity
**/
  
  @Column(name = "MAINENTITY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getMainEntity() {
  return mainEntity;
  }
  /**
* Sets the value of mainEntity attribute.
* @param mainEntity .
**/
  public void setMainEntity(String 
  mainEntity) {
  this.mainEntity = mainEntity;
  }

        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.
**/
        private gov.nih.nci.calims2.domain.common.Document document;
        /**
* Retrieves the value of the document attribute.
* @return document
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "DOCUMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "REPORTDESIGN_DOCUMENT_FK")

        public gov.nih.nci.calims2.domain.common.Document getDocument() {
        return document;
        }
   
        /**
* Sets the value of document attribute.
* @param document .
**/
        public void setDocument(gov.nih.nci.calims2.domain.common.Document document) {
        this.document = document;
        }






}
