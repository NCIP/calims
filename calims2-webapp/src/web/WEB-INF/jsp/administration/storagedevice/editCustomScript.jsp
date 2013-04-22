<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script src="${staticPath}/javascript/namingconvention/NameValidator.js"/>

<ct:script>
  var namingConventions = ${namingConventions};
    
  function validateStorageDevice(evt,  currentForm) {
    var result = nameValidator.validateName(namingConventions, "name", "laboratory");
    return currentForm.validate() && validateForm() && result;
  }
</ct:script>