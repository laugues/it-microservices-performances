'use strict';

angular.module('BalanceForms')
    .controller('EuInvoiceController', [
        '$scope',
        function ($scope) {
            $scope.apiTextColor = "green";
            console.log("Hello World  from EuInvoiceController!");
        }]);
