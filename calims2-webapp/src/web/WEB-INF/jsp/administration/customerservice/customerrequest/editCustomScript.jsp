<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script>
  dojo.addOnLoad(function() {
    var submissionDate = dijit.byId("submissionDate");
    submissionDate.set("readOnly", true);
    var status = dijit.byId("status");
    status.set("readOnly", true);
    var laboratoryFinalApproveDate = dijit.byId("laboratoryFinalApproveDate");
    laboratoryFinalApproveDate.set("readOnly", true);
    
  });
</ct:script>