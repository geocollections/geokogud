angular.module('search').controller('SearchLocalitiesController', function($scope, $uibModal){
    $scope.optionsID = [
        {name: 'equals'},
        {name: 'does not equal'},
        {name: 'greater than'},
        {name: 'smaller than'},
        {name: 'is in list'},
        {name: 'is between'},
    ]
});