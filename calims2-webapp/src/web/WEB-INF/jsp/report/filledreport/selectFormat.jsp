<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form" %>

<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>


<div dojoType="dijit.layout.LayoutContainer">

  <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
    <tiles:insertDefinition name=".pageTitle"/>
  </div>

  <div class="layout_margin" dojoType="dijit.layout.ContentPane" layoutAlign="client">
    <ct:form id="runReportForm" action="/" validate="true">
      <input type="hidden" name="flowContext" value="${flowContext}"/>
      <input type="hidden" name="id" value="${id}"/>
      <label for="format" class="fieldLabel"><fmt:message key="${pagePrefix}format"/></label>
      <ct:single-select id="format" invalidKey="${pagePrefix}format.invalid" name="format" promptKey="${pagePrefix}format.prompt" required="true" collectionType="ENUMERATIONS" options="${formats}" />
      <table>
        <tr>
          <ct:secure-url url="${config.urlPrefix}${config.listCommand}" >
            <td><ct:button name="cancelGenerate" labelKey="${pagePrefix}button.cancelGenerate" url="${config.urlPrefix}${config.listCommand}"/></td>
          </ct:secure-url>
          <ct:secure-url url="${config.urlPrefix}/exportReport.do" >
            <td><ct:button name="run" labelKey="${pagePrefix}button.runReport" url="${config.urlPrefix}/exportReport.do" validate="true"/></td>
          </ct:secure-url>
        </tr>
       </table>
    </ct:form>
  </div>
</div>