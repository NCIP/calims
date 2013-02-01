<%@ page pageEncoding="ISO-8859-1" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<c:set var="pagePrefix" scope="request"><tiles:getAsString name="pagePrefix"/></c:set>
<ct:page>
  <ct:page-title><fmt:message key="${pagePrefix}pagetitle" /></ct:page-title>
  <ct:meta httpEquiv="Content-Type" content="text/html; charset=UTF-8" />
  <ct:dojo-include config="parseOnLoad: true" />
  <ct:dojo-layer name="calims2/base.js" />
  <ct:dojo-require dojoType="dojo.parser" />
  <ct:dojo-require dojoType="dijit.layout.LayoutContainer" />
  <ct:dojo-require dojoType="dijit.layout.ContentPane" />
  <ct:style src="${dojoPath}/dijit/themes/${dojoTheme}/${dojoTheme}.css" />
  <ct:style src="${dojoPath}/dojo/resources/dojo.css" />
  <ct:style src="${dojoPath}/calims2/themes/main.css" />

<body id="bodyId" class="${dojoAccess} class="${dojoTheme}">
  <div class="loginLayoutContainer" dojoType="dijit.layout.LayoutContainer">
    <div class="headerPane" dojoType="dijit.layout.ContentPane" layoutAlign="top">
      <tiles:insertAttribute name="header" />
    </div>
    <div class="bodyPane" dojoType="dijit.layout.ContentPane" layoutAlign="client">
      <tiles:insertAttribute name="body" />
    </div>
    <div class="footerPane" dojoType="dijit.layout.ContentPane" layoutAlign="bottom">
        <tiles:insertAttribute name="footer" />
    </div> 
  </div>
</body>
</ct:page>
