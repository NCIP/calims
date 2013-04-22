<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

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
    <ct:form id="selectServiceForm" action="/" validate="true">
      <input type="hidden" name="flowContext" value="${flowContext}"/>
      <label for="services" class="fieldLabel"><fmt:message key="${pagePrefix}services"/></label>
      <ct:single-select id="services" invalidKey="${pagePrefix}services.invalid" name="templateId" properties="id:id,label:name" promptKey="${pagePrefix}services.prompt" required="true" options="${services}" />
      <table>
        <tr>
          <ct:secure-url url="${config.urlPrefix}${config.listCommand}" >
            <td><ct:button name="cancel" labelKey="${pagePrefix}button.cancel" url="${config.urlPrefix}${config.listCommand}"/></td>
          </ct:secure-url>
          <ct:secure-url url="${config.urlPrefix}/selectService.do" >
            <td><ct:button name="cloneService" labelKey="${pagePrefix}button.cloneService" url="${config.urlPrefix}/cloneService.do" validate="true"/></td>
          </ct:secure-url>
        </tr>
       </table>
    </ct:form>
  </div>
</div>