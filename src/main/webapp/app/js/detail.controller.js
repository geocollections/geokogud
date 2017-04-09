var module = angular.module("geoApp");
var constructor = function ($scope, $stateParams, applicationService, $translate, $sce) {
    var vm = this;

    vm.service = applicationService;
    vm.fields = [];
    vm.urlsMap = [];

    searchEntity();

    function searchEntity () {
        applicationService.getEntity($stateParams.type,$stateParams.id,onEntityData)
    }

    function onEntityData(response) {
        vm.results = response.data.results[0];
        vm.fields = Object.keys(vm.results);
        vm.urlsMap = collectUrls(vm.results);

    }

    function collectUrls(obj) {

    }

};

constructor.$inject = ["$scope", "$stateParams", 'ApplicationService', '$translate', '$sce'];

module.controller("DetailController", constructor);