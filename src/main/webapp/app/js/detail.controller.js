var constructor = function ($scope, $stateParams, applicationService) {
    var vm = this;

    vm.service = applicationService;
    vm.fields = [];
    searchEntity();

    function searchEntity () {
        applicationService.getEntity($stateParams.type,$stateParams.id,onEntityData)
    }

    function onEntityData(response) {
        console.log(response.data.result[0]);
        vm.sample = response.data.result[0];
        dynamicalyCreateField(vm.sample);
    }

    function dynamicalyCreateField(obj) {
        Object.keys(obj).forEach(function(key,index) {
            console.log(key);
            console.log(vm.sample[key]);
            if(vm.sample[key] != null && vm.sample[key] != '')
                vm.fields.push({"name" : key, "value" : vm.sample[key]});
            // key: the name of the object key
            // index: the ordinal position of the key within the object
        });
    }


};

constructor.$inject = ["$scope", "$stateParams", 'ApplicationService'];

module.controller("DetailController", constructor);