'use strict';

//routes
angular.module('main', ['main.info','main.news','main.map','main.geocollection']).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/main', '/main/info');
    $stateProvider.state('main', {
        url: "/main",
        templateUrl: "app/main/index.html"
    });
});

//routes
angular.module('main.info', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('main.info', {
        url: "/info",
        templateUrl: "app/main/info.html",
        controller: "MainInfoController"
    });
});

//routes
angular.module('main.news', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('main.news', {
        url: "/news",
        templateUrl: "app/main/news.html",
        controller: "MainNewsController"
    });
});

//routes
angular.module('main.geocollection', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('main.geocollection', {
        url: "/geocollection",
        templateUrl: "app/main/geocollection.html",
        controller: "MainInfoController"
    });
});

//routes
angular.module('usingCollection', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('usingCollection', {
        url: "/usingCollection",
        templateUrl: "app/main/using_collection.html"
    });
});

//routes
angular.module('database', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('database', {
        url: "/database",
        templateUrl: "app/main/database.html"
    });
});

//routes
angular.module('main.map', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('main.map', {
        url: "/map",
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