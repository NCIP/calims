/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.specimen;

import java.util.Collection;

import javax.validation.ConstraintViolation;

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
import gov.nih.nci.calims2.domain.inventory.visitor.SpecimenVisitor;

/**
 * @author connollym
 * 
 */

public class SpecimenHierarchyValidator implements SpecimenVisitor {

  @SuppressWarnings("unused")
  private Collection<ConstraintViolation<Specimen>> violations;

  /**
   * {@inheritDoc}
   */
  public void visitAntibody(Antibody antibody) {
    visitProtein(antibody);
  }

  /**
   * {@inheritDoc}
   */
  public void visitArtificialSpecimen(ArtificialSpecimen artificialSpecimen) {
    visitSpecimen(artificialSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitBioSpecimen(BioSpecimen bioSpecimen) {
    visitSpecimen(bioSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCarbohydrate(Carbohydrate carbohydrate) {
    visitMolecularSpecimen(carbohydrate);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCellSpecimen(CellSpecimen cellSpecimen) {
    visitBioSpecimen(cellSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitFluidSpecimen(FluidSpecimen fluidSpecimen) {
    visitBioSpecimen(fluidSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitLipid(Lipid lipid) {
    visitBioSpecimen(lipid);
  }

  /**
   * {@inheritDoc}
   */
  public void visitMolecularSpecimen(MolecularSpecimen molecularSpecimen) {
    visitBioSpecimen(molecularSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitNanomaterial(Nanomaterial nanomaterial) {
    visitArtificialSpecimen(nanomaterial);
  }

  /**
   * {@inheritDoc}
   */
  public void visitNucleicAcid(NucleicAcid acid) {
    visitMolecularSpecimen(acid);
  }

  /**
   * {@inheritDoc}
   */
  public void visitPCRProduct(PCRProduct pCRProduct) {
    visitNucleicAcid(pCRProduct);
  }

  /**
   * {@inheritDoc}
   */
  public void visitPrimer(Primer primer) {
    visitNucleicAcid(primer);
  }

  /**
   * {@inheritDoc}
   */
  public void visitProtein(Protein protein) {
    visitMolecularSpecimen(protein);
  }

  /**
   * {@inheritDoc}
   */
  public void visitSmallMolecule(SmallMolecule smallMolecule) {
    visitMolecularSpecimen(smallMolecule);
  }

  /**
   * {@inheritDoc}
   */
  public void visitSpecimen(Specimen specimen) {
    // nothing to do here
  }

  /**
   * {@inheritDoc}
   */
  public void visitTissueSpecimen(TissueSpecimen tissueSpecimen) {
    visitBioSpecimen(tissueSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitWholeOrganism(WholeOrganism wholeOrganism) {
    visitBioSpecimen(wholeOrganism);
  }

  /**
   * The violations to be set.
   * 
   * @param violations the violations to be set.
   */
  public void setViolations(Collection<ConstraintViolation<Specimen>> violations) {
    this.violations = violations;
  }

}
