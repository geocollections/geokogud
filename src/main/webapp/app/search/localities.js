angular.module('search').controller('SearchLocalitiesController', function($scope, $uibModal){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Locality', value: 'Locality' },
        {  name: 'Box count', value: 'Box count' }
    ];

});