/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.report;
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
* NCI|A shortened version of a speech or written text, containing only the main points.
**/

@Entity
@Table(name = "SUMMARY")

public class Summary extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|A line of text serving to indicate what the passage below it is about.; NCI|A brief description given
* for purposes of identification; an identifying or descriptive marker that is attached to an object.;.
**/
  private String headerLabelList;
  /**
* Retrieves the value of the headerLabelList attribute.
* @return headerLabelList
**/
  
  @Column(name = "HEADERLABELLIST", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getHeaderLabelList() {
  return headerLabelList;
  }
  /**
* Sets the value of headerLabelList attribute.
* @param headerLabelList .
**/
  public void setHeaderLabelList(String 
  headerLabelList) {
  this.headerLabelList = headerLabelList;
  }
  /**
* NCI|The largest possible quantity or degree.;NCI|An arrangement of objects one under another in a line.;NCI|To
* determine the number or amount of something; the result of this activity.
**/
  private Long maximumColumnCount;
  /**
* Retrieves the value of the maximumColumnCount attribute.
* @return maximumColumnCount
**/
  
  @Column(name = "MAXIMUMCOLUMNCOUNT", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getMaximumColumnCount() {
  return maximumColumnCount;
  }
  /**
* Sets the value of maximumColumnCount attribute.
* @param maximumColumnCount .
**/
  public void setMaximumColumnCount(Long 
  maximumColumnCount) {
  this.maximumColumnCount = maximumColumnCount;
  }
  /**
* NCI|The largest possible quantity or degree.;NCI|An arrangement of objects side by side in a line.;NCI|To
* determine the number or amount of something; the result of this activity.
**/
  private Long maximumRowCount;
  /**
* Retrieves the value of the maximumRowCount attribute.
* @return maximumRowCount
**/
  
  @Column(name = "MAXIMUMROWCOUNT", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getMaximumRowCount() {
  return maximumRowCount;
  }
  /**
* Sets the value of maximumRowCount attribute.
* @param maximumRowCount .
**/
  public void setMaximumRowCount(Long 
  maximumRowCount) {
  this.maximumRowCount = maximumRowCount;
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
@org.hibernate.annotations.ForeignKey(name = "SUMMARTYPE_FK")

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
   

        /**
* An associated gov.nih.nci.calims2.domain.report.Query object.
**/
        private gov.nih.nci.calims2.domain.report.Query query;
        /**
* Retrieves the value of the query attribute.
* @return query
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "QUERY_FK")
@org.hibernate.annotations.ForeignKey(name = "SUMMARY_QUERY_FK")

        public gov.nih.nci.calims2.domain.report.Query getQuery() {
        return query;
        }
   
        /**
* Sets the value of query attribute.
* @param query .
**/
        public void setQuery(gov.nih.nci.calims2.domain.report.Query query) {
        this.query = query;
        }






}
