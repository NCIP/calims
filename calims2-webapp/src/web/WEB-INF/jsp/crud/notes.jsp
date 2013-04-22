<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>

<c:if test="${not form.viewMode}">
<table class="centeredBlock">
  <tr id="noteStatus_row">
    <td id="noteStatus_labelCell" class="fieldLabel">
      <label id="noteStatus_label" for="noteStatus">
        <fmt:message key="crud.notes.noteStatus" />
      </label>
    </td>
    <td id="noteStatus_fieldCell" class="fieldView">
      <ct:single-select id="noteStatus" collectionType="ENUMERATIONS" options="${noteStatuses}" name="newNoteStatus" 
                        promptKey="crud.notes.noteStatus.prompt" selected="${form.currentNoteStatus}"/>
    </td>
  </tr>
  
  <tr id="noteContent_row">
    <td id="noteContent_labelCell" class="fieldLabel">
      <label id="noteContent_label" for="noteContent">
        <fmt:message key="crud.notes.noteContent" />
      </label>
    </td>
    <td id="noteStatus_fieldCell" class="fieldView">
      <ct:textarea id="noteContent" name="newNote" />
    </td>
  </tr>
<table>
</c:if>

<table></table>

<c:if test="${not empty notes && fn:length(notes) > 0}">
  <div class="centeredBlock" dojoType="dijit.layout.LayoutContainer" style="height: 60%; width:70%;">
    <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
      <div class="centeredBlock" id="whereClauseDiv" style="height:auto; overflow:auto;">
        <table align="center" id="clauseTable" class="viewQueryTable" >
          <thead>
            <tr>
              <th colspan="4"><h1 align="center"><B>Notes<B></h1></th>
            </tr>
            <tr>
              <th><fmt:message key="crud.notes.noteContent"/></th>
              <th><fmt:message key="crud.notes.noteStatus"/></th>
              <th><fmt:message key="crud.notes.dateCreated"/></th>
              <th><fmt:message key="crud.notes.createdBy"/></th>
            </tr> 
          </thead>
          <tbody id="clauseTableBody">
            <c:forEach var="note" items="${notes}">
              <tr>
                <td><c:out value="${note.content}"/></td>
                <td><ct:enum value="${note.status}" /></td>
                <td><joda:format style="SS" value="${note.dateCreated}" /></td>
                <td><c:out value="${note.createdBy}"/></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</c:if>