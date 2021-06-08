<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<jsp:include page="fragments/index.jsp"/>
<jsp:include page="fragments/tableSetup.jsp"/>
<body>
<script type="text/javascript" src="resources/js/orders.js"></script>

<script>
    let orders = ${orderJson}
</script>

<div class="container">

    <table id="orderList" class="table table-striped table-bordered" style="width:100%">
    </table>

</div>
</body>
</html>
