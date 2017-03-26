angular.module('search').controller('SearchStratigraphyController', function($scope, StratigraphyService){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Author', value: 'author' },
    ];
    $scope.stratigraphicSearch = {page:1};


    $scope.search = function() {
        StratigraphyService.search($scope.stratigraphicSearch).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.stratigraphicSearch.maxSize = 5;
            $scope.response = result;
        });
    };

    $scope.search();
}).controller('StratigraphyDetailsController', function($scope, StratigraphyService, $http,$stateParams){
    $scope.loadInfo = function() {
        StratigraphyService.details($stateParams.id).then(function(result){
            $scope.stratigraphy = result.stratigraphy.result[0];
            console.log(result);
        });
    };
    $scope.loadInfo();
});