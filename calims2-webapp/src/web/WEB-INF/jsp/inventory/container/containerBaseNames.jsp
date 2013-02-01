<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<c:forEach var="index" begin="0" end="${depth - 1}">
  <tr>
    <td class="fieldLabel">
      <label for="basename_${index}">
        <fmt:message key="${module}.containerCopyForm.basename" >
          <fmt:param value="${index + 1}"/>
        </fmt:message>
        <span class="requiredMarker">*</span>
      </label>
    </td>
    <td class="fieldView">
      <ct:validationTextBox id="basename_${index}" name="basename[${index}]" promptKey="${module}.containerCopyForm.basename.prompt" required="true"/>
    </td>
  </tr>
</c:forEach>