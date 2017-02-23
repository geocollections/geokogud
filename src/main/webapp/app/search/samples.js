angular.module('search').controller('SearchSampleController', function($scope, SearchService, $uibModal){
    $scope.searchDefault = function() {
        SearchService.getSearch("sample").then(function(response) {
            $scope.samleSearch = response;
        });
    };

    $scope.searchDefault();

    $scope.search = function() {
        SearchService.sampleListSearch($scope.samleSearch);
    };

    // MUST be as CLASSIFIER but not hard coded
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}]

    $scope.toggle = function(state) {
        var i = $scope.samleSearch.dbs.indexOf(state);
        if (i > -1) {
            $scope.samleSearch.dbs.splice(i, 1);
        } else {
            $scope.samleSearch.dbs.push(state);
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