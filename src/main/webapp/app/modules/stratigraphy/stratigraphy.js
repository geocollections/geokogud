angular.module('search').controller('SearchStratigraphyController', function($scope, SearchService){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Author', value: 'author' },
    ];

    $scope.searchDefault = function(search) {
        if(!search) search = "stratigraphy";
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