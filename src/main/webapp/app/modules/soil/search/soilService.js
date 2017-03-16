angular.module('search').factory("SoilService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/soil', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function(id) {
            return $http.get('/details/soil/'+id)
                .then(function(response){
                    return response.data;
                });
        }
    };
}]);