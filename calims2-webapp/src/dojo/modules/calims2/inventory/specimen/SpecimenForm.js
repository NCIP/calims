dojo.provide("calims2.inventory.specimen.SpecimenForm");

dojo.declare(
    "calims2.inventory.specimen.SpecimenForm",
    null,
    { onLoadHandler : function() {
        var containerCategories = dijit.byId("containerCategories");
        var containerSubcategories = dijit.byId("containerSubcategories");
        var containerTypes = dijit.byId("containerTypes");
        var containers = dijit.byId("containers");
        var fillPatterns = dijit.byId("fillPatterns");
        
        containerSubcategories.query = { "parentId" : containerCategories.getValue() };
        containerTypes.query = { "parentId" : containerSubcategories.getValue() };
        containers.query = { "parentId" : containerTypes.getValue() };
        if (dojo.byId("editMode").value == "true") {
          fillPatterns.required = false;
          dojo.addClass("fillPatterns_row", "hidden");
        }
        
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
          var fillPatterns = dijit.byId("fillPatterns");
          fillPatterns.query = { "layoutId" : "" };
          fillPatterns.setValue("");
        });
        
        // onChange of the container subcategories
        dojo.connect(containerSubcategories, "onChange", function(newValue) {
          var containerTypes = dijit.byId("containerTypes");
          containerTypes.query = { "parentId" : newValue };
          containerTypes.setValue("");
          var containers = dijit.byId("containers");
          containers.query = { "parentId" : "" };
          containers.setValue("");
          var fillPatterns = dijit.byId("fillPatterns");
          fillPatterns.query = { "layoutId" : "" };
          fillPatterns.setValue("");
        });
        
        // onChange of the container Types
        dojo.connect(containerTypes, "onChange", function(newValue) {
          var containers = dijit.byId("containers");
          containers.query = { "parentId" : newValue };
          containers.setValue("");
          var fillPatterns = dijit.byId("fillPatterns");
          fillPatterns.query = { "layoutId" : "" };
          fillPatterns.setValue("");
        });
        
        // onChange of the containers
        dojo.connect(containers, "onChange", function(newValue) {
         if (newValue != "") {
           containersStore.fetchItemByIdentity({identity: newValue,
              onItem: function(item) {
                var fillPatterns = dijit.byId("fillPatterns");
                fillPatterns.required = item.composition[0] == 'COMPOSITE';
                if (fillPatterns.required) {
                  dojo.removeClass("fillPatterns_row", "hidden");
                  fillPatterns.query = { "layoutId" : item.layoutId[0] };
                  fillPatterns.setValue("");
                } else {
                  dojo.addClass("fillPatterns_row", "hidden");
                  fillPatterns.query = { "layoutId" : "" };
                  fillPatterns.setValue("");
                }
              }
              });
         } else {
           var fillPatterns = dijit.byId("fillPatterns");
           fillPatterns.required = false;
           dojo.addClass("fillPatterns_row", "hidden");
           fillPatterns.query = { "layoutId" : "" };
           fillPatterns.setValue("");
         }   
        });
      }
    });