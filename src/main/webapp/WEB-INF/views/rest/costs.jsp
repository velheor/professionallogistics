<!DOCTYPE HTML>
<html>
<jsp:include page="../fragments/index.jsp"/>
<body ng-app="Prolog" ng-controller="CostController">
<script type="text/javascript" src="resources/js/costs.js"></script>
<table>
    <tr>
        <th>Cost amount</th>
        <th>Cost currency name</th>
    </tr>
    <!-- $scope.costs -->
    <tr ng-repeat="cost in costs">
        <td>{{ cost.amount }}</td>
        <td>{{ cost.currencyName }}</td>
        <td>{{ cost.order.truckCategory}}</td>
    </tr>
    <button ng-click="changeAllCostCurrency()">Change currency</button>

</table>
</body>
</html>