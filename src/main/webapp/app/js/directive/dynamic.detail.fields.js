angular.module('geoApp').directive('entityFieldName', function () {
    return {
        template: "{{name}}",
        restrict: 'AE',
        scope: {
            name: '=',
        },
        link: function (scope) {
        }
    };
}).directive('entityFieldValue', function () {
    return {
        template: '<span>{{value}}</span>' +
                  '<span data-ng-if="isDate">{{value | date:dateFormat}}</span>',
        restrict: 'AE',
        scope: {
            value: '='
        },
        link: function (scope) {
            isDate();
        }
    };
});