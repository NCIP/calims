/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Message.RecipientType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.email.EmailMessage;
import gov.nih.nci.calims2.business.email.EmailService;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.uic.select.Option;

/**
 * @author viseem
 *
 */
@Controller
@RequestMapping(MessageController.URL_PREFIX)
public class MessageController {
  
  private static Logger log = LoggerFactory.getLogger(MessageController.class);
  
  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/message";
  
  private GenericService<ContactInformation> contactInformationService;
  private EmailService emailService;
  
  /**
   * Go to the create message page.
   * @return The create message view.
   */
  @RequestMapping("/create.do")
  public ModelAndView create() {
    return createModel(new MessageForm());
  }
  
  /**
   * Creates the model for the create message page.
   * @param form The form containing the message data
   * @return The  model for the create message page.
   */
  public ModelAndView createModel(MessageForm form) {
    ModelAndView model = new ModelAndView();
    model.addObject("form", form);
    Map<String, Object> params = new HashMap<String, Object>();
    List<ContactInformation> contactInformations = contactInformationService.findByNamedQuery(ContactInformation.class.getName()
        + ".findPersonWithEmail", params);
    List<Option> options = new ArrayList<Option>();
    for (ContactInformation ci : contactInformations) {
      String label = ci.getPerson().getFamilyName() + " " + ci.getPerson().getGivenName() + " - " + ci.getEmailAddress();
      Option newOption = new Option(ci.getId().toString(), label);
      options.add(newOption);
    }
    model.addObject("to", options);
    model.setViewName("administration.message.create");
    return model;
  }
  
  /**
   * Sends the message.
   * @param form The form containing the message data
   * @return The next view.
   */
  @RequestMapping("/send.do")
  public ModelAndView send(@ModelAttribute("form")MessageForm form) {
    ModelAndView model = new ModelAndView();
    if (form.getContactInformationIds() == null || form.getContactInformationIds().length == 0) {
      form.setErrorKey("norecipient");
      return createModel(form);
    }
    form.setContactInformations(EntityWithIdHelper.createEntities(ContactInformation.class, form.getContactInformationIds()));
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("ids", form.getContactInformationIds());
    List<ContactInformation> contactInformations = contactInformationService.findByNamedQuery(ContactInformation.class.getName()
        + ".findByIds", params);
    EmailMessage message = new EmailMessage();
    message.setSubject(form.getSubject());
    message.setBody(form.getMessage());
    message.setFrom("moxieinbox@moxieinformatics.com");
    for (ContactInformation ci : contactInformations) {
      log.debug(ci.getEmailAddress());
      message.addRecipient(RecipientType.TO, ci.getEmailAddress());
    }
    emailService.send(message);
    model.setViewName("administration.message.success");
    return model;
  }

  /**
   * @param contactInformationService the contactInformationService to set
   */
  @Resource(name = "contactInformationService")
  public void setContactInformationService(GenericService<ContactInformation> contactInformationService) {
    this.contactInformationService = contactInformationService;
  }

  /**
   * @param emailService the emailService to set
   */
  @Resource(name = "emailService")
  public void setEmailService(EmailService emailService) {
    this.emailService = emailService;
  }
}
