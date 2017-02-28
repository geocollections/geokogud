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






angular.module('geoApp').factory("SearchService", ['$http', '$state', '$rootScope', '$q', function($http, $state, $rootScope, $q) {
    var apiUrl = '/search';
    var deferred = $q.defer();
    return {
        //This method returns common search object
        getSearch: function (searchName) {
            return $http.get(apiUrl + '/get-search', {params: {name: searchName}}).then(function(response) {
                return response.data;
            });
        },

        //This method makes common search request to API
        listSearch: function (sampleSearch) {
            return $http.post(apiUrl + '/list', sampleSearch).then(function(response) {
                return response.data;
            });
        },

        // not used
        taxonSearch: function (val) {
            return $http.get(apiUrl + '/taxon', {params: {term: val}}).then(function (response) {
                return response.data.results;
            });
        },

        defaultSearchOptions : function() {
            return  [
                {value:"SPECIMENS",name:"Specimens"},
                {value:"SAMPLES",name:"Samples"},
                {value:"DRILL CORES",name:"Drill cores"},
                {value:"LOCALITIES",name:"Localities"},
                {value:"REFERENCES",name:"References"},
                {value:"STRATIGRAPHIES",name:"Stratigraphy"},
                {value:"ANALYSES",name:"Analyses"},
                {value:"PREPARATION",name:"Preparation"},
                {value:"ARCHIVE",name:"Photo archive"},
                {value:"SOIL",name:"SOIL"},
                {value:"DOI",name:"DOI"}]
        },

        // MUST be as CLASSIFIER but not hard coded
        departments : function() {
            return [
                {code:"GIT",label:"GIT"},
                {code:"TUG",label:"TUG"},
                {code:"ELM",label:"ELM"},
                {code:"TUGO",label:"TUGO"},
                {code:"MUMU",label:"MUMU"},
                {code:"EGK",label:"EGK"}]
        },

    };
}]);
