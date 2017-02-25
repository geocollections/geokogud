'use strict';
//routes
angular.module('search', ['search.specimens','search.samples','search.drillCores','search.localities','search.references',
    'search.stratigraphy','search.analyses','search.preparations','search.photoArchive','search.soil','search.doi']).config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.when('/search', '/search/samples');
    $stateProvider.state('search', {
        url: "/search",
        templateUrl: "app/search/index.html"
    });
});

//routes
angular.module('fullsearch', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('fullsearch', {
        url: "/fullsearch",
        templateUrl: "app/search/search.html",
        controller: "FullSearchController"
    });
});


//routes
angular.module('search.specimens', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.specimens', {
        url: "/specimens",
        templateUrl: "app/search/specimens.html",
        controller: "SearchSpecimensController"
    });
});

//routes
angular.module('search.samples', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.samples', {
        url: "/samples",
        templateUrl: "app/search/samples.html",
        controller: "SearchSampleController"
    });

});

//routes
angular.module('search.drillCores', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.drillCores', {
        url: "/drillCores",
        templateUrl: "app/search/drill_cores.html",
        controller: "SearchDrillCoresController"
    });

});

//routes
angular.module('search.localities', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.localities', {
        url: "/localities",
        templateUrl: "app/search/localities.html",
        controller: "SearchLocalitiesController"
    });
});

//routes
angular.module('search.references', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.references', {
        url: "/references",
        templateUrl: "app/search/references.html",
        controller: "SearchReferencesController"
    });

});

//routes
angular.module('search.stratigraphy', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.stratigraphy', {
        url: "/stratigraphy",
        templateUrl: "app/search/stratigraphy.html",
        controller: "SearchStratigraphyController"
    });

});

//routes
angular.module('search.analyses', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.analyses', {
        url: "/analyses",
        templateUrl: "app/search/analyses.html",
        controller: "SearchAnalysesController"
    });

});

//routes
angular.module('search.preparations', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.preparations', {
        url: "/preparations",
        templateUrl: "app/search/preparations.html",
        controller: "SearchPreparationsController"
    });

});

//routes
angular.module('search.photoArchive', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.photoArchive', {
        url: "/photoArchive",
        templateUrl: "app/search/photo_archive.html",
        controller: "SearchPhotoArchiveController"
    });

});

//routes
angular.module('search.soil', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.soil', {
        url: "/soil",
        templateUrl: "app/search/soil.html",
        controller: "SearchSoilController"
    });
});

//routes
angular.module('search.doi', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.doi', {
        url: "/doi",
        templateUrl: "app/search/doi.html",
        controller: "SearchDoiController"
    });
});

