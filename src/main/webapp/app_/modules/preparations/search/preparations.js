angular.module('search').controller('SearchPreparationsController', function ($scope, PreparationService, $stateParams, $uibModal, $window) {
    $scope.isInstitutionsCollapsed = true;
    $scope.isIdentifierFieldsCollapsed = false;

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
        PreparationService.search($scope.searchParameters, $stateParams).then(function (result) {
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
        });
    };
    $scope.showHint = function () {
        $scope.isHintHidden = !$scope.isHintHidden;
        $scope.getLocalities($scope.response.result);
    };
    $scope.searchDefault = function () {
        $scope.searchParameters = {sortField: {}, dbs: []};
        $scope.searchParameters.sortField.sortBy = "id";
        $scope.sortByAsc = true;
        $scope.toggle("GIT");
        $scope.search();
    };
    $scope.searchDefault();

    $scope.order = function (predicate) {
        $scope.sortByAsc = ($scope.searchParameters.sortField.sortBy === predicate ? !$scope.sortByAsc : true);
        $scope.searchParameters.sortField.sortBy = predicate;
        !$scope.sortByAsc ? $scope.searchParameters.sortField.order = "ASCENDING" : $scope.searchParameters.sortField.order = "DESCENDING";
        $scope.search();
    };

}).controller('PreparationDetailsController', function ($scope, $stateParams, PreparationService) {
    PreparationService.details($stateParams).then(function (result) {
        console.log(result)
        $scope.preparation = result.preparation.result[0];
    });
}).factory("PreparationService", ['$http', function ($http) {
    return {
        search: function (searchParameters, params) {
            return $http.post('/search/preparation', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function (params) {
            return $http.get('/details/preparation/' + params.id)
                .then(function (response) {
                    return response.data;
                });
        }
    };
}]);