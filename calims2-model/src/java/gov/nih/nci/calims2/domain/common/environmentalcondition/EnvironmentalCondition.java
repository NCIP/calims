package gov.nih.nci.calims2.domain.common.environmentalcondition;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.common.Type;
import java.util.Collection;
import gov.nih.nci.calims2.domain.inventory.event.Event;

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

import gov.nih.nci.calims2.domain.common.visitor.EnvironmentalConditionVisitor;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="entitytype",     discriminatorType=DiscriminatorType.STRING, length=30)
@DiscriminatorValue("EnvironmentalCondition")

public class EnvironmentalCondition extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
   
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
@org.hibernate.annotations.ForeignKey(name = "ENVIROEVENT_FK")

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
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "ENVIROTYPE_FK")

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
   
        private Set<gov.nih.nci.calims2.domain.administration.Quantity> quantityCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Quantity>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="QUANTITY_ENVIRONMENTALCON",joinColumns=@JoinColumn(name="ID_QUANTITY_ENVIRONMENTAL"))
        @ForeignKey(name="FK_QUANTITY_ENVIRONMENTAL")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.administration.Quantity> getQuantityCollection() {
        return quantityCollection;
        }
        public void setQuantityCollection(Set<gov.nih.nci.calims2.domain.administration.Quantity> quantityCollection) {
             this.quantityCollection = quantityCollection;
        }

/** Accepts the EnvironmentalConditionVisitor.
 * @param environmentalConditionVisitor The EnvironmentalConditionVisitor to accept.
 **/ public void accept(EnvironmentalConditionVisitor environmentalConditionVisitor) {
       environmentalConditionVisitor.visitEnvironmentalCondition(this);
}






}
