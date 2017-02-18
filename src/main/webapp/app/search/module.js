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

angular.module('search').controller('SearchInfoController', function(SearchService, $scope, $http){
    $scope.seachTaxonomy = function(val) {
        SearchService.taxonomySearch(val).then(function(result) {
            $scope.taxonResult = result;
        });
    };
    $scope.seachTaxonomy();

}).controller('SearchNewsController', function(){
    console.log("SearchNewsController");
}).factory("SearchService", function($http) {
    var apiUrl = '/search';
    return {
        taxonomySearch: function () {
            return $http.get(apiUrl + '/taxon').then(function(response) {
                    return response.data;
            });
        }
    };

})