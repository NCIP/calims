<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-require dojoType="calims2.inventory.layout.CoordinateHelper"/>
<ct:script src="${staticPath}/javascript/namingconvention/NameValidator.js"/>

<jsp:include page="/WEB-INF/jsp/crud/edit.jsp"/>

<ct:script>

  var namingConventions = ${namingConventions};
  var layoutMap = ${layoutMap};
  var containerLayoutMap = ${parentLayouts};
  
  dojo.addOnLoad(function() {
      var parentContainers = dijit.byId("parentContainers");
      var coordinateX = dijit.byId("coordinateX");
      var coordinateY = dijit.byId("coordinateY");
      var locations = dijit.byId("locations");
      dojo.addClass("coordinateX_row", "hidden");
      dojo.addClass("coordinateY_row", "hidden");
      
      // onChange of parentContainers
    dojo.connect(parentContainers, "onChange", function(newValue) {
      console.debug("parentContainers onChange");
      console.debug(newValue);
      if (newValue) {
        dojo.removeClass("coordinateX_row", "hidden");
        dojo.removeClass("coordinateY_row", "hidden");
        dijit.byId("locations").set("value", "");
      } else {
        dojo.addClass("coordinateX_row", "hidden");
        dojo.addClass("coordinateY_row", "hidden");
      }
    });
    
    // onChange of locations
    dojo.connect(locations, "onChange", function(newValue) {
      console.debug("location onChange");
      console.debug(newValue);
      if (newValue) {
        dijit.byId("parentContainers").set("value", "");
        dijit.byId("coordinateX").set("value", "");
        dijit.byId("coordinateY").set("value", "");
        dojo.addClass("coordinateX_row", "hidden");
        dojo.addClass("coordinateY_row", "hidden");
      } 
    });
    
    parentContainers.isValid = function(isFocused) {
      console.debug("parentContainers.isValid");
      console.debug("isFocused = " + isFocused);
      if (this._isvalid) {
        return true;
      }
      var locations = dijit.byId("locations");
      if (locations.get("value") != "") {
        return true;
      }
      return dijit.byId("parentContainers").get("value") != "";
    };
    
    coordinateX.validator = function(newValue, constraint) {
      console.debug("coordinateX.validator");
      var parentContainerId = dijit.byId("parentContainers").get("value");
      if (parentContainerId != "") {
        var coordinateHelper = new calims2.inventory.layout.CoordinateHelper();
        var layoutId = containerLayoutMap[parentContainerId];
        var layout = layoutMap[layoutId];
        return !this._isEmpty(newValue) && coordinateHelper.validateCoordinate(layout.labelX, parseInt(layout.x, 10), newValue);
      } 
      return true;
    };
    
    coordinateY.validator = function(newValue, constraint) {
      console.debug("coordinateY.validator");
      var parentContainerId = dijit.byId("parentContainers").get("value");
      if (parentContainerId != "") {
        var coordinateHelper = new calims2.inventory.layout.CoordinateHelper();
        var layoutId = containerLayoutMap[parentContainerId];
        var layout = layoutMap[layoutId];
        return !this._isEmpty(newValue) && coordinateHelper.validateCoordinate(layout.labelY, parseInt(layout.y, 10), newValue);
      } 
      return true;
    };
    
    locations.isValid = function(isFocused) {
      console.debug("locations.isValid");
      console.debug("isFocused = " + isFocused);
      if (this._isvalid) {
        return true;
      }
      var parentContainers = dijit.byId("parentContainers");
      if (parentContainers.get("value") != "") {
        return true;
      }
      var res = dijit.byId("locations").get("value") != "";
      return res;
    };
      
    });

  function validateCopy(evt, currentForm) {
    return currentForm.validate() && validateForm();
  }
</ct:script>