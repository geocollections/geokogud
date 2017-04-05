var module = angular.module("geoApp");
var constructor = function ($scope, $stateParams, applicationService, $translate, $sce) {
    var vm = this;

    vm.service = applicationService;
    vm.fields = [];
    searchEntity();

    function searchEntity () {
        applicationService.getEntity($stateParams.type,$stateParams.id,onEntityData)
    }

    function onEntityData(response) {
        vm.sample = response.data.results[0];
        dynamicalyCreateField(vm.sample);
    }

    function dynamicalyCreateField(obj) {
        var hintRoot = 'API_TRANSLATION.SAMPLE.';
        Object.keys(obj).forEach(function(key,index) {
            var upKey = key.toUpperCase();
            if(vm.sample[key] != null && vm.sample[key] != '')
                $translate([hintRoot+upKey]).then(function (translations) {
                    var name = translations[hintRoot+upKey];
                    vm.fields.push({"name" : name, "value" : $sce.trustAsHtml('<a href="">' + vm.sample[key] + '</a>')});
                });
        });
    }

};

constructor.$inject = ["$scope", "$stateParams", 'ApplicationService', '$translate', '$sce'];

module.controller("DetailController", constructor);