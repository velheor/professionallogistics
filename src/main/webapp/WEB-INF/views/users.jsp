<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="fragments/index.jsp"/>
<body>
<div class="container">
    <button class="btn btn-primary" id="addRow">Add user</button>
    <table id="userList" class="table table-hover">
        <thead>
        <tr class="table-primary">
            <th scope="col">User ID</th>
            <th scope="col">First name</th>
            <th scope="col">Last name</th>
            <th scope="col">Functions</th>
        </tr>
        </thead>

        <tbody>

        </tbody>
    </table>

</div>
</body>
</html>
