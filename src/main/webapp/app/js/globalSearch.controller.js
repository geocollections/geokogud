var module = angular.module("geoApp");

var constructor = function (configuration, $translate, $http, applicationService, $state, $stateParams, $scope, $rootScope, WebPagesFactory, GlobalSearchFactory) {

    $scope.amountOfResults = {
        "specimen": [],
        "sample": [],
        "drillcore": [],
        "locality": [],
        "reference": [],
        "stratigraphy": [],
        "analysis": [],
        "preparation": [],
        "image": [],
        "soil_site": [],
        "doi": []
    };
    $scope.currentTab = "";

    $scope.searchGlobally = function () {
        console.log($stateParams.query);
        GlobalSearchFactory.searchGlobally(
            $stateParams.query,
            function (result) {
                alert(JSON.stringify(result.data, null, "    "));
            }
        );
    };

    $scope.selectTab = function(tabTitle) {
        $scope.currentTab = tabTitle;
    };

    $scope.getSelectedTabPartial = function() {

    };

    $scope.searchGlobally();
};

constructor.$inject = ["configuration", '$translate', '$http', 'ApplicationService', '$state', '$stateParams', '$scope', '$rootScope', 'WebPagesFactory', 'GlobalSearchFactory'];

module.controller("GlobalSearchController", constructor);
