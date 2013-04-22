<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<c:forEach var="quantity" items="${quantities}" varStatus="status">
  <tr>
   <td class="fieldLabel"><c:out value="${quantity.type.displayName}" /></td>
   <td class="fieldView">
     <c:out value="${quantity.value}" />&nbsp;<c:out value="${quantity.standardUnit.name}" />
   </td>
  </tr>
</c:forEach>
