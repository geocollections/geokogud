angular.module('search').controller('FullSearchController', function($scope, SearchService, $uibModal, $rootScope){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Number', value: 'number' },
        {  name: 'Locality', value: 'locality' },
        {  name: 'Depth (m)', value: 'depth' },
        {  name: 'Stratigraphy', value: 'stratigraphy' },
        {  name: 'Collector', value: 'collector' }
    ];

    $scope.defaultSearchOptions = SearchService.defaultSearchOptions();
    // MUST be as CLASSIFIER but not hard coded
    $scope.departments = SearchService.departments();

    //$scope.defaultSearchOption = $scope.defaultSearchOptions[1];
    $scope.defaultSearchOption = $scope.defaultSearchOptions[1].value;


    $scope.searchDefault = function(search) {
        if(!search) search = "SAMPLES";
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

    $scope.toggle = function(state) {
        var i = $scope.sampleSearch.dbs.indexOf(state);
        if (i > -1) {
            $scope.sampleSearch.dbs.splice(i, 1);
        } else {
            $scope.sampleSearch.dbs.push(state);
        }
    };

    $scope.tableChanged = function() {
        $scope.searchDefault($scope.defaultSearchOption);
    };
/*    $scope.$watch('defaultSearchOption', function(data) {
        console.log(data)
    });*/
});