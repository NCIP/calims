<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<%@ attribute name="command" required="true" type="gov.nih.nci.calims2.uic.descriptor.command.Command" description="The command descriptor" %>
<%@ attribute name="keyPrefix" required="true" type="java.lang.String" description="The prefix for all the keys used" %>
<%@ attribute name="formId" required="true" type="java.lang.String" description="The id of the form" %>

<ct:button labelKey="${keyPrefix}button.${command.name}" 
           name="${command.name}" type="${command.type}">
  <script type="dojo/method" event="onClick" args="evt">
    <c:if test="${not empty command.url}">
      dojo.byId("${formId}").action = "${pageContext.request.contextPath}${command.url}";
    </c:if>
      dijit.byId("${formId}").validateFlag = ${command.validate};
    <c:if test="${not empty command.javascriptFunction}">
      ${command.javascriptFunction}(evt);
    </c:if>
  </script>
</ct:button>