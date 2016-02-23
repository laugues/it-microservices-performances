'use strict';

angular.module('BalanceForms')
    .controller('ApiInvoiceController', [
        '$scope',
        function ($scope) {
            $scope.apiTextColor = "red";
            console.log("Hello World  from ApiInvoiceController!");
        }]);
