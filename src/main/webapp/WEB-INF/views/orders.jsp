<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/index.jsp"/>
<jsp:include page="fragments/tableSetup.jsp"/>
<body>
<script type="text/javascript" src="resources/js/orders.js"></script>

<script>
    let orders =
    ${orderJson}
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
                    <input type="text" aria-label="Price from" placeholder="Price from" class="form-control">
                    <input type="text" aria-label="Price to" placeholder="to" class="form-control">
                </div>

                <div class="form-group row">
                    <input class="form-control" type="datetime-local" aria-label="Date from" id="dateFrom">

                    <input class="form-control" type="datetime-local" aria-label="Date to" id="dateTo">
                </div>
                <button type="button" id="search" class="btn btn-primary">Search</button>
            </div>
        </form:form>
    </div>


</div>
</body>
</html>
