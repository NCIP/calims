<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-require dojoType="dojo.data.ItemFileReadStore"/>
<ct:dojo-require dojoType="dijit.Tree"/>
<ct:dojo-require dojoType="dojo._base.html"/>

<fmt:message key="${pagePrefix}connector.invalid" var="connectorInvalid"/>
<fmt:message key="${pagePrefix}connector.prompt" var="connectorPrompt"/>
<c:set value="${pageContext.request.contextPath}${staticPath}/images/delete.png" var="deleteImage"/>
<fmt:message key="${pagePrefix}deleteTooltip" var="deleteTooltip"/>
<fmt:message key="${pagePrefix}operator.invalid" var="operatorInvalid"/>
<fmt:message key="${pagePrefix}operator.prompt" var="operatorPrompt"/>
<fmt:message key="${pagePrefix}value.prompt" var="valuePrompt"/>

<ct:script>
  var tree = ${tree};
  var rowCount = ${(empty rows) ? 0 : fn:length(rows) };
  var connectorData = ${connectors};
  var connectorStore = new dojo.data.ItemFileReadStore({data : connectorData});
  var connectorInvalid = "${connectorInvalid}";
  var connectorPrompt = "${connectorPrompt}";
  var deleteImage = "${deleteImage}";
  var deleteTooltip = "${deleteTooltip}";
  var operatorData = ${operators};
  var operatorStore = new dojo.data.ItemFileReadStore({data : operatorData});
  var operatorInvalid = "${operatorInvalid}";
  var operatorPrompt = "${operatorPrompt}";
  var valuePrompt = "${valuePrompt}";
  var formManager = {
  
      // Add a new clause at the end of the table
      addClause : function() {
        if (this.selectedPropertyItem && this.selectedPropertyItem.type) {
          this.createRow();
        }
      },
      
      // remove a clause from the table
      removeClause : function(evt) {
        console.debug("removeClause");
        var imgNode = evt.currentTarget;
        formManager.removeRow(imgNode.parentNode.parentNode);
      },
      
      // Create one row at the end of the table for the given property item
      createRow : function () {
        var tableBody = dojo.byId("clauseTableBody");
        if (tableBody.childElementCount > 0) {
          var rowId = tableBody.lastElementChild.id.substring(4);
          var connectorCell = tableBody.lastElementChild.lastElementChild;
          var connectorSelect = connectorCell.appendChild(document.createElement("div"));
          connectorSelect.id = "connector_" + rowCount;
          var connectorSelectWidget = new dijit.form.FilteringSelect({
            id : "connector_" + rowId,
            missingMessage : connectorInvalid,
            name : "connector[" + rowId + "]",
            promptMessage : connectorPrompt,
            required : true,
            store : connectorStore,
            searchAttr : "label"
            }, connectorSelect);
          dojo.addClass(connectorSelectWidget.domNode, "connector");  
        }
        var trNode = document.createElement("tr");
        trNode.id = "row_" + rowCount;
        var actionCell = trNode.appendChild(document.createElement("td"));
        var imgNode = actionCell.appendChild(document.createElement("img"));
        imgNode.class = "imageIcon";
        imgNode.src = deleteImage;
        imgNode.title = deleteTooltip;
        //imgNode.onclick = "formManager.removeClause(this);"; 
        dojo.connect(imgNode, "click", this.removeClause);
        
        var propertyName = (this.selectedPropertyItem.relationship) ? 
                            this.selectedPropertyItem.relationship + "." + this.selectedPropertyItem.name : 
                            this.selectedPropertyItem.name;
        var propertyCell = trNode.appendChild(document.createElement("td"));
        var propertyInput = document.createElement("input");
        propertyInput.id = "property_" + rowCount;
        propertyInput.name = "property[" + rowCount +"]";
        propertyInput.type = "hidden";
        propertyInput.value = propertyName;
        propertyCell.appendChild(propertyInput);
        
        var propertyTypeInput = document.createElement("input");
        propertyTypeInput.id = "propertyType_" + rowCount;
        propertyTypeInput.name = "propertyType[" + rowCount +"]";
        propertyTypeInput.type = "hidden";
        propertyTypeInput.value = this.selectedPropertyItem.type;
        propertyCell.appendChild(propertyTypeInput);
        
        propertyCell.appendChild(document.createTextNode(propertyName));
        
        var operatorCell = trNode.appendChild(document.createElement("td"));
        var operatorSelect = operatorCell.appendChild(document.createElement("div"));
        operatorSelect.id = "operator_" + rowCount;
        var operatorSelectWidget = new dijit.form.FilteringSelect({
          id : "operator_" + rowCount,
          missingMessage : operatorInvalid,
          name : "operator[" + rowCount + "]",
          promptMessage : operatorPrompt,
          store : operatorStore,
          searchAttr : "label"
          }, operatorSelect);
        dojo.addClass(operatorSelectWidget.domNode, "operator");
        
        var valueCell = trNode.appendChild(document.createElement("td"));
        var valueTextBox = valueCell.appendChild(document.createElement("div"));
        valueTextBox.id = "value_" + rowCount;
        var valueWidget = this.createValueWidget(this.selectedPropertyItem.type, valueTextBox);
        
        var connectorCell = trNode.appendChild(document.createElement("td"));
          
        tableBody.appendChild(trNode);
        rowCount++;
      },
      
      // Creates the widget that is used for the value based on the property type.
      createValueWidget : function(type, node) {
        console.debug(type);
        if (type == "boolean") {
        }
        var widget = new dijit.form.ValidationTextBox({
          id : "value_" + rowCount,
          maxLength : 100,
          name : "value[" + rowCount + "]",
          promptMessage : valuePrompt
          }, node);
        return widget;   
      },
      
      // Remove a row from the clause table
      // rowNode is the DOM node of the TR to remove
      removeRow : function(rowNode) {
        var cells = dojo.query("td", rowNode);
        if (cells[4].childElementCount > 0) {
          dijit.byNode(cells[4].firstElementChild).destroyRecursive();
        }
        dijit.byNode(cells[3].firstElementChild).destroyRecursive();
        dijit.byNode(cells[2].firstElementChild).destroyRecursive();
        var tableBody = dojo.byId("clauseTableBody");
        tableBody.removeChild(rowNode);
        if (tableBody.childElementCount > 0 && tableBody.lastElementChild.lastElementChild.firstElementChild) {
          dijit.byNode(tableBody.lastElementChild.lastElementChild.firstElementChild).destroyRecursive();
        }
      },
      
      // Create the entity tree for selection of clauses
      // entityName is the name of the entity selected
      createEntityTree : function(entityName) {
      var data = {"identifier" : "id",
                  "label" : "name"
                 };
      var subtree = tree.items[0];
      data.items = [this.searchTree(subtree, entityName)];         
      var store = new dojo.data.ItemFileReadStore({data : data});
      var model = new dijit.tree.TreeStoreModel({ store : store, query : { "name" :"*"}});  
      var oldTree = dijit.byId("entityTree");
      if (oldTree) {
        oldTree.destroyRecursive();
      }
      var newNode = document.createElement("div");
      newNode.id = "entityTree";
      var leftPanelNode = dojo.byId("leftPanel");
      leftPanelNode.appendChild(newNode);
      var treeWidget = new dijit.Tree({model:model}, "entityTree");
      dojo.connect(treeWidget, "onClick", formManager.selectedOnClick);
      },
      
      // search the tree for the subtree of the entity with the given name
      // tree is the whole entity tree
      // name is the name of the entity whose subtree is searched
      // returns the root of the entity subtree
      searchTree : function (tree, name) {
        if (tree.entity && tree.entity[0] == name) {
          return tree;
        }  
        var children = tree.children;
        if (children) {
          for (var i = 0; i < children.length; i++) {
            var child = children[i];
            var result = this.searchTree(child, name);
            if (result) {
              return result;
            }  
          }  
        }
        return null;  
     },  
    
    // event handler for the select main entity button click 
    selectMainEntity : function() {
      if (this.selectedItem && this.selectedItem.entity) {
        dojo.addClass(dojo.byId("tree"), "hidden");
        var selectEntityButton = dijit.byId("selectEntityButton");
        var changeEntityButton = dijit.byId("changeEntityButton");
        var entityNameInput = dojo.byId("entityNameInput");
        var entityName = dojo.byId("entityName");
        dojo.addClass(selectEntityButton.domNode, "hidden");
        dojo.removeClass(changeEntityButton.domNode, "hidden");
        entityNameInput.value = this.selectedItem.entity[0];
        entityName.innerHTML = this.selectedItem.name[0];
        this.createEntityTree(this.selectedItem.entity[0]);
        var addClauseButton = dijit.byId("addClauseButton");
        dojo.removeClass(addClauseButton.domNode, "hidden");
      }
    },
    
    // event handler for the change main entity button click 
    changeMainEntity : function() {
      console.debug("changeMainEntity");
      var selectEntityButton = dijit.byId("selectEntityButton");
      var changeEntityButton = dijit.byId("changeEntityButton");
      var entityNameInput = dojo.byId("entityNameInput");
      var entityName = dojo.byId("entityName");
      dojo.addClass(changeEntityButton.domNode, "hidden");
      dojo.removeClass(selectEntityButton.domNode, "hidden");
      entityNameInput.value = "";
      entityName.innerHTML = "";
      dijit.byId("entityTree").destroyRecursive();
      dojo.removeClass(dojo.byId("tree"), "hidden");
      var addClauseButton = dijit.byId("addClauseButton");
      dojo.addClass(addClauseButton.domNode, "hidden");
      var tableBody = dojo.byId("clauseTableBody");
      while (tableBody.childElementCount > 0) {
        this.removeRow(tableBody.lastElementChild);
      }
    },
    
    // event handler for click on an element of the main tree
    mainOnClick : function(item, node, event) {
      formManager.selectedItem = item;
    },
    
    // event handler for click on an element of the entity tree
    selectedOnClick : function(item, node, event) {
      formManager.selectedPropertyItem = item;
    }
  };
  
  dojo.addOnLoad(function() {
    var treeStore = new dojo.data.ItemFileReadStore({data : tree});
    var model = new dijit.tree.TreeStoreModel({ store : treeStore, query : { "name" :"*"}});   
    var treeWidget = new dijit.Tree({model:model}, "tree");
    dojo.connect(treeWidget, "onClick", formManager.mainOnClick);
    if (dojo.byId("entityNameInput").value != "") {
      formManager.createEntityTree(dojo.byId("entityNameInput").value);
      dojo.addClass(treeWidget.domNode, "hidden");
      dojo.query("img", "clauseTableBody").forEach(function(imgNode) {
         dojo.connect(imgNode, "click", formManager.removeClause);
        });
    } 
  });
  
  function validateQuery(evt, currentForm) {
    var entitySelected = dojo.byId("entityNameInput").value != "";
    return currentForm.validate() && validateForm() && entitySelected;
  }
  
