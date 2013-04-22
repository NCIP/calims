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

import java.util.HashSet;

import org.springframework.beans.BeanUtils;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName;
import gov.nih.nci.calims2.domain.inventory.Antibody;
import gov.nih.nci.calims2.domain.inventory.ArtificialSpecimen;
import gov.nih.nci.calims2.domain.inventory.BioSpecimen;
import gov.nih.nci.calims2.domain.inventory.Carbohydrate;
import gov.nih.nci.calims2.domain.inventory.CellSpecimen;
import gov.nih.nci.calims2.domain.inventory.Container;
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
 * @author viseem
 * 
 */
public class SpecimenAliquotFactory implements SpecimenVisitor {

  private static final String[] EXCLUDED_PROPERTIES = new String[] {"id", "dateCreated", "createdBy", "dateModified", "modifiedBy",
      "container", "externalIdentifierCollection", "notesCollection", "parentSpecimen", "quantityCollection", "receivedDateTime", "documentCollection" };

  private Container container;
  private Specimen result;

  private void createSpecimen(Class<? extends Specimen> clazz, Specimen original) {
    if (result == null) {
      try {
        result = clazz.newInstance();
        BeanUtils.copyProperties(original, result, EXCLUDED_PROPERTIES);
      } catch (InstantiationException e) {
        throw new InternalError("Can not happen. Specimen have a default constructor that do nothing");
      } catch (IllegalAccessException e) {
        throw new InternalError("Can not happen. Specimen default constructor is public");
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  public void visitAntibody(Antibody antibody) {
    createSpecimen(Antibody.class, antibody);
    visitProtein(antibody);
  }

  /**
   * {@inheritDoc}
   */
  public void visitArtificialSpecimen(ArtificialSpecimen artificialSpecimen) {
    createSpecimen(ArtificialSpecimen.class, artificialSpecimen);
    visitSpecimen(artificialSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitBioSpecimen(BioSpecimen bioSpecimen) {
    createSpecimen(BioSpecimen.class, bioSpecimen);
    visitSpecimen(bioSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCarbohydrate(Carbohydrate carbohydrate) {
    createSpecimen(Carbohydrate.class, carbohydrate);
    visitMolecularSpecimen(carbohydrate);
  }

  /**
   * {@inheritDoc}
   */
  public void visitCellSpecimen(CellSpecimen cellSpecimen) {
    createSpecimen(CellSpecimen.class, cellSpecimen);
    visitBioSpecimen(cellSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitFluidSpecimen(FluidSpecimen fluidSpecimen) {
    createSpecimen(FluidSpecimen.class, fluidSpecimen);
    visitBioSpecimen(fluidSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitLipid(Lipid lipid) {
    createSpecimen(Lipid.class, lipid);
    visitMolecularSpecimen(lipid);
  }

  /**
   * {@inheritDoc}
   */
  public void visitMolecularSpecimen(MolecularSpecimen molecularSpecimen) {
    createSpecimen(MolecularSpecimen.class, molecularSpecimen);
    visitBioSpecimen(molecularSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitNanomaterial(Nanomaterial nanomaterial) {
    createSpecimen(Nanomaterial.class, nanomaterial);
    visitArtificialSpecimen(nanomaterial);
  }

  /**
   * {@inheritDoc}
   */
  public void visitNucleicAcid(NucleicAcid acid) {
    createSpecimen(NucleicAcid.class, acid);
    visitMolecularSpecimen(acid);
  }

  /**
   * {@inheritDoc}
   */
  public void visitPCRProduct(PCRProduct pCRProduct) {
    createSpecimen(PCRProduct.class, pCRProduct);
    visitNucleicAcid(pCRProduct);
  }

  /**
   * {@inheritDoc}
   */
  public void visitPrimer(Primer primer) {
    createSpecimen(Primer.class, primer);
    visitNucleicAcid(primer);
  }

  /**
   * {@inheritDoc}
   */
  public void visitProtein(Protein protein) {
    createSpecimen(Protein.class, protein);
    visitMolecularSpecimen(protein);
  }

  /**
   * {@inheritDoc}
   */
  public void visitSmallMolecule(SmallMolecule smallMolecule) {
    createSpecimen(SmallMolecule.class, smallMolecule);
    visitMolecularSpecimen(smallMolecule);
  }

  /**
   * {@inheritDoc}
   */
  public void visitSpecimen(Specimen specimen) {
    createSpecimen(Specimen.class, specimen);
    result.setContainer(container);
    result.setParentSpecimen(specimen);
    result.setOrganizationCollection(new HashSet<Organization>(result.getOrganizationCollection()));
    result.setSamplingLocationCollection(new HashSet<Location>(result.getSamplingLocationCollection()));
  }

  /**
   * {@inheritDoc}
   */
  public void visitTissueSpecimen(TissueSpecimen tissueSpecimen) {
    createSpecimen(TissueSpecimen.class, tissueSpecimen);
    visitBioSpecimen(tissueSpecimen);
  }

  /**
   * {@inheritDoc}
   */
  public void visitWholeOrganism(WholeOrganism wholeOrganism) {
    createSpecimen(WholeOrganism.class, wholeOrganism);
    visitBioSpecimen(wholeOrganism);
    WholeOrganism copy = (WholeOrganism) result;
    copy.setAdditionalOrganismNameCollection(new HashSet<AdditionalOrganismName>(copy.getAdditionalOrganismNameCollection()));
  }

  /**
   * Creates an aliquot of the given source specimen in the given container.
   * 
   * @param <T> The type of specimen
   * @param source The source specimen
   * @param container The container to associate to the new specimen
   * @return The newly created specimen
   */
  @SuppressWarnings("unchecked")
  public static <T extends Specimen> T createAliquot(T source, Container container) {
    SpecimenAliquotFactory factory = new SpecimenAliquotFactory();
    factory.container = container;
    source.accept(factory);
    return (T) factory.result;
  }

}
