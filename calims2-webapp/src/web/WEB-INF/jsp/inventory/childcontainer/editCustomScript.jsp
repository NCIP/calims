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
  dojo.addOnLoad(function() {
    var containerCategories = dijit.byId("containerCategories");
    var containerSubcategories = dijit.byId("containerSubcategories");
    var containerTypes = dijit.byId("containerTypes");
    var layouts = dijit.byId("layouts");
    
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
  });
  
  var namingConventions = ${namingConventions};
  
  
  function validateContainer(evt, currentForm) {
    var nameValid = nameValidator.validateInput(namingConventions, dijit.byId("name").getValue(), "global");
   
    var quantityValid = quantityValidator.validateQuantities();
    return currentForm.validate() && validateForm() && nameValid && quantityValid;
  }
</ct:script>