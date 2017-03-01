angular.module('search').controller('SearchSpecimensController', function(SearchService, $scope, $uibModal){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Name', value: 'name' },
        {  name: 'Classification', value: 'classification'},
        {  name: 'Locality', value: 'locality'},
        {  name: 'Depth (m)', value: 'depth'},
        {  name: 'Stratigraphy', value: 'stratigraphy'},
        {  name: 'Collector', value: 'collector'},
        {  name: 'Image date', value: 'imagedate'},
    ];
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];
    $scope.searchDefault = function(search) {
        if(!search) search = "specimen";
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
