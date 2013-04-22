/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.report;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;
/**
* 
**/

@Entity
@Table(name = "CONJUNCTION")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_CONJUNCTION_CLAUSE")

public class Conjunction extends Clause {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
    
        /**
* An associated gov.nih.nci.calims2.domain.report.Clause object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.report.Clause> clauseCollection = new HashSet<gov.nih.nci.calims2.domain.report.Clause>();
        /**
* Retrieves the value of the clauseCollection attribute.
* @return clauseCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "CONJUNCTION_FK")
@org.hibernate.annotations.ForeignKey(name = "CLAUSECONJUN_FK")

        
       
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
    


/** Accepts the ClauseVisitor.
 * @param clauseVisitor The clauseVisitor to accept.
 **/ public void accept(ClauseVisitor clauseVisitor) {
       clauseVisitor.visitConjunction(this);
}




}