</ct:script>
<div class="centeredBlock" dojoType="dijit.layout.LayoutContainer" style="height: 60%; width:100%;">
  <div id="leftPanel" dojoType="dijit.layout.ContentPane" layoutAlign="left" style="width:300px; overflow:auto">
    <div id="tree" class="${(not empty mainEntity) ? 'hidden' : ''}"></div>
  </div>
  
  <div dojoType="dijit.layout.ContentPane" layoutAlign="client" >
    <!-- <div id="mainEntityDiv">
    </div>  -->
    <div id="whereClauseDiv" style="height:auto; overflow:auto;">
      <table id="clauseTable" class="editQueryTable" border="0">
        <thead>
        <tr>
          <th colspan="2">
            
            <input id="entityNameInput" type="hidden" name="entityNameInput" value="${mainEntity.name}"/>
            <ct:button id="selectEntityButton" labelKey="${pagePrefix}button.selectEntity" 
                       name="selectEntity" type="button" styleClass="${(not empty mainEntity) ? 'hidden' : ''}">
              <script type="dojo/method" event="onClick" args="evt">
                  formManager.selectMainEntity();
              </script>
            </ct:button>
            <ct:button id="changeEntityButton" labelKey="${pagePrefix}button.changeEntity" 
                       name="changeEntity" type="button" styleClass="${(not empty mainEntity) ? '' : 'hidden'}">
              <script type="dojo/method" event="onClick" args="evt">
                  formManager.changeMainEntity();
              </script>
            </ct:button>
            </th>
            <th colspan="3"><h2>
              <span id="entityName"><ct:enum value="${mainEntity}"/></span></h2>
            </th>
        </tr>
          <tr>
            <th>&nbsp</th>
            <th><fmt:message key="${pagePrefix}propertyHeader"/></th>
            <th><fmt:message key="${pagePrefix}operatorHeader"/></th>
            <th><fmt:message key="${pagePrefix}valueHeader"/></th>
            <th><fmt:message key="${pagePrefix}connectorHeader"/></th>
          </tr>
        </thead>
        <tbody id="clauseTableBody">
          <c:forEach var="row" items="${rows}" varStatus="status">
            <tr id="row_${status.index}">
              <td><img class="imageIcon" src="${deleteImage}" title="${deleteTooltip}"/></td>
              <td><input type="hidden" name="property[${status.index}]" value="${row.propertyName}"/><input type="hidden" name="propertyType[${status.index}]" value="${row.propertyType}"/><c:out value="${row.propertyName}"/></td>
              <td><div class="operator" id="operator_${status.index}" dojoType="dijit.form.FilteringSelect" missingMessage="${operatorInvalid}" 
                       name="operator[${status.index}]" promptMessage="${operatorPrompt}" required="true" 
                       store="operatorStore" searchAttr="label" value="${row.operator}"></div></td>
              <td><div id="value_${status.index}" dojoType="dijit.form.ValidationTextBox" maxLength="100" name="value[${status.index}]" 
                       promptMessage="${valuePrompt}" value="${row.value}"></div></td>
              <c:choose>         
                <c:when test="${not status.last}">
                  <td><div class="connector" id="connector_${status.index}" dojoType="dijit.form.FilteringSelect" missingMessage="${connectorInvalid}" 
                       name="connector[${status.index}]" promptMessage="${connectorPrompt}" required="true" 
                       store="connectorStore" searchAttr="label" value="${row.connector}" ></div></td>
                </c:when>
                <c:otherwise><td></td></c:otherwise>       
              </c:choose>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
    <div>
      <ct:button id="addClauseButton" labelKey="${pagePrefix}button.addClause" 
                 name="addClause" type="button" styleClass="${(not empty mainEntity) ? '' : 'hidden'}">
        <script type="dojo/method" event="onClick" args="evt">
          formManager.addClause();
        </script>
      </ct:button>
      <fmt:message key="${pagePrefix}queryTip"/></th>
    </div>
  </div>
</div>