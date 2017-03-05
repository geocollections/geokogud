angular.module('search').controller('SearchAnalysesController', function($scope, SearchService){
    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = false;
    $scope.isAnalysesFieldsCollapsed = false;
    $scope.isInstitutionsCollapsed = false;
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Number', value: 'number' },
        {  name: 'Locality', value: 'locality' },
        {  name: 'Depth (m)', value: 'depth' },
        {  name: 'Stratigraphy', value: 'stratigraphy' },
        {  name: 'Collector', value: 'collector' },
    ];
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];

    $scope.searchDefault = function(search) {
        if(!search) search = "analysis";
        SearchService.getSearch(search).then(function(search) {
            $scope.sampleSearch = search;
            $scope.sampleSearch.sortAsc = true;
            $scope.sampleSearch.orderBy = "id";
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

    $scope.order = function(predicate) {
        console.log($scope.sampleSearch)
        $scope.sampleSearch.sortAsc = ($scope.sampleSearch.orderBy === predicate) ? !$scope.sampleSearch.sortAsc : true;
        $scope.sampleSearch.orderBy = predicate;
        $scope.search();
    };

});