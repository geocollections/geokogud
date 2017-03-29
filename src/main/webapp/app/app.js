'use strict';
angular.module('geoApp', [
    'ngAnimate',
    'ui.bootstrap',
    'ui.bootstrap.showErrors',
    'ui.bootstrap.datetimepicker',
    'ui.router',
    'map',
    'news',
    'geocollection',
    'git',
    'cgNotify',
    'ui.select2',
    'angular-confirm',
    'ngFileUpload',
    'search',
    'database',
    'usingCollection',
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
angular.module('geoApp').config(['$locationProvider', function($locationProvider) {
    //for fixing # in address bar
   /* $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });*/
   $locationProvider.hashPrefix('');
}]);

angular.module('geoApp').config(function($stateProvider, $urlRouterProvider, $httpProvider, $provide, uibDatepickerConfig, uibDatepickerPopupConfig) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    // For any unmatched url, redirect to /dashboard
    $urlRouterProvider.otherwise("/");

    $stateProvider.state('index', {
        url: "/",
        template: "<div>{{ 'INDEX.PAGE_LOADING' | translate }}</div>",
        params: {toState: {name: 'index'}, id: null, readOnly: true, serviceAreaId: null},
        controller: function($http, $rootScope, $state, $stateParams) {

            $rootScope.currentUser.authenticated = true;
            if ($stateParams.toState.name != 'index')
                $state.go($stateParams.toState.name, $stateParams);
            else
                $state.go('index');

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

    $translateProvider.preferredLanguage('et');
    $translateProvider.fallbackLanguage('en');
    $translateProvider.useLocalStorage();
    $translateProvider.useSanitizeValueStrategy('escape');

    $translateProvider.useStaticFilesLoader({
        prefix: '/app/i18n/translations_',
        suffix: '.json'
});
  }]);

  angular.module('geoApp').controller('Ctrl', ['$translate', '$scope', function ($translate, $scope) {

    $scope.changeLanguage = function (langKey) {
      $translate.use(langKey);
    };
  }]);

  angular.module('geoApp').controller('NewsController', function($scope, $http) {
	  var years = [];
	  var yearToShow;
	    $http.get('/news').
	        then(function(response) {
	            $scope.news = response.data;
	            angular.forEach($scope.news.result, function(currentNews) {
	                var year = currentNews.date_added.split("-")[0];
	                if (years.indexOf(year) == -1) { years.push(year); }
	            });
	            $scope.years = years.reverse();
	            yearToShow = $scope.years[0];
	            console.log(yearToShow);
	        });
	    $scope.showNews = function ($event) {
	        yearToShow = $event.target.innerText;
	     }
	    $scope.yearFilter = function (id) {
	        return id.date_added.startsWith(yearToShow);
	    };
});

angular.module('geoApp').run(['$http', '$rootScope', '$state', '$stateParams',
    'AddressService', 'UserService', '$sce',
    '$window','$uibModal', 'AuthorizationService', 'SearchService',
    function ($http, $rootScope, $state, $stateParams, ClassifierService, AddressService,
              UserService, $sce,
              $window,$uibModal, AuthorizationService, SearchService) {

/*    $rootScope.openInNewTab = function(to, params) {
        window.open($state.href(to, params, {absolute: true}), '_blank');
    };*/

    $rootScope.openInNewTab = function(to, params) {
        window.open($state.href(to, params, {absolute: true}), 'width=750,height=750,scrollbars, resizable');
    };

    $rootScope.openInNewWindow = function(params) {
        window.open('/#/'+params.object+'/' + params.id, '', 'width=750,height=750,scrollbars, resizable');
    };

    $rootScope.openUrlInNewWindow = function(params) {
        window.open(params.url, '', 'width=750,height=750,scrollbars, resizable');
    };

    $rootScope.showGoogleMap = function(lat, lon, localityName) {
        window.open('http://maps.google.com/?q='+lat+','+lon+' ('+localityName+')', '', 'width=750,height=540,scrollbars, resizable');
    };

    $rootScope.showEstonianLandBoardMap = function(lat,lon) {
        window.open('http://geoportaal.maaamet.ee/url/xgis-latlon.php?lat='+lat+'&lon='+lon+'&out=xgis&app_id=UU82', '', 'width=900,height=600,scrollbars, resizable');
    }

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
