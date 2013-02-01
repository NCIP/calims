package gov.nih.nci.calims2.domain.workflow;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/**
* 
**/

@Entity
@Table(name = "PROCESSEDDATA")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_PROCESSEDDATA_DATA")

public class ProcessedData extends Data {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
   
/**
* An associated gov.nih.nci.calims2.domain.workflow.ExperimentalResult object.
**/
        private gov.nih.nci.calims2.domain.workflow.ExperimentalResult experimentalResult;
        /**
* Retrieves the value of the experimentalResult attribute.
* @return experimentalResult
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "EXPERIMENTALRESULT_FK")
@org.hibernate.annotations.ForeignKey(name = "PROCESEXPERI_FK")

        public gov.nih.nci.calims2.domain.workflow.ExperimentalResult getExperimentalResult() {
        return experimentalResult;
        }
   
        /**
* Sets the value of experimentalResult attribute.
* @param experimentalResult .
**/
        public void setExperimentalResult(gov.nih.nci.calims2.domain.workflow.ExperimentalResult experimentalResult) {
        this.experimentalResult = experimentalResult;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.workflow.Finding object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.workflow.Finding> findingCollection = new HashSet<gov.nih.nci.calims2.domain.workflow.Finding>();
        /**
* Retrieves the value of the findingCollection attribute.
* @return findingCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "ProcessedData_Finding",
joinColumns = @JoinColumn(name = "PROCESSEDDATA_ID"),
inverseJoinColumns = @JoinColumn(name = "FINDING_ID"))
@org.hibernate.annotations.ForeignKey(name = "PROCESSEDDAT_FINDING_ID", inverseName = "FINDING_PROCESSEDDAT_ID")
        
       
        public Set<gov.nih.nci.calims2.domain.workflow.Finding> getFindingCollection() {
        return findingCollection;
        }
    
        /**
* Sets the value of findingCollection attribute.
* @param findingCollection .
**/
        public void setFindingCollection(Set<gov.nih.nci.calims2.domain.workflow.Finding> findingCollection) {
        this.findingCollection = findingCollection;
        }
    






}