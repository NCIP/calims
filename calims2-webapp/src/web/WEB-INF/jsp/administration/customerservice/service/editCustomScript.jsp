<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script>
  dojo.addOnLoad(function() {
    var status = dijit.byId("status");
    
    var customerRequestCustomerMode = dojo.byId("customerRequestCustomerMode").value == "true";
    if (customerRequestCustomerMode) {
      status.set("readOnly", true);
    }
  });
</ct:script>