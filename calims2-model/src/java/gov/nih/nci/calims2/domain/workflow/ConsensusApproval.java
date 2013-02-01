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
@Table(name = "CONSENSUSAPPROVAL")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_CONSENSUSAPPROVAL_APPROVA")

public class ConsensusApproval extends Approval {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Long requiredPollCount;
  /**
* Retrieves the value of the requiredPollCount attribute.
* @return requiredPollCount
**/
  
  @Column(name = "REQUIREDPOLLCOUNT", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getRequiredPollCount() {
  return requiredPollCount;
  }
  /**
* Sets the value of requiredPollCount attribute.
* @param requiredPollCount .
**/
  public void setRequiredPollCount(Long 
  requiredPollCount) {
  this.requiredPollCount = requiredPollCount;
  }
  /**
* 
**/
  private Long requiredReviewerCount;
  /**
* Retrieves the value of the requiredReviewerCount attribute.
* @return requiredReviewerCount
**/
  
  @Column(name = "REQUIREDREVIEWERCOUNT", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getRequiredReviewerCount() {
  return requiredReviewerCount;
  }
  /**
* Sets the value of requiredReviewerCount attribute.
* @param requiredReviewerCount .
**/
  public void setRequiredReviewerCount(Long 
  requiredReviewerCount) {
  this.requiredReviewerCount = requiredReviewerCount;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.workflow.enumeration.ConsensusApprovalStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.workflow.enumeration.ConsensusApprovalStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.workflow.enumeration.ConsensusApprovalStatus 
  status) {
  this.status = status;
  }






}
