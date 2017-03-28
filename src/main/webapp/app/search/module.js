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
        views: {
            "specific-search": {
                templateUrl: "app/modules/specimens/search/specimen.html",
                controller: "SearchSpecimensController"
            }
        }
    }).state('specimen.view', {
        url: "/specimen/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/specimens/modal/specimen.html",
                controller: "SpecimenController"
            }
        }
    });
});

//routes
angular.module('search.samples', []).config(function($stateProvider) {
    $stateProvider.state('search.samples', {
        url: "/samples",
        views: {
            "specific-search": {
                templateUrl: "app/modules/samples/search/samples.html",
                controller: "SearchSampleController"
            }
        }
    }).state('sample.view', {
        url: "/sample/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/samples/modal/sample.html",
                controller: "SampleController"
            }
        }
    });

});

//routes
angular.module('search.drillCores', []).config(function($stateProvider) {
    $stateProvider.state('search.drillCores', {
        url: "/drillCores",
        views: {
            "specific-search": {
                templateUrl: "app/modules/drillCores/search/drillCores.html",
                controller: "SearchDrillCoresController"
            }
        }
    }).state('drillCores.view', {
        url: "/drillCores/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/drillCores/details/drillCoreDetails.html",
                controller: "DrillCoreDetailsController"
            }
        }
    });

});

//routes
angular.module('search.localities', []).config(function($stateProvider) {
    $stateProvider.state('search.localities', {
        url: "/localities",
        views: {
            "specific-search": {
                templateUrl: "app/modules/localities/search/localities.html",
                controller: "SearchLocalitiesController"
            }
        }
    }).state('locality.view', {
        url: "/locality/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/localities/details/localityDetails.html",
                controller: "LocalityDetailsController"
            }
        }
    });
});

//routes
angular.module('search.references', []).config(function($stateProvider) {
    $stateProvider.state('search.references', {
        url: "/references",
        views: {
            "specific-search": {
                templateUrl: "app/modules/references/search/references.html",
                controller: "SearchReferenceController",
                params: {doi: false}
            }
        }
    }).state('references.view', {
        url: "/references/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/references/details/referenceDetails.html",
                controller: "ReferenceDetailsController"
            }
        }
    });

});

//routes
angular.module('search.stratigraphy', []).config(function($stateProvider) {
    $stateProvider.state('search.stratigraphy', {
        url: "/stratigraphy",
        views: {
            "specific-search": {
                templateUrl: "app/modules/stratigraphy/stratigraphy.html",
                controller: "SearchStratigraphyController"
            }
        }
    }).state('stratigraphy.view', {
        url: "/stratigraphy/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/stratigraphy/modal/stratigraphy.html",
                controller: "StratigraphyDetailsController"
            }
        }
    });

});

//routes
angular.module('search.analyses', []).config(function($stateProvider) {
    $stateProvider.state('search.analyses', {
        url: "/analyses",
        views: {
            "specific-search": {
                templateUrl: "app/modules/analyses/search/analyses.html",
                controller: "SearchAnalysesController"
            }
        }
    });

});

//routes
angular.module('search.preparations', []).config(function($stateProvider) {
    $stateProvider.state('search.preparations', {
        url: "/preparations",
        views: {
            "specific-search": {
                templateUrl: "app/modules/preparations/search/preparations.html",
                controller: "SearchPreparationsController"
            }
        }
    });

});

//routes
angular.module('search.photoArchive', []).config(function($stateProvider) {
    $stateProvider.state('search.photoArchive', {
        url: "/photoArchive",
        views: {
            "specific-search": {
                templateUrl: "app/modules/photoArchive/search/photo_archive.html",
                controller: "SearchPhotoArchiveController"
            }
        }
    }).state('photoArchive.view', {
        url: "/image/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/photoArchive/modal/photo_archive.html",
                controller: "PhotoArchiveController"
            }
        }
    });

});

//routes
angular.module('search.soil', []).config(function($stateProvider) {
    $stateProvider.state('search.soil', {
        url: "/soil",
        views: {
            "specific-search": {
                templateUrl: "app/modules/soil/search/soilSearch.html",
                controller: "SearchSoilController"
            }
        }
    }).state('soil.view', {
        url: "/soil/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/soil/details/soilDetails.html",
                controller: "SoilDetailsController"
            }
        }
    });
});

//routes
angular.module('search.doi', []).config(function($stateProvider) {
    $stateProvider.state('search.doi', {
        url: "/doi",
        views: {
            "specific-search": {
                templateUrl: "app/modules/doi/search/doi.html",
                controller: "SearchDoiController"
            }
        }
    }).state('doi.view', {
        url: "/doi/:id",
        views: {
            "specific-search": {
                templateUrl: "app/modules/doi/details/doiDetails.html",
                controller: "DoiDetailsController"
            }
        }
    });
});

