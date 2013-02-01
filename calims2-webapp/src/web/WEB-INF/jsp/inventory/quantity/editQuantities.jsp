<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<c:forEach var="quantity" items="${quantities}" varStatus="status">
<c:set var="required" value="${quantity.type.status.name=='REQUIRED'}"/>
  <tr>
   <td class="fieldLabel"><label for="quantity_value_${status.index}"><c:out value="${quantity.type.displayName}" /><span class="requiredMarker${(required) ? '' : ' hidden'}">*</span></label></td>
   <td style="white-space:nowrap;">
     <ct:hidden id="quantity_typeId_${status.index}" name="quantities.typeIds[${status.index}]" value="${quantity.type.id}" />
     <ct:numberTextBox id="quantity_value_${status.index}" 
                       name="quantities.values[${status.index}]" 
                       numberType="decimal" 
                       promptKey="inventory.quantity.value.prompt" 
                       value="${quantity.value}"
                       required="${required}"
                       style="width:5em;"/>
     <ct:single-select id="quantity_unit_${status.index}" 
                       name="quantities.unitIds[${status.index}]" 
                       promptKey="inventory.quantity.unitSelectKey"
                       properties="id:id,label:displayName"
                       options="${standardUnits}"
                       required="${required}" 
                       selected="${quantity.standardUnit}" 
                       style="width:8em;"/>
   </td>
  </tr>
</c:forEach>
