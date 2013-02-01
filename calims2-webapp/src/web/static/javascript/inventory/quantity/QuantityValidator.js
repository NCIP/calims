var quantityValidator = {
  // function that iterates over the quantities present in the page for validation
  // it returns false if a value is found that has no corresponding unit selected.
  validateQuantities : function() {
	var i = 0;
	var currentValue = dijit.byId("quantity_value_" + i);
	while (currentValue) {
	  if (!isNaN(currentValue.getValue() )) {
	    var unitId = dijit.byId("quantity_unit_" + i).getValue();
	    if (unitId == "-1") {
	      return false; 	
	    } 	
	  }	  
	  i++;
	  currentValue = dijit.byId("quantity_value_" + i);
	}
	return true;
  }	
};