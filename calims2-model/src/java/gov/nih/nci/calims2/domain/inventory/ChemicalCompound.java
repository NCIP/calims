package gov.nih.nci.calims2.domain.inventory;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.inventory.characteristics.PhysicalCharacteristics;
import gov.nih.nci.calims2.domain.inventory.characteristics.ChemicalCharacteristics;

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
@Table(name = "CHEMICALCOMPOUND")

public class ChemicalCompound extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String chemicalFormula;
  /**
* Retrieves the value of the chemicalFormula attribute.
* @return chemicalFormula
**/
  
  @Column(name = "CHEMICALFORMULA", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getChemicalFormula() {
  return chemicalFormula;
  }
  /**
* Sets the value of chemicalFormula attribute.
* @param chemicalFormula .
**/
  public void setChemicalFormula(String 
  chemicalFormula) {
  this.chemicalFormula = chemicalFormula;
  }
  /**
* 
**/
  private DateTime expirationDate;
  /**
* Retrieves the value of the expirationDate attribute.
* @return expirationDate
**/
  
  @Column(name = "EXPIRATIONDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getExpirationDate() {
  return expirationDate;
  }
  /**
* Sets the value of expirationDate attribute.
* @param expirationDate .
**/
  public void setExpirationDate(DateTime 
  expirationDate) {
  this.expirationDate = expirationDate;
  }
  /**
* 
**/
  private String NDCCode;
  /**
* Retrieves the value of the NDCCode attribute.
* @return NDCCode
**/
  
  @Column(name = "NDCCODE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getNDCCode() {
  return NDCCode;
  }
  /**
* Sets the value of NDCCode attribute.
* @param NDCCode .
**/
  public void setNDCCode(String 
  NDCCode) {
  this.NDCCode = NDCCode;
  }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Nanomaterial object.
**/
        private gov.nih.nci.calims2.domain.inventory.Nanomaterial nanomaterial;
        /**
* Retrieves the value of the nanomaterial attribute.
* @return nanomaterial
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "NANOMATERIAL_FK")
@org.hibernate.annotations.ForeignKey(name = "CHEMICALCOM_NANOMATERIAL_FK")

        public gov.nih.nci.calims2.domain.inventory.Nanomaterial getNanomaterial() {
        return nanomaterial;
        }
   
        /**
* Sets the value of nanomaterial attribute.
* @param nanomaterial .
**/
        public void setNanomaterial(gov.nih.nci.calims2.domain.inventory.Nanomaterial nanomaterial) {
        this.nanomaterial = nanomaterial;
        }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Container object.
**/
        private gov.nih.nci.calims2.domain.inventory.Container container;
        /**
* Retrieves the value of the container attribute.
* @return container
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINER_FK")
@org.hibernate.annotations.ForeignKey(name = "CHEMCIALCOM_CONTAINER_FK")

        public gov.nih.nci.calims2.domain.inventory.Container getContainer() {
        return container;
        }
   
        /**
* Sets the value of container attribute.
* @param container .
**/
        public void setContainer(gov.nih.nci.calims2.domain.inventory.Container container) {
        this.container = container;
        }






}
