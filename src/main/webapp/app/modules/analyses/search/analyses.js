angular.module('search.analyses', []).config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider.state('search.analyses', {
        url: "/analyses",
        templateUrl: "app/modules/analyses/search/analyses.html",
        controller: "SearchAnalysesController",
        reloadOnSearch: false
    });
});
angular.module('search').controller('SearchAnalysesController', function ($scope, $stateParams, $location, $state, SearchService) {
    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = true;
    $scope.isAnalysesFieldsCollapsed = true;
    $scope.isInstitutionsCollapsed = true;
    $scope.sortbyOptions = [
        {name: 'ID', value: 'id'},
        {name: 'Number', value: 'number'},
        {name: 'Locality', value: 'locality'},
        {name: 'Depth (m)', value: 'depth'},
        {name: 'Stratigraphy', value: 'stratigraphy'},
        {name: 'Collector', value: 'collector'},
    ];
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
            $scope.sampleSearch = search;
            $scope.search();
        });
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
        SearchService.listSearch($scope.sampleSearch).then(function (result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 100;
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