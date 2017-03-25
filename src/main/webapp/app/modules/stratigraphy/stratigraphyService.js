angular.module('search').factory("StratigraphyService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/stratigraphy', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function(id) {
            return $http.get('/details/stratigraphy/'+id)
                .then(function(response){
                    return response.data;
                });
        }
    };
}]);