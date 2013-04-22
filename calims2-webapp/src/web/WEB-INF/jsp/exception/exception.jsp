<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3><fmt:message key="${pagePrefix}header" /></h3>
<c:if test="${not empty exception}">
  <fmt:message key="${pagePrefix}name" >
    <fmt:param value="${exception.message}" />
  </fmt:message>
  <br/>
  <fmt:message key="${pagePrefix}class" >
    <fmt:param value="${exception.class.name}" />
  </fmt:message>
  <br/>
</c:if>
<fmt:message key="${pagePrefix}log" />
