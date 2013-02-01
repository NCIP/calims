<%@ tag import="gov.nih.nci.calims2.uic.descriptor.form.BaseField" %>
<%@ tag import="gov.nih.nci.calims2.uic.descriptor.form.NumberField" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<%@ attribute name="field" required="true" type="gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement" description="The field descriptor" %>
<%@ attribute name="keyPrefix" required="true" type="java.lang.String" description="The prefix for all the keys used" %>

<jsp:useBean id="field" type="gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement" scope="page" />

<c:if test="${field.type.name != 'HIDDEN'}">
  <c:choose>
   <c:when test="${not empty field.disabled}">
    <ct:expression name="disabled" expectedType="java.lang.Boolean" expression="${field.disabled}"/>
   </c:when>
   <c:otherwise>
     <c:set var="disabled" value="${false}" scope="page"/>
   </c:otherwise> 
  </c:choose>
  
  <c:if test="${field.invalidMessage}">
    <c:set var="invalidKey" value="${keyPrefix}${field.id}.invalid" scope="page"/>
  </c:if>
  
  <c:choose>
   <c:when test="${not empty field.readOnly}">
    <ct:expression name="readOnly" expectedType="java.lang.Boolean" expression="${field.readOnly}"/>
   </c:when>
   <c:otherwise>
     <c:set var="readOnly" value="${false}" scope="page"/>
   </c:otherwise> 
  </c:choose>
</c:if>

<c:if test="${field.type.name == 'CHECKBOX' || field.type.name == 'DATE' || field.type.name == 'HIDDEN' || field.type.name == 'NUMBER' || field.type.name == 'TEXT' || field.type.name == 'TEXTAREA'}">
  <c:if test="${not empty field.value}">
    <ct:expression name="value" expectedType="java.lang.Object" expression="${field.value}"/>
  </c:if>
</c:if>

<c:if test="${field.type.name == 'MULTI_SELECT' || field.type.name == 'SELECT' || field.type.name == 'SINGLE_SELECT'}">
  <ct:expression name="options" expectedType="java.util.Collection" expression="${field.options}"/>
  <c:if test="${not empty field.optionCreatorCallback}">
    <ct:expression name="optionCreatorCallback" expectedType="gov.nih.nci.calims2.uic.select.OptionCreatorCallback" expression="${field.optionCreatorCallback}"/>
  </c:if>
  <c:if test="${field.type.name != 'SINGLE_SELECT' && not empty field.selectKey}">
    <c:set var="selectKey" value="${keyPrefix}${field.selectKey}" />
  </c:if>
</c:if>

