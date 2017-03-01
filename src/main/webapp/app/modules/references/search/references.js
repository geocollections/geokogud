angular.module('search').controller('SearchReferencesController', function($scope, SearchService){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Author', value: 'author' },
        {  name: 'Year', value: 'year'},
        {  name: 'Title', value: 'title'},
    ];
    $scope.searchDefault = function(search) {
        if(!search) search = "reference";
        SearchService.getSearch(search).then(function(search) {
            $scope.sampleSearch = search;
            $scope.search();
        });
    };
    $scope.searchDefault();

    $scope.search = function() {
        SearchService.listSearch($scope.sampleSearch).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.response = result;
        });
    };
});