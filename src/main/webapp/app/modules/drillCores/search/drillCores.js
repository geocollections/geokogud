angular.module('search').controller('SearchDrillCoresController', function ($scope, DrillCoreService) {
    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = true;
    $scope.isInstitutionsCollapsed = true;
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
        $scope.searchParameters = {sortField : {}};
        $scope.searchParameters.sortField.sortBy = "id";
        $scope.sortByAsc = true;
        $scope.search();
    };

    $scope.searchDefault();

    $scope.order = function(predicate) {
        $scope.sortByAsc = ($scope.searchParameters.sortField.sortBy === predicate ? !$scope.sortByAsc : true);
        $scope.searchParameters.sortField.sortBy =  predicate;
        !$scope.sortByAsc ? $scope.searchParameters.sortField.order = "ASCENDING" :  $scope.searchParameters.sortField.order = "DESCENDING";
        $scope.search();
    };
}).controller('DrillCoreDetailsController', function($scope,$stateParams, DrillCoreService){
    $scope.drillCore = {};
    DrillCoreService.details($stateParams.id).then(function(result) {
        $scope.drillCore = result.drillCore.result[0];
        console.log(result);
    });
}).factory("DrillCoreService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/drillcore', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function(id) {
            return $http.get('/details/drillcore/'+id)
                .then(function(response){
                    return response.data;
                });
        }
    };
}])