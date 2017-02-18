angular.module('geoApp').factory("UserService", ['$http', '$state', '$rootScope', function($http, $state, $rootScope) {
        return true;
}]).factory('AuthorizationService', function($rootScope) {
    return {
        isAuthorized: function(privilege) {
            return true;
        }
    };
}).factory("AddressService", function($http, $filter) {
    return true;

}).factory("ClassifierService", function($http) {

}).factory("SimpleResponseErrorInterceptor", function($q, $rootScope) {

    return {
        'request': function(config) {
            return config;
        },
        'responseError': function(rejection) {
            if (rejection.status == 401) {
                if ($rootScope.currentUser.authenticated) {
                    if (confirm("Sessioon on lõppenud. Soovid uuesti sisse logida?")) {
                        location.href = '/index.html';
                    } else {
                        location.href = '/j_spring_cas_security_logout';
                    }
                }
                $rootScope.currentUser.authenticated = false;
            } else if (rejection.status == 403) {
                alert("Puudub õigus antud päringuks.");
            } else {
                //console.log(rejection.status + ": " + rejection.statusText);
            }

            return $q.reject(rejection);
        }
    };

});
