angular.module('search').controller('SearchDrillCoresController', function ($scope, DrillCoreService) {

    $scope.departments = [
        {code: "GIT", label: "GIT"},
        {code: "TUG", label: "TUG"},
        {code: "ELM", label: "ELM"},
        {code: "TUGO", label: "TUGO"},
        {code: "MUMU", label: "MUMU"},
        {code: "EGK", label: "EGK"}];

    $scope.sortbyOptions = [
        {name: 'ID', value: 'id'},
        {name: 'Locality', value: 'Locality'},
        {name: 'Box count', value: 'Box count'}
    ];
    $scope.search = function() {
        DrillCoreService.search($scope.searchParameters).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.response = result;
        });
    };

    $scope.searchDefault = function() {
        $scope.searchParameters = {};
        $scope.search();
    };

    $scope.searchDefault();
}).factory("DrillCoreService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/drillcore', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        }
    };
}])