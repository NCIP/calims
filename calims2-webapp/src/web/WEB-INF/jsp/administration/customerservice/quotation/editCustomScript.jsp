<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script src="${staticPath}/javascript/inventory/quantity/QuantityValidator.js"/>

<ct:script>
  function validateQuotation(evt, currentForm) {
    var result = quantityValidator.validateQuantities();
    return currentForm.validate() && validateForm() && result;
  }
</ct:script>