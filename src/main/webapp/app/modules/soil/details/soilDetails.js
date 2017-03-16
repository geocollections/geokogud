angular.module('search').controller('SoilDetailsController', function($scope,$stateParams, SoilService){
    $scope.soil = {};
    $scope.samples = [];

    SoilService.details($stateParams.id).then(function(result) {
        $scope.soil = result.soil.result[0];
        $scope.samples = result.samples.result;
        console.log(result);
    });
});