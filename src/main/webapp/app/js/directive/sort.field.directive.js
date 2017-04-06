angular.module('geoApp').directive('sortField', function () {
    return {
        restrict: 'AE',
        replace: true,
        template: '<a href data-ng-click="order(value)">' +
                    '<span>{{ name | translate}}</span>' +
                    '<span data-ng-show="$parent.searchParameters.sortField.sortBy == value && sortByAsc" class="glyphicon glyphicon-triangle-bottom"></span>' +
                    '<span data-ng-show="$parent.searchParameters.sortField.sortBy == value && !sortByAsc" class="glyphicon glyphicon-triangle-top"></span>' +
                  '</a>{{$parent.sortByAsc}}',
        scope: {
            name: '@',
            value: '@'

        },
        controller: ['$scope', function ($scope) {
            $scope.order = function (predicate) {
                $scope.sortByAsc = ($scope.$parent.searchParameters.sortField.sortBy === predicate ? !$scope.sortByAsc : true);
                $scope.$parent.searchParameters.sortField.sortBy = predicate;
                !$scope.sortByAsc ? $scope.$parent.searchParameters.sortField.order = "ASCENDING" : $scope.$parent.searchParameters.sortField.order = "DESCENDING";
                $scope.$parent.search();
            };
        }]
    }
});