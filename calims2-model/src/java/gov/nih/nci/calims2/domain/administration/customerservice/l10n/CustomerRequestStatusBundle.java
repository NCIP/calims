package gov.nih.nci.calims2.domain.administration.customerservice.l10n;


import java.util.ListResourceBundle;

import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public class CustomerRequestStatusBundle  extends ListResourceBundle {

private static final Object[][] CONTENTS = {

{CustomerRequestStatus.APPROVED.name(), "Approved"},
{CustomerRequestStatus.APPROVALPENDING.name(), "Approval Pending"},
{CustomerRequestStatus.CANCELLED.name(), "Cancelled"},
{CustomerRequestStatus.COMPLETED.name(), "Completed"},
{CustomerRequestStatus.MODIFIED.name(), "Modified"},
{CustomerRequestStatus.REJECTED.name(), "Rejected"},
{CustomerRequestStatus.SUBMITTED.name(), "Submitted"},
{CustomerRequestStatus.INQUIRY.name(), "Inquiry"},
{CustomerRequestStatus.LABRESPONSE.name(), "Lab Response"},
{CustomerRequestStatus.CUSTOMERRESPONSE.name(), "Customer Response"},
{CustomerRequestStatus.INQUIRYSUBMITTED.name(), "Inquiry Submitted"},
{CustomerRequestStatus.LABAPPROVED.name(), "Lab Approved"},
{CustomerRequestStatus.CUSTOMERAPPROVED.name(), "Customer Approved"},
{CustomerRequestStatus.CUSTOMERREQUESTSUBMITTED.name(), "Customer Request Submitted"}};

 /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
