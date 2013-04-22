/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.common.I10n;

import java.util.ListResourceBundle;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;

/**
 * @author connollym
 *
 */
public class TypeEnumerationBundle extends ListResourceBundle {
  private static final Object[][] CONTENTS = {
    {TypeEnumeration.ACCOUNT.name(), "Account"},
    {TypeEnumeration.ACCOUNTNUMBER.name(), "Account Number"},
    {TypeEnumeration.ADAPTER.name(), "Adapter"},
    {TypeEnumeration.ADDITIONLORGANISMNAME.name(), "Additional Organism Name"},
    {TypeEnumeration.ANTIBODY.name(), "Antibody"},
    {TypeEnumeration.ANTIGEN.name(), "Antigen"},
    {TypeEnumeration.BILLINGINFORMATION.name(), "Billing Information"},
    {TypeEnumeration.CARBOHYDRATE.name(), "Carbohydrate"},
    {TypeEnumeration.CELLSPECIMEN.name(), "Cell Specimen"},
    {TypeEnumeration.CHARACTERISTICS.name(), "Characteristics"},
    {TypeEnumeration.COLLABORATION.name(), "Collaboration"},
    {TypeEnumeration.CONTACTINFORMATION.name(), "Contact Information"},
    {TypeEnumeration.CONTAINER.name(), "Container"},
    {TypeEnumeration.CONTAINER_QUANTITY.name(), "Container Quantity"},
    {TypeEnumeration.CONTRACT.name(), "Contract"},
    {TypeEnumeration.CUSTOMERREQUEST.name(), "Customer Request"},
    {TypeEnumeration.ENVIRONMENTLCONDITION.name(), "Environmental Condition"},
    {TypeEnumeration.EQUIPMENT.name(), "Equipment"},
    {TypeEnumeration.EVENT.name(), "Event"},
    {TypeEnumeration.EXTERNALIDENTIFIER.name(), "External Identifier"},
    {TypeEnumeration.EXPERIMENT.name(), "Experiment"},
    {TypeEnumeration.FEATURE.name(), "Feature"},
    {TypeEnumeration.FILEEXTENSION.name(), "File Extension"},
    {TypeEnumeration.FILEFORMATSPECIFICATION.name(), "File Format Specification"},
    {TypeEnumeration.FLUIDSPECIMEN.name(), "Fluid Specimen"},
    {TypeEnumeration.HAZARD.name(), "Hazard"},
    {TypeEnumeration.INQUIRY.name(), "Inquiry"},
    {TypeEnumeration.INVOICE.name(), "Invoice"},
    {TypeEnumeration.LABSUPPLY.name(), "Lab Supply"},
    {TypeEnumeration.LABSUPPLY_QUANTITY.name(), "Lab Supply Quantity"},
    {TypeEnumeration.LIPID.name(), "Lipid"},
    {TypeEnumeration.LOCATION.name(), "Location"},
    {TypeEnumeration.NAMINGCONVENTION.name(), "Naming Convention"},
    {TypeEnumeration.NANOMATERIAL.name(), "Nanomaterial"},
    {TypeEnumeration.NUCLEICACID.name(), "Nucleic Acid"},
    {TypeEnumeration.ORGANIZATION.name(), "Organization"},
    {TypeEnumeration.PARAMETER.name(), "Parameter"},
    {TypeEnumeration.PCRPRODUCT.name(), "PCR Product"},
    {TypeEnumeration.POSTALADDRESS.name(), "Postal Address"},
    {TypeEnumeration.PRIMER.name(), "Primer"},
    {TypeEnumeration.PROJECT.name(), "Project"},
    {TypeEnumeration.PROTEIN.name(), "Protein"},
    {TypeEnumeration.QUANTITY.name(), "Quantity"},
    {TypeEnumeration.QUERY.name(), "Query"},
    {TypeEnumeration.QUOTATION.name(), "Quotation"},
    {TypeEnumeration.QUOTATION_QUANTITY.name(), "Quotation Quantity"},
    {TypeEnumeration.RATE.name(), "Rate"},
    {TypeEnumeration.RATE_QUANTITY.name(), "Rate Quantity"},
    {TypeEnumeration.SERVICE.name(), "Service"},
    {TypeEnumeration.SERVICEITEM.name(), "Service Item"},
    {TypeEnumeration.SERVICEITEM_QUANTITY.name(), "Service Item Quantity"},
    {TypeEnumeration.SMALLMOLECULE.name(), "Small Molecule"},
    {TypeEnumeration.SOFTWARE.name(), "Software"},
    {TypeEnumeration.SOP.name(), "SOP"},
    {TypeEnumeration.SPECIMEN_QUANTITY.name(), "Specimen Quantity"},
    {TypeEnumeration.STORAGEDEVICE.name(), "Storage Device"},
    {TypeEnumeration.STORAGESPACE.name(), "Storage Space"},
    {TypeEnumeration.STRAIN.name(), "Strain"},
    {TypeEnumeration.SUMMARY.name(), "Summary"},
    {TypeEnumeration.TELEPHONENUMBER.name(), "Telephone Number"},
    {TypeEnumeration.TISSUESPECIMEN.name(), "Tissue Specimen"},
    {TypeEnumeration.UNIT.name(), "Unit"},
    {TypeEnumeration.WHOLEORGANISM.name(), "Whole Organism"}
    };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
