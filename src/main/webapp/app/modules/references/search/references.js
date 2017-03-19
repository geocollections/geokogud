angular.module('search').controller('SearchReferenceController', function($scope, ReferenceService, $stateParams){

    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];

    $scope.isInstitutionsCollapsed = true;
    $scope.isIdentifierFieldsCollapsed = false;

    $scope.search = function() {
        ReferenceService.search($scope.searchParameters, $stateParams).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.response = result;
        });
    };

    $scope.searchDefault = function() {
        $scope.searchParameters = {sortField : {}, dbs : []};
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

}).factory("ReferenceService", ['$http', function ($http) {
    return {
        search: function (searchParameters, params) {
            var search = "reference";
            if(params.doi) search = "doi";
            return $http.post('/search/'+search, searchParameters)
                .then(function (response) {
                    return response.data;
                });
        }
    };
}]);