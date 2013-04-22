<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-require dojoType="dijit.layout.LayoutContainer" />
<ct:dojo-require dojoType="dijit.layout.ContentPane" />

<div class="header" dojoType="dijit.layout.LayoutContainer">
  <div class="noPaddingContentPane hdrBG" dojoType="dijit.layout.ContentPane" layoutAlign="top">   
    <div class="ncilogo">
      <a href="http://www.cancer.gov" target="_blank">
        <img alt="National Cancer Institute" src="${pageContext.request.contextPath}${staticPath}/images/logotype.gif" 
        width="283" height="37" border="0">
      </a>
    </div>
    <div class="nihtag">
      <a href="http://www.cancer.gov" target="_blank">
        <img alt="U.S. National Institutes of Health | www.cancer.gov" src="${pageContext.request.contextPath}${staticPath}/images/tagline.gif" 
        width="295" height="37" border="0">
      </a>
    </div>
  </div>
  <div class="noPaddingContentPane" dojoType="dijit.layout.ContentPane" layoutAlign="left">
    <div class="leftlogo">
      <a href="${pageContext.request.contextPath}/home/home.do">
        <img src="${pageContext.request.contextPath}${staticPath}/images/headerLeftLogo.jpg" alt="caLIMS2" />
      </a>
    </div>
  </div>
    
  <div class="noPaddingContentPane" dojoType="dijit.layout.ContentPane" layoutAlign="client">
  </div>
    
  <div class="noPaddingContentPane" dojoType="dijit.layout.ContentPane" layoutAlign="right">
    <div class="rightlogo">
      <a href="http://lpg.nci.nih.gov/" target="_blank">
        <img src="${pageContext.request.contextPath}${staticPath}/images/headerRightLogo.jpg" alt="caLIMS2" />
      </a>
    </div>
  </div>
</div>