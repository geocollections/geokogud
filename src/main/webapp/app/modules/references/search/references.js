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
            console.log(result);
            $scope.response = result;
        });
    };

    $scope.searchDefault = function(search) {
        $scope.searchParameters = {sortField : {}};
        $scope.searchParameters.sortField.sortBy = "id";
        $scope.sortByAsc = true;
        $scope.search();
    };

    $scope.searchDefault();

    $scope.order = function(predicate) {
        console.log(predicate);
        console.log($scope.searchParameters.sortBy);
        $scope.sortByAsc = ($scope.searchParameters.sortField.sortBy === predicate ? !$scope.sortByAsc : true);
        $scope.searchParameters.sortField.sortBy =  predicate;
        console.log($scope.sortByAsc );
        !$scope.sortByAsc ? $scope.searchParameters.sortField.order = "ASCENDING" :  $scope.searchParameters.sortField.order = "DESCENDING";
        $scope.search();
    };
/*    $scope.searchDefault = function(search) {
        if(!search) search = "image";
        SearchService.getSearch(search).then(function(search) {
            $scope.doiSearch = search;
            //$scope.doiSearch.dbs  = ['GIT','TUG', 'ELM', 'TUGO', 'MUMU', 'EGK']
            $scope.search();
        });
    };

    $scope.searchDefault();

    $scope.search = function() {
        SearchService.listSearch($scope.doiSearch).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.response = result;;
        });
    };*/

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