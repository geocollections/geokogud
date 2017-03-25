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
angular.module('search.specimens', []).config(function($stateProvider) {
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
angular.module('search.samples', []).config(function($stateProvider) {
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
angular.module('search.drillCores', []).config(function($stateProvider) {
    $stateProvider.state('search.drillCores', {
        url: "/drillCores",
        templateUrl: "app/modules/drillCores/search/drillCores.html",
        controller: "SearchDrillCoresController"
    }).state('drillCores', {
        template: '<data-ui-view/>',
    }).state('drillCores.view', {
        url: "/drillCores/:id",
        templateUrl: "app/modules/drillCores/details/drillCoreDetails.html",
        controller: "DrillCoreDetailsController"
    });

});

//routes
angular.module('search.localities', []).config(function($stateProvider) {
    $stateProvider.state('search.localities', {
        url: "/localities",
        templateUrl: "app/modules/localities/search/localities.html",
        controller: "SearchLocalitiesController"
    }).state('locality', {
        template: '<data-ui-view/>',
    }).state('locality.view', {
        url: "/locality/:id",
        templateUrl: "app/modules/localities/details/localityDetails.html",
        controller: "LocalityDetailsController"
    });
});

//routes
angular.module('search.references', []).config(function($stateProvider) {
    $stateProvider.state('search.references', {
        url: "/references",
        templateUrl: "app/modules/references/search/references.html",
        controller: "SearchReferenceController",
        params: {doi: false}
    }).state('references', {
        template: '<data-ui-view/>',
    }).state('references.view', {
        url: "/references/:id",
        templateUrl: "app/modules/references/details/referenceDetails.html",
        controller: "ReferenceDetailsController"
    });

});

//routes
angular.module('search.stratigraphy', []).config(function($stateProvider) {
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
angular.module('search.analyses', []).config(function($stateProvider) {
    $stateProvider.state('search.analyses', {
        url: "/analyses",
        templateUrl: "app/modules/analyses/search/analyses.html",
        controller: "SearchAnalysesController"
    });

});

//routes
angular.module('search.preparations', []).config(function($stateProvider) {
    $stateProvider.state('search.preparations', {
        url: "/preparations",
        templateUrl: "app/modules/preparations/search/preparations.html",
        controller: "SearchPreparationsController"
    });

});

//routes
angular.module('search.photoArchive', []).config(function($stateProvider) {
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
angular.module('search.soil', []).config(function($stateProvider) {
    $stateProvider.state('search.soil', {
        url: "/soil",
        templateUrl: "app/modules/soil/search/soilSearch.html",
        controller: "SearchSoilController"
    }).state('soil', {
        template: '<data-ui-view/>',
    }).state('soil.view', {
        url: "/soil/:id",
        templateUrl: "app/modules/soil/details/soilDetails.html",
        controller: "SoilDetailsController"
    });
});

//routes
angular.module('search.doi', []).config(function($stateProvider) {
    $stateProvider.state('search.doi', {
        url: "/doi",
        templateUrl: "app/modules/doi/search/doi.html",
        controller: "SearchReferenceController",
        params: {doi: true}
    }).state('doi', {
    template: '<data-ui-view/>',
}).state('doi.view', {
    url: "/doi/:id",
    templateUrl: "app/modules/doi/details/doiDetails.html",
    controller: "ReferenceDetailsController"
});
});

