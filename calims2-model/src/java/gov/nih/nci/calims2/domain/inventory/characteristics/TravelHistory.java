package gov.nih.nci.calims2.domain.inventory.characteristics;
import gov.nih.nci.calims2.domain.administration.Location;
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

import gov.nih.nci.calims2.domain.inventory.visitor.CharacteristicsVisitor;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@DiscriminatorValue("TravelHistory")

public class TravelHistory extends BioCharacteristics {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Location object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Location> locationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Location>();
        /**
* Retrieves the value of the locationCollection attribute.
* @return locationCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "TRAVELHISTORY_FK")
@org.hibernate.annotations.ForeignKey(name = "LOCATITRAVEL_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Location> getLocationCollection() {
        return locationCollection;
        }

        /**
* Sets the value of locationCollection attribute.
* @param locationCollection .
**/
        public void setLocationCollection(Set<gov.nih.nci.calims2.domain.administration.Location> locationCollection) {
        this.locationCollection = locationCollection;
        }
    




/** Accepts the CharacteristicsVisitor.
 * @param characteristicsVisitor The characteristicsVisitor to accept.
 **/ public void accept(CharacteristicsVisitor characteristicsVisitor) {
       characteristicsVisitor.visitTravelHistory(this);
}


}
