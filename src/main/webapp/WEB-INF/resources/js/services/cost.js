app.service('CostService', function () {
    this.changeAllCostCurrency = function (currencyNameTo, costs, rates) {
        costs.forEach(function(part, index, theArray) {
            let calculatedAmount = (theArray[index].amount * calculateExchangeRate(currencyNameTo, theArray[index].currencyName, rates)).toFixed(2);
            theArray[index].currencyName = currencyNameTo;
            theArray[index].amount = calculatedAmount;
        });
        return costs;
    }

    function calculateExchangeRate(currencyNameTo, currencyNameFrom, rates) {
        let exchangeRateTo = rates.get(currencyNameTo);
        let exchangeRateFrom = rates.get(currencyNameFrom);
        return (exchangeRateTo / exchangeRateFrom).toFixed(6)
    }
});