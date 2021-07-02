<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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

        <form:form method="POST" modelAttribute="orderFilter">
            <div class="col-lg-4 align-self-center">
                <div class="input-group">
                    <form:input type="text" path="priceFrom" placeholder="Price from" class="form-control"/>
                    <form:input type="text" path="priceTo" placeholder="to" class="form-control"/>
                </div>

                <div class="form-group row">
                    <form:input path="dateFrom" class="form-control" type="datetime-local"/>

                    <form:input path="dateTo" class="form-control" type="datetime-local"/>
                </div>
                <button type="submit" id="search" class="btn btn-primary">Search</button>
            </div>
        </form:form>
    </div>


</div>
</body>
</html>
