var module = angular.module("geoApp");
var constructor = function ($scope, $state,$stateParams, applicationService, configuration, bsLoadingOverlayService, errorService) {
    var vm = this;

    vm.service = applicationService;
    vm.reload = reload;
    vm.fields = [];  vm.urlsMap = [];
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
        vm.imageUrl = (['specimenImage','photoArchive'].indexOf($stateParams.type) > -1 ? vm.service.composeImageUrl(vm.results) : null);
        vm.externalImagePath = (['specimenImage','photoArchive'].indexOf($stateParams.type) > -1  ? vm.service.composeExternalImagePath(vm.results) : null);
        vm.files = (['doi'].indexOf($stateParams.type) > -1 ? composeFileInfo(response.data.results) : []);


        vm.detailLoadingHandler.stop();
        getLocality();
        getRelatedData();
        vm.localities = (['doi'].indexOf($stateParams.type) > -1 ? getLocalities(): []);

    }

    function onDetailError(error) {
        errorService.commonErrorHandler(error);
        vm.detailLoadingHandler.stop();
    }

    function isIncludedField (field) {
        return configuration.detailFieldsConfig[$stateParams.type].ignoreFields.indexOf(field) == -1;
    }

    function getLocalities() {
        //vm.doiGeolocation
        var localities = [];
        angular.forEach(vm.doiGeolocation, function(location){
            localities.push({
                latitude: location.point.split(' ')[0],
                longitude: location.point.split(' ')[1],
                localityEng: location.locality__locality_en,
                localityEt: location.locality__locality,
                fid: ""
            })
        });
        return localities;
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

    function composeFileInfo(results) {
        var files = [];
        angular.forEach(results, function(r) {
            if(r.doiattachment__attachment__filename != null) {
                files.push({fileName : r.doiattachment__attachment__filename});
            }
        });
        return files;
    }

    function reload(id) {
        $state.go('coreBox.view', {id:id})
    }
};

constructor.$inject = ["$scope", "$state", "$stateParams", 'ApplicationService', 'configuration', 'bsLoadingOverlayService', 'ErrorService'];

module.controller("DetailController", constructor);