<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<jsp:include page="fragments/index.jsp"/>
<jsp:include page="fragments/tableSetup.jsp"/>
<body>
<script type="text/javascript" src="resources/js/users.js"></script>

<div class="container">
    <button class="btn btn-primary" id="submit">Submit form</button>
    <button class="btn btn-primary" id="addRow">Add user</button>
    <table id="userList" class="table table-striped table-bordered" style="width:100%"></table>
</div>
</body>
</html>