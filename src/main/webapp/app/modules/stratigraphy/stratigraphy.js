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
}).controller('StratigraphyController', function($scope, SearchService, $uibModal, $http,$stateParams){
    $scope.loadInfo = function() {
        $http.get('/search/stratigraphy/' + $stateParams.id).success(function (response) {
            $scope.stratigraphy = response.result[0];
        });
    };
    $scope.loadInfo();
}).controller('StratigraphyDetailsController',function($scope,$http){

});