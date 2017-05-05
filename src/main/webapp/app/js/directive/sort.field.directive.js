angular.module('geoApp').directive('sortField', function () {
    return {
        restrict: 'AE',
        replace: true,
        template: '<a href data-ng-click="order(value)">' +
                    '<span>{{ name | translate}}</span>' +
                    '<span data-ng-show="$parent.searchParameters.sortField.sortBy == predicate && $parent.sortByAsc" class="glyphicon glyphicon-triangle-bottom"></span>' +
                    '<span data-ng-show="$parent.searchParameters.sortField.sortBy == predicate && !$parent.sortByAsc" class="glyphicon glyphicon-triangle-top"></span>' +
                  '</a>' ,
        scope: {
            name: '@',
            value: '@'

        },
        controller: ['$scope','$translate', function ($scope,$translate) {
            function localizePredicate(predicate) {
                var tokens = predicate.split(",");
                if(tokens.length == 0) return predicate;
                var value_et = tokens[0], value_en = tokens[1];

                return $translate.use() == 'et' ? value_et : value_en;
            }

            $scope.order = function (predicate) {
                $scope.predicate = predicate;
                predicate = localizePredicate(predicate);
                $scope.$parent.sortByAsc = ($scope.$parent.searchParameters.sortField.sortBy === predicate ? !$scope.$parent.sortByAsc : true);
                $scope.$parent.searchParameters.sortField.sortBy = predicate;
                !$scope.$parent.sortByAsc ? $scope.$parent.searchParameters.sortField.order = "ASCENDING" : $scope.$parent.searchParameters.sortField.order = "DESCENDING";
                $scope.$parent.searchParameters.page = 1;
                $scope.$parent.search();
            };
        }]
    }
});