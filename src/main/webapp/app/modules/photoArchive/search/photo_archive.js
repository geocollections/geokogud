angular.module('search').controller('SearchPhotoArchiveController', function($scope, $uibModal){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Date', value: 'date' },
        {  name: 'Number', value: 'number' },
        {  name: 'Author', value: 'author' },
    ];
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];
});