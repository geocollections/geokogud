'use strict';

//routes
angular.module('main', ['main.info','main.news','main.map','main.geocollection',
'main.usingCollection', 'main.database','main.git','main.map']).config(function($stateProvider, $urlRouterProvider) {
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
angular.module('main.geocollection', []).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/main/geocollection', '/main/geocollection/list');
    $stateProvider.state('main.geocollection', {
        url: "/geocollection",
        template: '<data-ui-view/>',
    }).state('main.geocollection.list', {
        url: "/list",
        templateUrl: "app/main/geocollection.html",
        controller: "MainInfoController"
    });
});

//routes
angular.module('main.usingCollection', []).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/main/usingCollection', '/main/usingCollectionv/list');
    $stateProvider.state('main.usingCollection', {
        url: "/usingCollection",
        template: '<data-ui-view/>',
    }).state('main.usingCollection.list', {
        url: "/list",
        templateUrl: "app/main/usingCollection.html",
        controller: "MainInfoController"
    });
});

//routes
angular.module('main.git', []).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/main/git', '/main/git/list');
    $stateProvider.state('main.git', {
        url: "/git",
        template: '<data-ui-view/>',
    }).state('main.git.list', {
        url: "/list",
        templateUrl: "app/main/git.html",
        controller: "MainInfoController"
    });
});

//routes
angular.module('main.database', []).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/main/database', '/main/database/list');
    $stateProvider.state('main.database', {
        url: "/database",
        template: '<data-ui-view/>',
    }).state('main.database.list', {
        url: "/list",
        templateUrl: "app/main/database.html",
        controller: "MainInfoController"
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