angular.module('search').controller('FullSearchController', function($scope, SearchService, $uibModal){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Number', value: 'number' },
        {  name: 'Locality', value: 'locality' },
        {  name: 'Depth (m)', value: 'depth' },
        {  name: 'Stratigraphy', value: 'stratigraphy' },
        {  name: 'Collector', value: 'collector' }
    ];

    $scope.defaultSearchOptions = [
        {value:"SPECIMENS",name:"Specimens"},
        {value:"SAMPLES",name:"Samples"},
        {value:"DRILL CORES",name:"Drill cores"},
        {value:"LOCALITIES",name:"Localities"},
        {value:"REFERENCES",name:"References"},
        {value:"STRATIGRAPHIES",name:"Stratigraphy"},
        {value:"ANALYSES",name:"Analyses"},
        {value:"PREPARATION",name:"Preparation"},
        {value:"ARCHIVE",name:"Photo archive"},
        {value:"SOIL",name:"SOIL"},
        {value:"DOI",name:"DOI"}];

    //$scope.defaultSearchOption = $scope.defaultSearchOptions[1];
    $scope.defaultSearchOption = $scope.defaultSearchOptions[1].value;

    // MUST be as CLASSIFIER but not hard coded
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];

    $scope.searchDefault = function(search) {
        if(!search) search = "SAMPLES";
        SearchService.getSearch(search).then(function(search) {
            $scope.sampleSearch = search;
            $scope.search();
        });
    };

    $scope.searchDefault();

    $scope.search = function() {
        SearchService.sampleListSearch($scope.sampleSearch).then(function(result) {
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