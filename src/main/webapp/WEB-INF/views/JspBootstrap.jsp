<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="index.jsp"/>
<jsp:include page="dataTable.jsp"/>
<body>
<div class="container">
    <table id="userList" class="table table-hover">
        <thead>
        <tr class="table-primary">
            <th scope="col">User ID</th>
            <th scope="col">First name</th>
            <th scope="col">Last name</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
            </tr>
        </c:forEach>
        </tbody>

        <tfoot>
        </tfoot>
    </table>
</div>
</body>
</html>
