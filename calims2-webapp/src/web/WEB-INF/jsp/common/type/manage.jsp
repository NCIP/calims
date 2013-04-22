<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>

<div dojoType="dijit.layout.LayoutContainer">

  <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
    <tiles:insertDefinition name=".pageTitle"/>
  </div>
  
  <div class="layout_margin" dojoType="dijit.layout.ContentPane" layoutAlign="client">
    <ct:form id="manageForm" action="/">
      <input type="hidden" name="flowContext" value="${flowContext}"/>
      <input type="hidden" name="currentView" value="${currentView}"/>
      <input type="hidden" name="id"/>
      <table>
        <tr>
          <td>
            <ct:select name="dataElementCollection" options="${types}" />
          </td>
        </tr>
      </table>
      <table>  
        <tr>
          <td>
            <ct:button name="create" labelKey="${pagePrefix}button.new" url="/common/type/create.do"/>
          </td>
          <td>
            <ct:button name="search" labelKey="${pagePrefix}button.search" url="/common/type/list.do"/>
          </td>
        </tr>
       </table>
    </ct:form>
  </div>
</div>
