'use strict';

//routes
angular.module('main', ['main.info','main.news']).config(function($stateProvider, $urlRouterProvider) {
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

angular.module('main').controller('MainInfoController', function(){
    console.log("MainInfoController");
}).controller('MainNewsController', function(){
    console.log("MainNewsController");
});