'use strict';
angular.module('geoApp', [
    'ui.bootstrap',
    'ui.bootstrap.showErrors',
    'ui.bootstrap.datetimepicker',
    'ui.router',
    'main',
    'map',
    'news',
    'locality',
    'cgNotify',
    'ui.select',
    'angular-confirm',
    'ngFileUpload',
    'search',
    'database',
    'usingCollection',
    'fullsearch',
    'ngCookies',
    'pascalprecht.translate'
]);

var configuration = CONFIG;
// Get current URL as  API_URL if not defined in the config
if (configuration.API_URL === undefined) {
    var pathArray = location.href.split('/'),
        protocol = pathArray[0],
        host = pathArray[2];
    configuration.API_URL = protocol + '//' + host;
}

angular.module('geoApp').constant('configuration', configuration);

angular.module('geoApp').value('isActivityLogging', true);

angular.module('geoApp').config(function($stateProvider, $urlRouterProvider, $httpProvider, $provide, uibDatepickerConfig, uibDatepickerPopupConfig) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    // For any unmatched url, redirect to /dashboard
    $urlRouterProvider.otherwise("/");

    $stateProvider.state('index', {
        url: "/",
        template: "<div>Palun oota. Rakendust laaditakse.</div>",
        params: {toState: {name: 'main'}, id: null, readOnly: true, serviceAreaId: null},
        controller: function($http, $rootScope, $state, $stateParams) {

            $rootScope.currentUser.authenticated = true;
            if ($stateParams.toState.name != 'index')
                $state.go($stateParams.toState.name, $stateParams);
            else
                $state.go('main');

            $http.get('/config/').then(function(response) {
                $rootScope.config = response.data;
            });


        },
        resolve: {

        }
    });
    $httpProvider.interceptors.push('SimpleResponseErrorInterceptor');

    $provide.decorator("$exceptionHandler", function($delegate, $injector){
        return function(exception, cause){
            var $http = $injector.get("$http");
            $http.post('/logger', {
                url: window.location.href,
                message: exception.message,
                stackTrace: exception.stack
            });
            $delegate(exception, cause);
        };
    });

    //ui-bootstrap datepicker global configuration
    uibDatepickerConfig.startingDay = 1;
    uibDatepickerPopupConfig.currentText = 'Täna';
    uibDatepickerPopupConfig.clearText = 'Puhasta';
    uibDatepickerPopupConfig.closeText = 'Sulge';
});


angular.module('geoApp').config(['$translateProvider', function ($translateProvider) {
    // add translation tables
    $translateProvider.translations('en', translations_en);
    $translateProvider.translations('et', translations_et);
    $translateProvider.preferredLanguage('et');
    $translateProvider.fallbackLanguage('en');
    $translateProvider.useLocalStorage();
  }]);

  angular.module('geoApp').controller('Ctrl', ['$translate', '$scope', function ($translate, $scope) {

    $scope.changeLanguage = function (langKey) {
      $translate.use(langKey);
    };
  }]);

angular.module('geoApp').run(['$http', '$rootScope', '$state', '$stateParams',
    'AddressService', 'UserService', '$sce',
    '$window','$uibModal', 'AuthorizationService', 'SearchService',
    function ($http, $rootScope, $state, $stateParams, ClassifierService, AddressService,
              UserService, $sce,
              $window,$uibModal, AuthorizationService, SearchService) {
    $rootScope.currentUser = {};
    $rootScope.preventionYearOption = {};
    $rootScope.$state = $state;
    $rootScope.$stateParams = $stateParams;
    $rootScope.searchService = SearchService;
    $rootScope.classifierService = ClassifierService;
    $rootScope.addressService = AddressService;
    $rootScope.userService = UserService;

    $rootScope.$on('$stateChangeStart',
        function(event, toState, toParams, fromState, fromParams) {
            if ($rootScope.currentUser.authenticated === undefined && toState.name != 'index') {
                //redirect to state which initializes the app with info

                var params = {toState: toState};
                angular.extend(params, toParams);
                event.preventDefault();
                $state.go('index', params);
            } else if ($rootScope.currentUser.authenticated === false) {
                //session has ended
                event.preventDefault();
            }
        });
    $rootScope.openInNewTab = function(to, params) {
        window.open($state.href(to, params, {absolute: true}), '_blank');
    };

    //general date and time formats
    $rootScope.dateFormat = 'dd.MM.yyyy';
    $rootScope.dateTimeFormat = 'dd.MM.yyyy HH:mm:ss';
    $rootScope.dateTimeFormatSimple = 'dd.MM.yyyy HH:mm';
    $rootScope.timeFormatSimple = 'HH:mm';
    $rootScope.yearFormat = 'yyyy';

    //default ui-bootstrap datepicker options
    $rootScope.datePickerOptions = {
        formatYear: 'yy',
        class: 'datepicker'
    };

    $rootScope.yearOptions = {
        formatYear: $rootScope.yearFormat,
        minMode: 'year',
        maxMode: 'year',
        datepickerMode: "'year'"
    };

    //Use for rendering html content
    $rootScope.renderHtml = function(text) {
        return $sce.trustAsHtml(text);
    };

    $rootScope.loadTextModal = function (respond,callback) {
        $uibModal.open({
            templateUrl: '/app/core/views/notification-modal.html',
            controller: ["$scope", "callback", "$uibModalInstance", "content", function ($scope, callback, $uibModalInstance, content) {
                $scope.header = 'Hoiatus';
                $scope.content = $sce.trustAsHtml(content);
                $scope.confirm = function () {
                    callback();
                    $uibModalInstance.dismiss('confirm');
                };
                $scope.cancel = function () {
                    $uibModalInstance.dismiss('cancel');
                };

            }
            ],
            resolve: {
                content: function () {return respond},
                callback: function () {return callback;}
            }
        }).result.then(function (res) {});
    };
}]);


angular.module('geoApp').directive('accRequired', function() {
	return {
		compile: function(element) {
			element.append('<span title="required" class="required-marker text-danger lead">&nbsp;*</span>');
		}
	}
});
angular.module('geoApp').directive('accRequiredIf', function() {
    return {
        compile: function(element, attrs) {
            attrs.$observe('condition', function(value) {
                if (value == "true")
                    element.append('<span title="required" class="required-marker text-danger lead">&nbsp;*</span>');
                else {
                    if (element[0] && element[0].lastChild && element[0].lastChild.innerHTML == "&nbsp;*") {
                        if(typeof element[0].lastChild.remove =='function'){
                            element[0].lastChild.remove();
                        } else {
                            element[0].lastChild.innerHTML = "";
                        }
                    }

                }
            });
        }
    }
});
