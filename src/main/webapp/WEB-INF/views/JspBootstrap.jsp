<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: vladislav.atsman
  Date: 5/27/2021
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="index.jsp"/>
<body>
<div>
    <ul class="list-group">
        <c:forEach var="user" items="${users}">
            <p><c:out value="${user.firstName}"/></p>
            <p><c:out value="${user.lastName}"/></p>
        </c:forEach>
    </ul>
</div>
</body>
</html>
