angular.module('search').controller('SearchSoilController', function($scope, SoilService){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Person/institution', value: 'personInstitution' },
    ];
    $scope.searchParameters = {};

    $scope.search = function() {
        SoilService.search($scope.searchParameters).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
            $scope.response = result;
            console.log($scope.response);
        });
    };
});