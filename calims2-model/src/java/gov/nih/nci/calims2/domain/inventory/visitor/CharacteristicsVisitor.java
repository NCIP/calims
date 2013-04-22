/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.inventory.visitor;

import gov.nih.nci.calims2.domain.inventory.characteristics.APGARScore;
import gov.nih.nci.calims2.domain.inventory.characteristics.Age;
import gov.nih.nci.calims2.domain.inventory.characteristics.AnimalBirthWeight;
import gov.nih.nci.calims2.domain.inventory.characteristics.BehavioralCharacteristics;
import gov.nih.nci.calims2.domain.inventory.characteristics.BioCharacteristics;
import gov.nih.nci.calims2.domain.inventory.characteristics.BirthDate;
import gov.nih.nci.calims2.domain.inventory.characteristics.BirthWeight;
import gov.nih.nci.calims2.domain.inventory.characteristics.BodyRegion;
import gov.nih.nci.calims2.domain.inventory.characteristics.BreedingStatus;
import gov.nih.nci.calims2.domain.inventory.characteristics.Characteristics;
import gov.nih.nci.calims2.domain.inventory.characteristics.ChemicalCharacteristics;
import gov.nih.nci.calims2.domain.inventory.characteristics.CoatColor;
import gov.nih.nci.calims2.domain.inventory.characteristics.DevelopmentalStage;
import gov.nih.nci.calims2.domain.inventory.characteristics.Diagnosis;
import gov.nih.nci.calims2.domain.inventory.characteristics.DiseaseStage;
import gov.nih.nci.calims2.domain.inventory.characteristics.DiseaseState;
import gov.nih.nci.calims2.domain.inventory.characteristics.EthnicGroup;
import gov.nih.nci.calims2.domain.inventory.characteristics.FamilyHistory;
import gov.nih.nci.calims2.domain.inventory.characteristics.Gender;
import gov.nih.nci.calims2.domain.inventory.characteristics.Generation;
import gov.nih.nci.calims2.domain.inventory.characteristics.HearingDisorder;
import gov.nih.nci.calims2.domain.inventory.characteristics.HearingTestResult;
import gov.nih.nci.calims2.domain.inventory.characteristics.HistologicalGrade;
import gov.nih.nci.calims2.domain.inventory.characteristics.LifeStatus;
import gov.nih.nci.calims2.domain.inventory.characteristics.Metastasis;
import gov.nih.nci.calims2.domain.inventory.characteristics.NeonatalHearingImpairment;
import gov.nih.nci.calims2.domain.inventory.characteristics.NutritionalRequirement;
import gov.nih.nci.calims2.domain.inventory.characteristics.PathologyStatus;
import gov.nih.nci.calims2.domain.inventory.characteristics.PhysicalCharacteristics;
import gov.nih.nci.calims2.domain.inventory.characteristics.Preservation;
import gov.nih.nci.calims2.domain.inventory.characteristics.QuantitativeBiocharacteristics;
import gov.nih.nci.calims2.domain.inventory.characteristics.Race;
import gov.nih.nci.calims2.domain.inventory.characteristics.Sex;
import gov.nih.nci.calims2.domain.inventory.characteristics.TissueSide;
import gov.nih.nci.calims2.domain.inventory.characteristics.TissueSite;
import gov.nih.nci.calims2.domain.inventory.characteristics.TravelHistory;
import gov.nih.nci.calims2.domain.inventory.characteristics.Treatment;
import gov.nih.nci.calims2.domain.inventory.characteristics.TumorGrade;
import gov.nih.nci.calims2.domain.inventory.characteristics.TumorSize;
import gov.nih.nci.calims2.domain.inventory.characteristics.TumorStage;

/**
 * @author connollym
 *
 */
public interface CharacteristicsVisitor {

  /**
   * @param age
   */
  void visitAge(Age age);

  /**
   * @param animalBirthWeight
   */
  void visitAnimalBirthWeight(AnimalBirthWeight animalBirthWeight);

  /**
   * @param apgarScore
   */
  void visitAPGARScore(APGARScore apgarScore);


