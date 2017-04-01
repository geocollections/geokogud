angular.module('search').controller('SearchSpecimensController', function (SpecimenService, SearchService, $scope, $uibModal, $window) {
    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = true;
    $scope.isInstitutionsCollapsed = true;

    $scope.departments = [
        {code: "GIT", label: "GIT"},
        {code: "TUG", label: "TUG"},
        {code: "ELM", label: "ELM"},
        {code: "TUGO", label: "TUGO"},
        {code: "MUMU", label: "MUMU"},
        {code: "EGK", label: "EGK"}];

    $scope.specimensSearch = {};

    $scope.searchDefault = function (search) {
        $scope.sortByAsc = true;
        SpecimenService.search($scope.specimensSearch).then(function (search) {
            $scope.search();
        });
    };

    $scope.searchDefault();

    $scope.showHint = function () {
        $scope.isHintHidden = !$scope.isHintHidden;
        $scope.getLocalities($scope.response.result);
    };

    $scope.showMap = function () {
        $scope.isMapHidden = !$scope.isMapHidden;
        $scope.getLocalities($scope.response.result);
    };

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
        SpecimenService.search($scope.searchParameters).then(function (result) {
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
            if ($scope.isMapHidden) {
                $scope.getLocalities($scope.response.result);
            }
        });
    };

}).controller('SpecimenController', function ($scope, SearchService, $uibModal, $http, $stateParams) {
    $scope.loadInfo = function () {
        $http.get('/search/specimen/' + $stateParams.id).then(successCallback, errorCallback);
        function successCallback(response) {
            $scope.specimen = response.data.result[0];
        }

        function errorCallback(response) {
            $scope.specimen = "ehm, an error..";
        }
    };
    $scope.loadInfo();
});
