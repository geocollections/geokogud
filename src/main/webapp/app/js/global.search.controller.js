var module = angular.module("geoApp");

var constructor = function (configuration, $filter, $translate, $http, applicationService, $state, $stateParams, $scope,
                            $rootScope, WebPagesFactory, GlobalSearchFactory, bsLoadingOverlayService) {
    var vm = this;
    vm.service = applicationService;
    vm.searchLoadingHandler = bsLoadingOverlayService.createHandler({
        referenceId: "globalView"
    });


    $scope.searchResults = {
        "specimen": {},
        "sample": {},
        "locality": {},
        "reference": {},
        "stratigraphy": {},
        "image": {},
        "taxon": {}
    };
    addClientSorting();
    $scope.response = {
        results: [],
        related_data: {}
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
        if (!result.data) return;
        result.data.forEach(function (response) {
            $scope.searchResults[response.table] = response;
            if (response.table == $scope.selectedTab) {
                $scope.response.results = response.results;
                $scope.response.related_data = response.related_data;
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
        if (!tabTitle) {
            tabTitle = "specimen";
        }
        $state.go("global", {query: $stateParams.query, tab: tabTitle}, {location: "replace", inherit: false, notify: false});
        $stateParams.tab = tabTitle;
        $scope.selectedTab = tabTitle;
        $scope.response.results = $scope.searchResults[tabTitle].results;
        $scope.response.related_data = $scope.searchResults[tabTitle].related_data;
    };

    $scope.search = function () {
        console.log($scope.searchParameters.sortField.sortBy)
        $scope.response.results = $filter('orderBy')($scope.response.results,
            ($scope.searchParameters.sortField.order == 'DESCENDING' ? '-' : '') + $scope.searchParameters.sortField.sortBy);
    };
    $scope.getResultsLength = function (tab) {
        if ($scope.searchResults[tab].results != null) {
            return $scope.searchResults[tab].results.length;
        } else {
            return 0;
        }
    };

    $scope.isTabActive = function (tab) {
        return tab == $scope.selectedTab;
    };

    $scope.searchGlobally();
    $scope.selectTab($stateParams.tab);
};

constructor.$inject = ['configuration', '$filter', '$translate', '$http', 'ApplicationService', '$state', '$stateParams', '$scope',
    '$rootScope', 'WebPagesFactory', 'GlobalSearchFactory', 'bsLoadingOverlayService'];

module.controller("GlobalSearchController", constructor);
