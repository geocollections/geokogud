var module = angular.module("geoApp", ['ui.bootstrap','ui.bootstrap.datetimepicker', 'ui.router', 'pascalprecht.translate', 'ngFileUpload', 'ngCookies', 'ngSanitize', 'ngAnimate', 'ui.select2', 'ngStorage', 'bsLoadingOverlay']);

module.config(function ($translateProvider, $locationProvider, $urlRouterProvider) {

    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
    $locationProvider.hashPrefix('');

    $urlRouterProvider.otherwise("/");

    $translateProvider.useStaticFilesLoader({
        files: [{
            prefix: 'app/i18n/translations_',
            suffix: '.json'
        }, {
            prefix: 'app/i18n/translations_API_',
            suffix: '.json'
        }]
    });

    $translateProvider.preferredLanguage('et');
    $translateProvider.fallbackLanguage('en');
    $translateProvider.useLocalStorage();
    $translateProvider.useSanitizeValueStrategy('escape');
    $translateProvider.forceAsyncReload(true);
});

var fetchData = function () {
    var initInjector = angular.injector(["ng"]);
    var $http = initInjector.get("$http");

    return $http.get("config.json").then(function(response) {
        module.constant("configuration", response.data);
    }, function(errorResponse) {
        console.log("configuration missing!")
    });
};
var bootstrapApplication = function () {
    angular.element(document).ready(function() {
        angular.bootstrap(document, ["geoApp"]);
    });
};
fetchData().then(bootstrapApplication);