<%@ page import="gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form" %>

<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>
<ct:dojo-require dojoType="dijit.layout.TabContainer"/>

<jsp:useBean id="formDecorator" type="gov.nih.nci.calims2.uic.descriptor.FormDecorator" scope="request" />
<c:set var="form" value="${formDecorator.form}" />
<c:set var="hasTabs" value="${formDecorator.tabCount > 1}" />

<ct:form id="${form.id}" action="${form.action}" enctype="${form.enctype}" method="post" style="height:100%; width:100%;">
  <div dojoType="dijit.layout.LayoutContainer" style="height:100%; width:100%;">
  
    <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
      <tiles:insertDefinition name=".pageTitle"/>
    </div>
    
    <div class="${ (hasTabs) ? '' : 'layout_margin'}" dojoType="dijit.layout.ContentPane" layoutAlign="client">
      
      <c:if test="${not empty messagekey}">
        <div align="center">
          <fmt:message key="${pagePrefix}editerror"/>
        </div>
      </c:if>
    
      <ct:log message="rendering form ${form.id}"/>
      <c:forEach items='<%=formDecorator.getVisibleHiddenFields("edit") %>' var="field">
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
            <c:if test="${not empty tab.header}"><tiles:insertDefinition name=".customEdit.header.${tab.header}"/></c:if>
          
            <c:if test="${separatorCount > 0}" >
              <table class="centeredBlock"><tr><td valign="top">
            </c:if>
            <table class="centeredBlock">
              <c:forEach items='<%=formDecorator.getVisibleFields(tab, "edit") %>' var="field">
                <ct:log message="rendering field ${field.name}"/>
                <c:choose>
                  <c:when test="${field.type.name == 'CUSTOM'}"><tiles:insertDefinition name=".customEdit.${field.customSelector}"/></c:when>
                  <c:when test="${field.type.name == 'SEPARATOR'}"></table></td><td valign="top"><table class="centeredBlock"></c:when>
                  <c:otherwise>
                    <tr id="${field.id}_row">
                      <td id="${field.id}_labelCell" class="fieldLabel">
                        <label id="${field.id}_label" for="${field.id}">
                          <fmt:message key="${module}.${form.id}.${field.id}" />
                          <span id="${field.id}_requiredMarker" class="requiredMarker${(field.required) ? '' : ' hidden'}">*</span>
                        </label>
                      </td>
                      <td id="${field.id}_fieldCell" class="fieldView">
                        <form:field field="${field}" keyPrefix="${module}.${form.id}." /></td>
                    </tr>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </table>
            <c:if test="${separatorCount > 0}">
              </td></tr></table>
            </c:if>
            <c:if test="${not empty tab.footer}"><tiles:insertDefinition name=".customEdit.footer.${tab.footer}"/></c:if>
          </div>  
          <div dojoType="dijit.layout.ContentPane" layoutAlign="bottom">
            <table class="centeredBlock">
              <tr>
                <c:forEach items='<%=formDecorator.getActiveCommands(tab, "edit") %>' var="command">
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
  <script type="dojo/method" event="onSubmit" args="evt">
        var currentForm = dijit.byId("${form.id}");
        <c:choose>
          <c:when test="${not empty form.validateFunction}">
            return !currentForm.validateFlag || ${form.validateFunction}(evt,  currentForm);
          </c:when>
          <c:otherwise>
            return !currentForm.validateFlag || (currentForm.validate() && validateForm());
          </c:otherwise>
        </c:choose>
  </script>
</ct:form>
  
<ct:script>
  function validateForm() {
  <c:forEach items='<%=formDecorator.getAllVisibleFields("edit") %>' var="field"
   ><c:choose
     ><c:when test="${field.type.name == 'SELECT' && field.required}">
        if (!validateSingleSelect('${field.id}')) {
          return false;
        }
      </c:when
     ><c:when test="${field.type.name == 'MULTI_SELECT' && field.required}">
        if (!validateMultiSelect('${field.id}')) {
          return false;
        }
      </c:when
     ><c:when test="${field.type.name == 'TEXTAREA'}">
        if (!validateTextArea('${field.id}', ${field.required}, ${field.maxLength})) {
          return false;
        }
      </c:when
   ></c:choose
 ></c:forEach>
  return true;
  }
  
  function validateSingleSelect(fieldId) {
    return dijit.byId(fieldId).getValue() != "-1";
  }
  
  function validateMultiSelect(fieldId) {
    var selectedOptions = dijit.byId(fieldId).getSelected();
    for (var i = 0; i < selectedOptions.length; i++) {
      if (selectedOptions[i].value != "-1") {
        return true;
      }
    }
    return false;
  }
  
  function validateTextArea(fieldId, required, maxLength) {
    var textarea = dijit.byId(fieldId);
    var value = dijit.byId(fieldId).getValue();
    if (required && value == "" || value.length > maxLength) {
      return false;
    }
    return true;
  }
</ct:script>

<c:if test="${not empty form.script}"><jsp:include page="/WEB-INF/jsp${config.urlPrefix}/${form.script}.jsp" /></c:if>
