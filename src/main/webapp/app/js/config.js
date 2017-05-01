var module = angular.module("geoApp");

module.config(function($stateProvider,$urlRouterProvider) {
 //  $urlRouterProvider.when('/search', '/sample');

    $stateProvider.state('/',{
        url: "/",
        templateUrl: "app/templates/main/geokogud.html"
    }).state('map',{
        url: "/map",
        templateUrl: "app/templates/main/map.html"
    }).state('global',{
        url: "/global/:query/:section",
        templateUrl: "app/templates/main/global_search.html",
        controller: "GlobalSearchController as ctrl"
    }).state('search', {
        url: "/search",
        templateUrl: "app/templates/main/partial/search.html",
    }).state('specimens', {
        url: "/specimen",
        templateUrl: "app/templates/search/specimen.html",
        controller: "SearchController as ctrl",
        params: {type: "specimens"}
    }).state('specimen', {
        template: '<data-ui-view/>'
    }).state('specimen.view', {
        url: "/specimen/:id",
        templateUrl: "app/templates/search/detail/specimen.html",
        controller: "DetailController as detailCtrl",
        params: {type: "specimens"}
    }).state('specimenImage', {
        template: '<data-ui-view/>'
    }).state('specimenImage.view', {
        url: "/specimen_image/:id",
        templateUrl: "app/templates/search/detail/photoArchive.html",
        controller: "DetailController as detailCtrl",
        params: {type: "specimenImage"}
    }).state('samples', {
        url: "/sample",
        templateUrl: "app/templates/search/samples.html",
        controller: "SearchController as ctrl",
        params: {type: "samples"}
    }).state('sample', {
        template: '<data-ui-view/>'
    }).state('sample.view', {
        url: "/sample/:id",
        templateUrl: "app/templates/search/detail/sample.html",
        controller: "DetailController as detailCtrl",
        params: {type: "samples"}
    }).state('drillcores', {
        url: "/drillcore",
        templateUrl: "app/templates/search/drillcore/drillcore.html",
        controller: "SearchController as ctrl",
        params: {type: "drillCores"}
    }).state('drillcore', {
        template: '<data-ui-view/>'
    }).state('drillcore.view', {
        url: "/drillcore/:id",
        templateUrl: "app/templates/search/detail/drillCoreDetails.html",
        controller: "DetailController as detailCtrl",
        params: {type: "drillCores"}
    }).state('coreBox', {
        template: '<data-ui-view/>'
    }).state('coreBox.view', {
        url: "/corebox/:id",
        templateUrl: "app/templates/search/detail/coreBox.html",
        controller: "DetailController as detailCtrl",
        params: {type: "corebox"}
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
        url: "/reference",
        templateUrl: "app/templates/search/references.html",
        controller: "SearchController as ctrl",
        params: {type: "references",doi: false}
    }).state('reference', {
        template: '<data-ui-view/>',
    }).state('reference.view', {
        url: "/reference/:id",
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
        templateUrl: "app/templates/search/analyses/analyses.html",
        controller: "SearchController as ctrl",
        params: {type: "analyses"}
    }).state('analysis', {
        template: '<data-ui-view/>'
    }).state('analysis.view', {
        url: "/analysis/:id",
        templateUrl: 'app/templates/search/detail/analysis.html',
        controller: "DetailController as detailCtrl",
        params: {type: "analysis"}
    }).state('preparations', {
        url: "/preparation",
        templateUrl: "app/templates/search/preparations.html",
        controller: "SearchController as ctrl",
        params: {type: "preparations"}
    }).state('preparation', {
        template: '<data-ui-view/>'
    }).state('preparation.view', {
        url: "/preparation/:id",
        templateUrl: "app/templates/search/detail/preparation.html",
        controller: "DetailController as detailCtrl",
        params: {type: "preparations"}
    }).state('photoArchives', {
        url: "/image",
        templateUrl: "app/templates/search/photoArchive.html",
        controller: "SearchController as ctrl",
        params: {type: "photoArchive"}
    }).state('photoArchive', {
        template: '<data-ui-view/>'
    }).state('photoArchive.view', {
        url: "/image/:id",
        templateUrl: "app/templates/search/detail/photoArchive.html",
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
        templateUrl: "app/templates/search/doi/doi.html",
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
    })/*.state('map', {
        url: "/map",
        views: {
            "additional": {
                templateUrl: "app/templates/main/map.html"
            }
        }
    })*/.state('usingcollection', {
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
