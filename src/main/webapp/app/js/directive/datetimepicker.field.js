angular.module('geoApp').directive('commonDatetimepicker', function () {
    return {
        template: '<input type=\"text\" class=\"form-control\" placeholder=\"\"' +
        ' data-ng-model=\"field.name\" data-uib-datepicker-popup=\"{{dateFormat}}\" ' +
        'data-is-open=\"fromDate.open\" data-datepicker-options=\"datePickerOptions\" data-ng-required=\"true\" ' +
        'data-ng-click=\"fromDate.open = true\"/> ',
        restrict: 'AE',
        scope: {
            field: '=?ngModel',
            lookup: '@'
        },
        controller: ['$scope', function ($scope) {
            $scope.$watch('field.name', function(newValue) {
                if(newValue && newValue!=null) {
                    console.log(newValue)
                    //$scope.field = {name : newValue.toString().split('T')[0], lookupType : 'exact'};
                    //$scope.dateField = new Date($scope.field.name);
                }

            })

        }]
    }
});