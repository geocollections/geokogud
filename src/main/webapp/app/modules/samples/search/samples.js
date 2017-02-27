angular.module('search').controller('SearchSampleController', function($scope, SearchService, $uibModal){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Number', value: 'number' },
        {  name: 'Locality', value: 'locality' },
        {  name: 'Depth (m)', value: 'depth' },
        {  name: 'Stratigraphy', value: 'stratigraphy' },
        {  name: 'Collector', value: 'collector' }
    ];

    $scope.searchDefault = function() {
        SearchService.getSearch("sample").then(function(search) {
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

    $scope.defaultSearchOptions = [
        {value:"SPECIMENTS",name:"Speciments"},
        {value:"SAMPLES",name:"Samples"},
        {value:"DRILL CORES",name:"Drill cores"},
        {value:"LOCALITIES",name:"Localities"},
        {value:"REFERENCES",name:"References"},
        {value:"STRATIGRAPHY",name:"Stratigraphy"},
        {value:"ANALYSES",name:"Analyses"},
        {value:"PREPARATION",name:"Preparation"},
        {value:"ARCHIVE",name:"Photo archive"},
        {value:"SOIL",name:"SOIL"},
        {value:"DOI",name:"DOI"}];

    //$scope.defaultSearchOption = $scope.defaultSearchOptions[1].value;

    // MUST be as CLASSIFIER but not hard coded
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];

    $scope.toggle = function(state) {
        var i = $scope.sampleSearch.dbs.indexOf(state);
        if (i > -1) {
            $scope.sampleSearch.dbs.splice(i, 1);
        } else {
            $scope.sampleSearch.dbs.push(state);
        }
    };

    /* EXAMPLE STUFF for TAXON SEARCH*/
    $scope.searchService = SearchService;

    $scope.seachTaxonomy = function(val) {
        $scope.hideFullList = false;
        SearchService.taxonListSearch(val).then(function(result) {
            $scope.taxonResult = result;
        });
    };
    $scope.seachTaxonomy();

    $scope.taxonSelected = function(item) {
        $scope.hideFullList = true;
        $scope.currenResult = item;
    };

    $scope.openTaxonModal = function(taxon) {
        $uibModal.open({
            templateUrl:'/app/search/dialogs/taxon_modal.html',
            controller: function ($scope, $uibModalInstance, entity) {
                $scope.entity = entity;

                $scope.cancel = function () {
                    $uibModalInstance.dismiss();
                };
            },
            resolve: {
                entity: function () {
                    return angular.copy(taxon);
                }
            }
        });
    }
});