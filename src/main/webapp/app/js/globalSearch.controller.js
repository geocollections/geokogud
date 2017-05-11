var module = angular.module("geoApp");

var constructor = function (configuration, $translate, $http, applicationService, $state, $stateParams, $scope,
                            $rootScope, WebPagesFactory, GlobalSearchFactory, bsLoadingOverlayService) {
    var vm = this;
    vm.service = applicationService;
    vm.searchLoadingHandler = bsLoadingOverlayService.createHandler({
        referenceId: "globalView"
    });


    $scope.searchResults = {
        "specimen": [],
        "sample": [],
        "locality": [],
        "reference": [],
        "stratigraphy": [],
        "image": [],
        "taxon": []
    };
    addClientSorting();
    $scope.response = {
        results:[]
    };

    $scope.selectedTab = $stateParams.tab;

    $scope.searchGlobally = function () {
        vm.searchLoadingHandler.start();
        $scope.$parent.globalQuery = $stateParams.query;
        GlobalSearchFactory.searchGlobally(
            $stateParams.query,
            onGlobalDataLoaded
        );
    };
    function onGlobalDataLoaded(result) {
        result.data.forEach(function(response) {
            $scope.searchResults[response.table] = response.results;
            if(response.table == $scope.selectedTab) {
                $scope.response.results = response.results;
            }
        });
        vm.searchLoadingHandler.stop();
    }
    function addClientSorting() {
        $scope.searchParameters = {
            sortField: {sortBy: "id", order: "DESCENDING"}
        };
        $scope.sortByAsc = true;
    }

    $scope.selectTab = function (tabTitle) {
        if(!tabTitle) {
            tabTitle = "specimen";
        }
        $state.go("global", {query: $stateParams.query, tab: tabTitle}, {location: "replace", inherit: false, notify: false});
        $stateParams.tab = tabTitle;
        $scope.selectedTab = tabTitle;
        $scope.response.results = $scope.searchResults[tabTitle];
    };

    $scope.search = function() {
        console.log($scope.response.results)
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

constructor.$inject = ["configuration", '$translate', '$http', 'ApplicationService', '$state', '$stateParams', '$scope',
    '$rootScope', 'WebPagesFactory', 'GlobalSearchFactory','bsLoadingOverlayService'];

module.controller("GlobalSearchController", constructor);
