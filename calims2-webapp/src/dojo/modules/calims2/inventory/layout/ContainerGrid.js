dojo.provide("calims2.inventory.layout.ContainerGrid");

dojo.require("dijit.form.CheckBox");
dojo.require("dijit.layout.ContentPane");
dojo.require("calims2.inventory.layout.CoordinateHelper");

dojo.declare(
    "calims2.inventory.layout.ContainerGrid",
    [dijit.layout.ContentPane],
    {
     coordinateHelper : new calims2.inventory.layout.CoordinateHelper(),
     eventListener : {
       cellClick : function(selected, x, y, displayx, displayy) {
         console.debug("This is the default cellClick");
         console.debug("selected = " + selected);
         console.debug("coordinates = " + x + "," + y);
         console.debug("display = " + displayx + "," + displayy);
       }
     }, 
     readOnly : false,
     xdimension : 1,
     ydimension : 1,
     xlabelType : "",
     ylabelType : "",
     buildTable : function() {
       var content = '<table class="centeredBlock containerGridTable">';
       content += '<tr><th></th>';
       for (var i = 0; i < this.xdimension; i++) {
         content += '<th class="headerCell">' + this.coordinateHelper.getCoordinateString(this.xlabelType, this.xdimension, i) + '</th>';
       } 
       content += '</th></tr>';
       for (var i = 0; i < this.ydimension; i++) {
         content += '<tr><th class="headerCell">'+ this.coordinateHelper.getCoordinateString(this.ylabelType, this.ydimension, i) + '</th>';
         for (var j = 0; j < this.xdimension; j++) {
           if (this.readOnly) {
             var name = "cell_" + this.id + '_' + j + '_' + i;
             content += '<td id="' + name + '">&nbsp;</td>'
           } else {
           var name = "check_" + this.id + '_' + j + '_' + i;
           var onclick = "dijit.byId('" + this.id + "').cellClick(this, " + j + "," + i + ")";
           content += '<td style="text-align:center; vertical-align:middle"><input id="' + name + '" name="' + name + '"  dojoType="dijit.form.CheckBox" onClick="' + onclick + '"/></td>';
           //content += '<td style="color:red" onClick="' + onclick + '" >&nbsp;</td>';
           }
         }
         content += '</tr>';
       }
       content += '</table>';
       return content;
     },
     rebuild : function(xdimension, ydimension, xlabelType, ylabelType, listener) {
       this.xdimension = xdimension;
       this.ydimension = ydimension;
       this.xlabelType = xlabelType;
       this.ylabelType = ylabelType;
       this.setContent(this.buildTable());
       this.eventListener = listener;
     },
     refresh : function(coordinates) {
       for (var i = 0; i < this.xdimension; i++) {
         for (var j = 0; j < this.ydimension; j++) {
           if (this.readOnly) {
             var nodeId = "cell_" + this.id + '_' + i + '_' + j;
             var node = dojo.byId(nodeId);
             node.innerHTML = "&nbsp";
             dojo.addClass(node, "uncheckedCell");
             dojo.removeClass(node, "checkedCell");
           } else {  
           var nodeId = "check_" + this.id + '_' + i + '_' + j;
           dijit.byId(nodeId).setValue(false);
           }
         }  
       } 
       for(var i = 0; i < coordinates.length; i++) {
         var coordinate = coordinates[i];
         var x = Number(coordinate.x);
         var y = Number(coordinate.y);
         if (this.readOnly) {
           var nodeId = "cell_" + this.id + '_' + x + '_' + y;
           var node = dojo.byId(nodeId);
           node.innerHTML = "" + (i + 1);
           dojo.addClass(node, "checkedCell");
           dojo.removeClass(node, "uncheckedCell");
         } else {  
         var nodeId = "check_" + this.id + '_' + coordinate.x + '_' + coordinate.y;
         dijit.byId(nodeId).setValue(true);
         var displayx = this.coordinateHelper.getCoordinateString(this.xlabelType, this.xdimension, x);
         var displayy = this.coordinateHelper.getCoordinateString(this.ylabelType, this.ydimension, y);
         this.eventListener.cellClick(true, x, y, displayx, displayy);
         }
       }  
     },  
     cellClick : function(element, x, y) {
       var selected = element.checked;
       var displayx = this.coordinateHelper.getCoordinateString(this.xlabelType, this.xdimension, x);
       var displayy = this.coordinateHelper.getCoordinateString(this.ylabelType, this.ydimension, y);
       this.eventListener.cellClick(selected, x, y, displayx, displayy);
     },
     clear : function() {
       this.setContent("");
     }  
    }
    );