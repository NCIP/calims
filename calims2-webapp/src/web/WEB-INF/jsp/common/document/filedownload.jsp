<%--L
  Copyright Moxie Informatics.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/calims/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<tr id="filedownload_row">
   <td id="filedownload_labelCell" class="fieldLabel">
        <label id="filedownload_label" for="filedownload">
             <fmt:message key="common.document.documentForm.filedownload" />
        </label>
    </td>
    <td id="filedownload_fieldCell" class="fieldView">
          <a href="${pageContext.request.contextPath}/common/document/download.do?id=${form.entity.id}"><fmt:message key="common.document.documentForm.downloadlink"/></a>
    </td>
</tr>