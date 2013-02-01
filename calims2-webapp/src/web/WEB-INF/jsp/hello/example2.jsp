<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
result f submission: <br/>

<c:forEach var="name" items="${names}">
  ${name} <br/>
</c:forEach>