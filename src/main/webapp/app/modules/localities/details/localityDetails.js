angular.module('search').controller('LocalityDetailsController', function($scope,$stateParams, LocalityService){
    $scope.locality = {};

    LocalityService.details($stateParams.id).then(function(result) {
        $scope.locality = result.locality.result[0];
        console.log(result);
    });
});