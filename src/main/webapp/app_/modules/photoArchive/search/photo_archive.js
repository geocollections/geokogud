angular.module('search').controller('SearchPhotoArchiveController', function ($scope, SearchService, PhotoService, $uibModal, $window) {
    $scope.isIdentifierFieldsCollapsed = false;
    $scope.isLocationFieldsCollapsed = true;
    $scope.isInstitutionsCollapsed = true;

    $scope.departments = [
        {code: "GIT", label: "GIT"},
        {code: "TUG", label: "TUG"},
        {code: "ELM", label: "ELM"},
        {code: "TUGO", label: "TUGO"},
        {code: "MUMU", label: "MUMU"},
        {code: "EGK", label: "EGK"}];

    $scope.searchParameters = {};

    $scope.showHint = function () {
        $scope.isHintHidden = !$scope.isHintHidden;
        $scope.getLocalities($scope.response.result);
    };

    $scope.search = function () {
        if ($scope.searchParameters.imageSize) {
            imageDimensions = $scope.searchParameters.imageSize.name;
            if (imageDimensions) {
                x = imageDimensions.substring(0, imageDimensions.indexOf("x"));
                y = imageDimensions.substring(imageDimensions.indexOf("x") + 1);
                $scope.searchParameters.sizeX = {
                    lookUpType: $scope.searchParameters.imageSize.lookUpType,
                    name: x
                };
                $scope.searchParameters.sizeY = {
                    lookUpType: $scope.searchParameters.imageSize.lookUpType,
                    name: y
                };
            }
        }
        console.log($scope.searchParameters);
        PhotoService.search($scope.searchParameters).then(function (result) {
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
            console.log(result);
        });
    };

    $scope.searchDefault = function () {
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
}]).controller('PhotoArchiveController', function ($scope, SearchService, $uibModal, $http, $stateParams) {
    $scope.loadInfo = function () {
        $http.get('/details/photo-archive/' + $stateParams.id).then(successCallback, errorCallback);
        function successCallback(response) {
            console.log(response);
            $scope.image = response.data.photo.result[0];
            $scope.imageUrl = "http://geokogud.info/di.php?f=/var/www/"
                + $scope.image.databaseAcronym.toLowerCase()
                + "/image/" + $scope.image.imagesetSeries
                + "/" + $scope.image.imagesetNumber
                + "/" + $scope.image.fileName;
        }

        function errorCallback(response) {
            $scope.image = "ehm, an error..";
        }
    };
    $scope.loadInfo();
});