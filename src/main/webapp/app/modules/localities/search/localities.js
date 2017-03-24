angular.module('search').controller('SearchLocalitiesController', function($scope, LocalityService){
    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = true;
    $scope.isInstitutionsCollapsed = true;
    $scope.departments = [
        {code: "GIT", label: "GIT"},
        {code: "TUG", label: "TUG"},
        {code: "ELM", label: "ELM"},
        {code: "TUGO", label: "TUGO"},
        {code: "MUMU", label: "MUMU"},
        {code: "EGK", label: "EGK"}];

    $scope.toggle = function(state) {
        var i = $scope.searchParameters.dbs.indexOf(state);
        if (i > -1) {
            $scope.searchParameters.dbs.splice(i, 1);
        } else {
            $scope.searchParameters.dbs.push(state);
        }
    };
    $scope.search = function() {
        LocalityService.search($scope.searchParameters).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.searchParameters.maxSize = 5;
            $scope.response = result;
            if($scope.isMapHidden) {
                $scope.getLocalities($scope.response.result);
            }
        });
    };

    $scope.searchDefault = function() {
        $scope.searchParameters = {sortField : {}, dbs : []};
        $scope.searchParameters.sortField.sortBy = "id";
        $scope.sortByAsc = true;
        //$scope.toggle("GIT");
        $scope.search();
    };

    $scope.searchDefault();

    $scope.order = function(predicate) {
        $scope.sortByAsc = ($scope.searchParameters.sortField.sortBy === predicate ? !$scope.sortByAsc : true);
        $scope.searchParameters.sortField.sortBy =  predicate;
        !$scope.sortByAsc ? $scope.searchParameters.sortField.order = "ASCENDING" :  $scope.searchParameters.sortField.order = "DESCENDING";
        $scope.search();
    };

    $scope.showMap = function(){
        $scope.isMapHidden = !$scope.isMapHidden;
        $scope.getLocalities($scope.response.result);
    };

    $scope.getLocalities = function(list) {
        $scope.localities = [];
        if(list){
            angular.forEach(list, function (el) {
                if(el.latitude != null && el.longitude != null )
                    $scope.localities.push({latitude:el.latitude, longitude:el.longitude})
            })
        }
        return $scope.localities;
    }


}).controller('LocalityDetailsController', function($scope, LocalityService, $uibModal, $http,$stateParams){
    $scope.locality = {};
    LocalityService.details($stateParams.id).then(function(result) {
        $scope.locality = result.locality.result[0];
        console.log(result);
    });
}).factory("LocalityService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/locality', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function(id) {
            return $http.get('/details/locality/'+id)
                .then(function(response){
                    return response.data;
                });
        }
    };
}])