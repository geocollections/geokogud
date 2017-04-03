var constructor = function ($scope, $stateParams, applicationService) {
    var vm = this;

    vm.service = applicationService;

    searchEntity();

    function searchEntity () {
        applicationService.getEntity($stateParams.type,$stateParams.id,onEntityData)
    }

    function onEntityData(response) {
        console.log(response.data.result[0]);
        vm.sample = response.data.result[0];
    }

};

constructor.$inject = ["$scope", "$stateParams", 'ApplicationService'];

module.controller("DetailController", constructor);