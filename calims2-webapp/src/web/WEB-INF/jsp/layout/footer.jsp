<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>

<ct:dojo-require dojoType="dijit.layout.LayoutContainer" />
<ct:dojo-require dojoType="dijit.layout.ContentPane" />

<div class="footer" dojoType="dijit.layout.LayoutContainer">
  <div class="noPaddingContentPane" dojoType="dijit.layout.ContentPane" layoutAlign="top">  
     <div class="footerwrapper">
       <div class="footernavwrapper">
          <div class="footernav">
              <a href="https://wiki.nci.nih.gov/display/caLIMS2/Contact+Us;jsessionid=1D45E2E3EA59DD2E1CED908A7BF022B0">CONTACT US</a>
              <a href="http://www.nih.gov/about/privacy.htm" target="_blank">PRIVACY NOTICE</a>
              <a href="http://www.nih.gov/about/disclaim.htm" target="_blank">DISCLAIMER</a>
              <a href="http://www3.cancer.gov/accessibility/nci508.htm" target="_blank">ACCESSIBILITY</a>
              <a href="http://ncicb.nci.nih.gov/NCICB/support" target="_blank" class="last">APPLICATION SUPPORT</a>
          </div>
      </div>
    </div>
  </div>
  
  <div class="noPaddingContentPane logocenter" dojoType="dijit.layout.ContentPane" layoutAlign="client">
    <a href="http://www.cancer.gov/" target="_blank">
      <img src="${pageContext.request.contextPath}${staticPath}/images/footer_nci.gif" alt="National Cancer Institute" border="0">
    </a> 
    <a href="http://www.dhhs.gov/" target="_blank">
      <img src="${pageContext.request.contextPath}${staticPath}/images/footer_hhs.gif" alt="Department of Health and Human Services" border="0">
    </a> 
    <a href="http://www.nih.gov/" target="_blank">
      <img src="${pageContext.request.contextPath}${staticPath}/images/footer_nih.gif" alt="National Institutes of Health" border="0">
    </a>
    <a href="http://www.usa.gov/" target="_blank">
      <img src="${pageContext.request.contextPath}${staticPath}/images/footer_usagov.gif" alt="USAGov.gov" border="0">
    </a>
  </div>
</div>