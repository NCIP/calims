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