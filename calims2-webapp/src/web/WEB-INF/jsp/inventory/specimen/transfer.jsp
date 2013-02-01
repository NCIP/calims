<%@ page import="gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib tagdir="/WEB-INF/tags/form" prefix="form" %>

<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>
<ct:dojo-require dojoType="calims2.inventory.layout.CoordinateHelper"/>
<ct:dojo-require dojoType="calims2.inventory.specimen.TransferGrid"/>

<ct:form id="transferSpecimenForm" action="/" style="height:100%; width:100%;" validate="true">

<input type="hidden" name ="flowContext" value="${flowContext}" />
<input type="hidden" name ="sourceId" value="${source.id}" />

<div class="inventory-specimen-transfer" dojoType="dijit.layout.LayoutContainer" style="height:100%; width:100%;">
  
  <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
    <tiles:insertDefinition name=".pageTitle"/>
  </div>
  
  <div dojoType="dijit.layout.ContentPane" layoutAlign="left" style="width:30%">
    <table class="sourceContainerTable centeredBlock">
      <thead>
        <tr>
          <th colspan="2"><fmt:message key="${pagePrefix}sourceTitle" /></th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td class="fieldLabel"><fmt:message key="${pagePrefix}sourceName" /></td>
          <td><c:out value="${source.name}" /></td>
        </tr>
        <tr>
          <td class="fieldLabel"><fmt:message key="${pagePrefix}sourceDisplayName" /></td>
          <td><c:out value="${source.displayName}" /></td>
        </tr>
        <tr>
          <td class="fieldLabel"><fmt:message key="${pagePrefix}sourceType" /></td>
          <td><c:out value="${source.containerType.name}" /></td>
        </tr>
      
        <tr>
          <th colspan="2"><fmt:message key="${pagePrefix}targetTitle" /></th>
        </tr>
      
        <tr>
          <td class="fieldLabel"><fmt:message key="${pagePrefix}targetCategory" /><span class="requiredMarker">*</span></td>
          <td><ct:single-select id="containerCategories" invalidKey="${pagePrefix}targetCategory.invalid" 
                                                  name="targetCategoryId" options="${containerCategories}" 
                                                  promptKey="${pagePrefix}targetCategory.prompt" properties="id:id,label:name" 
                                                  required="true" selected="${category}"/></td>
        </tr>
        <tr>
          <td class="fieldLabel"><fmt:message key="${pagePrefix}targetSubCategory" /><span class="requiredMarker">*</span></td>
          <td><ct:single-select id="containerSubcategories" invalidKey="${pagePrefix}targetSubCategory.invalid" 
                                                  name="targetSubcategoryId" options="${containerSubcategories}" 
                                                  promptKey="${pagePrefix}targetSubCategory.prompt" properties="id:id,label:name,parentId:type.id" 
                                                  required="true" selected="${subCategory}" useDataStore="true"/></td>
        </tr>
        <tr>
        <td class="fieldLabel"><fmt:message key="${pagePrefix}targetType" /><span class="requiredMarker">*</span></td>
          <td><ct:single-select id="containerTypes" invalidKey="${pagePrefix}targetType.invalid" 
                                                  name="targetTypeId" options="${containerTypes}" 
                                                  promptKey="${pagePrefix}targetType.prompt" properties="id:id,label:name,parentId:containerSubcategory.id" 
                                                  required="true" selected="${containerType}" useDataStore="true"/></td>                 
        </tr>
        <tr>
          <td class="fieldLabel"><fmt:message key="${pagePrefix}target" /><span class="requiredMarker">*</span></td>
          <td><ct:single-select id="containers" invalidKey="${pagePrefix}target.invalid" 
                                                  name="targetId" options="${targets}" 
                                                  promptKey="${pagePrefix}target.prompt" properties="id:id,label:name,parentId:containerType.id" 
                                                  required="true" selected="${target}" useDataStore="true"/></td>   
        </tr>
        <tr>                                             
          <td colspan="2">
            <ct:button labelKey="${pagePrefix}button.select" name="submit" type="submit" url="/inventory/specimen/selectTarget.do" validate="true"/>
            <ct:button labelKey="${pagePrefix}button.transfer" name="submit" type="submit" url="/inventory/specimen/transfer.do"  validate="true"/>
            <ct:button labelKey="${pagePrefix}button.cancel" name="submit" type="submit" url="/inventory/specimen/cancelTransfer.do"/>
          </td>                                                  
        </tr>
      </tbody>
    </table>  
  </div>
  
  <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
    <div dojoType="dijit.layout.LayoutContainer" style="height:100%; width:100%;">
      <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
      
        <div style="position:absolute; top:0; left:0; height:100%; width:50%; overflow:auto">
          <div id="sourceGrid" dojoType="calims2.inventory.specimen.TransferGrid"></div>
        </div>
        
        <div style="position:absolute; top:0; left:50%; height:100%; width:50%; overflow:auto">
          <div id="targetGrid" dojoType="calims2.inventory.specimen.TransferGrid"></div>
        </div>
        
      </div>
      
      <div dojoType="dijit.layout.ContentPane" layoutAlign="bottom" style="height:50%; overflow:auto">
        <table class="specimenTransferTable centeredBlock" >
          <thead>
            <tr>
              <th colspan="6"><span><fmt:message key="${pagePrefix}tableTitle" /></span></th>
            </tr>
            <tr>
              <th>&nbsp</th>
              <th><fmt:message key="${pagePrefix}sourceXHeader"/></th>
              <th><fmt:message key="${pagePrefix}sourceYHeader"/></th>
              <th><fmt:message key="${pagePrefix}specimenHeader"/></th>
              <th><fmt:message key="${pagePrefix}targetXHeader"/></th>
              <th><fmt:message key="${pagePrefix}targetYHeader"/></th>
            </tr>
          </thead>
          <tbody id="transferTableBody">
          </tbody>
        </table>
      </div>
      
    </div>
  </div>
    
