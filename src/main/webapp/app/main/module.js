'use strict';

//routes
angular.module('main', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('main', {
        url: "/info",
        templateUrl: "app/main/info.html"
    });
});

//routes
angular.module('news', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('news', {
        url: "/news",
        templateUrl: "app/main/news.html"
    });
});

//routes
angular.module('map', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('map', {
        url: "/map",
        templateUrl: "app/main/map.html"
    });
});

//routes
angular.module('locality', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('locality', {
        url: "/localityid",
        template: '<data-ui-view/>',
    }).state('locality.edit', {
        url: "/:id",
        templateUrl: "app/main/locality.html",
        controller: "LocalityController"
    });

});

angular.module('main').controller('MainInfoController', function(){
    console.log("MainInfoController");
}).controller('MainNewsController', function(){
    console.log("MainNewsController");
}).controller('MainMapController', function(){
    console.log("MainMapController");
}).controller('LocalityController', function( $stateParams, $http, $scope){
    console.log("LocalityController");

    $scope.loadLocalityInfo = function() {
        $http.get('/locality/' + $stateParams.id).success(function (loc) {
            $scope.locality = loc.results[0];
        });
    };
    $scope.loadLocalityInfo();

});