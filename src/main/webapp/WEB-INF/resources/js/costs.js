let app = angular.module("Prolog", []);

app.controller("CostController", function ($scope, $http) {
    $scope.costs = [];
    _getAll()

    function _getAll() {
        let method = "GET";
        let url = '/prolog/costs';

        $http({
            method: method,
            url: url,
        }).then(
            function (res) {
                $scope.costs = res.data;
            }
        );
    }

    $scope.changeAllCostCurrency = function() {

        let method = "GET";
        let url = '/prolog/costs/change/all';

        $http({
            method: method,
            url: url,
            params: {
                to: 'EUR'
            },
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(
            function (res) {
                $scope.costs = res.data;
            }
        );
    };
});