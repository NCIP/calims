/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.common.type;

import java.util.Locale;

import gov.nih.nci.calims2.business.common.I10n.TypeEnumerationBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public enum TypeEnumeration implements I18nEnumeration {

  /**
   * Account type name.
   */
  ACCOUNT,
  /**
   * Account number type name.
   */
  ACCOUNTNUMBER,
  /**
   * Adapter type name.
   */
  ADAPTER,
  /**
   * AdditionalOrganismName type name.
   */
  ADDITIONLORGANISMNAME,
  
  /**
   * Antibody type name.
   */
  ANTIBODY,
  /**
   * Antigen type name.
   */
  
  ANTIGEN,
  /**
   * BillingInformation type name.
   */
  BILLINGINFORMATION,
  /**
   * Carbohydrate type name.
   */
  CARBOHYDRATE,
  /**
   * Cell Specimen type name.
   */
  CELLSPECIMEN,
  /**
   * Characteristics type name.
   */
  CHARACTERISTICS,
  /**
   * Collaboration type name.
   */
  COLLABORATION,
  /**
   * Contact Information type name.
   */
  CONTACTINFORMATION,
  /**
   * Container name.
   */
  CONTAINER,
  /**
   * Container_Quantity name.
   */
  CONTAINER_QUANTITY,
  /**
   * Contract name.
   */
  CONTRACT,
  /**
   * CustomerRequest type name.
   */
  CUSTOMERREQUEST,
  /**
   * EnvironmentalCondition type name.
   */
  ENVIRONMENTLCONDITION,
  /**
   * Equipment type name.
   */
  EQUIPMENT,
  /**
   * Event type name.
   */
  EVENT,
  /**
   * ExternalIdentifier type name.
   */
  EXTERNALIDENTIFIER,
  /**
   * Experiment type name.
   */
  EXPERIMENT,
  /**
   * Feature type name.
   */
  FEATURE,
  /**
   * FileExtension type name.
   */
  FILEEXTENSION,
  /**
   * FileFormatSpecification type name.
   */
  FILEFORMATSPECIFICATION,
  /**
   * FLUIDSPECIMEN type name.
   */
  FLUIDSPECIMEN,
  /**
   * Hazard type name.
   */
  HAZARD,
  /**
   * Inquiry type name.
   */
  INQUIRY,
  /**
   * Invoice type name.
   */
  INVOICE,
  /**
   * LabSupply type name.
   */
  LABSUPPLY,
  /**
   * LabSupply_Quantity name.
   */
  LABSUPPLY_QUANTITY,
  /**
   * Lipid type name.
   */
  LIPID,
  /**
   * Location type name.
   */
  
  LOCATION,
  /**
   * NamingConvention type name.
   */
  NAMINGCONVENTION,
  /**
   * Nanomaterial type name.
   */
  NANOMATERIAL,
  /**
   * NucleicAcid type name.
   */
  NUCLEICACID,
  /**
   * Organization type name.
   */
  ORGANIZATION,
  /**
   * Parameter type name.
   */
  PARAMETER,
  /**
   * PCRProduct type name.
   */
  PCRPRODUCT,
  /**
   * PostalAddress type name.
   */
  POSTALADDRESS,
  /**
   * Primer type name.
   */
  PRIMER,
  /**
   * Project type name.
   */
  PROJECT,
  /**
   * Protein type name.
   */
  PROTEIN,
  /**
   * Quotation quantity type name.
   */
  QUOTATION_QUANTITY,
  /**
   * Quantity type name.
   */
  QUANTITY,
  /**
   * Query type name.
   */
  QUERY,
  /**
   * Quotation type name.
   */
  QUOTATION,
  /**
   * Rate type name.
   */
  RATE,
  /**
   * RateItem_Quantity type name.
   */
  RATE_QUANTITY,
  /**
   * Service type name.
   */
  SERVICE,
  /**
   * ServiceItem type name.
   */
  SERVICEITEM,
  /**
   * ServiceItem_Quantity type name.
   */
  SERVICEITEM_QUANTITY,
  /**
   * Small Molecule type name.
   */
  SMALLMOLECULE,
  /**
   * Software type name.
   */
  SOFTWARE,
  /**
   * SOP type name.
   */
  SOP,
  /**
   * Specimen_Quantity type name.
   */
  SPECIMEN_QUANTITY,
  /**
   * StorageDevice type name.
   */
  STORAGEDEVICE,
  /**
   * StorageSpace type name.
   */
  STORAGESPACE,
  /**
   * Strain type name.
   */
  STRAIN,
  /**
   * Summary type name.
   */
  SUMMARY,
  /**
   * TelephoneNumber type name.
   */
  TELEPHONENUMBER,
  /**
   * TissueSpecimen type name.
   */
  TISSUESPECIMEN,
  /**
   * Unit type name.
   */
  UNIT,
  /**
   * Whole Organism type name.
   */
  WHOLEORGANISM;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(TypeEnumerationBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }

}
