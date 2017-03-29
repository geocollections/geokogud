'use strict';

//routes
angular.module('news', []).config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider.state('news', {
        url: "/news",
        views: {
            "additional": {
                templateUrl: "app/main/news.html"
            }
        }

    });
});
//routes
angular.module('map', []).config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider.state('map', {
        url: "/map",
        views: {
            "additional": {
                templateUrl: "app/main/map.html"
            }
        }
    });
});
//routes
angular.module('usingCollection', []).config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider.state('usingCollection', {
        url: "/usingCollection",
        views: {
            "additional": {
                templateUrl: "app/main/using_collection.html"
            }
        }
    });
});
//routes
angular.module('git', []).config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider.state('git', {
        url: "/git",
        views: {
            "additional": {
                templateUrl: "app/main/git.html"
            }
        }
    });
});
//routes
angular.module('geocollection', []).config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider.state('geocollection', {
        url: "/geocollection",
        views: {
            "additional": {
                templateUrl: "app/main/geocollection.html"
            }
        }
    });
});
//routes
    angular.module('database', []).config(function ($stateProvider, $urlRouterProvider) {
        $stateProvider.state('database', {
            url: "/database",
            views: {
                "additional": {
                    templateUrl: "app/main/database.html"
                }
            }
        });
    });

angular.module('main', []).controller('MainInfoController', function () {
    console.log("MainInfoController");
}).controller('MainNewsController', function () {
    console.log("MainNewsController");
}).controller('MainMapController', function () {
    console.log("MainMapController");
});
