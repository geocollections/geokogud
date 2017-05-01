var module = angular.module("geoApp");

var constructor = function (configuration, $translate, $http, applicationService, $state, $stateParams, $scope, $rootScope, WebPagesFactory, GlobalSearchFactory) {

    $scope.searchResults = {
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
        $stateParams.tab = tabTitle;
    };

    $scope.getSelectedTabPartial = function() {
        return "app/templates/search/"+$stateParams.tab+"/"+$stateParams.tab+"_results.html";
    };

    $scope.searchGlobally();
};

constructor.$inject = ["configuration", '$translate', '$http', 'ApplicationService', '$state', '$stateParams', '$scope', '$rootScope', 'WebPagesFactory', 'GlobalSearchFactory'];

module.controller("GlobalSearchController", constructor);
