package gov.nih.nci.calims2.domain.workflow;

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
@Table(name = "EXPERIMENT")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_EXPERIMENT_METHOD")

public class Experiment extends Method {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private org.joda.time.DateTime startDate;
  /**
* Retrieves the value of the startDate attribute.
* @return startDate
**/
  
  @Column(name = "STARTDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getStartDate() {
  return startDate;
  }
  /**
* Sets the value of startDate attribute.
* @param startDate .
**/
  public void setStartDate(org.joda.time.DateTime 
  startDate) {
  this.startDate = startDate;
  }
  /**
* 
**/
  private org.joda.time.DateTime stopDate;
  /**
* Retrieves the value of the stopDate attribute.
* @return stopDate
**/
  
  @Column(name = "STOPDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getStopDate() {
  return stopDate;
  }
  /**
* Sets the value of stopDate attribute.
* @param stopDate .
**/
  public void setStopDate(org.joda.time.DateTime 
  stopDate) {
  this.stopDate = stopDate;
  }
  /**
* 
**/
  private String title;
  /**
* Retrieves the value of the title attribute.
* @return title
**/
  
  @Column(name = "TITLE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getTitle() {
  return title;
  }
  /**
* Sets the value of title attribute.
* @param title .
**/
  public void setTitle(String 
  title) {
  this.title = title;
  }






}
