<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-layer name="calims2/inventory/layout/layout.js"/>

<ct:dojo-require dojoType="calims2.inventory.layout.ContainerGrid"/>

<ct:dojo-require dojoType="dojo.dnd.Source"/>

<div class="centeredBlock" dojoType="dijit.layout.LayoutContainer" style="height: 65%; width:70%;">
  <div id="containerGrid" dojoType="calims2.inventory.layout.ContainerGrid" layoutAlign="client"></div>
  <div dojoType="dijit.layout.ContentPane" layoutAlign="right" style="height:100%; width:130px;">
    <div class="centeredBlock" style="height:98%; width:110px; border-style:solid; border-width:1px; margin-top:0px; margin-bottom:0px;">
      <ol id="listContainer" jsId="listContainer" dojoType="dojo.dnd.Source" 
          style="height:100%; width:60px; overflow:auto; margin-top:0px; margin-bottom:0px;"></ol>
      <input type="hidden" id="coordinates" name="coordinates" value="" />
    </div>
  </div>
</div>

<ct:script>
  // the layout map
  var layouts = ${layoutMap};
  // the list of coordinates of the current pattern
  var coordinates = ${coordinates};
  
  dojo.addOnLoad(function() {
    dojo.connect(dijit.byId("layout"), "onChange", function(newValue) {
      var pane = dijit.byId("containerGrid");
      if (newValue !== "-1") {
        var layout = layouts[newValue];
        pane.rebuild(Number(layout.x), Number(layout.y), layout.labelX, layout.labelY, listener);
        listener.clear();
      } else {
        pane.clear();
        listener.clear();
      }
    });
    var layoutId = dijit.byId("layout").getValue();
    if (layoutId != "-1") {
      var pane = dijit.byId("containerGrid");
      var layout = layouts[layoutId];
      pane.rebuild(Number(layout.x), Number(layout.y), layout.labelX, layout.labelY, listener);
      pane.refresh(coordinates);
    }
  });
  var listener = {
    cellClick : function (selected, x, y, displayx, displayy) {
      var nodeId = x + "_" + y;          
      if (selected) {
        var data = { id : x + "_" + y,
                     data : '<span id="'+ nodeId + '">' + displayx + ',' + displayy + '</span>'
                   };
        listContainer.insertNodes(false, [data], false);
      } else {
        var nodes = listContainer.getAllNodes();
        var nodeToDelete = null;
        for (var i = 0; i < nodes.length; i++) {
          var node = nodes[i];
          var child = node.firstElementChild;
          if (child.id === nodeId) {
            nodeToDelete = node;
            break;
          }  
        }  
        nodeToDelete.parentNode.removeChild(nodeToDelete);
        listContainer.sync();
      }            
    },
    clear : function() {
      var nodes = listContainer.getAllNodes();
      for (var i = 0; i < nodes.length; i++) {
        var nodeToDelete = nodes[i];
        nodeToDelete.parentNode.removeChild(nodeToDelete);
      }  
      listContainer.sync();
    },
    getValues : function() {
      var result = "";
      var nodes = listContainer.getAllNodes();
      for (var i = 0; i < nodes.length; i++) {
        if (i > 0) {
          result += ",";
        }
        var node = nodes[i];
        var child = node.firstElementChild;
        result += child.id;
      }
    return result;    
    }
  }
</ct:script>