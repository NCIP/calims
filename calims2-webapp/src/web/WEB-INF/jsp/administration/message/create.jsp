<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<ct:dojo-require dojoType="dijit.form.Textarea"/>
<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>

<ct:dojo-require dojoType="dijit.form.FilteringSelect"/>

<div dojoType="dijit.layout.LayoutContainer">

  <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
    <tiles:insertDefinition name=".pageTitle"/>
  </div>
  
  <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
    <c:if test="${not empty form.errorKey}">
      <fmt:message key="${pagePrefix}${form.errorKey}"/>
    </c:if>
    <ct:form id="messageForm" action="/administration/message/send.do">
      <table>
        <tr>
          <td><fmt:message key="${pagePrefix}to"/></td>
          <td><ct:multi-select name="contactInformationIds" options="${to}" selectedOptions="${form.contactInformations}"/></td>
        </tr>
        <tr>
          <td><fmt:message key="${pagePrefix}subject"/></td>
          <td><ct:validationTextBox name="subject" required="true" value="${form.subject}"/></td>
        </tr>
        <tr>
          <td><fmt:message key="${pagePrefix}message"/></td>
          <td><ct:textarea name="message" value="${form.message}" cols="80" rows="10" /></td>
        </tr>
      </table>
      <ct:button labelKey="${pagePrefix}button.send" name="send">
        <script type="dojo/method" event="onClick" args="evt">
          dojo.byId("messageForm").action = "${pageContext.request.contextPath}/administration/message/send.do";
          dijit.byId("messageForm").noValidationFlag = false;
        </script>
      </ct:button>
      <ct:button labelKey="${pagePrefix}button.cancel" name="cancel" >
        <script type="dojo/method" event="onClick" args="evt">
          dojo.byId("messageForm").action = "${pageContext.request.contextPath}/home/home.do";
          dijit.byId("messageForm").noValidationFlag = true;
        </script>
      </ct:button>
      
      <script type="dojo/method" event="onSubmit" args="evt">
        var currentForm = dijit.byId("messageForm");
        return currentForm.noValidationFlag || currentForm.validate();
      </script>
    </ct:form>
  </div>
</div>