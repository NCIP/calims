<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form" %>

<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>

<jsp:useBean id="formDecorator" type="gov.nih.nci.calims2.uic.descriptor.FormDecorator" scope="request" />
<c:set var="form" value="${formDecorator.form}" />
<c:set var="hasTabs" value="${formDecorator.tabCount > 1}" />

<ct:form id="${form.id}" action="${form.action}" enctype="${form.enctype}" method="post" style="height:100%; width:100%;">
  <div dojoType="dijit.layout.LayoutContainer" style="height:100%; width:100%;">
  
    <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
      <tiles:insertDefinition name=".pageTitle"/>
    </div>
    
    <div class="${ (hasTabs) ? '' : 'layout_margin'}" dojoType="dijit.layout.ContentPane" layoutAlign="client">
      <ct:log message="rendering form ${form.id}"/>
      <c:forEach items='<%=formDecorator.getVisibleHiddenFields("details") %>' var="field">
        <ct:log message="rendering field ${field.name}"/>
        <form:field field="${field}" keyPrefix="${pagePrefix}" />
      </c:forEach>
      
      <c:if test="${hasTabs}">
        <div dojoType="dijit.layout.TabContainer" style="height:100%; width:100%">
      </c:if>
      <c:forEach var="tab" items="${form.children}">
        <c:if test="${hasTabs}">
          <fmt:message key="${module}.${form.id}.tab.${tab.name}" var="tabTitle"/> 
          <div dojoType="dijit.layout.ContentPane" title="${tabTitle}" >
        </c:if>
        <jsp:useBean id="tab" type="gov.nih.nci.calims2.uic.descriptor.form.FormTab"/>
        <div dojoType="dijit.layout.LayoutContainer" style="height:100%; width:100%;">
          <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
          
            <c:set var="separatorCount" value='<%=formDecorator.getSeparatorCount(tab) %>' />
  
            <c:if test="${not empty tab.header}"><tiles:insertDefinition name=".customDetails.header.${tab.header}"/></c:if>
            
            <c:if test="${separatorCount > 0}" >
              <table class="centeredBlock"><tr><td valign="top">
            </c:if>
            <table class="centeredBlock">
              <c:forEach items='<%=formDecorator.getVisibleFields(tab, "details") %>' var="field">
                <ct:log message="rendering field ${field.name}"/>
                <c:choose>
                  <c:when test="${field.type.name == 'CUSTOM'}"><tiles:insertDefinition name=".customDetails.${field.customSelector}"/></c:when>
                  <c:when test="${field.type.name == 'SEPARATOR'}"></table></td><td valign="top"><table class="centeredBlock"></c:when>
                  <c:otherwise>
                    <tr id="${field.id}_row">
                      <td id="${field.id}_labelCell" class="fieldLabel"><label id="${field.id}_label" for="${field.id}"><fmt:message key="${module}.${form.id}.${field.id}" /></label></td>
                      <td id="${field.id}_fieldCell" class="fieldView"><form:field-view field="${field}" keyPrefix="${module}.${form.id}." /></td>
                    </tr>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </table>
            <c:if test="${separatorCount > 0}">
              </td></tr></table>
            </c:if>
            <c:if test="${not empty tab.footer}"><tiles:insertDefinition name=".customDetails.footer.${tab.footer}"/></c:if>
          </div>
          <div dojoType="dijit.layout.ContentPane" layoutAlign="bottom">  
            <table class="centeredBlock">
              <tr>
                <c:forEach items='<%=formDecorator.getActiveCommands(tab, "details") %>' var="command">
                  <ct:log message="rendering command ${command.name}"/>
                  <td><form:command command="${command}" formId="${form.id}" keyPrefix="${pagePrefix}" /></td>
                </c:forEach>
              </tr>
            </table>
          </div>
        </div>    
        <c:if test="${hasTabs}">
          </div>
        </c:if>
      </c:forEach>
      <c:if test="${hasTabs}">
        </div>
      </c:if>
    </div>
  </div>    
</ct:form>  