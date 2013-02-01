package gov.nih.nci.calims2.domain.inventory.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.inventory.enumeration.SpecimenType;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class SpecimenTypeBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{SpecimenType.FLUIDSPECIMEN.name(), "Fluid Specimen"},
{SpecimenType.PROTEIN.name(), "Protein"},
{SpecimenType.LIPID.name(), "Lipid"},
{SpecimenType.WHOLEORGANISM.name(), "Whole Organism"},
{SpecimenType.PCRPRODUCT.name(), "PCR Product"},
{SpecimenType.SMALLMOLECULE.name(), "Small Molecule"},
{SpecimenType.TISSUESPECIMEN.name(), "Tissue Specimen"},
{SpecimenType.PRIMER.name(), "Primer"},
{SpecimenType.NUCLEICACID.name(), "Nucleic Acid"},
{SpecimenType.NANOMATERIAL.name(), "Nanomaterial"},
{SpecimenType.CELLSPECIMEN.name(), "Cell Specimen"},
{SpecimenType.ANTIBODY.name(), "Antibody"},
{SpecimenType.CARBOHYDRATE.name(), "Carbohydrate"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
