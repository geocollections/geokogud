angular.module('search').controller('SearchLocalitiesController', function($scope, SearchService){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Locality', value: 'Locality' },
        {  name: 'Box count', value: 'Box count' }
    ];
    $scope.searchDefault = function(search) {
        if(!search) search = "locality";
        SearchService.getSearch(search).then(function(search) {
            $scope.sampleSearch = search;
            $scope.sampleSearch.table = "locality";
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