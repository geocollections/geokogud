angular.module('search').controller('SearchDrillCoresController', function($scope, $uibModal){

    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];

    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Locality', value: 'Locality' },
        {  name: 'Box count', value: 'Box count' }
    ];

});