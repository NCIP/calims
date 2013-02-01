package gov.nih.nci.calims2.domain.report;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.SimpleEntity;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;
/**
* 
**/

@Entity
@Table(name = "CLAUSE")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_CLAUSE_SIMPLEENTITY")

public class Clause extends SimpleEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Integer clauseIndex;
  /**
* Retrieves the value of the clauseIndex attribute.
* @return clauseIndex
**/
  
  @Column(name = "CLAUSEINDEX", length = EntityWithId.COLUMNLENGTH)
  
  
  public Integer getClauseIndex() {
  return clauseIndex;
  }
  /**
* Sets the value of clauseIndex attribute.
* @param clauseIndex .
**/
  public void setClauseIndex(Integer 
  clauseIndex) {
  this.clauseIndex = clauseIndex;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.report.Query object.
**/
        private gov.nih.nci.calims2.domain.report.Query query;
        /**
* Retrieves the value of the query attribute.
* @return query
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "QUERY_FK")
@org.hibernate.annotations.ForeignKey(name = "CLAUSEQUERY_FK")

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
   


/** Accepts the ClauseVisitor.
 * @param clauseVisitor The clauseVisitor to accept.
 **/ public void accept(ClauseVisitor clauseVisitor) {
       clauseVisitor.visitClause(this);
}




}
