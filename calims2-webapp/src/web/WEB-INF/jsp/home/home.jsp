<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page import="org.joda.time.DateTime" %>

<ct:dojo-require dojoType="dijit.layout.ContentPane"/>
<ct:dojo-require dojoType="dijit.layout.LayoutContainer"/>

<div dojoType="dijit.layout.LayoutContainer">

  <div dojoType="dijit.layout.ContentPane" layoutAlign="top">
    <tiles:insertDefinition name=".pageTitle"/>
  </div>
  
  <div dojoType="dijit.layout.ContentPane" layoutAlign="client">
  
    <div class="browsesearchwrapper">
      <div class="browseboxhome" style="margin-bottom: 20px">
       <h2 class="tanbar">caLIMS v2</h2>
        <div class="boxpad">
          <div class="odd">
                      <h3><fmt:message key="${pagePrefix}todayis"/> <joda:format value="<%=new DateTime() %>" style="S-"/></h3>
          </div>
          <div class="even">
                      <h3><fmt:message key="${pagePrefix}welcome"/> <c:out value="${person.givenName} ${person.familyName}"/></h3>
          </div>
          <div class="odd">
                       <h3><fmt:message key="${pagePrefix}yourcurrentprojects"/></h3>
          </div>
          <div class="even">
                      <h3><fmt:message key="${pagePrefix}laboratoryUpdates"/></h3>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>