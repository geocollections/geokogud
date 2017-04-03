var module = angular.module("geoApp");

module.config(function($stateProvider,$urlRouterProvider) {
    $urlRouterProvider.when('/search', '/samples');
    $stateProvider.state('search', {
        url: "/search",
        templateUrl: "app/templates/main/partial/search.html"
    }).state('specimens', {
        url: "/specimens",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/specimen.html",
                controller: "SearchController as ctrl"
            }
        },
        params: {type: "specimens"}
    }).state('specimen.view', {
        url: "/specimen/:id",
        templateUrl: "app/templates/search/detail/specimen.html",
        controller: "DetailController as detailCtrl",
        params: {type: "specimens"}
    }).state('samples', {
        url: "/samples",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/samples.html",
                controller: "SearchController as ctrl"
            }
        },
        params: {type: "samples"}
    }).state('sample.view', {
        url: "/sample/:id",
        templateUrl: "app//templates/search/detail/sample.html",
        controller: "DetailController as detailCtrl",
        params: {type: "samples"}
    }).state('drillCores', {
        url: "/drillCores",
        views: {
            "specific-search": {
                templateUrl: "app//templates/search/drillCores.html",
                controller: "SearchController as ctrl"
            }
        },
        params: {type: "drillCores"}
    }).state('drillCores.view', {
        url: "/drillCores/:id",
        templateUrl: "app//templates/search/detail/drillCoreDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "drillCores"}
    }).state('localities', {
        url: "/localities",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/localities.html",
                controller: "SearchController as ctrl"
            }
        },
        params: {type: "localities"}
    }).state('locality.view', {
        url: "/locality/:id",
        templateUrl: "app/templates/search/detail/localityDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "localities"}
    }).state('references', {
        url: "/references",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/references.html",
                controller: "SearchController as ctrl"
            }
        },
        params: {type: "references",doi: false}
    }).state('references.view', {
        url: "/references/:id",
        templateUrl: "app/templates/search/detail/referenceDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "references",doi: false}
    }).state('stratigraphy', {
        url: "/stratigraphy",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/stratigraphy.html",
                controller: "SearchController as ctrl",
                params: {type: "stratigraphy"}
            }
        },
        params: {type: "stratigraphy"}
    }).state('stratigraphy.view', {
        url: "/stratigraphy/:id",
        templateUrl: "app/templates/search/detail/stratigraphy.html",
        controller: "DetailController as detailCtrl",
        params: {type: "stratigraphy"}
    }).state('analyses', {
        url: "/analyses",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/analyses.html",
                controller: "SearchController as ctrl"
            }
        },
        params: {type: "analyses"}
    }).state('preparations', {
        url: "/preparations",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/preparations.html",
                controller: "SearchController as ctrl",
                params: {type: "preparations"}
            }
        },
        params: {type: "preparations"}
    }).state('photoArchive', {
        url: "/photoArchive",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/photo_archive.html",
                controller: "SearchController as ctrl",
                params: {type: "photoArchive"}
            }
        },
        params: {type: "photoArchive"}
    }).state('photoArchive.view', {
        url: "/image/:id",
        templateUrl: "app/templates/search/detail/photo_archive.html",
        controller: "DetailController as detailCtrl",
        params: {type: "photoArchive"}
    }).state('soil', {
        url: "/soil",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/soil.html",
                controller: "SearchController as ctrl"
            }
        },
        params: {type: "soil"}
    }).state('soil.view', {
        url: "/soil/:id",
        templateUrl: "app/templates/search/detail/soilDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "soil"}
    }).state('doi', {
        url: "/doi",
        views: {
            "specific-search": {
                templateUrl: "app/templates/search/doi.html",
                controller: "SearchController as ctrl"
            }
        },
        params: {type: "doi"}
    }).state('doi.view', {
        url: "/doi/:id",
        templateUrl: "app/templates/search/detail/doiDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "doi"}
    })

    //main page
    .state('news', {
        url: "/news",
        views: {
            "additional": {
                templateUrl: "app/templates/main/news.html"
            }
        }

    }).state('map', {
        url: "/map",
        views: {
            "additional": {
                templateUrl: "app/templates/main/map.html"
            }
        }
    }).state('usingcollection', {
        url: "/usingcollection",
        views: {
            "additional": {
                templateUrl: "app/templates/main/using_collection.html"
            }
        }
    }).state('git', {
        url: "/git",
        views: {
            "additional": {
                templateUrl: "app/templates/main/git.html"
            }
        }
    }).state('geocollection', {
        url: "/geocollection",
        views: {
            "additional": {
                templateUrl: "app/templates/main/geocollection.html"
            }
        }
    }).state('database', {
        url: "/database",
        views: {
            "additional": {
                templateUrl: "app/templates/main/database.html"
            }
        }
    });
});
