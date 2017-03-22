'use strict';

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
angular.module('usingCollection', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('usingCollection', {
                url: "/usingCollection",
        templateUrl: "app/main/using_collection.html"
      });
});
//routes
angular.module('git', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('git', {
                url: "/git",
        templateUrl: "app/main/git.html"
      });
});
//routes
angular.module('geocollection', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('geocollection', {
                url: "/geocollection",
        templateUrl: "app/main/geocollection.html"
      });
});
-//routes
angular.module('database', []).config(function($stateProvider, $urlRouterProvider) {
            $stateProvider.state('database', {
                    url: "/database",
                    templateUrl: "app/main/database.html"
           });
        });
//routes
angular.module('locality', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('locality', {
        url: "/locality",
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
})