angular.module('search').factory("SpecimenService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/specimen', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        }
    };
}]);