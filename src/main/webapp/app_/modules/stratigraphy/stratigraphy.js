angular.module('search').controller('SearchStratigraphyController', function ($scope, StratigraphyService, $uibModal, $window) {
    $scope.isIdentifierFieldsCollapsed = false;

    $scope.departments = [
        {code: "GIT", label: "GIT"},
        {code: "TUG", label: "TUG"},
        {code: "ELM", label: "ELM"},
        {code: "TUGO", label: "TUGO"},
        {code: "MUMU", label: "MUMU"},
        {code: "EGK", label: "EGK"}];

    $scope.sortbyOptions = [
        {name: 'ID', value: 'id'},
        {name: 'Author', value: 'author'},
    ];
    $scope.stratigraphicSearch = {page: 1};

    $scope.showHint = function () {
        $scope.isHintHidden = !$scope.isHintHidden;
        $scope.getLocalities($scope.response.result);
    };

    $scope.search = function () {
        StratigraphyService.search($scope.stratigraphicSearch).then(function (result) {
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

    $scope.search();
}).controller('StratigraphyDetailsController', function ($scope, StratigraphyService, $http, $stateParams) {
    $scope.loadInfo = function () {
        StratigraphyService.details($stateParams.id).then(function (result) {
            $scope.stratigraphy = result.stratigraphy.result[0];
            console.log(result);
        });
    };
    $scope.loadInfo();
});