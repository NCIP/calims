package gov.nih.nci.calims2.domain.inventory;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.common.SOP;

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
* A fill-in-the-blank document that can contain formulas so that if one cell value is changed, the entire
* document is automatically updated, based on those formulas.
**/

@Entity
@Table(name = "WORKSHEET")

public class Worksheet extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;

        /**
* An associated gov.nih.nci.calims2.domain.common.SOP object.
**/
        private gov.nih.nci.calims2.domain.common.SOP SOP;
        /**
* Retrieves the value of the SOP attribute.
* @return SOP
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SOP_FK")
@org.hibernate.annotations.ForeignKey(name = "WORKSHEET_SOP_FK")

        public gov.nih.nci.calims2.domain.common.SOP getSOP() {
        return SOP;
        }
   
        /**
* Sets the value of SOP attribute.
* @param SOP .
**/
        public void setSOP(gov.nih.nci.calims2.domain.common.SOP SOP) {
        this.SOP = SOP;
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
@org.hibernate.annotations.ForeignKey(name = "WORKSHLABSUP_FK")

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
   






}
