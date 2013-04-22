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

import gov.nih.nci.calims2.domain.inventory.Antibody;
import gov.nih.nci.calims2.domain.inventory.ArtificialSpecimen;
import gov.nih.nci.calims2.domain.inventory.BioSpecimen;
import gov.nih.nci.calims2.domain.inventory.Carbohydrate;
import gov.nih.nci.calims2.domain.inventory.CellSpecimen;
import gov.nih.nci.calims2.domain.inventory.FluidSpecimen;
import gov.nih.nci.calims2.domain.inventory.Lipid;
import gov.nih.nci.calims2.domain.inventory.MolecularSpecimen;
import gov.nih.nci.calims2.domain.inventory.Nanomaterial;
import gov.nih.nci.calims2.domain.inventory.NucleicAcid;
import gov.nih.nci.calims2.domain.inventory.PCRProduct;
import gov.nih.nci.calims2.domain.inventory.Primer;
import gov.nih.nci.calims2.domain.inventory.Protein;
import gov.nih.nci.calims2.domain.inventory.SmallMolecule;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.TissueSpecimen;
import gov.nih.nci.calims2.domain.inventory.WholeOrganism;

/**
 * @author connollym
 *
 */
public interface SpecimenVisitor {
  
  /**
   * Visits the bioSpecimen subclass.
   * @param bioSpecimen the bioSpecimen to visit.
   */
  void visitBioSpecimen(BioSpecimen bioSpecimen);
  /**
   * Visits the antibody subclass.
   * @param antibody the antibody to visit
   */
  void visitAntibody(Antibody antibody);
  /**
   * Visits the carbohydrate subclass.
   * @param carbohydrate the carbohydrate to visit
   */
  void visitCarbohydrate(Carbohydrate carbohydrate);
  /**
   * Visits the cellSpecimen subclass.
   * @param cellSpecimen the cellSpecimen to visit
   */
  void visitCellSpecimen(CellSpecimen cellSpecimen);
  /**
   * Visits the fluidSpeciment subclass.
   * @param fluidSpeciment the fluidSpeciment to visit
   */
  void visitFluidSpecimen(FluidSpecimen fluidSpeciment);
  /**
   * Visits the lipid subclass.
   * @param lipid the lipid to visit
   */
  void visitLipid(Lipid lipid);
  /**
   * Visits the molecularSpecimen subclass.
   * @param molecularSpecimen the molecularSpecimen to visit
   */
  void visitMolecularSpecimen(MolecularSpecimen molecularSpecimen);
  /**
   * Visits the nanomaterial subclass.
   * @param nanomaterial the nanomaterial to visit
   */
  void visitNanomaterial(Nanomaterial nanomaterial);
  /**
   * Visits the acid subclass.
   * @param acid the acid to visit
   */
  void visitNucleicAcid(NucleicAcid acid);
  /**
   * Visits the pCRProduct subclass.
   * @param pCRProduct the pCRProduct to visit
   */
  void visitPCRProduct(PCRProduct pCRProduct);
  /**
   * Visits the primer subclass.
   * @param primer the primer to visit
   */
  void visitPrimer(Primer primer);
  /**
   * Visits the protein subclass.
   * @param protein the protein to visit
   */
  void visitProtein(Protein protein);
  /**
   * Visits the smallMolecule subclass.
   * @param smallMolecule the smallMolecule to visit
   */
  void visitSmallMolecule(SmallMolecule smallMolecule);
  /**
   * Visits the specimen subclass.
   * @param specimen the specimen to visit
   */
  void visitSpecimen(Specimen specimen);
  /**
   * Visits the tissueSpecimen subclass.
   * @param tissueSpecimen the tissueSpecimen to visit
   */
  void visitTissueSpecimen(TissueSpecimen tissueSpecimen);
  /**
   * Visits the wholeOrganism subclass.
   * @param wholeOrganism the wholeOrganism to visit
   */
  void visitWholeOrganism(WholeOrganism wholeOrganism);
  /**
   * Visits the artificialSpecimen subclass.
   * @param artificialSpecimen the artificialSpecimen to visit
   */
  void visitArtificialSpecimen(ArtificialSpecimen artificialSpecimen);
  
  
}
