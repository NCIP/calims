/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.l10n;

import java.util.ListResourceBundle;

import gov.nih.nci.calims2.ui.inventory.characteristics.CharacteristicsType;

/**
 * @author viseem
 *
 */
public class CharacteristicsTypeBundle extends ListResourceBundle {

  private static final Object[][] CONTENTS = {
    {CharacteristicsType.AGE.name(), "Age"},
    {CharacteristicsType.ANIMAL_BIRTH_WEIGHT.name(), "Animal Birth Weight"},
    {CharacteristicsType.APGAR_SCORE.name(), "APGAR Score"},
    {CharacteristicsType.BEHAVIORAL.name(), "Behavioral Characteristics"},
    {CharacteristicsType.BIRTH_DATE.name(), "Birth Date"},
    {CharacteristicsType.BODY_REGION.name(), "Body Region"},
    {CharacteristicsType.BREEDING_STATUS.name(), "Breeding Status"},
    {CharacteristicsType.COAT_COLOR.name(), "Coat Color"},
    {CharacteristicsType.DEVELOPMENTAL_STAGE.name(), "Developmental Stage"},
    {CharacteristicsType.DIAGNOSIS.name(), "Diagnosis"},
    {CharacteristicsType.DISEASE_STAGE.name(), "Disease Stage"},
    {CharacteristicsType.DISEASE_STATE.name(), "Disease State"},
    {CharacteristicsType.ETHNIC_GROUP.name(), "Ethnic Group"},
    {CharacteristicsType.FAMILY_HISTORY.name(), "Family History"},
    {CharacteristicsType.GENDER.name(), "Gender"},
    {CharacteristicsType.GENERATION.name(), "Generation"},
    {CharacteristicsType.HEARING_DISORDER.name(), "Hearing Disorder"},
    {CharacteristicsType.HEARING_TEST_RESULT.name(), "Hearing Test Result"},
    {CharacteristicsType.HISTOLOGICAL_GRADE.name(), "Histological Grade"},
    {CharacteristicsType.LIFE_STATUS.name(), "Life Status"},
    {CharacteristicsType.METASTASIS.name(), "Metastasis"},
    {CharacteristicsType.NEONATAL_HEARING_IMPAIRMENT.name(), "Neonatal Hearing Impairment"},
    {CharacteristicsType.NUTRITIONAL_REQUIREMENT.name(), "Nutritional Requirement"},
    {CharacteristicsType.PATHOLOGY_STATUS.name(), "Pathology Status"},
    {CharacteristicsType.PRESERVATION.name(), "Preservation"},
    {CharacteristicsType.RACE.name(), "Race"},
    {CharacteristicsType.SEX.name(), "Sex"},
    {CharacteristicsType.TISSUE_SIDE.name(), "Tissue Side"},
    {CharacteristicsType.TISSUE_SITE.name(), "Tissue Site"},
    {CharacteristicsType.TRAVEL_HISTORY.name(), "Travel History"},
    {CharacteristicsType.TREATMENT.name(), "Treatment"},
    {CharacteristicsType.TUMOR_GRADE.name(), "Tumor Grade"},
    {CharacteristicsType.TUMOR_SIZE.name(), "Tumor Size"},
    {CharacteristicsType.TUMOR_STAGE.name(), "Tumor Stage"},
    {CharacteristicsType.CHEMICAL.name(), "Chemical"},
    {CharacteristicsType.PHYSICAL.name(), "Physical"}
  };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }

}
