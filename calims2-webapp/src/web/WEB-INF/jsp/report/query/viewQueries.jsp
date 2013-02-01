<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>


<div class="centeredBlock" dojoType="dijit.layout.LayoutContainer" style="height: 60%; width:70%;">
  
  <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
    <div class="centeredBlock" id="whereClauseDiv" style="height:auto; overflow:auto;">
      <table id="clauseTable" class="viewQueryTable">
        <thead>
          <tr>
            <th colspan="4"><h2><ct:enum value="${mainEntity}"/></h2></th>
          </tr>
          <tr>
            <th><fmt:message key="${pagePrefix}propertyHeader"/></th>
            <th><fmt:message key="${pagePrefix}operatorHeader"/></th>
            <th><fmt:message key="${pagePrefix}valueHeader"/></th>
            <th><fmt:message key="${pagePrefix}connectorHeader"/></th>
          </tr>
        </thead>
        <tbody id="clauseTableBody">
          <c:forEach var="row" items="${rows}" varStatus="status">
            <tr>
              <td><c:out value="${row.propertyName}"/></td>
              <td><ct:enum value="${row.operator}"/></td>
              <td><c:out value="${row.value}"/></td>
              <c:choose>         
                <c:when test="${not status.last}">
                  <td><ct:enum value="${row.connector}"/></td>
                </c:when>
                <c:otherwise><td></td></c:otherwise>       
              </c:choose>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>