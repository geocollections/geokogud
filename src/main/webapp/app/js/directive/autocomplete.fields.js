angular.module('geoApp').directive('autocompleteField', function () {
    return {
        template: "<input type='text' class='form-control input-sm' data-ng-model='field' " +
        "placeholder='input search parameter...' " +
        "data-uib-typeahead='entity[localizedValue] for entity in factory.autocompleteSearch(table,$viewValue,localizedValue)' " +
        "data-typeahead-min-length='2' data-typeahead-on-select='entitySelected($item, $model)'/>",
        restrict: 'AE',
        scope: {
            table: '@',
            field: '=?ngModel',
            et: '@',
            en: '@'
        },
        controller: ['$scope','$rootScope', '$translate', 'ApplicationService', 'SearchFactory', function ($scope, $rootScope,
                                                                                                        $translate, ApplicationService, SearchFactory) {
            $scope.factory = SearchFactory;
            $scope.$watch('[et, en]', function(newValue) {
                if($scope.et != null && $scope.en != null) {
                    $scope.localizedValue = $translate.use() == 'et' ? newValue[0] : newValue[1];
                } else {
                    $scope.localizedValue = newValue[0] == null ? newValue[1] : newValue[0];
                }
            }, true);

            $rootScope.$on('$translateChangeSuccess', function() {
                if($scope.et != null && $scope.en != null) {
                    $scope.localizedValue = $translate.use() == 'et' ? $scope.et : $scope.en;
                } else {
                    $scope.localizedValue = $scope.et == null ? $scope.en : $scope.et;
                }
            });

            $scope.entitySelected = function (item) {
                $scope.field = item[$scope.localizedValue];
            };

        }]
    };
})