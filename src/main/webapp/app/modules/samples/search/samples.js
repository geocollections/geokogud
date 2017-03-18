angular.module('search').controller('SearchSampleController', function($scope, SampleService, SearchService, $uibModal){
    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = true;
    $scope.isInstitutionsCollapsed = true;$scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Number', value: 'number' },
        {  name: 'Locality', value: 'locality' },
        {  name: 'Depth (m)', value: 'depth' },
        {  name: 'Stratigraphy', value: 'stratigraphy' },
        {  name: 'Collector', value: 'collector' }
    ];


    $scope.search = function() {
        SampleService.search($scope.searchParameters).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.searchParameters.maxSize = 5;
            $scope.response = result;
        });
    };

    $scope.searchDefault = function() {
        $scope.searchParameters = {sortField : {}, dbs : []};
        $scope.searchParameters.sortField.sortBy = "id";
        $scope.sortByAsc = true;
        $scope.search();
    };

    $scope.searchDefault();

    $scope.defaultSearchOptions = [
        {value:"specimen",name:"Speciments"},
        {value:"sample",name:"Samples"},
        {value:"drillcore",name:"Drill cores"},
        {value:"locality",name:"Localities"},
        {value:"reference",name:"References"},
        {value:"stratigraphy",name:"Stratigraphy"},
        {value:"analysis",name:"Analyses"},
        {value:"preparation",name:"Preparation"},
        {value:"image",name:"Photo archive"},
        {value:"soil",name:"SOIL"},
        {value:"doi",name:"DOI"}];

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

    $scope.searchService = SearchService;
    $scope.entitySelected = function(item) {
        $scope.sampleSearch.locality.name = item.locality;
    };
    $scope.showMap = function(){
        $scope.isMapHidden = !$scope.isMapHidden;
        $scope.getLocalities($scope.response.result);
    };
    $scope.getLocalities = function(list) {
        $scope.localities = [];
        if(list){
          angular.forEach(list, function (el) {
              if(el.latitude != null && el.longitude != null  && el.localityEng != null  && el.locality != null  && el.localityId != null)
                $scope.localities.push({latitude:el.latitude, longitude:el.longitude, localityEng : el.localityEng, localityEt:el.locality, fid:el.localityId})
          })
        }
        return $scope.localities;
    }


}).controller('SampleController', function($scope, SearchService, $uibModal, $http,$stateParams){
    $scope.loadInfo = function() {
        $http.get('/search/sample/' + $stateParams.id).then(successCallback, errorCallback);
        function successCallback(response){
            console.log(response);
            $scope.sample = response.data.result[0];
        } function errorCallback(response){
            $scope.sample = "ehm, an error..";
        }
    };
    $scope.loadInfo();
}).factory("SampleService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/sample', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function(id) {
            return $http.get('/details/sample/'+id)
                .then(function(response){
                    return response.data;
                });
        }
    };
}])