  /**
   * @param behavioralCharacteristics
   */
  void visitBehavioralCharacteristics(BehavioralCharacteristics behavioralCharacteristics);

  /**
   * @param bioCharacteristics
   */
  void visitBioCharacteristics(BioCharacteristics bioCharacteristics);

  /**
   * @param birthDate
   */
  void visitBirthDate(BirthDate birthDate);

  /**
   * @param birthWeight
   */
  void visitBirthWeight(BirthWeight birthWeight);

  /**
   * @param bodyRegion
   */
  void visitBodyRegion(BodyRegion bodyRegion);

  /**
   * @param breedingStatus
   */
  void visitBreedingStatus(BreedingStatus breedingStatus);

  /**
   * @param characteristics
   */
  void visitCharacteristics(Characteristics characteristics);

  /**
   * @param chemicalCharacteristics
   */
  void visitChemicalCharacteristics(ChemicalCharacteristics chemicalCharacteristics);

  /**
   * @param coatColor
   */
  void visitCoatColor(CoatColor coatColor);

  /**
   * @param developmentalStage
   */
  void visitDevelopmentalStage(DevelopmentalStage developmentalStage);

  /**
   * @param diagnosis
   */
  void visitDiagnosis(Diagnosis diagnosis);

  /**
   * @param diseaseStage
   */
  void visitDiseaseStage(DiseaseStage diseaseStage);

  /**
   * @param diseaseState
   */
  void visitDiseaseState(DiseaseState diseaseState);

  /**
   * @param ethnicGroup
   */
  void visitEthnicGroup(EthnicGroup ethnicGroup);

  /**
   * @param familyHistory
   */
  void visitFamilyHistory(FamilyHistory familyHistory);

  /**
   * @param gender
   */
  void visitGender(Gender gender);

  /**
   * @param generation
   */
  void visitGeneration(Generation generation);

  /**
   * @param hearingDisorder
   */
  void visitHearingDisorder(HearingDisorder hearingDisorder);

  /**
   * @param hearingTestResult
   */
  void visitHearingTestResult(HearingTestResult hearingTestResult);

  /**
   * @param histologicalGrade
   */
  void visitHistologicalGrade(HistologicalGrade histologicalGrade);

  /**
   * @param lifeStatus
   */
  void visitLifeStatus(LifeStatus lifeStatus);

  /**
   * @param metastasis
   */
  void visitMetastasis(Metastasis metastasis);

  /**
   * @param neonatalHearingImpairment
   */
  void visitNeonatalHearingImpairment(NeonatalHearingImpairment neonatalHearingImpairment);

  /**
   * @param nutritionalRequirement
   */
  void visitNutritionalRequirement(NutritionalRequirement nutritionalRequirement);
  
  /**
   * @param quantitativeCharacteristics
   */
  void visitQuantitativeBiocharacteristics(QuantitativeBiocharacteristics quantitativeCharacteristics);


  /**
   * @param pathologyStatus
   */
  void visitPathologyStatus(PathologyStatus pathologyStatus);

  /**
   * @param physicalCharacteristics
   */
  void visitPhysicalCharacteristics(PhysicalCharacteristics physicalCharacteristics);

  /**
   * @param preservation
   */
  void visitPreservation(Preservation preservation);

  /**
   * @param race
   */
  void visitRace(Race race);

  /**
   * @param sex
   */
  void visitSex(Sex sex);

  /**
   * @param tissueSide
   */
  void visitTissueSide(TissueSide tissueSide);

  /**
   * @param tissueSite
   */
  void visitTissueSite(TissueSite tissueSite);

  /**
   * @param travelHistory
   */
  void visitTravelHistory(TravelHistory travelHistory);

  /**
   * @param treatment
   */
  void visitTreatment(Treatment treatment);

  /**
   * @param tumorGrade
   */
  void visitTumorGrade(TumorGrade tumorGrade);

  /**
   * @param tumorSize
   */
  void visitTumorSize(TumorSize tumorSize);

  /**
   * @param tumorStage
   */
  void visitTumorStage(TumorStage tumorStage);
}
