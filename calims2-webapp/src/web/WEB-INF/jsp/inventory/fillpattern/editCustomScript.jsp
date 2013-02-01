<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script>
  function validateFillPattern(evt, currentForm) {
    var valid = currentForm.validate() && validateForm();
    if (valid) {
      dojo.byId("coordinates").value = listener.getValues();
    }
    return valid;
  }
</ct:script>

  
