<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>
<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<c:choose>
  <c:when test="${empty privilegeEvaluator.currentUser}">
    <ct:menu id="mainMenu" menu="${menu}" />
  </c:when>
  <c:otherwise>
    <div style="float:left; width: 70%;">
      <ct:menu id="mainMenu" menu="${menu}" />
    </div>
    <div style="float:right; width: 30%;">
      <div class="dijitMenuBar dijitMenuPassive" style="text-align:right;padding-right: 15px;"> 
        <div class="dijitReset dijitInline dijitMenuItemLabel dijitMenuItem">
          <fmt:message key="menu.mainmenu.logged">
            <fmt:param><span class="user">${privilegeEvaluator.currentUsername}</span></fmt:param>
          </fmt:message>
          &nbsp;|&nbsp;
          <a href="${pageContext.request.contextPath}/j_spring_security_logout" style="text-decoration:underline;">
          <img src="${pageContext.request.contextPath}${staticPath}/images/logout.png"/>
            <fmt:message key="menu.mainmenu.logout" /></a>
        </div>
      </div>
    </div>
  </c:otherwise>
</c:choose>
