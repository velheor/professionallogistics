<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:include page="fragments/index.jsp"/>

<html>
<body>
<script type="text/javascript" src="<c:url value="/resources/js/users.js" />"></script>

<div class="container">
    <button class="btn btn-primary" id="addRow">Add user</button>
    <table id="userList" class="table table-hover"></table>
</div>
</body>
</html>
