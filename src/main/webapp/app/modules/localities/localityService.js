angular.module('search').factory("LocalityService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/locality', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function(id) {
            return $http.get('/details/locality/'+id)
                .then(function(response){
                    return response.data;
                });
        }
    };
}]);