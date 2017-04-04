var constructor = function ($scope, $stateParams, applicationService, $translate) {
    var vm = this;

    vm.service = applicationService;
    vm.fields = [];
    searchEntity();

    function searchEntity () {
        applicationService.getEntity($stateParams.type,$stateParams.id,onEntityData)
    }

    function onEntityData(response) {
        console.log(response.data.results[0]);
        vm.sample = response.data.results[0];
        dynamicalyCreateField(vm.sample);
    }

    function dynamicalyCreateField(obj) {
        var hintRoot = 'API_TRANSLATION.SAMPLE.';
        Object.keys(obj).forEach(function(key,index) {
            var upKey = key.toUpperCase()
            console.log(upKey);
            if(vm.sample[key] != null && vm.sample[key] != '')
                $translate([hintRoot+upKey]).then(function (translations) {
                    var name = translations[hintRoot+upKey];
                    vm.fields.push({"name" : name, "value" : vm.sample[key]});
                });

            // key: the name of the object key
            // index: the ordinal position of the key within the object
        });
    }

};

constructor.$inject = ["$scope", "$stateParams", 'ApplicationService', '$translate'];

module.controller("DetailController", constructor);