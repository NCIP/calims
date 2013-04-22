<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:message key="${pagePrefix}helpurl" var="helpurl"/>
<div class="pageTitle"><fmt:message key="${pagePrefix}header" />
   <div class="pagehelp">
     <a href="${(fn:startsWith(helpurl,'???'))?'':helpurl}" class="help" target="help">Help</a>
   </div>
</div>