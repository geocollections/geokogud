'use strict';
//routes
angular.module('search', ['search.info','search.news']).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/search', '/search/info');
    $stateProvider.state('search', {
        url: "/search",
        templateUrl: "app/search/index.html"
    });
});

//routes
angular.module('search.info', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.info', {
        url: "/info",
        templateUrl: "app/search/info.html",
        controller: "SearchInfoController"
    });
});

//routes
angular.module('search.news', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.news', {
        url: "/news",
        templateUrl: "app/search/news.html",
        controller: "SearchNewsController"
    });

});

angular.module('search').controller('SearchInfoController', function(SearchService, $scope, $uibModal){
    $scope.searchService = SearchService;

    $scope.seachTaxonomy = function(val) {
        $scope.hideFullList = false;
        SearchService.taxonListSearch(val).then(function(result) {
            $scope.taxonResult = result;
        });
    };
    $scope.seachTaxonomy();

    $scope.taxonSelected = function(item) {
        $scope.hideFullList = true;
        $scope.currenResult = item;
    }

    $scope.openTaxonModal = function(taxon) {
        $uibModal.open({
            templateUrl:'/app/search/dialogs/taxon_modal.html',
            controller: function ($scope, $uibModalInstance, entity) {
                $scope.entity = entity

                $scope.cancel = function () {
                    $uibModalInstance.dismiss();
                };
            },
            resolve: {
                entity: function () {
                    return angular.copy(taxon);
                }
            }
        });
    }
}).controller('SearchNewsController', function(){
    console.log("SearchNewsController");
}).factory("SearchService", function($http, $q) {
    var apiUrl = '/search';
    var deferred = $q.defer();
    return {
        taxonListSearch: function () {
            return $http.get(apiUrl + '/taxonList').then(function(response) {
                    return response.data;
            });
        },

        taxonSearch: function (val) {
            return $http.get(apiUrl + '/taxon', {
                params: {term: val}
            }).then(function (response) {
                return response.data.results;
            });
        }
    };

})