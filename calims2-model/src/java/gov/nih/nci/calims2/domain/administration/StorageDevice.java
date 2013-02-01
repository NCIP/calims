package gov.nih.nci.calims2.domain.administration;
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
* NCI|A physical structure or device capable of holding objects or samples.
**/

@Entity
@Table(name = "STORAGEDEVICE")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_STORAGEDEVICE_EQUIPMENT")

public class StorageDevice extends Equipment {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.StorageSpace object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.StorageSpace> storageSpaceCollection = new HashSet<gov.nih.nci.calims2.domain.administration.StorageSpace>();
        /**
* Retrieves the value of the storageSpaceCollection attribute.
* @return storageSpaceCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "STORAGEDEVICE_FK")
@org.hibernate.annotations.ForeignKey(name = "STORAGSTORAG_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.StorageSpace> getStorageSpaceCollection() {
        return storageSpaceCollection;
        }

        /**
* Sets the value of storageSpaceCollection attribute.
* @param storageSpaceCollection .
**/
        public void setStorageSpaceCollection(Set<gov.nih.nci.calims2.domain.administration.StorageSpace> storageSpaceCollection) {
        this.storageSpaceCollection = storageSpaceCollection;
        }
    






}
