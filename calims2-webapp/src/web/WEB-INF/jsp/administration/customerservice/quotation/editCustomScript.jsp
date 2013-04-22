<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script src="${staticPath}/javascript/inventory/quantity/QuantityValidator.js"/>

<ct:script>
  function validateQuotation(evt, currentForm) {
    var result = quantityValidator.validateQuantities();
    return currentForm.validate() && validateForm() && result;
  }
</ct:script>