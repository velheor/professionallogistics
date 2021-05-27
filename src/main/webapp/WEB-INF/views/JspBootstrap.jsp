<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="index.jsp"/>
<body>
<div>
    <ul class="list-group">
        <c:forEach var="user" items="${users}">
            <li class="list-group-item"><c:out value="${user.firstName}"/></li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
