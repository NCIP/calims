dojo.provide("calims2.inventory.specimen.TransferGrid");

dojo.require("dijit.layout.ContentPane");
dojo.require("dijit.Tooltip");
dojo.require("calims2.inventory.layout.CoordinateHelper");

dojo.declare(
    "calims2.inventory.specimen.TransferGrid",
    [dijit.layout.ContentPane],
    {
      coordinateHelper : new calims2.inventory.layout.CoordinateHelper(),
      eventListener : {
        cellClick : function(x, y, displayx, displayy) {
          console.debug("This is the default cellClick");
          console.debug("coordinates = " + x + "," + y);
          console.debug("display = " + displayx + "," + displayy);
        }
      }, 
      xdimension : 1,
      ydimension : 1,
      xlabelType : "",
      ylabelType : "",
      specimens : [],
      buildTable : function() {
        var toolTips = '';
        var content = '<table class="centeredBlock transferGridTable">';
        content += '<tr><th></th>';
         for (var i = 0; i < this.xdimension; i++) {
           content += '<th class="headerCell">' + this.coordinateHelper.getCoordinateString(this.xlabelType, this.xdimension, i) + '</th>';
         } 
         content += '</th></tr>';
         for (var i = 0; i < this.ydimension; i++) {
           var yLabel = this.coordinateHelper.getCoordinateString(this.ylabelType, this.ydimension, i);
           content += '<tr><th class="headerCell">'+ yLabel + '</th>';
           for (var j = 0; j < this.xdimension; j++) {
             var nodeId = "cell_" + this.id + '_' + j + '_' + i;
             var coordinate = j + '_' + i;
             var specimen = this.specimens[coordinate];
             var className = (specimen) ? "checkedCell" : "uncheckedCell";
             var xLabel = this.coordinateHelper.getCoordinateString(this.xlabelType, this.xdimension, j);
             var toolTipLabel = xLabel + yLabel;
             if (specimen) {
               toolTipLabel += ' : ' + specimen.name;
             } 
             toolTips += '<div dojoType="dijit.Tooltip" connectId="' + nodeId + '">' + toolTipLabel + '</div>';
             var onclick = "dijit.byId('" + this.id + "').cellClick(" + j + "," + i + ")";
             content += '<td id="' + nodeId + '" class="' +className+ '" onClick="' + onclick + '" >&nbsp;</td>';
           }
           content += '</tr>';
         }
         content += '</table>';
         content += toolTips;
         return content;
       },
       rebuild : function(xdimension, ydimension, xlabelType, ylabelType, specimens, listener) {
         this.xdimension = xdimension;
         this.ydimension = ydimension;
         this.xlabelType = xlabelType;
         this.ylabelType = ylabelType;
         this.specimens = specimens;
         this.setContent(this.buildTable());
         this.eventListener = listener;
       },
       cellClick : function(x, y) {
         var displayx = this.coordinateHelper.getCoordinateString(this.xlabelType, this.xdimension, x);
         var displayy = this.coordinateHelper.getCoordinateString(this.ylabelType, this.ydimension, y);
         this.eventListener.cellClick(x, y, displayx, displayy);
       },
       highlight : function(x, y, highlight) {
         var nodeId = "cell_" + this.id + '_' + x + '_' + y;
         var coordinate = x + '_' + y;
         var specimen = this.specimens[coordinate];
         var className = (specimen) ? "checkedCell" : "uncheckedCell";
         if (highlight) {
           dojo.removeClass(nodeId, className);
           dojo.addClass(nodeId, "highlightedCell");
         } else {
           dojo.removeClass(nodeId, "highlightedCell");
           dojo.addClass(nodeId, className);
         }  
       },
       highlighted : function(x, y) {
         var nodeId = "cell_" + this.id + '_' + x + '_' + y;
         return dojo.hasClass(nodeId, "highlightedCell");
       }  
    });