/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.characteristics;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import gov.nih.nci.calims2.domain.inventory.characteristics.APGARScore;
import gov.nih.nci.calims2.domain.inventory.characteristics.Age;
import gov.nih.nci.calims2.domain.inventory.characteristics.AnimalBirthWeight;
import gov.nih.nci.calims2.domain.inventory.characteristics.BehavioralCharacteristics;
import gov.nih.nci.calims2.domain.inventory.characteristics.BirthDate;
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
import gov.nih.nci.calims2.domain.inventory.characteristics.Race;
import gov.nih.nci.calims2.domain.inventory.characteristics.Sex;
import gov.nih.nci.calims2.domain.inventory.characteristics.TissueSide;
import gov.nih.nci.calims2.domain.inventory.characteristics.TissueSite;
import gov.nih.nci.calims2.domain.inventory.characteristics.TravelHistory;
import gov.nih.nci.calims2.domain.inventory.characteristics.Treatment;
import gov.nih.nci.calims2.domain.inventory.characteristics.TumorGrade;
import gov.nih.nci.calims2.domain.inventory.characteristics.TumorSize;
import gov.nih.nci.calims2.domain.inventory.characteristics.TumorStage;
import gov.nih.nci.calims2.ui.inventory.l10n.CharacteristicsTypeBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 * 
 */
public enum CharacteristicsType implements I18nEnumeration {
  /** Age. */
  AGE(CharacteristicsCategory.BIO, Age.class),

  /** AnimalBirthWeight. */
  ANIMAL_BIRTH_WEIGHT(CharacteristicsCategory.BIO, AnimalBirthWeight.class),

  /** Age. */
  APGAR_SCORE(CharacteristicsCategory.BIO, APGARScore.class),

  /** APGARScore. */
  BEHAVIORAL(CharacteristicsCategory.BIO, BehavioralCharacteristics.class),

  /** BehavioralCharacteristics. */
  BIRTH_DATE(CharacteristicsCategory.BIO, BirthDate.class),

  /** BodyRegion. */
  BODY_REGION(CharacteristicsCategory.BIO, BodyRegion.class),

  /** BreedingStatus. */
  BREEDING_STATUS(CharacteristicsCategory.BIO, BreedingStatus.class),

  /** CoatColor. */
  COAT_COLOR(CharacteristicsCategory.BIO, CoatColor.class),

  /** DevelopmentalStage. */
  DEVELOPMENTAL_STAGE(CharacteristicsCategory.BIO, DevelopmentalStage.class),

  /** Diagnosis. */
  DIAGNOSIS(CharacteristicsCategory.BIO, Diagnosis.class),

  /** DiseaseStage. */
  DISEASE_STAGE(CharacteristicsCategory.BIO, DiseaseStage.class),

  /** DiseaseState. */
  DISEASE_STATE(CharacteristicsCategory.BIO, DiseaseState.class),

  /** EthnicGroup. */
  ETHNIC_GROUP(CharacteristicsCategory.BIO, EthnicGroup.class),

  /** FamilyHistory. */
  FAMILY_HISTORY(CharacteristicsCategory.BIO, FamilyHistory.class),

  /** Gender. */
  GENDER(CharacteristicsCategory.BIO, Gender.class),

  /** Generation. */
  GENERATION(CharacteristicsCategory.BIO, Generation.class),

  /** HearingDisorder. */
  HEARING_DISORDER(CharacteristicsCategory.BIO, HearingDisorder.class),

  /** HearingTestResult. */
  HEARING_TEST_RESULT(CharacteristicsCategory.BIO, HearingTestResult.class),

  /** HistologicalGrade. */
  HISTOLOGICAL_GRADE(CharacteristicsCategory.BIO, HistologicalGrade.class),

  /** LifeStatus. */
  LIFE_STATUS(CharacteristicsCategory.BIO, LifeStatus.class),

  /** Metastasis. */
  METASTASIS(CharacteristicsCategory.BIO, Metastasis.class),

  /** NeonatalHearingImpairment. */
  NEONATAL_HEARING_IMPAIRMENT(CharacteristicsCategory.BIO, NeonatalHearingImpairment.class),

  /** NutritionalRequirement. */
  NUTRITIONAL_REQUIREMENT(CharacteristicsCategory.BIO, NutritionalRequirement.class),

  /** PathologyStatus. */
  PATHOLOGY_STATUS(CharacteristicsCategory.BIO, PathologyStatus.class),

  /** Preservation. */
  PRESERVATION(CharacteristicsCategory.BIO, Preservation.class),

  /** Race. */
  RACE(CharacteristicsCategory.BIO, Race.class),

  /** Sex. */
  SEX(CharacteristicsCategory.BIO, Sex.class),

  /** TissueSide. */
  TISSUE_SIDE(CharacteristicsCategory.BIO, TissueSide.class),

  /** TissueSite. */
  TISSUE_SITE(CharacteristicsCategory.BIO, TissueSite.class),

  /** TravelHistory. */
  TRAVEL_HISTORY(CharacteristicsCategory.BIO, TravelHistory.class),

  /** Treatment. */
  TREATMENT(CharacteristicsCategory.BIO, Treatment.class),

  /** TumorGrade. */
  TUMOR_GRADE(CharacteristicsCategory.BIO, TumorGrade.class),

  /** TumorSize. */
  TUMOR_SIZE(CharacteristicsCategory.BIO, TumorSize.class),

  /** TumorStage. */
  TUMOR_STAGE(CharacteristicsCategory.BIO, TumorStage.class),

  /** ChemicalCharacteristics. */
  CHEMICAL(CharacteristicsCategory.BIO, ChemicalCharacteristics.class),

  /** PhysicalCharacteristics. */
  PHYSICAL(CharacteristicsCategory.BIO, PhysicalCharacteristics.class);

  private CharacteristicsCategory category;
  private Class<? extends Characteristics> clazz;

  /**
   * Constructor.
   * 
   * @param category The category of this charateristics
   * @param clazz The domain class
   */
  private CharacteristicsType(CharacteristicsCategory category, Class<? extends Characteristics> clazz) {
    this.category = category;
    this.clazz = clazz;
  }

  /**
   * @return the category
   */
  public CharacteristicsCategory getCategory() {
    return category;
  }

  /**
   * @return the clazz
   */
  public Class<? extends Characteristics> getClazz() {
    return clazz;
  }

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(CharacteristicsTypeBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }

  /**
   * Gets the collection of characteristic types of the given category ordered according to the locale.
   * 
   * @param category The category to look for.
   * @param locale The locale to use for sorting.
   * @return the collection of characteristic types of the given category ordered according to the locale.
   */
  public static List<CharacteristicsType> getByCategory(CharacteristicsCategory category, Locale locale) {
    List<CharacteristicsType> types = new ArrayList<CharacteristicsType>();
    for (CharacteristicsType type : CharacteristicsType.values()) {
      if (type.getCategory() == category) {
        types.add(type);
      }
    }
    return I18nEnumerationHelper.sortByLocalizedValues(types, locale);
  }
}
