/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.account;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountStatus;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class AccountControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    AccountController controller = new AccountController();
    CRUDAssert.assertControllerConstructor(controller, AccountController.URL_PREFIX,
        "administration.customerservice.account.", "name", Account.class, AccountForm.class,
        CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    AccountController controller = new AccountController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    GenericServiceMockup<Document> documentService = new GenericServiceMockup<Document>();
    controller.setDocumentService(documentService);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    GenericServiceMockup<Laboratory> laboratoryService = new GenericServiceMockup<Laboratory>();
    
    controller.setTypeService(typeService);
    controller.setOrganizationService(organizationService);
    controller.setLaboratoryService(laboratoryService);
    
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);

    CRUDAssert.assertTypes(typeService, TypeEnumeration.ACCOUNT, "types", result);
    CRUDAssert.assertFindAll(laboratoryService, Laboratory.class, "name", "laboratories", result);
    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "organizations", result);
    CRUDAssert.assertFindAll(documentService, Document.class, "name", "documents", result);
    CRUDAssert.assertEnumerationCollection(result, "accountStatuses", AccountStatus.class);
    //CRUDAssert.assertFindAll(externalIdentifierService, ExternalIdentifier.class, "name", "externalIdentifiers", result);
  }
  
}
