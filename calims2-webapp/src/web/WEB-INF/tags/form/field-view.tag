<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>


<%@ attribute name="field" required="true" type="gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement" description="The field descriptor" %>
<%@ attribute name="keyPrefix" required="true" type="java.lang.String" description="The prefix for all the keys used" %>

<c:if test="${field.type.name == 'CHECKBOX' || field.type.name == 'DATE' || field.type.name == 'DATETIME' || field.type.name == 'NUMBER' || field.type.name == 'TEXT' || field.type.name == 'TEXTAREA'}">
  <c:if test="${not empty field.value}">
    <ct:expression name="value" expectedType="java.lang.Object" expression="${field.value}"/>
  </c:if>
</c:if>

<c:choose>
  <c:when test="${field.type.name == 'CHECKBOX'}">
    <c:out value="${value}" />
  </c:when>

  <c:when test="${field.type.name == 'DATE'}">
    <joda:format locale="<%=org.springframework.web.servlet.support.RequestContextUtils.getLocale(request) %>" style="S-" value="${value}" />
  </c:when>
  
  <c:when test="${field.type.name == 'DATETIME'}">
    <joda:format locale="<%=org.springframework.web.servlet.support.RequestContextUtils.getLocale(request) %>" style="SM" value="${value}" /><br/>
  </c:when>
  
  <c:when test="${field.type.name == 'MULTI_SELECT'}">
    <ct:expression name="selected" expectedType="java.util.Collection" expression="${field.selected}"/>
    <c:if test="${not empty field.optionCreatorCallback}">
      <ct:expression name="optionCreatorCallback" expectedType="gov.nih.nci.calims2.uic.select.OptionCreatorCallback" expression="${field.optionCreatorCallback}"/>
    </c:if>
    <ct:multi-select-view idProperty="${field.idProperty}" 
                          labelProperty="${field.labelProperty}" 
                          selectedOptions="${selected}" 
                          optionCreatorCallback="${optionCreatorCallback}"/>
  </c:when>
  
  <c:when test="${field.type.name == 'NUMBER'}">
    <c:if test="${not empty value}">
      <fmt:formatNumber groupingUsed="true" pattern="${field.pattern}" value="${value}" />
    </c:if>
  </c:when>
  
  <c:when test="${field.type.name == 'SELECT'}">
    <ct:expression name="selected" expectedType="java.lang.Object" expression="${field.selected}"/>
    <c:if test="${not empty field.optionCreatorCallback}">
      <ct:expression name="optionCreatorCallback" expectedType="gov.nih.nci.calims2.uic.select.OptionCreatorCallback" expression="${field.optionCreatorCallback}"/>
    </c:if>
    <ct:select-view idProperty="${field.idProperty}" 
                    labelProperty="${field.labelProperty}" 
                    selectedOption="${selected}" 
                    optionCreatorCallback="${optionCreatorCallback}"/>
  </c:when>
  
  <c:when test="${field.type.name == 'SINGLE_SELECT'}">
    <ct:expression name="selected" expectedType="java.lang.Object" expression="${field.selected}"/>
    <c:if test="${not empty field.optionCreatorCallback}">
      <ct:expression name="optionCreatorCallback" expectedType="gov.nih.nci.calims2.uic.select.OptionCreatorCallback" expression="${field.optionCreatorCallback}"/>
    </c:if>
    <ct:single-select-view collectionType="${field.collectionType}"
                           optionCreatorCallback="${optionCreatorCallback}"
                           properties="${field.properties}" 
                           selected="${selected}" />
  </c:when>
  
  <c:when test="${field.type.name == 'TEXT'}">
    <c:out value="${value}" />
  </c:when>
  
  <c:when test="${field.type.name == 'TEXTAREA'}">
    <c:out value="${value}" />
  </c:when>
  
</c:choose> 
