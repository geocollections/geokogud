var module = angular.module("geoApp");

var constructor = function (configuration, $translate, $http, applicationService, $state, $stateParams, $scope, $rootScope, WebPagesFactory, GlobalSearchFactory) {

    $scope.searchResults = {
        "specimen": [],
        "sample": [],
        "locality": [],
        "reference": [],
        "stratigraphy": [],
        "image": [],
        "taxon": []
    };

    $scope.response = {
        results:[]
    };

    $scope.selectedTab = $stateParams.tab;

    $scope.searchGlobally = function () {
        console.log($stateParams.query);
        $scope.$parent.globalQuery = $stateParams.query;
        GlobalSearchFactory.searchGlobally(
            $stateParams.query,
            function (result) {
                result.data.forEach(function(response) {
                    $scope.searchResults[response.table] = response.results;
                    if(response.table == $scope.selectedTab) {
                        $scope.response.results = response.results;
                    }
                });
            }
        );
    };

    $scope.selectTab = function (tabTitle) {
        if(!tabTitle) {
            tabTitle = "specimen";
        }
        $state.go("global", {query: $stateParams.query, tab: tabTitle}, {location: "replace", inherit: false, notify: false});
        $stateParams.tab = tabTitle;
        $scope.selectedTab = tabTitle;
        $scope.response.results = $scope.searchResults[tabTitle];
    };

    $scope.getResultsLength = function(tab) {
        return $scope.searchResults[tab].length;
    };

    $scope.isTabActive = function(tab) {
        return tab == $scope.selectedTab;
    };

    $scope.searchGlobally();
    $scope.selectTab($stateParams.tab);
};

constructor.$inject = ["configuration", '$translate', '$http', 'ApplicationService', '$state', '$stateParams', '$scope', '$rootScope', 'WebPagesFactory', 'GlobalSearchFactory'];

module.controller("GlobalSearchController", constructor);
