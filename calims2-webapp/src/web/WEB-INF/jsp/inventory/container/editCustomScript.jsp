<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-require dojoType="calims2.inventory.layout.CoordinateHelper"/>
<ct:script src="${staticPath}/javascript/namingconvention/NameValidator.js"/>
<ct:script src="${staticPath}/javascript/inventory/quantity/QuantityValidator.js"/>

<ct:script>

  var namingConventions = ${namingConventions};
  var layoutMap = ${layoutMap};
  var containerLayoutMap = ${parentLayouts};
  
  dojo.addOnLoad(function() {
    var name = dijit.byId("name");
    var isTemplate = dijit.byId("isTemplate");
    var parentContainers = dijit.byId("parentContainers");
    var coordinateX = dijit.byId("coordinateX");
    var coordinateY = dijit.byId("coordinateY");
    var locations = dijit.byId("locations");
    var containerCategories = dijit.byId("containerCategories");
    var containerSubcategories = dijit.byId("containerSubcategories");
    var containerTypes = dijit.byId("containerTypes");
    var layouts = dijit.byId("layouts");
    
    var editMode = dojo.byId("editMode").value == "true";
    if (editMode) {
      isTemplate.set("readOnly", true);
      if (locations.get("value")) {
        dojo.addClass("coordinateX_row", "hidden");
        dojo.addClass("coordinateY_row", "hidden");
      }
      containerSubcategories.query = { "parentId" : "${form.entity.containerType.containerSubcategory.type.id}" };
      containerTypes.query = { "parentId" : "${form.entity.containerType.containerSubcategory.id}" };
      layouts.query = { "parentId" : "${form.entity.containerType.id}" };
    } else {
      dojo.addClass("coordinateX_row", "hidden");
      dojo.addClass("coordinateY_row", "hidden");
    }  
    parentContainers.query = { "template" : "" + isTemplate.checked };
    var updatable = dojo.byId("updatable").value == "true";
    if (!updatable) {
      name.set("readOnly", true);
      isTemplate.set("readOnly", true);
      parentContainers.set("readOnly", true);
      coordinateX.set("readOnly", true);
      coordinateY.set("readOnly", true);
      locations.set("readOnly", true);
      containerCategories.set("readOnly", true);
      containerSubcategories.set("readOnly", true);
      containerTypes.set("readOnly", true);
      layouts.set("readOnly", true);
    }
    
    // onChange of isTemplate flag
    dojo.connect(isTemplate, "onChange", function(newValue) {
      console.debug("isTemplate onChange");
      console.debug(newValue);
      var parentContainers = dijit.byId("parentContainers");
      parentContainers.set("value", "");
      parentContainers.query = { "template" : "" + isTemplate.checked };
    });
    
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
    
    // onChange of the categories
    dojo.connect(containerCategories, "onChange", function(newValue) {
      var containerSubcategories = dijit.byId("containerSubcategories");
      containerSubcategories.query = { "parentId" : newValue };
      containerSubcategories.setValue("");
      var containerTypes = dijit.byId("containerTypes");
      containerTypes.query = { "parentId" : "" };
      containerTypes.setValue("");
      var layouts = dijit.byId("layouts");
      layouts.query = { "parentId" : "" };
      layouts.setValue("");
    });
    
    // onChange of the subcategories
    dojo.connect(containerSubcategories, "onChange", function(newValue) {
      var containerTypes = dijit.byId("containerTypes");
      containerTypes.query = { "parentId" : newValue };
      containerTypes.setValue("");
      var layouts = dijit.byId("layouts");
      layouts.query = { "parentId" : "" };
      layouts.setValue("");
    });
    
    // onChange of the containerTypes
    dojo.connect(containerTypes, "onChange", function(newValue) {
      var layouts = dijit.byId("layouts");
      layouts.query = { "parentId" : newValue };
      containerTypesStore.fetchItemByIdentity({identity: newValue,
        onItem: function(item) {
          var layouts = dijit.byId("layouts");
          if (item.defaultLayoutId != "") {
            layouts.setValue(item.defaultLayoutId + "-" + item.id);
          } else {
            layouts.setValue("");
          }
        }
        });
    });
    
    name.validator = function(newValue, constraint) {
      console.debug("name.validator");
      return this.readOnly || !this._isEmpty(newValue) && nameValidator.validateInput(namingConventions, newValue, "global");
    };
    
    parentContainers.isValid = function(isFocused) {
      console.debug("parentContainers.isValid");
      console.debug("isFocused = " + isFocused);
      if (this.readOnly || this._isvalid) {
        return true;
      }
      var isTemplate = dijit.byId("isTemplate");
      var locations = dijit.byId("locations");
      if (isTemplate.checked || locations.get("value") != "") {
        return true;
      }
      return dijit.byId("parentContainers").get("value") != "";
    };
    
    coordinateX.validator = function(newValue, constraint) {
      console.debug("coordinateX.validator");
      if (this.readOnly) {
        return true;
      }
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
      if (this.readOnly) {
        return true;
      }
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
      if (this.readOnly || this._isvalid) {
        console.debug("_isvalid is true");
        return true;
      }
      var isTemplate = dijit.byId("isTemplate");
      var parentContainers = dijit.byId("parentContainers");
      if (isTemplate.checked || parentContainers.get("value") != "") {
        console.debug("return = true")
        return true;
      }
      var res = dijit.byId("locations").get("value") != "";
      console.debug("return = " + res);
      return res;
    };
    
  });
  
  function validateContainer(evt, currentForm) {
    var quantityValid = quantityValidator.validateQuantities();
    return currentForm.validate() && validateForm() && quantityValid;
  }
</ct:script>