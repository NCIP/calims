package gov.nih.nci.calims2.domain.inventory;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.administration.Person;
import java.util.Collection;

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
* NCI|Execute or satisfy a request or order; supply or furnish.; NCI|A distinctive style or form of something,
* the characteristic set of traits or actions or qualities of a group, person, or thing, as behavior
* patterns; in molecular biology: a nucleic acid or protein motif that is computationally detectable
* within aligned sequences.
**/

@Entity
@Table(name = "FILLPATTERN")

public class FillPattern extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Layout object.
**/
        private gov.nih.nci.calims2.domain.inventory.Layout layout;
        /**
* Retrieves the value of the layout attribute.
* @return layout
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LAYOUT_FK")
@org.hibernate.annotations.ForeignKey(name = "FILLPALAYOUT_FK")

        public gov.nih.nci.calims2.domain.inventory.Layout getLayout() {
        return layout;
        }
   
        /**
* Sets the value of layout attribute.
* @param layout .
**/
        public void setLayout(gov.nih.nci.calims2.domain.inventory.Layout layout) {
        this.layout = layout;
        }
   
        private List<gov.nih.nci.calims2.domain.inventory.Coordinate> coordinateCollection = new ArrayList<gov.nih.nci.calims2.domain.inventory.Coordinate>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="COORDINATE_FILLPATTERN",joinColumns=@JoinColumn(name="ID_COORDINATE_FILLPATTERN"))
        @ForeignKey(name="FK_COORDINATE_FILLPATTERN")
        @Fetch(FetchMode.SUBSELECT)
        public List<gov.nih.nci.calims2.domain.inventory.Coordinate> getCoordinateCollection() {
        return coordinateCollection;
        }
        public void setCoordinateCollection(List<gov.nih.nci.calims2.domain.inventory.Coordinate> coordinateCollection) {
             this.coordinateCollection = coordinateCollection;
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
@org.hibernate.annotations.ForeignKey(name = "FILLPATTERN_PERSON_FK")

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






}
