var module = angular.module("geoApp");

var constructor = function ($uibModal) {

    var service = {};

    service.currentModal = null;

    service.showModalError = function (errorReason) {
        animation: false,
        $uibModal.open({
            templateUrl: 'app/templates/main/partial/default.error.html',
            controller: ["configuration","$uibModalInstance","errorReason","$translate",
                function(configuration,$uibModalInstance, errorReason, $translate) {
                var vm = this;
                vm.reason = 'ERROR.'+errorReason;
                vm.close = close;

                function close() {
                    $uibModalInstance.close();
                }
            }],
            controllerAs: 'error',
            keyboard: false,
            backdrop: 'static',
            resolve: {
                errorReason: function () {return errorReason;}
            }
        });
    };

    service.commonErrorHandler = function(errorData, status, callback) {
        //400, 401, 403
        var error;
        if (errorData.status == 404) {
            error = "INVALID_REQUEST";
        }

        if(errorData && errorData.data && errorData.data.errorCode) {
            switch (errorData.data.errorCode) {
                case "error.request.failed" : error = "INVALID_REQUEST"; break;
                default : error = "INTERNAL_SERVER_ERROR";break;
            }
        }

        if(error) service.showModalError(error, callback);
    };

    return service;
};

constructor.$inject = ['$uibModal'];
module.service('ErrorService', constructor);