angular.module('search').controller('SearchPhotoArchiveController', function($scope, SearchService,PhotoService){
    $scope.sortbyOptions = [
        {  name: 'ID', value: 'id' },
        {  name: 'Date', value: 'date' },
        {  name: 'Number', value: 'number' },
        {  name: 'Author', value: 'author' },
    ];
    $scope.departments = [
        {code:"GIT",label:"GIT"},
        {code:"TUG",label:"TUG"},
        {code:"ELM",label:"ELM"},
        {code:"TUGO",label:"TUGO"},
        {code:"MUMU",label:"MUMU"},
        {code:"EGK",label:"EGK"}];
    $scope.photoArchiveSearch = {};


    $scope.search = function() {
        if ($scope.photoArchiveSearch.imageSize){
            imageDimensions = $scope.photoArchiveSearch.imageSize.name;
            x = imageDimensions.substring(0,imageDimensions.indexOf("x"));
            y = imageDimensions.substring(imageDimensions.indexOf("x")+1);
            $scope.photoArchiveSearch.sizeX = {
                lookUpType : $scope.photoArchiveSearch.imageSize.lookUpType,
                name : x
            };
            $scope.photoArchiveSearch.sizeY = {
                lookUpType : $scope.photoArchiveSearch.imageSize.lookUpType,
                name : y
            };
        }
        console.log($scope.photoArchiveSearch);
        PhotoService.search($scope.photoArchiveSearch).then(function(result) {
            $scope.totalItems = result.count;
            $scope.pageSize = 30;
            $scope.response = result;
            console.log(result);
        });
    };

    $scope.searchDefault = function() {
        $scope.search();
    };

    $scope.searchDefault();

}).factory("PhotoService", ['$http', function ($http) {
    return {
        search: function (searchParameters) {
            return $http.post('/search/photo-archive', searchParameters)
                .then(function (response) {
                    return response.data;
                });
        }
    };
}]).controller('PhotoArchiveController', function($scope, SearchService, $uibModal, $http,$stateParams){
    $scope.loadInfo = function() {
        $http.get('/details/photo-archive/' + $stateParams.id).then(successCallback, errorCallback);
        function successCallback(response){
            console.log(response);
            $scope.image = response.data.photo.result[0];
        } function errorCallback(response){
            $scope.image = "ehm, an error..";
        }
    };
    $scope.loadInfo();
});