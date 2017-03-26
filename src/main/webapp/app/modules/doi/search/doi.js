angular.module('search').controller('SearchDoiController', function($scope, DoiService, $stateParams, SearchService){

    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];

    $scope.searchService = SearchService;
    $scope.entitySelected = function(item) {
        $scope.searchParameters.author.name = item;
    };

    $scope.isInstitutionsCollapsed = true;
    $scope.isIdentifierFieldsCollapsed = false;

    $scope.toggle = function(state) {
        var i = $scope.searchParameters.dbs.indexOf(state);
        if (i > -1) {
            $scope.searchParameters.dbs.splice(i, 1);
        } else {
            $scope.searchParameters.dbs.push(state);
        }
    };
    $scope.search = function() {
        DoiService.search($scope.searchParameters, $stateParams).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.searchParameters.maxSize = 5;
            $scope.response = result;
        });
    };

    $scope.searchDefault = function() {
        $scope.searchParameters = {sortField : {}, dbs : []};
        $scope.searchParameters.sortField.sortBy = "id";
        $scope.sortByAsc = true;
        $scope.toggle("GIT");
        $scope.search();
    };
    $scope.searchDefault();

    $scope.order = function(predicate) {
        $scope.sortByAsc = ($scope.searchParameters.sortField.sortBy === predicate ? !$scope.sortByAsc : true);
        $scope.searchParameters.sortField.sortBy =  predicate;
        !$scope.sortByAsc ? $scope.searchParameters.sortField.order = "ASCENDING" :  $scope.searchParameters.sortField.order = "DESCENDING";
        $scope.search();
    };

}).controller('DoiDetailsController', function($scope,$stateParams, DoiService){
    DoiService.details($stateParams).then(function(result) {
        $scope.doi = result.reference.result[0];
    });
}).factory("DoiService", ['$http', function ($http) {
    return {
        search: function (searchParameters, params) {
            return $http.post('/search/doi', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function(params) {
            return $http.get('/details/doi/'+params.id)
                .then(function(response){
                    return response.data;
                });
        }
    };
}]);