<%@ page import="org.apache.commons.lang.StringEscapeUtils, 
                 gov.nih.nci.calims2.util.enumeration.I18nEnumeration,
                 gov.nih.nci.calims2.uic.descriptor.ColumnVisibility" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form" %>

<ct:dojo-layer name="calims2/listPage.js"/>

<ct:dojo-require dojoType="dojo.data.ItemFileReadStore"/>
<ct:dojo-require dojoType="dijit.Dialog"/>
<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>
<ct:dojo-require dojoType="dojox.grid.DataGrid"/>
<ct:dojo-require dojoType="dojox.widget.PlaceholderMenuItem"/>

<ct:style src="${dojoPath}/dojox/grid/resources/Grid.css" />
<ct:style src="${dojoPath}/dojox/grid/resources/${dojoTheme}Grid.css" />

<jsp:useBean id="tableDecorator" type="gov.nih.nci.calims2.uic.descriptor.TableDecorator" scope="request" />

<ct:script>

  function collectionFmt(value){
    var result = value.replace(/&lt;br\/>/g, "<br\/>");
    return result;
  }
  
  function actionFmt(value) {
    var separatorPosition = value.indexOf("-");
    var id = value.substring(0, separatorPosition);
    var flags = value.substring(separatorPosition + 1, value.length);
    var itemCommands = ${tableDecorator.itemCommands};
    var result = ""; 
    for (var i = 0; i < itemCommands.length; i++) {
      if (flags.charAt(i) == "Y") {
        result += actionButton(itemCommands[i], id);
      } 
    }
    return result;
  }
  
  function actionButton(command, id) {
    var jsf = (command.javascriptFunction == "") ? "submitCommand" : command.javascriptFunction;
    var result = '<img class=\"imageIcon\" src=\"${pageContext.request.contextPath}${staticPath}\/images\/' + command.icon 
                 + '\" onclick=\"' + jsf + '(\''+command.url+'\',' + id + ');\" title=\"' + command.tooltip + '\"\/>';
    return result;
  } 
  
  function submitCommand(url,id) {
    var form = dojo.byId("list");
    form.action = "${pageContext.request.contextPath}" + url;
    form.id.value = id;
    form.submit();
  }
  
  function deleteDialog(url,id) {
    var form = dojo.byId("list");
    form.action = "${pageContext.request.contextPath}" + url;
    form.id.value = id;
    dijit.byId("deleteDialog").show();
  }
  
  var data = ${tableDecorator.dataStore};
  var store = new dojo.data.ItemFileReadStore({data : data});
  
  function handleResize(event) {
    dataGrid.update();
  }
  
  function connectEvents() {
    dojo.connect(window, "resize", handleResize);
    dataGrid.update();
  }
  
  dojo.addOnLoad(connectEvents);  
</ct:script>

<ct:style>
 #list { height:100%; }
</ct:style>
<fmt:message key="crud.deleteConfirmation.title" var="title"/>
<div id="deleteDialog" dojoType="dijit.Dialog" style="display:none" title="${title}">
  <fmt:message key="crud.deleteConfirmation.confirm"/><br/>
  <ct:button name="delete" type="button" labelKey="crud.deleteConfirmation.button.delete">
    <script type="dojo/method" event="onClick" args="evt">
    dijit.byId("deleteDialog").hide();
    var form = dojo.byId("list");
    form.submit();
  </script>
  </ct:button>
  <ct:button name="delete" type="button" labelKey="crud.deleteConfirmation.button.cancel">
    <script type="dojo/method" event="onClick" args="evt">
    dijit.byId("deleteDialog").hide();
  </script>
  </ct:button>
</div>
<div dojoType="dijit.layout.LayoutContainer">

  <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
    <tiles:insertDefinition name=".pageTitle"/>
  </div>
  
  <div class="layout_margin" dojoType="dijit.layout.ContentPane" layoutAlign="client">
    <ct:form id="list" action="${tableDecorator.config.urlPrefix}/list.do" method="post" >
      <input type="hidden" name="flowContext" value="${flowContext}"/>
      <input type="hidden" name="currentView" value="${currentView}"/>
      <input type="hidden" name="id"/>
      <c:forEach items="${tableDecorator.table.hiddenFields}" var="field">
        <form:field field="${field}" keyPrefix="${pagePrefix}" />
      </c:forEach>
      
      <div dojoType="dijit.Menu" jsid="gridMenu" id="gridMenu" style="display: none;">
        <div dojoType="dojox.widget.PlaceholderMenuItem" label="GridColumns"></div>
      </div>
      <c:set var="columns" value="${tableDecorator.displayableColumns}" />
      <table id="${tableDecorator.table.id}" dojoType="dojox.grid.DataGrid" jsId="dataGrid" store="store" query="{id:'*'}" columnReordering="true" headerMenu="gridMenu" style="min-height:200px; height:90%;">
        <colgroup span="1" noscroll="true"></colgroup>
        <colgroup span="${fn:length(columns)}"></colgroup>
        <thead>
          <tr>
            <th field="id" formatter="actionFmt" width="${fn:length(tableDecorator.table.itemCommands)*26 + 10}px"><fmt:message key="${pagePrefix}actions" /></th>
            <c:forEach items="${columns}" var="column" varStatus="varStatus">
              <jsp:useBean id="column" type="gov.nih.nci.calims2.uic.descriptor.table.Column"/>
              <c:set var="width" value="<%= tableDecorator.getColumnLength(column) * 8 %>" />
              <th field="${column.name}" <c:if test="${not empty column.formatter}">formatter="${column.formatter}"</c:if> <c:if test="<%= tableDecorator.getColumnVisibility(column) == ColumnVisibility.INITIALLY_INVISIBLE %>">hidden="true"</c:if> width="${width}px"><fmt:message key="${pagePrefix}${column.name}"/></th>
            </c:forEach>
          </tr>
        </thead>
      </table>
      <c:set var="commands" value="${tableDecorator.activeCommands}" />
      <c:if test="${not empty commands && fn:length(commands) > 0}">
        <table>
          <tr>
            <c:forEach items="${commands}" var="command">
              <td><ct:button iconClass="${command.iconClass}" labelKey="${pagePrefix}button.${command.name}" name="${command.name}" type="${command.type}" url="${command.url}"/></td>
            </c:forEach>
          </tr>
        </table>
      </c:if> 
    </ct:form>
  </div>
</div>