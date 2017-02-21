'use strict';
//routes
angular.module('search', ['search.info','search.samples']).config(function($stateProvider, $urlRouterProvider) {
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
angular.module('search.samples', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.samples', {
        url: "/news",
        templateUrl: "app/search/samples.html",
        controller: "SearchSampleController"
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
    };

    $scope.openTaxonModal = function(taxon) {
        $uibModal.open({
            templateUrl:'/app/search/dialogs/taxon_modal.html',
            controller: function ($scope, $uibModalInstance, entity) {
                $scope.entity = entity;

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
}).controller('SearchSampleController', function($scope, SearchService){
    $scope.searchDefault = function() {
        SearchService.getSearch("sample").then(function(response) {
            $scope.samleSearch = response;
        });
    };

    $scope.searchDefault();

    $scope.search = function() {
        SearchService.sampleListSearch($scope.samleSearch);
    };

    // MUST be as CLASSIFIER but not hard coded
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}]

    $scope.toggle = function(state) {
        var i = $scope.samleSearch.dbs.indexOf(state);
        if (i > -1) {
            $scope.samleSearch.dbs.splice(i, 1);
        } else {
            $scope.samleSearch.dbs.push(state);
        }
    };
}).factory("SearchService", function($http, $q) {
    var apiUrl = '/search';
    var deferred = $q.defer();
    return {
        getSearch: function (searchName) {
            return $http.get(apiUrl + '/get-search', {params: {name: searchName}}).then(function(response) {
                return response.data;
            });
        },

        sampleListSearch: function (sampleSearch) {
            return $http.post(apiUrl + '/sample-list', sampleSearch).then(function(response) {
                return response.data;
            });
        },

        taxonListSearch: function () {
            return $http.get(apiUrl + '/taxon-list').then(function(response) {
                    return response.data;
            });
        },

        taxonSearch: function (val) {
            return $http.get(apiUrl + '/taxon', {params: {term: val}}).then(function (response) {
                return response.data.results;
            });
        }
    };
});