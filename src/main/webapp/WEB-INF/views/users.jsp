<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<jsp:include page="fragments/index.jsp"/>
<jsp:include page="fragments/tableSetup.jsp"/>
<body>
<script type="text/javascript" src="resources/js/users.js"></script>
<script>
    let users = ${userJson};
</script>

<div class="container">

    <button class="btn btn-primary" id="addRow">Add user</button>

    <form:form method="POST" modelAttribute="userViewDtoForm">
        <button class="btn btn-primary" id="submit" type="submit">Submit form</button>
        <table id="userList" class="table table-striped table-bordered" style="width:100%">
        </table>
    </form:form>

</div>
</body>
</html>