<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script>
  dojo.addOnLoad(function() {
    var rates = dijit.byId("rates");
    var customerRequestCustomerMode = dojo.byId("customerRequestCustomerMode").value == "true";
    if (customerRequestCustomerMode) {
      rates.set("readOnly", true);
    }
    var subtotal = dijit.byId("subtotal");
    subtotal.set("readOnly", true);

    var calculateSubtotal = function () {
      var subtotal = dijit.byId("subtotal");
      var quantity = dijit.byId("quantity").getValue();
      var rateId = dijit.byId("rates").getValue();
      if (isNaN(quantity) || rateId == "") {
        subtotal.setValue("");
        return;
      }
      ratesStore.fetchItemByIdentity({identity: rateId, 
      onItem: function(item) {
        var rate = item.rate[0];
        if (rate != "") {
          var unit = item.unit[0];
          var value = (quantity * rate);    
          subtotal.setValue(unit + " " + value);
        }
      }
    });
  };
  
  calculateSubtotal();

  //onChange event for rates 
  dojo.connect(rates, "onChange", calculateSubtotal); 
 
  //onChange event for quantities 
  dojo.connect(dijit.byId("quantity"), "onChange", calculateSubtotal);
  });

</ct:script>
   