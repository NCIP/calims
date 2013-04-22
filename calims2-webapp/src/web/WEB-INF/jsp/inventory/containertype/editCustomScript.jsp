<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:script>
  dojo.addOnLoad(function() {
    var containerCategories = dijit.byId("containerCategories");
    var containerSubcategories = dijit.byId("containerSubcategories");
    containerSubcategories.query = { "parentId" : containerCategories.getValue() };
    
    // onChange of the categories
    dojo.connect(containerCategories, "onChange", function(newValue) {
      var containerSubcategories = dijit.byId("containerSubcategories");
      containerSubcategories.query = { "parentId" : newValue };
      containerSubcategories.setValue("");
    });
    
    // onChange of the composition
    var compositionOnChange = function(newValue) {
      var composition = dijit.byId("composition").getValue();
      var composite = composition == "COMPOSITE";
      var childContainerType = dijit.byId("containerTypes");
      childContainerType.required = composite;
      if (childContainerType.required) {
        dojo.removeClass("containerTypes_row", "hidden");
        if (composite) {
          childContainerType.query = { "composition" : "SIMPLE" };
        } else {
          childContainerType.query = { "composition" : "*" };
        }
      } else {
        dojo.addClass("containerTypes_row", "hidden");
      }  
    };
    compositionOnChange.apply(this);
    var composition = dijit.byId("composition");
    dojo.connect(composition, "onChange", compositionOnChange);
  });
  
</ct:script>