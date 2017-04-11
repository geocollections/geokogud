angular.module('geoApp').directive('entityFieldName', function () {
    return {
        template: "{{name}}",
        restrict: 'AE',
        scope: {
            name: '=',
        },
        link: function (scope) {
        }
    };
}).directive('entityFieldValue', function () {
    return {
        template: '<span data-ng-if="!isDate(name) && !isUrl(name)">{{value}}</span>' +
                  '<span data-ng-if="isDate(name)">{{value | date:dateFormat}}</span>' +
                  '<span data-ng-if="isUrl(name)">' +
                    '<a href data-ng-click="openInNewWindow()" >{{value}}</a>'+
                  '</span>',
        restrict: 'AE',
        scope: {
            name: '=',
            value: '=',
            values: '='
        },
        controller: ['$scope','ApplicationService', 'configuration', '$stateParams', function ($scope, ApplicationService, configuration, $stateParams) {
            $scope.config = configuration.detailFieldsConfig[$stateParams.type];

            $scope.openInNewWindow = function() {
                ApplicationService.openInNewWindow({object: $scope.url.object, id: $scope.values[$scope.url.id]});
            };

            $scope.isDate = function(name) {
                return $scope.config.date.indexOf(name) > -1;
            };
            $scope.isUrl = function(name) {
                $scope.url = null;
                angular.forEach($scope.config.urls, function(url) {
                    if(url.value_et == name || url.value_en == name) {
                        $scope.url = url;
                    }
                });

                return $scope.url == null ? false : true;
            };

        }]
    };
});