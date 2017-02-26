angular.module('search').controller('SearchReferencesController', function($scope, $uibModal){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Author', value: 'author' },
        {  name: 'Year', value: 'year'},
        {  name: 'Title', value: 'title'},
    ];
});