<c:choose>
  <c:when test="${field.type.name == 'CHECKBOX'}">
    <ct:button
             checked="${value}" 
             disabled="${disabled}"
             id="${field.id}" 
             name="${field.name}"           
             readOnly="${readOnly}"            
             style="${field.style}"
             styleClass="${field.styleClass}"
             tabIndex="<%=((BaseField)field).getTabIndex()%>"
             type="checkbox"
             value="true" />
  </c:when>
  
  <c:when test="${field.type.name == 'DATE'}">
    <ct:date 
             disabled="${disabled}"
             formatLength="${field.formatLength}" 
             id="${field.id}" 
             invalidKey="${invalidKey}" 
             name="${field.name}"
             pattern="${field.pattern}" 
             promptKey="${keyPrefix}${field.id}.prompt" 
             readOnly="${readOnly}" 
             required="${field.required}" 
             style="${field.style}"
             styleClass="${field.styleClass}"
             tabIndex="<%=((BaseField)field).getTabIndex()%>"
             value="${value}" />
  </c:when>
  
  <c:when test="${field.type.name == 'FILE_INPUT'}">
    <ct:fileInput
                          disabled="${disabled}" 
                          id="${field.id}" 
                          invalidKey="${invalidKey}"
                          maxLength="${field.maxLength}"
                          name="${field.name}" 
                          promptKey="${keyPrefix}${field.id}.prompt" 
                          readOnly="${readOnly}" 
                          required="${field.required}" 
                          style="${field.style}"
                          styleClass="${field.styleClass}"
                          tabIndex="<%=((BaseField)field).getTabIndex()%>" />
  </c:when>
  
  <c:when test="${field.type.name == 'HIDDEN'}">
    <ct:hidden id="${field.id}" name="${field.name}" value="${value}" />
  </c:when>
  
  <c:when test="${field.type.name == 'MULTI_SELECT'}">
    <ct:expression name="selected" expectedType="java.util.Collection" expression="${field.selected}"/>
    <ct:multi-select  
                     disabled="${disabled}"
                     id="${field.id}" 
                     name="${field.name}" 
                     readOnly="${readOnly}" 
                     required="${field.required}"
                     style="${field.style}"
                     styleClass="${field.styleClass}"
                     tabIndex="<%=((BaseField)field).getTabIndex()%>"
                     idProperty="${field.idProperty}" 
                     labelProperty="${field.labelProperty}" 
                     options="${options}" 
                     selectedOptions="${selected}" 
                     size="${(empty field.size) ? 5 : field.size}"
                     optionCreatorCallback="${optionCreatorCallback}" 
                     selectKey="${selectKey}"/>
  </c:when>
  
  <c:when test="${field.type.name == 'NUMBER'}">
    <ct:numberTextBox     constraints="${field.constraints}" 
                          disabled="${disabled}" 
                          id="${field.id}" 
                          invalidKey="${invalidKey}"
                          max="${field.max}"
                          maxLength="${field.maxLength}"
                          min="${field.min}"
                          name="${field.name}" 
                          numberType="${field.numberType}" 
                          pattern="${field.pattern}" 
                          places="<%=((NumberField)field).getPlaces() %>" 
                          promptKey="${keyPrefix}${field.id}.prompt" 
                          readOnly="${readOnly}" 
                          required="${field.required}" 
                          style="${field.style}"
                          styleClass="${field.styleClass}"
                          tabIndex="<%=((BaseField)field).getTabIndex()%>"
                          value="${value}"/>
  </c:when>
  
  <c:when test="${field.type.name == 'SINGLE_SELECT'}">
    <ct:expression name="selected" expectedType="java.lang.Object" expression="${field.selected}"/>
    <c:set var="invalidKey" value="${keyPrefix}${field.id}.invalid" /> 
    <ct:single-select  
               collectionType="${field.collectionType}"
               disabled="${disabled}"
               id="${field.id}" 
               invalidKey="${(field.required) ? invalidKey : ''}" 
               name="${field.name}" 
               promptKey="${keyPrefix}${field.id}.prompt" 
               readOnly="${readOnly}" 
               required="${field.required}"
               style="${field.style}"
               styleClass="${field.styleClass}"
               tabIndex="<%=((BaseField)field).getTabIndex()%>"
               properties="${field.properties}" 
               optionCreatorCallback="${optionCreatorCallback}"
               options="${options}" 
               selected="${selected}" 
               useDataStore="${field.useDataStore}"/>
  </c:when>
  
  <c:when test="${field.type.name == 'SELECT'}">
    <ct:expression name="selected" expectedType="java.lang.Object" expression="${field.selected}"/>
    <ct:select  
               disabled="${disabled}"
               id="${field.id}" 
               name="${field.name}" 
               readOnly="${readOnly}" 
               required="${field.required}"
               style="${field.style}"
               styleClass="${field.styleClass}"
               tabIndex="<%=((BaseField)field).getTabIndex()%>"
               idProperty="${field.idProperty}" 
               labelProperty="${field.labelProperty}" 
               options="${options}" 
               selectedOption="${selected}" 
               size="${(empty field.size) ? 1 : field.size}"
               optionCreatorCallback="${optionCreatorCallback}"
               selectKey="${selectKey}"/>
  </c:when>
  
  <c:when test="${field.type.name == 'TEXT'}">
    <ct:validationTextBox 
                          constraints="${field.constraints}" 
                          disabled="${disabled}" 
                          format="${field.format}" 
                          id="${field.id}" 
                          invalidKey="${invalidKey}"
                          maxLength="${field.maxLength}"
                          name="${field.name}" 
                          pattern="${field.pattern}" 
                          promptKey="${keyPrefix}${field.id}.prompt" 
                          readOnly="${readOnly}" 
                          required="${field.required}" 
                          style="${field.style}"
                          styleClass="${field.styleClass}"
                          tabIndex="<%=((BaseField)field).getTabIndex()%>" 
                          value="${value}"/>
  </c:when>
  <c:when test="${field.type.name == 'TEXTAREA'}">
    <ct:textarea disabled="${disabled}" 
                 id="${field.id}" 
                 name="${field.name}" 
                 readOnly="${readOnly}" 
                 style="${field.style}"
                 styleClass="${field.styleClass}"
                 tabIndex="<%=((BaseField)field).getTabIndex()%>"
                 value="${value}"/>
  </c:when>
</c:choose> 
