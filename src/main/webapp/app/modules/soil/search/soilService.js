angular.module('search').factory("SoilService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/soil', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        }
    };
}]);