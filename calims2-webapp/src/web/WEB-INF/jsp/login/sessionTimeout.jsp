<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="pagePrefix" value="login.sessionTimeout." />
<html>
<head>
<title><fmt:message key="${pagePrefix}pageTitle" /></title>
</head>
<body>
  <h3><fmt:message key="${pagePrefix}error" /></h3>
  <div>
    <a href="${pageContext.request.contextPath}/login/login.do" >Login</a>
  </div>
</body>
</html>