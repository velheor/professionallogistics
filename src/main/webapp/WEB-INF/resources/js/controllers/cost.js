app.controller("CostController", function ($scope, $http, CostService) {
    let rates = new Map();
    $scope.costs = [];

    _getAll();
    _getExchangeRate();

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

    function _getExchangeRate() {
        let method = "GET";
        let url = 'http://data.fixer.io/api/latest?access_key=706c24d1c5aa4201e00909c13506b5ba&format=1&base=EUR&symbols=EUR,BYN,RUB,USD';

        $http({
            method: method,
            url: url,
        }).then(
            function (res) {
                let currencies = Object.keys(res.data.rates);
                let exchangingRate = Object.values(res.data.rates);
                for (let i = 0; i < currencies.length; i++) {
                    rates.set(currencies[i], exchangingRate[i]);
                }
            }
        );
    }

    $scope.changeAllCostCurrency = function (currencyName) {
        $scope.costs = CostService.changeAllCostCurrency(currencyName, $scope.costs, rates)
    }
});