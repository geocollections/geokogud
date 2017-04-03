angular.module('search').controller('SearchSoilController', function ($scope, SoilService, $uibModal, $window) {
    $scope.isIdentifierFieldsCollapsed = false;

    $scope.showHint = function () {
        $scope.isHintHidden = !$scope.isHintHidden;
        $scope.getLocalities($scope.response.result);
    };

    $scope.showMap = function () {
        $scope.isMapHidden = !$scope.isMapHidden;
        $scope.getLocalities($scope.response.result);
    };

    $scope.searchParameters = {};

    $scope.getLocalities = function (list) {
        $scope.localities = [];
        if (list) {
            angular.forEach(list, function (el) {
                if (el.latitude != null && el.longitude != null)
                    $scope.localities.push({latitude: el.latitude, longitude: el.longitude})
            })
        }
        console.log($scope.localities);
        return $scope.localities;
    };

    $scope.search = function () {
        SoilService.search($scope.searchParameters).then(function (result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.windowWidth = "innerWidth" in window ? window.innerWidth : document.documentElement.offsetWidth;
            if ($scope.windowWidth > 400) {
                $scope.searchParameters.maxSize = 5;
            } else {
                $scope.searchParameters.maxSize = 2;
            }
            // Window resize event
            var w = angular.element($window);
            w.bind('resize', function () {
                $scope.windowWidth = "innerWidth" in window ? window.innerWidth : document.documentElement.offsetWidth;
                // Change maxSize based on window width
                /* if($scope.windowWidth > 1000) {
                 $scope.searchParameters.maxSize = 15;
                 } else if($scope.windowWidth > 800) {
                 $scope.searchParameters.maxSize = 10;
                 } else if($scope.windowWidth > 600) {
                 $scope.searchParameters.maxSize = 8;
                 } */
                if ($scope.windowWidth > 400) {
                    $scope.searchParameters.maxSize = 5;
                } else {
                    $scope.searchParameters.maxSize = 2;
                }
                $scope.$apply();
            });
            $scope.response = result;
            console.log($scope.response);
            if ($scope.isMapHidden) {
                $scope.getLocalities($scope.response.result);
            }
        });
    };
    $scope.search();
});