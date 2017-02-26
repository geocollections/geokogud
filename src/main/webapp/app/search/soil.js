angular.module('search').controller('SearchSoilController', function($scope, $uibModal){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Person/institution', value: 'personInstitution' },
    ];
});