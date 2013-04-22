/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.inventory.enumeration;
import java.util.Locale;

import gov.nih.nci.calims2.domain.inventory.Antibody;
import gov.nih.nci.calims2.domain.inventory.Carbohydrate;
import gov.nih.nci.calims2.domain.inventory.CellSpecimen;
import gov.nih.nci.calims2.domain.inventory.FluidSpecimen;
import gov.nih.nci.calims2.domain.inventory.Lipid;
import gov.nih.nci.calims2.domain.inventory.Nanomaterial;
import gov.nih.nci.calims2.domain.inventory.NucleicAcid;
import gov.nih.nci.calims2.domain.inventory.PCRProduct;
import gov.nih.nci.calims2.domain.inventory.Primer;
import gov.nih.nci.calims2.domain.inventory.Protein;
import gov.nih.nci.calims2.domain.inventory.SmallMolecule;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.TissueSpecimen;
import gov.nih.nci.calims2.domain.inventory.WholeOrganism;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;



/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum SpecimenType  implements I18nEnumeration {



/**
* FLUIDSPECIMEN status name.
*/
FLUIDSPECIMEN (FluidSpecimen.class),
/**
* PROTEIN status name.
*/
PROTEIN (Protein.class),
/**
* LIPID status name.
*/
LIPID (Lipid.class),
/**
* WHOLEORGANISM status name.
*/
WHOLEORGANISM (WholeOrganism.class),
/**
* PCRPRODUCT status name.
*/
PCRPRODUCT (PCRProduct.class),
/**
* SMALLMOLECULE status name.
*/
SMALLMOLECULE (SmallMolecule.class),
/**
* TISSUESPECIMEN status name.
*/
TISSUESPECIMEN (TissueSpecimen.class),
/**
* PRIMER status name.
*/
PRIMER (Primer.class),
/**
* NUCLEICACID status name.
*/
NUCLEICACID (NucleicAcid.class),
/**
* NANOMATERIAL status name.
*/
NANOMATERIAL (Nanomaterial.class),
/**
* CELLSPECIMEN status name.
*/
CELLSPECIMEN (CellSpecimen.class),
/**
* ANTIBODY status name.
*/
ANTIBODY (Antibody.class),
/**
* CARBOHYDRATE status name.
*/
CARBOHYDRATE (Carbohydrate.class);

  private Class<? extends Specimen> specimenClass;
  private SpecimenType(Class<? extends Specimen> specimenClass) {
    this.specimenClass = specimenClass;
  }
  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.inventory.l10n.SpecimenTypeBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
  /**
   * @return the specimenClass
   */
  public Class<? extends Specimen> getSpecimenClass() {
    return specimenClass;
  }
}