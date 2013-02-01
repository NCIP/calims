/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.nih.nci.calims2.ui.report.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import gov.nih.nci.calims2.domain.administration.Adapter;
import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Equipment;
import gov.nih.nci.calims2.domain.administration.EquipmentIOType;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.PostalAddress;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.Software;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.StorageDevice;
import gov.nih.nci.calims2.domain.administration.StorageSpace;
import gov.nih.nci.calims2.domain.administration.TelephoneNumber;
import gov.nih.nci.calims2.domain.administration.Unit;
import gov.nih.nci.calims2.domain.administration.Word;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation;
import gov.nih.nci.calims2.domain.administration.customerservice.Contract;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Invoice;
import gov.nih.nci.calims2.domain.administration.customerservice.Quotation;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName;
import gov.nih.nci.calims2.domain.inventory.Antibody;
import gov.nih.nci.calims2.domain.inventory.Antigen;
import gov.nih.nci.calims2.domain.inventory.ArtificialSpecimen;
import gov.nih.nci.calims2.domain.inventory.BioSpecimen;
import gov.nih.nci.calims2.domain.inventory.Biohazard;
import gov.nih.nci.calims2.domain.inventory.Carbohydrate;
import gov.nih.nci.calims2.domain.inventory.CellSpecimen;
import gov.nih.nci.calims2.domain.inventory.ChemicalCompound;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.Feature;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.domain.inventory.FluidSpecimen;
import gov.nih.nci.calims2.domain.inventory.Hazard;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.Lipid;
import gov.nih.nci.calims2.domain.inventory.MolecularSpecimen;
import gov.nih.nci.calims2.domain.inventory.Nanomaterial;
import gov.nih.nci.calims2.domain.inventory.NucleicAcid;
import gov.nih.nci.calims2.domain.inventory.PCRProduct;
import gov.nih.nci.calims2.domain.inventory.Primer;
import gov.nih.nci.calims2.domain.inventory.Protein;
import gov.nih.nci.calims2.domain.inventory.Sequence;
import gov.nih.nci.calims2.domain.inventory.SmallMolecule;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.Strain;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.domain.inventory.TissueSpecimen;
import gov.nih.nci.calims2.domain.inventory.WholeOrganism;
import gov.nih.nci.calims2.domain.inventory.Worksheet;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Report;
import gov.nih.nci.calims2.ui.report.l10n.QueriedEntityBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 *
 */
public enum QueriedEntity implements I18nEnumeration {
  /** Adapter. */
  ADAPTER(Adapter.class),
  
  /** BaseUnit. */
  BASE_UNIT(BaseUnit.class),
  
  /** Collaboration. */
  COLLABORATION(Collaboration.class),
  
  /** ContactInformation. */
  CONTACT_INFORMATION(ContactInformation.class),
  
  /** ContainerSubcategory. */
  CONTAINER_SUBCATEGORY(ContainerSubcategory.class),
  
  /** Equipment. */
  EQUIPMENT(Equipment.class),
  
  /** EquipmentIOType. */
  EQUIPMENTIOTYPE(EquipmentIOType.class),
  
  /** Laboratory. */
  LABORATORY(Laboratory.class),
  
  /** Location. */
  LOCATION(Location.class),
  
  /** NamingConvention. */
  NAMING_CONVENTION(NamingConvention.class),
  
  /** Organization. */
  ORGANIZATION(Organization.class),
  
  /** Person. */
  PERSON(Person.class),
  
  /** PostalAddress. */
  POSTAL_ADDRESS(PostalAddress.class),
  
  /** Role. */
  ROLE(Role.class),
  
  /** Software. */
  SOFTWARE(Software.class),
  
  /** StandardUnit. */
  STANDARD_UNIT(StandardUnit.class),
  
  /** StorageDevice. */
  STORAGE_DEVICE(StorageDevice.class),
  
  /** StorageSpace. */
  STORAGE_SPACE(StorageSpace.class),
  
  /** TelephoneNumber. */
  TELEPHONE_NUMBER(TelephoneNumber.class),
  
  /** Unit. */
  UNIT(Unit.class),
  
  /** Word. */
  WORD(Word.class),
  
  /** Account. */
  ACCOUNT(Account.class),
  
  /** AccountNumber. */
  ACCOUNT_NUMBER(AccountNumber.class),
  
  /** BillingInformation. */
  BILLING_INFORMATION(BillingInformation.class),
  
  /** Contract. */
  CONTRACT(Contract.class),
  
  /** CustomerRequest. */
  CUSTOMER_REQUEST(CustomerRequest.class),
  
  /** Invoice. */
  INVOICE(Invoice.class),
  
  /** Quotation. */
  QUOTATION(Quotation.class),
  
  /** Rate. */
  RATE(Rate.class),
  
