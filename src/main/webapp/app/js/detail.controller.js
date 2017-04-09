var module = angular.module("geoApp");
var constructor = function ($scope, $stateParams, applicationService, configuration) {
    var vm = this;

    vm.service = applicationService;
    vm.fields = [];
    vm.urlsMap = [];
    vm.isIncludedField = isIncludedField

    searchEntity();

    function searchEntity () {
        applicationService.getEntity($stateParams.type,$stateParams.id,onEntityData)
    }

    function onEntityData(response) {
        vm.results = response.data.results[0];
        vm.fields = Object.keys(vm.results);
    }

    function isIncludedField (field) {
        return configuration.detailFieldsConfig[$stateParams.type].ignoreFields.indexOf(field) == -1;
    }

};

constructor.$inject = ["$scope", "$stateParams", 'ApplicationService', 'configuration'];

module.controller("DetailController", constructor);