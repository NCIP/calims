package gov.nih.nci.calims2.domain.workflow;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "FINDING")

public class Finding extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String content;
  /**
* Retrieves the value of the content attribute.
* @return content
**/
  
  @Column(name = "CONTENT", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getContent() {
  return content;
  }
  /**
* Sets the value of content attribute.
* @param content .
**/
  public void setContent(String 
  content) {
  this.content = content;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.workflow.enumeration.FindingStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.workflow.enumeration.FindingStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.workflow.enumeration.FindingStatus 
  status) {
  this.status = status;
  }

        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "FINDING_TYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.workflow.ProcessedData object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.workflow.ProcessedData> processedDataCollection = new HashSet<gov.nih.nci.calims2.domain.workflow.ProcessedData>();
        /**
* Retrieves the value of the processedDataCollection attribute.
* @return processedDataCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "ProcessedData_Finding",
joinColumns = @JoinColumn(name = "FINDING_ID"),
inverseJoinColumns = @JoinColumn(name = "PROCESSEDDATA_ID"))
@org.hibernate.annotations.ForeignKey(name = "FINDING_PROCESSEDDAT_ID", inverseName = "PROCESSEDDAT_FINDING_ID")
        
       
        public Set<gov.nih.nci.calims2.domain.workflow.ProcessedData> getProcessedDataCollection() {
        return processedDataCollection;
        }
    
        /**
* Sets the value of processedDataCollection attribute.
* @param processedDataCollection .
**/
        public void setProcessedDataCollection(Set<gov.nih.nci.calims2.domain.workflow.ProcessedData> processedDataCollection) {
        this.processedDataCollection = processedDataCollection;
        }
    
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_FINDING",joinColumns=@JoinColumn(name="ID_NOTES_FINDING"))
        @ForeignKey(name="FK_NOTES_FINDING")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

    
        /**
* An associated gov.nih.nci.calims2.domain.workflow.Approval object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.workflow.Approval> approvalCollection = new HashSet<gov.nih.nci.calims2.domain.workflow.Approval>();
        /**
* Retrieves the value of the approvalCollection attribute.
* @return approvalCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "finding")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.workflow.Approval> getApprovalCollection() {
        return approvalCollection;
        }

        /**
* Sets the value of approvalCollection attribute.
* @param approvalCollection .
**/
        public void setApprovalCollection(Set<gov.nih.nci.calims2.domain.workflow.Approval> approvalCollection) {
        this.approvalCollection = approvalCollection;
        }
    






}
