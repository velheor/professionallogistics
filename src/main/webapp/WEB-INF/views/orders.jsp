<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<jsp:include page="fragments/index.jsp"/>
<jsp:include page="fragments/tableSetup.jsp"/>
<body>
<script type="text/javascript" src="resources/js/orders.js"></script>

<script>
    let orders = ${orderJson};
</script>

<div class="container">

    <div class="row">
        <div class="col-lg-8">
            <table id="orderList" class="table table-striped table-bordered">
            </table>
        </div>
        <div class="col-lg-4 align-self-center">
            <form:form method="POST" modelAttribute="orderFilter">
                <div class="input-group mb-3">
                    <form:input type="text" path="priceFrom" placeholder="Price from" class="form-control"/>
                    <form:input type="text" path="priceTo" placeholder="to" class="form-control"/>
                </div>

                <div class="row mb-3">
                    <form:input path="dateFrom" class="form-control" type="datetime-local"/>
                </div>
                <div class="row mb-3">
                    <form:input path="dateTo" class="form-control" type="datetime-local"/>
                </div>

                <button type="submit" id="search" class="btn btn-primary btn-block">Search</button>
            </form:form>
        </div>
    </div>

</div>
</body>
</html>
