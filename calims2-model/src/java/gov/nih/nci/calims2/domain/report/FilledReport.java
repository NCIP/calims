/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.report;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "FILLEDREPORT")

public class FilledReport extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String executedBy;
  /**
* Retrieves the value of the executedBy attribute.
* @return executedBy
**/
  
  @Column(name = "EXECUTEDBY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getExecutedBy() {
  return executedBy;
  }
  /**
* Sets the value of executedBy attribute.
* @param executedBy .
**/
  public void setExecutedBy(String 
  executedBy) {
  this.executedBy = executedBy;
  }
  /**
* 
**/
  private DateTime executionTime;
  /**
* Retrieves the value of the executionTime attribute.
* @return executionTime
**/
  
  @Column(name = "EXECUTIONTIME")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getExecutionTime() {
  return executionTime;
  }
  /**
* Sets the value of executionTime attribute.
* @param executionTime .
**/
  public void setExecutionTime(org.joda.time.DateTime 
  executionTime) {
  this.executionTime = executionTime;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.report.Report object.
**/
        private gov.nih.nci.calims2.domain.report.Report report;
        /**
* Retrieves the value of the report attribute.
* @return report
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "REPORT_FK")
@org.hibernate.annotations.ForeignKey(name = "FILLEDREPORT_FK")

        public gov.nih.nci.calims2.domain.report.Report getReport() {
        return report;
        }
   
        /**
* Sets the value of report attribute.
* @param report .
**/
        public void setReport(gov.nih.nci.calims2.domain.report.Report report) {
        this.report = report;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.
**/
        private gov.nih.nci.calims2.domain.common.Document document;
        /**
* Retrieves the value of the document attribute.
* @return document
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "DOCUMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "FILLEDREPORT_DOCUMENT_FK")

        public gov.nih.nci.calims2.domain.common.Document getDocument() {
        return document;
        }
   
        /**
* Sets the value of document attribute.
* @param document .
**/
        public void setDocument(gov.nih.nci.calims2.domain.common.Document document) {
        this.document = document;
        }






}
