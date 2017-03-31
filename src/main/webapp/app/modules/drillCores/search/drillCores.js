angular.module('search').controller('SearchDrillCoresController', function ($scope, DrillCoreService) {
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

    $scope.sortbyOptions = [
        {name: 'ID', value: 'id'},
        {name: 'Locality', value: 'Locality'},
        {name: 'Box count', value: 'Box count'}
    ];

    $scope.toggle = function(state) {
        var i = $scope.searchParameters.dbs.indexOf(state);
        if (i > -1) {
            $scope.searchParameters.dbs.splice(i, 1);
        } else {
            $scope.searchParameters.dbs.push(state);
        }
    };

    $scope.search = function() {
        DrillCoreService.search($scope.searchParameters).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
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
        console.log($scope.localities);
        return $scope.localities;
    }
}).controller('DrillCoreDetailsController', function($scope,$stateParams, DrillCoreService){
    $scope.drillCore = {};
    DrillCoreService.details($stateParams.id).then(function(result) {
        $scope.drillCore = result;
        $scope.drillCoreBoxes = result.drillcoreBoxes;
        console.log(result);
    });
}).factory("DrillCoreService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/drillcore', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        },
        details: function(id) {
            return $http.get('/details/drillcore/'+id)
                .then(function(response){
                    return response.data;
                });
        }
    };
}])