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
angular.module('search.specimens', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.specimens', {
        url: "/specimens",
        templateUrl: "app/modules/specimens/search/specimen.html",
        controller: "SearchSpecimensController"
    }).state('specimen', {
        template: '<data-ui-view/>',
    }).state('specimen.view', {
        url: "/specimen/:id",
        templateUrl: "app/modules/specimens/modal/specimen.html",
        controller: "SpecimenController"
    });
});

//routes
angular.module('search.samples', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.samples', {
        url: "/samples",
        templateUrl: "app/modules/samples/search/samples.html",
        controller: "SearchSampleController"
    }).state('sample', {
        template: '<data-ui-view/>',
    }).state('sample.view', {
        url: "/sample/:id",
        templateUrl: "app/modules/samples/modal/sample.html",
        controller: "SampleController"
    });

});

//routes
angular.module('search.drillCores', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.drillCores', {
        url: "/drillCores",
        templateUrl: "app/modules/drillCores/search/drill_cores.html",
        controller: "SearchDrillCoresController"
    });

});

//routes
angular.module('search.localities', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.localities', {
        url: "/localities",
        templateUrl: "app/modules/localities/search/localities.html",
        controller: "SearchLocalitiesController"
    });
});

//routes
angular.module('search.references', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.references', {
        url: "/references",
        templateUrl: "app/modules/references/search/references.html",
        controller: "SearchReferenceController",
        params: {doi: false}
    });

});

//routes
angular.module('search.stratigraphy', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.stratigraphy', {
        url: "/stratigraphy",
        templateUrl: "app/modules/stratigraphy/stratigraphy.html",
        controller: "SearchStratigraphyController"
    }).state('stratigraphy', {
        template: '<data-ui-view/>',
    }).state('stratigraphy.view', {
        url: "/stratigraphy/:id",
        templateUrl: "app/modules/stratigraphy/modal/stratigraphy.html",
        controller: "SampleController"
    });

});

//routes
angular.module('search.analyses', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.analyses', {
        url: "/analyses",
        templateUrl: "app/modules/analyses/search/analyses.html",
        controller: "SearchAnalysesController"
    });

});

//routes
angular.module('search.preparations', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.preparations', {
        url: "/preparations",
        templateUrl: "app/modules/preparations/search/preparations.html",
        controller: "SearchPreparationsController"
    });

});

//routes
angular.module('search.photoArchive', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.photoArchive', {
        url: "/photoArchive",
        templateUrl: "app/modules/photoArchive/search/photo_archive.html",
        controller: "SearchPhotoArchiveController"
    }).state('photoArchive', {
        template: '<data-ui-view/>',
    }).state('photoArchive.view', {
        url: "/image/:id",
        templateUrl: "app/modules/photoArchive/modal/photo_archive.html",
        controller: "PhotoArchiveController"
    });

});

//routes
angular.module('search.soil', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.soil', {
        url: "/soil",
        templateUrl: "app/modules/soil/search/soil.html",
        controller: "SearchSoilController"
    });
});

//routes
angular.module('search.doi', []).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.doi', {
        url: "/doi",
        templateUrl: "app/modules/doi/search/doi.html",
        controller: "SearchReferenceController",
        params: {doi: true}
    });
});

