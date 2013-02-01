package gov.nih.nci.calims2.domain.report;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;
/**
* 
**/

@Entity
@Table(name = "NEGATION")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_NEGATION_CLAUSE")

public class Negation extends Clause {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;

        /**
* An associated gov.nih.nci.calims2.domain.report.Clause object.
**/
        private gov.nih.nci.calims2.domain.report.Clause clause;
        /**
* Retrieves the value of the clause attribute.
* @return clause
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CLAUSE_FK")
@org.hibernate.annotations.ForeignKey(name = "NEGATION_CLAUSE_FK")

        public gov.nih.nci.calims2.domain.report.Clause getClause() {
        return clause;
        }
   
        /**
* Sets the value of clause attribute.
* @param clause .
**/
        public void setClause(gov.nih.nci.calims2.domain.report.Clause clause) {
        this.clause = clause;
        }


/** Accepts the ClauseVisitor.
 * @param clauseVisitor The clauseVisitor to accept.
 **/ public void accept(ClauseVisitor clauseVisitor) {
       clauseVisitor.visitNegation(this);
}




}
