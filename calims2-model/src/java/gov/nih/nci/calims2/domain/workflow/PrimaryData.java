/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.workflow;
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
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;



import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "PRIMARYDATA")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_PRIMARYDATA_DATA")

public class PrimaryData extends Data {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
    
        /**
* An associated gov.nih.nci.calims2.domain.workflow.ProcessedData object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.workflow.ProcessedData> processDataCollection = new HashSet<gov.nih.nci.calims2.domain.workflow.ProcessedData>();
        /**
* Retrieves the value of the processDataCollection attribute.
* @return processDataCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "PRIMARYDATA_FK")
@org.hibernate.annotations.ForeignKey(name = "PROCESPRIMAR_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.workflow.ProcessedData> getProcessDataCollection() {
        return processDataCollection;
        }

        /**
* Sets the value of processDataCollection attribute.
* @param processDataCollection .
**/
        public void setProcessDataCollection(Set<gov.nih.nci.calims2.domain.workflow.ProcessedData> processDataCollection) {
        this.processDataCollection = processDataCollection;
        }
    






}
