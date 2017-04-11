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
});