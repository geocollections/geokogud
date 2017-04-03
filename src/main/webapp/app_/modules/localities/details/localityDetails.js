angular.module('search').controller('LocalityDetailsController', function($scope,$stateParams, LocalityService){
    $scope.locality = {};

    LocalityService.details($stateParams.id).then(function(result) {
        $scope.locality = result.locality.result[0];
        $scope.images = result.locality.relatedData != null ? result.locality.relatedData.image : null;
        $scope.drillcores = result.locality.relatedData != null ? result.locality.relatedData.drillcore : null;
        $scope.references = result.locality.relatedData != null ? result.locality.relatedData.reference : null;
        $scope.specimens = result.specimens.result;
        console.log(result);
    });
});