<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>

<c:if test="${config.advancedSearch}">
  <ct:script>
    dojo.addOnLoad(function() {
      
      var queryId = dijit.byId("queryId");
   
      // onChange of the queries
      dojo.connect(queryId, "onChange", function(newValue) {
      var button=dijit.byId("advancedSearchButton");
      
      if (newValue) {
          button.set("disabled", false);
          queryIdStore.fetchItemByIdentity({identity: newValue,
          onItem: function(item) {
            var description = dojo.byId("description");
            description.innerHTML = item.description[0];
          }
          });
        } else {
            button.set("disabled", true);
            var description = dojo.byId("description");
            description.innerHTML = "";
        }
      });
    });
  
  </ct:script>
</c:if>  

<div dojoType="dijit.layout.LayoutContainer">

  <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
    <tiles:insertDefinition name=".pageTitle"/>
  </div>
  
  <div class="layout_margin" dojoType="dijit.layout.ContentPane" layoutAlign="client">
    <ct:form id="manageForm" action="/">
      <input type="hidden" name="flowContext" value="${flowContext}"/>
      <input type="hidden" name="currentView" value="${currentView}"/>
      <c:if test="${config.advancedSearch}">
        <table>
          <tr>
            <td><label for="queryId"><fmt:message key="${pagePrefix}query"/></label></td>
            <td><ct:single-select id="queryId" name="queryId" promptKey="${pagePrefix}query.prompt" options="${queries}" properties="id:id,label:name,description:description" useDataStore="true" /></td>
            <td><span id="description"></span></td>
          </tr>
        </table>   
      </c:if>
      <table>
        <tr>
          <ct:secure-url url="${config.urlPrefix}${config.createCommand}" >
            <td><ct:button name="create" labelKey="${pagePrefix}button.new" url="${config.urlPrefix}${config.createCommand}"/></td>
          </ct:secure-url>
          <ct:secure-url url="${config.urlPrefix}${config.listCommand}" >
            <td><ct:button name="search" labelKey="${pagePrefix}button.search" url="${config.urlPrefix}${config.listCommand}"/></td>
          </ct:secure-url>
          <c:if test="${config.advancedSearch}">
            <ct:secure-url url="${config.urlPrefix}${config.listCommand}" >
              <td><ct:button disabled="true" id="advancedSearchButton" name="advancedSearch" labelKey="${pagePrefix}button.advancedSearch" url="${config.urlPrefix}${config.listCommand}"/></td>
            </ct:secure-url>
          </c:if>
        </tr>
       </table>
    </ct:form>
  </div>
</div>