</div>
</ct:form>
<ct:script>
  var model = {
    deleteImage : "${pageContext.request.contextPath}${staticPath}/images/delete.png",
    deleteTooltip : "<fmt:message key="${pagePrefix}deleteTooltip"/>",
    rowCount : 0,
    sourceLayout : {
      "x" : ${source.layout.x_dimension},
      "y" : ${source.layout.y_dimension},
      "labelX" : "${source.layout.x_dimensionLabel.name}",
      "labelY" : "${source.layout.y_dimensionLabel.name}"
    },
    sourceSpecimens : ${sourceSpecimens}
<c:if test="${not empty target}" >
    ,
    targetLayout : {
      "x" : ${target.layout.x_dimension},
      "y" : ${target.layout.y_dimension},
      "labelX" : "${target.layout.x_dimensionLabel.name}",
      "labelY" : "${target.layout.y_dimensionLabel.name}"
    },
    targetSpecimens : ${targetSpecimens},
    targetContainerIds : ${targetContainerIds}
</c:if>    
  };
  
  var controller = {
     addTransfer : function(x, y, displayx, displayy) {
       console.debug("addTransfer");
       var sourceCoordinate = model.sourceX + "_" + model.sourceY;
       var specimen = model.sourceSpecimens[sourceCoordinate];
       var specimenId = specimen.id;
       var targetCoordinate = x + "_" + y;
       var containerId = model.targetContainerIds[targetCoordinate];
       if (!this.checkAddition(specimenId, containerId)) {
         return false;
       }
       var trNode = document.createElement("tr");
       trNode.id = "row_" + x + "-" + y;
       var actionCell = trNode.appendChild(document.createElement("td"));
       var imgNode = actionCell.appendChild(document.createElement("img"));
       imgNode.class = "imageIcon";
       imgNode.src = model.deleteImage;
       imgNode.title = model.deleteTooltip;
       dojo.connect(imgNode, "click", this.removeTransfer);
       
       var sourceXCell = trNode.appendChild(document.createElement("td"));
       sourceXCell.appendChild(document.createTextNode(model.sourceDisplayX));
       
       var sourceYCell = trNode.appendChild(document.createElement("td"));
       sourceYCell.appendChild(document.createTextNode(model.sourceDisplayY));
       
       var specimenCell = trNode.appendChild(document.createElement("td"));
       specimenCell.appendChild(document.createTextNode(specimen.name));
       
       var specimenInput = document.createElement("input");
       specimenInput.id = "specimen_" + model.rowCount;
       specimenInput.name = "specimen[" + model.rowCount +"]";
       specimenInput.type = "hidden";
       specimenInput.value = specimenId;
       specimenCell.appendChild(specimenInput);
       
       var containerInput = document.createElement("input");
       containerInput.id = "container_" + model.rowCount;
       containerInput.name = "container[" + model.rowCount +"]";
       containerInput.type = "hidden";
       containerInput.value = containerId;
       specimenCell.appendChild(containerInput);
       
       var targetXCell = trNode.appendChild(document.createElement("td"));
       targetXCell.appendChild(document.createTextNode(displayx));
       
       var targetYCell = trNode.appendChild(document.createElement("td"));
       targetYCell.appendChild(document.createTextNode(displayy));
       
       var tableBody = dojo.byId("transferTableBody");
       tableBody.appendChild(trNode);
       model.rowCount++;
       return true;
     },
     removeTransfer : function(evt) {
       console.debug("removeTransfer");
       var trNode = evt.currentTarget.parentNode.parentNode;
       var rowId = trNode.id;
       var pos1 = rowId.indexOf("_");
       var pos2 = rowId.indexOf("-");
       var x = Number(rowId.substring(pos1 + 1, pos2));
       var y = Number(rowId.substring(pos2 + 1));
       var targetGrid = dijit.byId("targetGrid");
       targetGrid.highlight(x, y, false);
       var tableBody = dojo.byId("transferTableBody");
       tableBody.removeChild(trNode);
     },
     checkAddition : function(specimenId, containerId) {
       var found = false;
       var tableBody = dojo.byId("transferTableBody");
       var rows = dojo.query("tr", tableBody);
       rows.forEach(function(trNode) {
         var cells = dojo.query("td", trNode);
         var inputs = dojo.query("input", cells[3]);
         var rowSpecimenId = null;
         var rowContainerId = null;
         inputs.forEach(function(inputNode) {
           var pos = inputNode.name.indexOf("specimen");
           if (pos >= 0) {
             rowSpecimenId = inputNode.value;
           } else {
             rowContainerId = inputNode.value;
           }
         });
         found = found || (specimenId === rowSpecimenId && containerId === rowContainerId);
       });
       return !found;
     }
  };
  
  dojo.addOnLoad(function(){
    var containerCategories = dijit.byId("containerCategories");
        var containerSubcategories = dijit.byId("containerSubcategories");
        var containerTypes = dijit.byId("containerTypes");
        var containers = dijit.byId("containers");
        
        containerSubcategories.query = { "parentId" : containerCategories.getValue() };
        containerTypes.query = { "parentId" : containerSubcategories.getValue() };
        containers.query = { "parentId" : containerTypes.getValue() };
        
        // onChange of the container categories
        dojo.connect(containerCategories, "onChange", function(newValue) {
          var containerSubcategories = dijit.byId("containerSubcategories");
          containerSubcategories.query = { "parentId" : newValue };
          containerSubcategories.setValue("");
          var containerTypes = dijit.byId("containerTypes");
          containerTypes.query = { "parentId" : "" };
          containerTypes.setValue("");
          var containers = dijit.byId("containers");
          containers.query = { "parentId" : "" };
          containers.setValue("");
        });
        
        // onChange of the container subcategories
        dojo.connect(containerSubcategories, "onChange", function(newValue) {
          var containerTypes = dijit.byId("containerTypes");
          containerTypes.query = { "parentId" : newValue };
          containerTypes.setValue("");
          var containers = dijit.byId("containers");
          containers.query = { "parentId" : "" };
          containers.setValue("");
        });
        
        // onChange of the container Types
        dojo.connect(containerTypes, "onChange", function(newValue) {
          var containers = dijit.byId("containers");
          containers.query = { "parentId" : newValue };
          containers.setValue("");
        });
        
        var sourceEventListener = {
          cellClick : function(x, y, displayx, displayy) {
            console.debug("This is the source cellClick");
            console.debug("coordinates = " + x + "," + y);
            console.debug("display = " + displayx + "," + displayy);
            var coordinate = x + '_' + y;
            var specimen = model.sourceSpecimens[coordinate];
            if (specimen) {
              console.debug("selection ok");
              var sourceGrid = dijit.byId("sourceGrid");
              if (model.sourceX) {
                sourceGrid.highlight(model.sourceX, model.sourceY, false);
              }
              model.sourceX = x;
              model.sourceY = y;
              model.sourceDisplayX = displayx;
              model.sourceDisplayY = displayy;
              sourceGrid.highlight(model.sourceX, model.sourceY, true);
            }
          }  
        };
        var sourceGrid = dijit.byId("sourceGrid");
        var sourceLayout = model.sourceLayout;
        sourceGrid.rebuild(sourceLayout.x, sourceLayout.y, sourceLayout.labelX, sourceLayout.labelY, model.sourceSpecimens, sourceEventListener);
        if (sourceLayout.x == 1 && sourceLayout.y == 1) {
          sourceGrid.cellClick(0, 0);
        }
        
        var targetLayout = model.targetLayout;
        if (targetLayout) {
          var targetEventListener = {
          cellClick : function(x, y, displayx, displayy) {
            console.debug("This is the target cellClick");
            console.debug("coordinates = " + x + "," + y);
            console.debug("display = " + displayx + "," + displayy);
            var coordinate = x + '_' + y;
            var specimen = model.targetSpecimens[coordinate];
            if (model.sourceX !== undefined && specimen === undefined) {
              console.debug("selection ok");
              var added = controller.addTransfer(x, y, displayx, displayy);
              if (added) {
                var targetGrid = dijit.byId("targetGrid");
                targetGrid.highlight(x, y, true);
              }
            }
            }
          };
          var targetGrid = dijit.byId("targetGrid");
          targetGrid.rebuild(targetLayout.x, targetLayout.y, targetLayout.labelX, targetLayout.labelY, model.targetSpecimens, targetEventListener);
        }
  });

</ct:script>