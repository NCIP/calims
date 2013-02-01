<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-layer name="calims2/inventory/specimen/specimen.js"/>

<ct:dojo-require dojoType="calims2.inventory.specimen.SpecimenForm"/>
<ct:script src="${staticPath}/javascript/inventory/quantity/QuantityValidator.js"/>

<ct:script>

  dojo.addOnLoad(function() {
      var specimenForm = new calims2.inventory.specimen.SpecimenForm();
      specimenForm.onLoadHandler();
    });
  
  function validateCellSpecimen(evt, currentForm) {
    var result = quantityValidator.validateQuantities();
    return currentForm.validate() && validateForm() && result;
  }
</ct:script>