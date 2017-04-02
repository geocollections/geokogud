var constructor = function ($scope, $stateParams, applicationService) {
    var vm = this;

    console.log("TEST");
    vm.service = applicationService;

    searchEntity();

    function searchEntity () {
        console.log("searching...");
        applicationService.getEntity($stateParams.type,$stateParams.id,onEntityData)
    }

    function onEntityData(data) {
        console.log(data);
    }

};

constructor.$inject = ["$scope", "$stateParams", 'ApplicationService'];

module.controller("DetailController", constructor);