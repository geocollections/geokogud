angular.module('search').factory("SearchService", function($http, $q) {
    var apiUrl = '/search';
    var deferred = $q.defer();
    return {
        getSearch: function (searchName) {
            return $http.get(apiUrl + '/get-search', {params: {name: searchName}}).then(function(response) {
                return response.data;
            });
        },

        sampleListSearch: function (sampleSearch) {
            return $http.post(apiUrl + '/sample-list', sampleSearch).then(function(response) {
                return response.data;
            });
        },

        taxonListSearch: function () {
            return $http.get(apiUrl + '/taxon-list').then(function(response) {
                return response.data;
            });
        },

        taxonSearch: function (val) {
            return $http.get(apiUrl + '/taxon', {params: {term: val}}).then(function (response) {
                return response.data.results;
            });
        }
    };
});
