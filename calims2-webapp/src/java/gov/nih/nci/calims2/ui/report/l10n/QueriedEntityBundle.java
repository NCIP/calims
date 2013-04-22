/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.l10n;

import java.util.ListResourceBundle;

import gov.nih.nci.calims2.ui.report.query.QueriedEntity;

/**
 * @author viseem
 *
 */
public class QueriedEntityBundle extends ListResourceBundle {

  private static final Object[][] CONTENTS = {
    {QueriedEntity.ADAPTER.name(), "Adapter"},
    {QueriedEntity.BASE_UNIT.name(), "Base Unit"},
    {QueriedEntity.COLLABORATION.name(), "Collaboration"},
    {QueriedEntity.CONTACT_INFORMATION.name(), "Contact Information"},
    {QueriedEntity.CONTAINER_SUBCATEGORY.name(), "Container Subcategory"},
    {QueriedEntity.EQUIPMENT.name(), "Equipment"},
    {QueriedEntity.EQUIPMENTIOTYPE.name(), "Equipment IO Type"},
    {QueriedEntity.LABORATORY.name(), "Laboratory"},
    {QueriedEntity.LOCATION.name(), "Location"},
    {QueriedEntity.NAMING_CONVENTION.name(), "Naming Convention"},
    {QueriedEntity.ORGANIZATION.name(), "Organization"},
    {QueriedEntity.PERSON.name(), "Person"},
    {QueriedEntity.POSTAL_ADDRESS.name(), "Postal Address"},
    {QueriedEntity.ROLE.name(), "Role"},
    {QueriedEntity.SOFTWARE.name(), "Software"},
    {QueriedEntity.STANDARD_UNIT.name(), "Standard Unit"},
    {QueriedEntity.STORAGE_DEVICE.name(), "Storage Device"},
    {QueriedEntity.STORAGE_SPACE.name(), "Storage Space"},
    {QueriedEntity.TELEPHONE_NUMBER.name(), "Telephone Number"},
    {QueriedEntity.UNIT.name(), "Unit"},
    {QueriedEntity.WORD.name(), "Word"},
    {QueriedEntity.ACCOUNT.name(), "Account"},
    {QueriedEntity.ACCOUNT_NUMBER.name(), "Account Number"},
    {QueriedEntity.BILLING_INFORMATION.name(), "Billing Information"},
    {QueriedEntity.CONTRACT.name(), "Contract"},
    {QueriedEntity.CUSTOMER_REQUEST.name(), "Customer Request"},
    {QueriedEntity.INVOICE.name(), "Invoice"},
    {QueriedEntity.QUOTATION.name(), "Quotation"},
    {QueriedEntity.RATE.name(), "Rate"},
    {QueriedEntity.SERVICE.name(), "Service"},
    {QueriedEntity.SERVICE_ITEM.name(), "Service Item"},
    {QueriedEntity.DOCUMENT.name(), "Document"},
    {QueriedEntity.TYPE.name(), "Type"},
    {QueriedEntity.ADDITIONAL_ORGANISM_NAME.name(), "Additional Organism Name"},
    {QueriedEntity.ANTYBODY.name(), "Antibody"},
    {QueriedEntity.ANTIGEN.name(), "Antigen"},
    {QueriedEntity.ARTIFICIAL_SPECIMEN.name(), "Artificial Specimen"},
    {QueriedEntity.BIO_HAZARD.name(), "Bio Hazard"},
    {QueriedEntity.BIO_SPECIMEN.name(), "Bio Specimen"},
    {QueriedEntity.CARBOHYDRATE.name(), "Carbohydrate"},
    {QueriedEntity.CELL_SPECIMEN.name(), "Cell Specimen"},
    {QueriedEntity.CHEMICAL_COMPOUND.name(), "Chemical Compound"},
    {QueriedEntity.CONTAINER.name(), "Container"},
    {QueriedEntity.FEATURE.name(), "Feature"},
    {QueriedEntity.FILL_PATTERN.name(), "Fill Pattern"},
    {QueriedEntity.FLUID_SPECIMEN.name(), "Fluid Specimen"},
    {QueriedEntity.HAZARD.name(), "Hazard"},
    {QueriedEntity.LAB_SUPPLY.name(), "Lab Supply"},
    {QueriedEntity.LAYOUT.name(), "Layout"},
    {QueriedEntity.LIPID.name(), "Lipid"},
    {QueriedEntity.MOLECULAR_SPECIMEN.name(), "Molecular Specimen"},
    {QueriedEntity.NANO_MATERIAL.name(), "Nanomaterial"},
    {QueriedEntity.NUCLEIC_ACID.name(), "Nucleic Acid"},
    {QueriedEntity.PCR_PRODUCT.name(), "PCR Product"},
    {QueriedEntity.PRIMER.name(), "Primer"},
    {QueriedEntity.PROTEIN.name(), "Protein"},
    {QueriedEntity.SEQUENCE.name(), "Sequence"},
    {QueriedEntity.SMALL_MOLECULE.name(), "SmallMolecule"},
    {QueriedEntity.SPECIMEN.name(), "Specimen"},
    {QueriedEntity.STRAIN.name(), "Strain"},
    {QueriedEntity.TAXON.name(), "Taxon"},
    {QueriedEntity.TISSUE_SPECIMEN.name(), "Tissue Specimen"},
    {QueriedEntity.WHOLE_ORGANISM.name(), "Whole Organism"},
    {QueriedEntity.WORK_SHEET.name(), "Work Sheet"},
    {QueriedEntity.QUERY.name(), "Query"},
    {QueriedEntity.REPORT.name(), "Report"}
  };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }


}
