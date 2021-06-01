<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<jsp:include page="fragments/index.jsp"/>
<jsp:include page="fragments/tableSetup.jsp"/>
<body>
<script type="text/javascript" src="resources/js/users.js"></script>
<script>
    let users = ${users};
</script>

<div class="container">

    <button class="btn btn-primary" id="addRow">Add user</button>

    <form:form method="POST" modelAttribute="users">
        <button class="btn btn-primary" id="submit" type="submit">Submit form</button>
        <table id="userList" class="table table-striped table-bordered" style="width:100%">
            <c:forEach items="${users}" var="contact" varStatus="status">
                <tr>
                    <td><input name="contacts[${status.index}].firstname" value="${contact.firstname}"/></td>
                    <td><input name="contacts[${status.index}].lastname" value="${contact.lastname}"/></td>
                    <td><input name="contacts[${status.index}].email" value="${contact.email}"/></td>
                    <td><input name="contacts[${status.index}].phone" value="${contact.phone}"/></td>
                </tr>
            </c:forEach>
        </table>
    </form:form>

</div>
</body>
</html>