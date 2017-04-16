var module = angular.module("geoApp");
var constructor = function ($scope, $stateParams, applicationService, configuration, bsLoadingOverlayService, errorService) {
    var vm = this;

    vm.service = applicationService;
    vm.fields = [];
    vm.urlsMap = [];
    vm.isIncludedField = isIncludedField;
    vm.detailLoadingHandler = bsLoadingOverlayService.createHandler({referenceId: "detailView"});

    searchEntity();

    function searchEntity () {
        vm.detailLoadingHandler.start();
        applicationService.getEntity($stateParams.type,$stateParams.id,onEntityData, onDetailError)
    }

    function onEntityData(response) {
        vm.results = response.data.results[0];
        vm.relatedData = response.data.related_data;
        vm.fields = Object.keys(vm.results);
        vm.detailLoadingHandler.stop();
        getLocality();
        getRelatedData();
    }


    function onDetailError(error) {
        errorService.commonErrorHandler(error);
        vm.detailLoadingHandler.stop();
    }

    function isIncludedField (field) {
        return configuration.detailFieldsConfig[$stateParams.type].ignoreFields.indexOf(field) == -1;
    }

    function getLocality() {
        var localityFields = configuration.detailFieldsConfig[$stateParams.type].locality;
        if(localityFields) {
            vm.locality = {
                latitude : vm.results[localityFields.lat],
                longitude : vm.results[localityFields.lon],
                localityId : vm.results[localityFields.id],
                localityEn : vm.results[localityFields.value_en],
                countryEn : vm.results[localityFields.country]
            };
        }
    }

    function getRelatedData() {
        if(vm.relatedData) {
            vm.doiAgent = vm.relatedData["doi_agent"];
            vm.doiRelatedIdentifier = vm.relatedData["doi_related_identifier"];
            vm.doiGeolocation = vm.relatedData["doi_geolocation"];
            vm.samples = vm.relatedData["sample"];
            vm.soilHorizon = vm.relatedData["soil_horizon"];
            vm.stratigraphyStratotype = vm.relatedData["stratigraphy_stratotype"];
            vm.stratigraphyReference = vm.relatedData["stratigraphy_reference"];
            vm.stratigraphySynonym = vm.relatedData["stratigraphy_synonym"];
            vm.references = vm.relatedData["reference"];
            vm.drillcores = vm.relatedData["drillcore"];
            vm.images = vm.relatedData["image"];
            vm.drillcoreBoxes = vm.relatedData["drillcore_box"];
            vm.specimenIdentifications = vm.relatedData["specimen_identification"];
            vm.specimenReference = vm.relatedData["specimen_reference"];
            vm.specimenImage = vm.relatedData["specimen_image"];
            vm.localityReferences = vm.relatedData["locality_reference"];
            vm.localitySynonyms = vm.relatedData["locality_synonym"];
        }
    }
};

constructor.$inject = ["$scope", "$stateParams", 'ApplicationService', 'configuration', 'bsLoadingOverlayService', 'ErrorService'];

module.controller("DetailController", constructor);