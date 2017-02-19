'use strict';

//routes
angular.module('main', ['main.info','main.news','main.map']).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/main', '/main/info');
    $stateProvider.state('main', {
        url: "/main",
        templateUrl: "app/main/index.html"
    });
});

//routes
angular.module('main.info', []).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/main/info', '/main/info/list');
    $stateProvider.state('main.info', {
        url: "/info",
        template: '<data-ui-view/>',
    }).state('main.info.list', {
        url: "/list",
        templateUrl: "app/main/info.html",
        controller: "MainInfoController"
    });
});

//routes
angular.module('main.news', []).config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when('/main/news', '/main/news/list');
    $stateProvider.state('main.news', {
        url: "/news",
        template: '<data-ui-view/>',
    }).state('main.news.list', {
        url: "/list",
        templateUrl: "app/main/news.html",
        controller: "MainNewsController"
    });

});

//routes
angular.module('main.map', []).config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.when('/main/map', '/main/map/list');
    $stateProvider.state('main.map', {
        url: "/map",
        template: '<data-ui-view/>',
    }).state('main.map.list', {
        url: "/list",
        templateUrl: "app/main/map.html",
        controller: "MainMapController"
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