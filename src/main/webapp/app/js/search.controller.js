var module = angular.module("geoApp");

var constructor = function ($scope, $stateParams, configuration, $http, applicationService, $window, $translate, SearchFactory, errorService, bsLoadingOverlayService) {
    var vm = this;
    vm.service = applicationService;
    vm.factory = SearchFactory;
    vm.searchLoadingHandler = bsLoadingOverlayService.createHandler({
        referenceId: "searchView"
    });

    var search = vm.service.getTranslationRoot($stateParams.type);
    $scope.searchParameters = {};

    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = true;
    $scope.isAnalysesFieldsCollapsed = true;
    $scope.isInstitutionsCollapsed = true;

    function onSearchData(result) {
        $scope.pageSize = 100;
        $scope.totalItems = result.data.count;
        $scope.windowWidth = "innerWidth" in window ? window.innerWidth : document.documentElement.offsetWidth;
        if ($scope.windowWidth > 400) {
            $scope.searchParameters.maxSize = 5;
        } else {
            $scope.searchParameters.maxSize = 2;
        }
        // Window resize event
        var w = angular.element($window);
        w.bind('resize', function () {
            $scope.windowWidth = "innerWidth" in window ? window.innerWidth : document.documentElement.offsetWidth;
            if ($scope.windowWidth > 400) {
                $scope.searchParameters.maxSize = 5;
            } else {
                $scope.searchParameters.maxSize = 2;
            }
            $scope.$apply();
        });
        $scope.response = result.data;

        if ($scope.isMapHidden) {
            $scope.getLocalities($scope.response);
        }
        vm.searchLoadingHandler.stop();
        $('html, body').animate({
            scrollTop: ($("#searches").offset().top - 50)
        }, 'fast');
    }

    $scope.search = function () {
        $scope.showImages = $scope.searchParameters.searchImages && $scope.searchParameters.searchImages.name ? true : false;

        vm.searchLoadingHandler.start();
        applicationService.getList($stateParams.type, $scope.searchParameters, onSearchData, onSearchError)
    };

    function onSearchError(error) {
        if(configuration.pageSetUp.debugMode) errorService.commonErrorHandler(error);
        setEmptyResponse();
        vm.searchLoadingHandler.stop();
    }
    function setEmptyResponse() {
        $scope.response.count = 0;
        $scope.response.results = null;
        $scope.totalItems = 0;
    }

    $scope.searchDefault = function () {
        $scope.searchParameters = {
            sortField: {sortBy: "id", order: "DESCENDING"},
            dbs: vm.service.departments.map(function (department) {
                return department.code;
            })
        };
        $scope.sortByAsc = true;
        $scope.search();
    };

    $scope.addRemoveInstitution = function (institution) {
        var index = $scope.searchParameters.dbs.indexOf(institution);
        if (index == -1) {
            vm.service.toggle(institution, $scope.searchParameters.dbs);
        } else {
            $scope.searchParameters.dbs.splice(index, 1);
        }
    };

    $scope.searchDefault();

    $scope.showHint = function () {
        $scope.isHintHidden = !$scope.isHintHidden;

    };

    $scope.showMap = function () {
        $scope.isMapHidden = !$scope.isMapHidden;
        $scope.getLocalities($scope.response.results);
    };

    $scope.countTotalImages = function() {

    };
    $scope.composeImageUrl = function(imageData) {
        var imageUrl = "http://geokogud.info/git/image/";
        return imageUrl+ imageData.imageset__imageset_series + "/"+imageData.imageset__imageset_number+"/"+imageData.filename;
        //http://geokogud.info/git/image/OH/OH07-1/preview/OH07-1-2.jpg
    };
    $scope.getLocalities = function (list) {
        $scope.localities = [];
        if (list) {
            angular.forEach(list, function (el) {
                if (el.locality__latitude != null && el.locality__longitude != null && el.locality__locality_en != null && el.locality__locality != null && el.locality_id != null) {
                    console.log("in if");
                    addToLocalities(el.locality__latitude, el.locality__longitude, el.locality__locality_en, el.locality__locality, el.locality_id);
                } else if (noneIsNull(el.latitude, el.longitude, el.locality_en, el.locality, el.id)) {
                    console.log("else if")
                    addToLocalities(el.latitude, el.longitude, el.locality_en, el.locality, el.id);
                } else if(noneIsNull(el.latitude, el.longitude, '', '', '')) {
                    addToLocalities(el.latitude, el.longitude, '', '', null);
                }
            })
        }
        return $scope.localities;
    };

    function noneIsNull(latitude, longitude, locality_en, locality, locality_id) {
        return latitude != null && longitude != null && locality_en != null && locality != null && locality_id != null;
    }

    function addToLocalities(latitude, longitude, locality_en, locality, locality_id) {
        $scope.localities.push({
            latitude: latitude,
            longitude: longitude,
            localityEng: locality_en,
            localityEt: locality,
            fid: locality_id
        });
    }

};

constructor.$inject = ["$scope", "$stateParams", "configuration", "$http", 'ApplicationService', '$window', '$translate', 'SearchFactory', 'ErrorService', 'bsLoadingOverlayService'];

module.controller("SearchController", constructor);
