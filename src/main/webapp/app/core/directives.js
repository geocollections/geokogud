angular.module('geoApp').directive('loading', function () {
    return {
        restrict: 'E',
        replace:true,
        template: '<div class="loading"><img src="img/loader.gif" width="20" height="20" />Laaditakse...</div>',
        link: function (scope, element, attr) {
            scope.$watch('loading', function (val) {
                if (val)
                    $(element).show();
                else
                    $(element).hide();
            });
        }
    }
}).directive('saving', function () {
    return {
        restrict: 'E',
        replace:true,
        template: '<div class="saving"><img src="img/loader.gif" width="20" height="20" />Salvestatakse...</div>',
        link: function (scope, element, attr) {
            scope.$watch('saving', function (val) {
                if (val)
                    $(element).show();
                else
                    $(element).hide();
            });
        }
    }
}).directive('compile', function($compile) {
    return function (scope, element, attrs) {
        scope.$watch(
            function (scope) {
                return scope.$eval(attrs.compile);
            },
            function (value) {
                element.html(value);
                $compile(element.contents())(scope);
            }
        );
    };
}).directive('validate', function() {
    /**
     * Custom directive for additional validation of input field
     */
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function(scope, elem, attrs, ngModel) {
            if (!ngModel) return;
            scope.$watch(attrs['validate'], function(v) {
                /**
                 * Maybe shouldn't override $invalid value, but use $error.invalid instead?
                 */
                ngModel.$setValidity('$invalid', v);
            });
        }
    }
}).directive('myTooltip', function() {
    return {
        restrict: 'E',
        templateUrl: 'app/core/views/my-tooltip.html',
        scope: {
            construction: '='
        }
    }
}).directive('bsTooltip', function(){

    return {
        restrict: 'A',
        link: function(scope, element, attrs){
            $(element).hover(function(){
                // on mouseenter
                $(element).tooltip('show');
            }, function(){
                // on mouseleave
                $(element).tooltip('hide');
            });
        }
    };

}).directive('ngClick', function($timeout) {

    /**
     * Overriding angular ng-click due to double click issue:
     * https://github.com/angular/angular.js/issues/9826
     */

    var delay = 500;

    return {
        restrict: 'A',
        priority: -1,
        link: function (scope, elem) {
            var disabled = false;

            function onClick(evt) {
                if (disabled) {
                    evt.preventDefault();
                    evt.stopImmediatePropagation();
                } else {
                    disabled = true;
                    $timeout(function () { disabled = false; }, delay, false);
                }
            }

            scope.$on('$destroy', function () { elem.off('click', onClick); });
            elem.on('click', onClick);
        }
    }

}).directive('focusMe', function($timeout) {
    return {
        scope: { trigger: '@focusMe' },
        link: function(scope, element) {
            scope.$watch('trigger', function(value) {
                if(value === "true") {
                    $timeout(function() {
                        element[0].focus();
                    });
                }
            });
        }
    };
}).directive('stringToNumber', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, ngModel) {
            ngModel.$parsers.push(function(value) {
                return '' + value;
            });
            ngModel.$formatters.push(function(value) {
                return parseFloat(value, 10);
            });
        }
    };
}).directive('clickOutside', ['$document', function ($document) {
    return {
        restrict: 'A',
        scope: {
            clickOutside: '&',
            isActive: '='
        },
        link: function (scope, el, attr) {
            function eventHandler(e){
                if(!scope.isActive){
                    return;
                }
                if (el !== e.target && !el[0].contains(e.target)) {
                    scope.$apply(function () {
                        scope.$eval(scope.clickOutside);
                    });
                }
            }

            $document.on('click', eventHandler);

            scope.$on('$destroy', function() {
                $document.off('click', eventHandler);
            });
        }
    }
}])
.directive('selectexact', function(){
    return {
      template: '<select class="col-md-4 form-control" data-ng-model="sampleSearch.selectexact" ng-options="option.name for option in idOptions track by option.value"><option value="">-- Choose --</option></select>',
        restrict: 'E',
        scope: {
          selectedValue: '='
        },
        link: function (scope) {
          scope.idOptions = [{
              name: 'equals', value: 'equals'
          }, {
              name: 'does not equal', value: 'does not equal'
          },{
              name: 'greater than', value: 'greater than'
          },{
              name: 'smaller than', value: 'smaller than'
          },{
              name: 'is in list', value: 'is in list'
          },{
              name: 'is between', value: 'is between'
          }
          ];
        }
    };
}).directive('selectdefault', function(){
    return {
      template: '<select class="col-md-4 form-control" data-ng-model="sampleSearch.selectdefault" ng-options="option.name for option in defaultOptions track by option.value"><option value="">-- Choose --</option></select>',
        restrict: 'E',
        scope: {
          selectedValue: '='
        },
        link: function (scope) {
          scope.defaultOptions = [{
              name: 'contains', value: 'contains'
          }, {
              name: 'equals', value: 'equals'
          },{
              name: 'start with', value: 'start with'
          },{
              name: 'ends with', value: 'ends with'
          },{
              name: 'does not contain', value: 'does not contain'
          },{
              name: 'is in list', value: 'is in list'
          },
          ];
        }
    };
}).directive('selecthierarchy', function(){
    return {
      template: '<select class="col-md-4 form-control" data-ng-model="sampleSearch.selecthierarchy" ng-options="option.name for option in defaultOptions track by option.value"><option value="">-- Choose --</option></select>',
        restrict: 'E',
        scope: {
          selectedValue: '='
        },
        link: function (scope) {
          scope.defaultOptions = [{
              name: 'hierarchy', value: 'hierarchy'
          },{
              name: 'contains', value: 'contains'
          }, {
              name: 'equals', value: 'equals'
          },{
              name: 'start with', value: 'start with'
          },{
              name: 'ends with', value: 'ends with'
          },{
              name: 'does not contain', value: 'does not contain'
          },{
              name: 'is in list', value: 'is in list'
          },
          ];
        }
    };
}).directive('ascdesc', function(){
    return {
      template: '<select class="col-md-4 form-control" data-ng-model="sortby.asc.desc" ng-options="option.name for option in defaultOptions track by option.value"><option value="">-- Choose --</option></select>',
        restrict: 'E',
        scope: {
          selectedValue: '='
        },
        link: function (scope) {
          scope.defaultOptions = [{
              name: 'ASC', value: 'asc'
          },{
              name: 'DESC', value: 'desc'
          }
          ];
        }
    };
});