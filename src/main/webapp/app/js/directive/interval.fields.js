angular.module('geoApp').directive('intervalField', function () {
    return {
        template: "<span class='col-md-6 form-group'><input type='number' ng-model='field.name' class='form-control'/></span>",
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
    };
}).directive('checkboxField', function () {
    return {
        template: "<label><input type='checkbox' data-ng-click='checked()' value='value' ng-model='field.name' data-ng-disabled='true'><span class=\"cr\"><i class=\"cr-icon glyphicon glyphicon-ok\"></i>" +
        "</span>{{ name | translate }}</label>",
        restrict: 'AE',
        scope: {
            field: '=?ngModel',
            name:'@'
        },
        controller: ['$scope', function ($scope) {
            $scope.field = {lookUpType : 'exact'};
            $scope.checked = function() {
                console.log($scope.field)
            }

        }]
    };
});