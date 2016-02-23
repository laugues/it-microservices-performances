'use strict';

angular.module('BalanceForms')
    .controller('FrInvoiceController', [
        '$scope',
        function ($scope) {
            $scope.apiTextColor = "blue";
            console.log("Hello World  from FrInvoiceController!");
        }]);
