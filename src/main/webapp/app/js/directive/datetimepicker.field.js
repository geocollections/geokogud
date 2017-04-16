angular.module('geoApp').directive('commonDatetimepicker', function () {
    return {
        template: '<span class=\'col-md-6 form-group\'><input type=\"text\" class=\"form-control\" placeholder=\"\"' +
        ' data-ng-model=\"field.name\" data-uib-datepicker-popup=\"{{dateFormat}}\" ' +
        'data-is-open=\"fromDate.open\" data-datepicker-options=\"datePickerOptions\" ' +
        'data-ng-click=\"fromDate.open = true\"/></span> ',
        restrict: 'AE',
        scope: {
            field: '=?ngModel',
            lookup: '@'
        },
        controller: ['$scope', function ($scope) {
            $scope.$watch('field.name', function(newValue){
                if(newValue) $scope.field.lookUpType = $scope.lookup;
            });

        }]
    }
});