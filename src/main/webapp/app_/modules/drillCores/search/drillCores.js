angular.module('search').controller('SearchDrillCoresController', function ($scope, DrillCoreService, $uibModal, $window) {
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

    $scope.toggle = function (state) {
        var i = $scope.searchParameters.dbs.indexOf(state);
        if (i > -1) {
            $scope.searchParameters.dbs.splice(i, 1);
        } else {
            $scope.searchParameters.dbs.push(state);
        }
    };

    $scope.search = function () {
        DrillCoreService.search($scope.searchParameters).then(function (result) {
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

    $scope.searchDefault = function () {
        $scope.searchParameters = {sortField: {}, dbs: []};
        $scope.searchParameters.sortField.sortBy = "id";
        $scope.sortByAsc = true;
        $scope.search();
    };

    $scope.searchDefault();

    $scope.order = function (predicate) {
        $scope.sortByAsc = ($scope.searchParameters.sortField.sortBy === predicate ? !$scope.sortByAsc : true);
        $scope.searchParameters.sortField.sortBy = predicate;
        !$scope.sortByAsc ? $scope.searchParameters.sortField.order = "ASCENDING" : $scope.searchParameters.sortField.order = "DESCENDING";
        $scope.search();
    };

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
    }
}).controller('DrillCoreDetailsController', function ($scope, $stateParams, DrillCoreService) {
    $scope.drillCore = {};
    DrillCoreService.details($stateParams.id).then(function (result) {
        $scope.drillCore = result;
        console.log($scope.drillCore.drillcoreBoxes);
    });
}).factory("DrillCoreService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/drillcore', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function (id) {
            return $http.get('/details/drillcore/' + id)
                .then(function (response) {
                    return response.data;
                });
        }
    };
}])