  /** Service. */
  SERVICE(Service.class),
  
  /** ServiceItem. */
  SERVICE_ITEM(ServiceItem.class),
  
  /** Document. */
  DOCUMENT(Document.class),
  
  /** Type. */
  TYPE(Type.class),
  
  /** AdditionalOrganismName. */
  ADDITIONAL_ORGANISM_NAME(AdditionalOrganismName.class),
  
  /** Antibody. */
  ANTYBODY(Antibody.class),
  
  /** Antigen. */
  ANTIGEN(Antigen.class),
  
  /** ArtificialSpecimen. */
  ARTIFICIAL_SPECIMEN(ArtificialSpecimen.class),
  
  /** Biohazard. */
  BIO_HAZARD(Biohazard.class),
  
  /** BioSpecimen. */
  BIO_SPECIMEN(BioSpecimen.class),
  
  /** Carbohydrate. */
  CARBOHYDRATE(Carbohydrate.class),
  
  /** CellSpecimen. */
  CELL_SPECIMEN(CellSpecimen.class),
  
  /** ChemicalCompound. */
  CHEMICAL_COMPOUND(ChemicalCompound.class),
  
  /** Container. */
  CONTAINER(Container.class),
  
  /** Feature. */
  FEATURE(Feature.class),
  
  /** FillPattern. */
  FILL_PATTERN(FillPattern.class),
  
  /** FluidSpecimen. */
  FLUID_SPECIMEN(FluidSpecimen.class),
  
  /** Hazard. */
  HAZARD(Hazard.class),
  
  /** LabSupply. */
  LAB_SUPPLY(LabSupply.class),
  
  /** Layout. */
  LAYOUT(Layout.class),
  
  /** Lipid. */
  LIPID(Lipid.class),
  
  /** MolecularSpecimen. */
  MOLECULAR_SPECIMEN(MolecularSpecimen.class),
  
  /** Nanomaterial. */
  NANO_MATERIAL(Nanomaterial.class),
  
  /** NucleicAcid. */
  NUCLEIC_ACID(NucleicAcid.class),
  
  /** PCRProduct. */
  PCR_PRODUCT(PCRProduct.class),
  
  /** Primer. */
  PRIMER(Primer.class),
  
  /** Protein. */
  PROTEIN(Protein.class),
  
  /** Sequence. */
  SEQUENCE(Sequence.class),
  
  /** SmallMolecule. */
  SMALL_MOLECULE(SmallMolecule.class),
  
  /** Specimen. */
  SPECIMEN(Specimen.class),
  
  /** Strain. */
  STRAIN(Strain.class),
  
  /** Taxon. */
  TAXON(Taxon.class),
  
  /** TissueSpecimen. */
  TISSUE_SPECIMEN(TissueSpecimen.class),
  
  /** WholeOrganism. */
  WHOLE_ORGANISM(WholeOrganism.class),
  
  /** Worksheet. */
  WORK_SHEET(Worksheet.class),
  
  /** Query. */
  QUERY(Query.class),
  
  /** Report. */
  REPORT(Report.class);
  
  private DomainPackage domainPackage;
  private Class<?> persistentClass;
  
  /**
   * Gets the list of queried entities in the given domain package.
   * @param domainPackage The domain package
   * @return the list of queried entities in the given domain package.
   */
  public static List<QueriedEntity> getByDomainPackage(DomainPackage domainPackage) {
    List<QueriedEntity> entities = new ArrayList<QueriedEntity>();
    for (QueriedEntity queriedEntity : QueriedEntity.values()) {
      if (queriedEntity.getDomainPackage() == domainPackage) {
        entities.add(queriedEntity);
      }
    }
    return entities;
  }
  
  /**
   * Gets the queriedEntity by its persistent class name.
   * @param persistentClassName The persistent class name
   * @return the queriedEntity with the given persistent class name
   */
  public static QueriedEntity getByPersistentClass(String persistentClassName) {
    for (QueriedEntity queriedEntity : QueriedEntity.values()) {
      if (queriedEntity.getPersistentClass().getName().equals(persistentClassName)) {
        return queriedEntity;
      }
    }
    return null;
  }
  
  private QueriedEntity(Class<?> persistentClass) {
    this.persistentClass = persistentClass;
    String packageName = persistentClass.getPackage().getName();
    for (DomainPackage dp : DomainPackage.values()) {
      if (packageName.equals(dp.getPackageName())) {
        domainPackage = dp;
        break;
      }
    }
  }
  
  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(QueriedEntityBundle.class, locale, this);
  }
  
  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }

  /**
   * @return the domainPackage
   */
  public DomainPackage getDomainPackage() {
    return domainPackage;
  }

  /**
   * @return the persistentClass
   */
  public Class<?> getPersistentClass() {
    return persistentClass;
  }
  

}
