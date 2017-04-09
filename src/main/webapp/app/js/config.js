var module = angular.module("geoApp");

module.config(function($stateProvider,$urlRouterProvider) {
    $urlRouterProvider.when('/search', '/sample');
    $stateProvider.state('search', {
        url: "/search",
        views: {
            "specific-search": {
                templateUrl: "app/templates/main/partial/search.html"
            }
        }

    }).state('specimens', {
        url: "/specimen",
        templateUrl: "app/templates/search/specimen.html",
        controller: "SearchController as ctrl",
        params: {type: "specimens"}
    }).state('specimen', {
        template: '<data-ui-view/>',
    }).state('specimen.view', {
        url: "/specimen/:id",
        templateUrl: "app/templates/search/detail/specimen.html",
        controller: "DetailController as detailCtrl",
        params: {type: "specimens"}
    }).state('samples', {
        url: "/sample",
/*        views: {
            "specific-search": {

            }
        },*/
        templateUrl: "app/templates/search/samples.html",
        controller: "SearchController as ctrl",
        params: {type: "samples"}
    }).state('sample', {
        template: '<data-ui-view/>',
    }).state('sample.view', {
        url: "/sample/:id",
        templateUrl: "app//templates/search/detail/sample.html",
        controller: "DetailController as detailCtrl",
        params: {type: "samples"}
    }).state('drillCores', {
        url: "/drillcore",
        templateUrl: "app//templates/search/drillCores.html",
        controller: "SearchController as ctrl",
        params: {type: "drillCores"}
    }).state('drillCore', {
        template: '<data-ui-view/>',
    }).state('drillCore.view', {
        url: "/drillcore/:id",
        templateUrl: "app//templates/search/detail/drillCoreDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "drillCores"}
    }).state('localities', {
        url: "/localities",
        templateUrl: "app/templates/search/localities.html",
        controller: "SearchController as ctrl",
        params: {type: "localities"}
    }).state('locality', {
        template: '<data-ui-view/>',
    }).state('locality.view', {
        url: "/locality/:id",
        templateUrl: "app/templates/search/detail/localityDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "localities"}
    }).state('references', {
        url: "/references",
        templateUrl: "app/templates/search/references.html",
        controller: "SearchController as ctrl",
        params: {type: "references",doi: false}
    }).state('reference', {
        template: '<data-ui-view/>',
    }).state('references.view', {
        url: "/references/:id",
        templateUrl: "app/templates/search/detail/referenceDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "references",doi: false}
    }).state('stratigraphies', {
        url: "/stratigraphy",
        templateUrl: "app/templates/search/stratigraphy.html",
        controller: "SearchController as ctrl",
        params: {type: "stratigraphy"}
    }).state('stratigraphy', {
        template: '<data-ui-view/>',
    }).state('stratigraphy.view', {
        url: "/stratigraphy/:id",
        templateUrl: "app/templates/search/detail/stratigraphy.html",
        controller: "DetailController as detailCtrl",
        params: {type: "stratigraphy"}
    }).state('analyses', {
        url: "/analysis",
        templateUrl: "app/templates/search/analyses.html",
        controller: "SearchController as ctrl",
        params: {type: "analyses"}
    }).state('analysis', {
        template: '<data-ui-view/>'
    }).state('analysis.view', {
        url: "/analysis/:id",
        template: ''
    }).state('preparations', {
        url: "/preparation",
        templateUrl: "app/templates/search/preparations.html",
        controller: "SearchController as ctrl",
        params: {type: "preparations"}
    }).state('preparation', {
        template: '<data-ui-view/>'
    }).state('preparation.view', {
        url: "/preparation/:id",
        template: ''
    }).state('photoArchives', {
        url: "/image",
        templateUrl: "app/templates/search/photo_archive.html",
        controller: "SearchController as ctrl",
        params: {type: "photoArchive"}
    }).state('photoArchive', {
        template: '<data-ui-view/>'
    }).state('photoArchive.view', {
        url: "/image/:id",
        templateUrl: "app/templates/search/detail/photo_archive.html",
        controller: "DetailController as detailCtrl",
        params: {type: "photoArchive"}
    }).state('soils', {
        url: "/soil",
        templateUrl: "app/templates/search/soil.html",
        controller: "SearchController as ctrl",
        params: {type: "soil"}
    }).state('soil', {
        template: '<data-ui-view/>'
    }).state('soil.view', {
        url: "/soil/:id",
        templateUrl: "app/templates/search/detail/soilDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "soil"}

    }).state('dois', {
        url: "/doi",
        templateUrl: "app/templates/search/doi.html",
        controller: "SearchController as ctrl",
        params: {type: "doi"}
    }).state('doi', {
        template: '<data-ui-view/>'
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
        params: { contentId: 32 },
        views: {
            "additional": {
                templateUrl: "app/templates/main/using_collection.html"
            }
        }
    }).state('git', {
        url: "/git",
        params: { contentId: 2 },
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
        params: { contentId: 21 },
        views: {
            "additional": {
                templateUrl: "app/templates/main/database.html"
            }
        }
    });
});
