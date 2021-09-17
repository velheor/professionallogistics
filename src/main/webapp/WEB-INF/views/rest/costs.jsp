<!DOCTYPE HTML>
<html>
<jsp:include page="../fragments/index.jsp"/>
<body ng-app="Prolog" ng-controller="CostController">
<script type="text/javascript" src="resources/js/root.js"></script>
<script type="text/javascript" src="resources/js/controllers/cost.js"></script>
<script type="text/javascript" src="resources/js/services/cost.js"></script>
<table>
    <tr>
        <th>Cost amount</th>
        <th>Cost currency name</th>
    </tr>
    <!-- $scope.costs -->
    <tr ng-repeat="cost in costs">
        <td>{{ cost.amount }}</td>
        <td>{{ cost.currencyName }}</td>
    </tr>
    <form ng-submit="changeAllCostCurrency(currencyName)">
        <input type="text" ng-model="currencyName"/>
        <button type="submit">Change currency</button>
    </form>

</table>
</body>
</html>