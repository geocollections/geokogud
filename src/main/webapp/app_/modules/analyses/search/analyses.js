angular.module('search').controller('SearchAnalysesController', function ($scope, $stateParams, $location, $state, SearchService, $uibModal, $window) {
    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = true;
    $scope.isAnalysesFieldsCollapsed = true;
    $scope.isInstitutionsCollapsed = true;

    $scope.departments = [
        {code: "GIT", label: "GIT"},
        {code: "TUG", label: "TUG"},
        {code: "ELM", label: "ELM"},
        {code: "TUGO", label: "TUGO"},
        {code: "MUMU", label: "MUMU"},
        {code: "EGK", label: "EGK"}];

    $scope.searchDefault = function (search) {
        if (!search) search = "analysis";
        //
        SearchService.getSearch(search).then(function (search) {
            $scope.searchParameters = search;
            $scope.search();
        });
    };
    $scope.showHint = function () {
        $scope.isHintHidden = !$scope.isHintHidden;
        $scope.getLocalities($scope.response.result);
    };

    $scope.searchDefault();

    $scope.search = function () {
        var s = $scope.analysesSearch;

        //TODO: what to do with INSTITUTIONS? (list)
        $location.search({
            idValue: returnValue(s.id),
            idType: returnType(s.id),
            numberValue: returnValue(s.number),
            numberType: returnType(s.number),
            bedIndexValue: returnValue(s.bedIndex),
            bedIndexType: returnType(s.bedIndex),
            localityValue: returnValue(s.locality),
            localityType: returnType(s.locality),
            adminunitValue: returnValue(s.adminunit),
            adminunitType: returnType(s.adminunit),
            depthValue: returnValue(s.depth),
            depthType: returnType(s.depth),
            stratigraphyValue: returnValue(s.stratigraphy),
            stratigraphyType: returnType(s.stratigraphy),
            analysisTypeValue: returnValue(s.analysisType),
            analysisTypeType: returnType(s.analysisType),
            componentAnalysedValue: returnValue(s.componentAnalysed),
            componentAnalysedType: returnType(s.componentAnalysed),
            contentValue: returnValue(s.content),
            contentType: returnType(s.content)
        });
        SearchService.listSearch($scope.searchParameters).then(function (result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
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
                // Change maxSize based on window width
                /* if($scope.windowWidth > 1000) {
                 $scope.searchParameters.maxSize = 15;
                 } else if($scope.windowWidth > 800) {
                 $scope.searchParameters.maxSize = 10;
                 } else if($scope.windowWidth > 600) {
                 $scope.searchParameters.maxSize = 8;
                 } */
                if ($scope.windowWidth > 400) {
                    $scope.searchParameters.maxSize = 5;
                } else {
                    $scope.searchParameters.maxSize = 2;
                }
                $scope.$apply();
            });
            $scope.response = result;
            console.log($location.search().bedIndexValue);
        });
    };

    function returnValue(criterion) {
        return criterion.value != null && criterion.value != '' ? criterion.value : null;
    }

    function returnType(criterion) {
        return criterion.value != null && criterion.value != '' ? criterion.type : null;
    }
});