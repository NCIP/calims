<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-layer name="calims2/inventory/layout/layout.js"/>

<ct:dojo-require dojoType="calims2.inventory.layout.ContainerGrid"/>

<div class="centeredBlock" dojoType="dijit.layout.LayoutContainer" style="height: 65%; width:70%;">
  <div id="containerGrid" dojoType="calims2.inventory.layout.ContainerGrid" layoutAlign="client" readOnly="true">
  </div>
  <div dojoType="dijit.layout.ContentPane" layoutAlign="right" style="height:100%; width:130px;">
    <div class="centeredBlock" style="height:98%; width:110px; border-style:solid; border-width:1px; margin-top:0px; margin-bottom:0px;">
      <ol class="centeredBlock" 
          style="height:100%; width:60px; overflow:auto; margin-top:0px; margin-bottom:0px;">
        <c:forEach var="label" items="${labels}">
          <li><span><c:out value="${label}" /></span></li>
        </c:forEach>
      </ol>
    </div>
  </div>
</div>

<ct:script>
  dojo.addOnLoad(function() {
      var layouts = ${layoutMap};
      var coordinates = ${coordinates};
      var pane = dijit.byId("containerGrid");
      var layout = layouts["${form.entity.layout.id}"];
      pane.rebuild(Number(layout.x), Number(layout.y), layout.labelX, layout.labelY, pane.eventListener);
      pane.refresh(coordinates);
  });
  
</ct:script>