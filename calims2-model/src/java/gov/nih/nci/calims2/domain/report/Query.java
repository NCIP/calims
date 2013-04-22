/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.report;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.common.Type;
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
* NCI|A sentence of inquiry that asks for a reply; a request for information (e.g., a formal request to
* a database or search engine).
**/

@Entity
@Table(name = "QUERY")

public class Query extends DisplayableEntity {
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
* An associated gov.nih.nci.calims2.domain.report.Clause object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.report.Clause> clauseCollection = new HashSet<gov.nih.nci.calims2.domain.report.Clause>();
        /**
* Retrieves the value of the clauseCollection attribute.
* @return clauseCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "query")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.report.Clause> getClauseCollection() {
        return clauseCollection;
        }

        /**
* Sets the value of clauseCollection attribute.
* @param clauseCollection .
**/
        public void setClauseCollection(Set<gov.nih.nci.calims2.domain.report.Clause> clauseCollection) {
        this.clauseCollection = clauseCollection;
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
@org.hibernate.annotations.ForeignKey(name = "QUERYCTYPE_FK")

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
