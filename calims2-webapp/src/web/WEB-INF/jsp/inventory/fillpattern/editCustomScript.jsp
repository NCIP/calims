<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

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

  
