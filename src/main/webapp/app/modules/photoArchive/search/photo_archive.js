angular.module('search').controller('SearchPhotoArchiveController', function($scope, SearchService){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Date', value: 'date' },
        {  name: 'Number', value: 'number' },
        {  name: 'Author', value: 'author' },
    ];
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];

    $scope.searchDefault = function(search) {
        if(!search) search = "image";
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
            console.log(result);
        });
    };
});