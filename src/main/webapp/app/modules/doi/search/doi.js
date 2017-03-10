angular.module('search').controller('SearchDoiController', function($scope, DoiService){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'DOI', value: 'doi' },
    ];
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];

    $scope.isInstitutionsCollapsed = true;
    $scope.isIdentifierFieldsCollapsed = false;

    $scope.searchParameters = {};

    $scope.search = function() {
        DoiService.search($scope.searchParameters).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.response = result;
        });
    };

    $scope.search();
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

}).factory("DoiService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/doi', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        }
    };
}]);