angular.module('search').controller('SearchStratigraphyController', function($scope, $uibModal){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Author', value: 'author' },
    ];
});