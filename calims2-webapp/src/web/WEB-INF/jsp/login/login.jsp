<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.nci.nih.gov/calims2/tags" prefix="ct"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<ct:dojo-require dojoType="dijit.layout.LayoutContainer" />
<ct:dojo-require dojoType="dijit.layout.ContentPane" />

<div dojoType="dijit.layout.LayoutContainer">

  <div class="noPaddingContentPane pageTitle" dojoType="dijit.layout.ContentPane" layoutAlign="top">
      <fmt:message key="${pagePrefix}welcome" />
      <fmt:message key="${pagePrefix}helpurl" var="helpurl"/> 
      <div class="pagehelp">
          <a href="${(fn:startsWith(helpurl,'???'))?'':helpurl}" class="help" target="help">Help</a>
      </div>
  </div>

  <div class="noPaddingContentPane maincolumn" dojoType="dijit.layout.ContentPane" layoutAlign="left">
        <div class="maincolumn_inner">
          
        
          <div class="textcontent">
          
          <div class="loginbox">
            <div class="log_left">
            <form name="f" action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
              <div class="tit_txt">Login</div>
              <div class="loginForm_holder">
                <div class="log_hand1">
                  <div class="ip_holder">
                    <div class="lft_lab"><label for="j_username"><fmt:message key="${pagePrefix}username" /></label></div>
                    <div class="lft_rght"><input type="text" name="j_username" id="j_username" class="inputbox_bg" value=""></div>
                  </div>
                  
                  <div class="ip_holder">
                    <div class="lft_lab"><label for="j_password"><fmt:message key="${pagePrefix}password" /></label></div>
                    <div class="lft_rght"><input type="password" name="j_password" id="j_password" class="inputbox_bg" /></div>
                  </div>
                </div>
                <div><br/></div>
                <div class="log_hand_link">
                  <div class="lft_rght"><a href="#">Can't access your account?</a><br />
                  <a href="#">Request user account </a></div>
                  <div class="login_btn">
                    <input type="submit" value="<fmt:message key="${pagePrefix}button.login" />" class="loginbutton" />
                      </div>
                </div>
              </div>
              </form>
            </div>
            <div class="log_rght">  
          </div>
          </div>
          <p>caLIMS v2 is an open source basic Laboratory Information Management System which will support programmatic integration with caBIG® applications and services - for example caArray and caTissue. The caLIMS v2 core application will provide the functions needed for basic research laboratory operations. These include functions for managing users and groups, equipment, key reagents and supplies, specimens and their derivatives, laboratory workflow, experimental results, quality control, and reports.  An internal adaptive workflow engine will enable users to easily create new and/or modify existing laboratory 'template' workflows to fit the specific needs of their laboratories; in addition, these workflow templates can be shared with other caLIMS v2 instances. The core version caLIMS v2 application will support the generic molecular biology domain; however, the flexible design will enable later releases of caLIMS to be customized for additional specific domains, such as next generation sequencing, nanoparticle characterizations, model organism research, or proteomics, by the integration with existing caBIG® applications or the addition of new modules.</p>
          </div>
          
        </div>
      </div>
      <div class="noPaddingContentPane rightcolumn" dojoType="dijit.layout.ContentPane" layoutAlign="client">
        <div class="rightcolumn_inner">
          <div class="leftmodule">
            <h3 class="bluetitle">Features</h3>
            <div class="feat_list">
            <ul>
              <li><b>Administration Module</b>
              <ul><li>Manage Organizations/Laboratories, Persons/Contact Information/Roles, Collaborations</li>
                  <li>Manage Equipment/Software, Locations/Storage Space, Naming Conventions</li>
              </ul>
              </li>
              <li><b>Customer Service Module</b>
              <ul><li>Manage Customer Requests/Accounts/Billing</li>
                  <li>Manage Services/Service Items/Rates</li>
              </ul>
              </li>
              <li><b>Inventory Module</b>
              <ul><li>Manage Containers</li>
                  <li>Manage Specimens/Reagents/Lab Supplies</li>
              </ul>
              </li>
              <li><b>Report Module</b>
              <ul><li>Manage Queries/Searches</li>
                  <li>Manage Reports/Report Design</li>
              </ul>
              </li>
              <li><b>Workflow/Project Module (not yet completed)</b>
              <ul><li>Manage Project/Experiment/Procedure/Run</li>
                  <li>Manage Approvals</li>
                  <li>Manage Workflow</li>
              </ul>
              </li>
            </ul> 
            </div>
          </div>  
          <div id="newsflash" class="leftmodule">
            <h3 class="bluetitle" >Latest News</h3>
            <p>Work has completed for Construction phase 2 iteration 3 and phase 3 iteration 0.</p>
            <p>caLIMS v2.C3I0 milestone release will be available shortly.  This milestone release will contain the Administration, Customer Service, Inventory, and Report module functions.  Stay tuned for more information on the development schedule for the remaining Workflow/Project module.</p>  
            <p><A HREF="https://wiki.nci.nih.gov/x/2oMYAQ" target="_blank">Follow caLIMS v2 development progress on the caLIMS v2 wiki.</A></p>
            <p><A HREF="https://wiki.nci.nih.gov/x/xQKy" target="_blank"> Interested parties are invited to join the caLIMS v2 Development Working Group.</A></p>  
            <p><A HREF="https://wiki.nci.nih.gov/x/mZV-AQ">The caLIMS v2 development team welcome submission of laboratory experiment workflows.</A></p>
            <p><A HREF="https://wiki.nci.nih.gov/x/xQKy" target="_blank">DWG meeting notes and presentations are available.</A></p>
            <p><A HREF="https://wiki.nci.nih.gov/x/WQnDAQ" target="_blank">To contact the  caLIMS v2 project leads: </A></p>
          </div>
        </div>
      </div>
      </div>
   