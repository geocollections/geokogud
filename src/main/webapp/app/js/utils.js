var module = angular.module('geoApp');

var constructor = function ($http) {

    var service = {};

    service.isFunction = function (testable) {
        return typeof testable == "function";
    };

    service.httpGet = function (url, data, successCb, errorCb, headers) {
        var config = {
            "params": data,
            "headers": headers ? headers : {},
            "method": "GET",
            "url": url
        };

        service.httpRequest(url, config, successCb, errorCb)
    };

    service.httpPost = function (url, data, successCb, errorCb, headers) {
        var config = {
            "data": data,
            "headers": headers ? headers : {},
            "method": "POST",
            "url": url
        };

        service.httpRequest(url, config, successCb, errorCb)
    };

    service.preRequestCallbacks = [];

    service.httpRequest = function (url, config, successCb, errorCb) {

        for (var i in service.preRequestCallbacks) {
            if (service.isFunction(service.preRequestCallbacks[i])) {
                service.preRequestCallbacks[i]();
            }
        }

        $http(config).then(successCallback, errorCallback);

        function successCallback(response, status, headers, config) {
            service.isFunction(successCb) && successCb(response, status, headers, config);
        }

        function errorCallback(err, status, headers, config) {
            service.isFunction(errorCb) && errorCb(err, status, headers, config);
        }

    };

    service.inArray = function (elem, arr) {
        return arr.indexOf(elem) >= 0;
    };

    service.toggleInArray = function (elem, arr) {
        var inArr = service.inArray(elem, arr);
        if (inArr) {
            arr.splice(arr.indexOf(elem), 1);
        }
        else {
            arr.push(elem);
        }
    };

    return service;
};

constructor.$inject = ['$http'];

module.service('utils', constructor);
