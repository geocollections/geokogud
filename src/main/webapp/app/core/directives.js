angular.module('geoApp').directive('loading', function () {
    return {
        restrict: 'E',
        replace: true,
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
        replace: true,
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
}).directive('compile', function ($compile) {
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
}).directive('validate', function () {
    /**
     * Custom directive for additional validation of input field
     */
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function (scope, elem, attrs, ngModel) {
            if (!ngModel) return;
            scope.$watch(attrs['validate'], function (v) {
                /**
                 * Maybe shouldn't override $invalid value, but use $error.invalid instead?
                 */
                ngModel.$setValidity('$invalid', v);
            });
        }
    }
}).directive('myTooltip', function () {
    return {
        restrict: 'E',
        templateUrl: 'app/core/views/my-tooltip.html',
        scope: {
            construction: '='
        }
    }
}).directive('bsTooltip', function () {

    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            $(element).hover(function () {
                // on mouseenter
                $(element).tooltip('show');
            }, function () {
                // on mouseleave
                $(element).tooltip('hide');
            });
        }
    };

}).directive('ngClick', function ($timeout) {

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
                    $timeout(function () {
                        disabled = false;
                    }, delay, false);
                }
            }

            scope.$on('$destroy', function () {
                elem.off('click', onClick);
            });
            elem.on('click', onClick);
        }
    }

}).directive('focusMe', function ($timeout) {
    return {
        scope: {trigger: '@focusMe'},
        link: function (scope, element) {
            scope.$watch('trigger', function (value) {
                if (value === "true") {
                    $timeout(function () {
                        element[0].focus();
                    });
                }
            });
        }
    };
}).directive('stringToNumber', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            ngModel.$parsers.push(function (value) {
                return '' + value;
            });
            ngModel.$formatters.push(function (value) {
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
            function eventHandler(e) {
                if (!scope.isActive) {
                    return;
                }
                if (el !== e.target && !el[0].contains(e.target)) {
                    scope.$apply(function () {
                        scope.$eval(scope.clickOutside);
                    });
                }
            }

            $document.on('click', eventHandler);

            scope.$on('$destroy', function () {
                $document.off('click', eventHandler);
            });
        }
    }
}])
    .directive('selectexact', function () {
        return {
            template: '<select class="{{selectCss}}" data-ng-model="field" ' +
            'ng-options="option.value as option.name for option in idOptions"></select>',
            restrict: 'E',
            scope: {
                field: '=?ngModel',
                customCss: '@'
            },
            link: function (scope) {
                scope.selectCss = angular.isUndefined(scope.customCss) ? 'col-md-4 form-control' : scope.customCss;
                scope.idOptions = [{
                    name: 'equals', value: 'exact'
                }, {
                    name: 'does not equal', value: 'iexact'
                }, {
                    name: 'greater than', value: 'gt'
                }, {
                    name: 'smaller than', value: 'lt'
                }, {
                    name: 'is in list', value: 'in'
                }, {
                    name: 'is between', value: 'range'
                }
                ];

                scope.$watch('field', function (data) {
                    if (data) return;
                    scope.field = scope.idOptions[0].value;
                });
            }
        };
    }).directive('selectdefault', function () {
    return {
        template: '<select class="{{selectCss}}" data-ng-model="field" ' +
        'ng-options="option.value as option.name for option in defaultOptions"></select>',
        restrict: 'E',
        scope: {
            field: '=?ngModel',
            customCss: '@'
        },
        link: function (scope, $watch) {
            scope.selectCss = angular.isUndefined(scope.customCss) ? 'col-md-4 form-control' : scope.customCss;
            scope.defaultOptions = [{
                name: 'contains', value: 'contains'
            }, {
                name: 'equals', value: 'exact'
            }, {
                name: 'start with', value: 'startswith'
            }, {
                name: 'ends with', value: 'startswith'
            }, {
                name: 'does not contain', value: 'icontains'
            }, {
                name: 'is in list', value: 'in'
            }
            ];

            scope.$watch('field', function (data) {
                if (data) return;
                scope.field = scope.defaultOptions[0].value;
            });
        }
    };
}).directive('selecthierarchy', function () {
    return {
        template: '<select class="{{selectCss}}" data-ng-model="field" ' +
        'ng-options="option.value as option.name for option in defaultOptions"></select>',
        restrict: 'E',
        scope: {
            field: '=?ngModel',
            customCss: '@'
        },
        link: function (scope) {
            scope.selectCss = angular.isUndefined(scope.customCss) ? 'col-md-4 form-control' : scope.customCss;
            scope.defaultOptions = [{
                name: 'hierarchy', value: 'hierarchy'
            }, {
                name: 'contains', value: 'contains'
            }, {
                name: 'equals', value: 'exact'
            }, {
                name: 'start with', value: 'startswith'
            }, {
                name: 'ends with', value: 'startswith'
            }, {
                name: 'does not contain', value: 'icontains'
            }, {
                name: 'is in list', value: 'in'
            },
            ];

            scope.$watch('field', function (data) {
                if (data) return;
                scope.field = scope.defaultOptions[0].value;
            });
        }
    };
}).directive('ascdesc', function () {
    return {
        template: '<select class="col-md-4 form-control" data-ng-model="field" ' +
        'ng-options="option.value as option.name for option in defaultOptions track by option.value"><option value="">-- Choose --</option></select>',
        restrict: 'E',
        scope: {
            field: '=?ngModel'
        },
        link: function (scope) {
            scope.defaultOptions = [{
                name: 'ASC', value: 'asc'
            }, {
                name: 'DESC', value: 'desc'
            }
            ];

        }
    };
}).directive('sectionOpenedIcon', function(){
    return {
        template: '<i class="pull-right glyphicon" ng-class="{\'glyphicon-chevron-down\': !isOpened, \'glyphicon-chevron-right\': isOpened}"></i>',
        restrict: 'E',
        transclude: true,
        replace: true,
        scope: {
            isOpened : '='
        }
    };
}).directive('localityMap',
    function () {
        return {
            scope: {
                x: '=',
                y: '=',
                name: '=',
                fid: '='
            },
            restrict: 'AE',
            replace: true,
            templateUrl: 'app/core/localityMap.html',
            controller: ['$scope', function ($scope) {
                var watcher = $scope.$watch('x', function() {
                    if($scope.x === undefined) return;
                    // at this point it is defined, map can be initialized
                    init();
                    // delete watcher if appropriate
                    watcher();
                });

                var olMap;

                function init()
                {
                    olMap = new ol.Map ({
                        target: "map",
                        layers: [
                            /*
                             new ol.layer.Tile({
                             //source: new ol.source.Stamen({
                             //layer: 'toner',
                             //})
                             source: new ol.source.OSM()
                             }),*/

                            new ol.layer.Tile({
                                source: new ol.source.XYZ({
                                    url: 'https://api.tiles.mapbox.com/v4/mapbox.light/{z}/{x}/{y}.png?access_token=pk.eyJ1Ijoia3V1dG9iaW5lIiwiYSI6ImNpZWlxdXAzcjAwM2Nzd204enJvN2NieXYifQ.tp6-mmPsr95hfIWu3ASz2w'
                                })
                            })
                        ],
                        controls: ol.control.defaults({
                            attributionOptions: ({
                                collapsible: true
                            })
                        }).extend([
                            new ol.control.ScaleLine({units: "metric"}),
                            new ol.control.FullScreen()
                        ]),
                        interactions: ol.interaction.defaults({mouseWheelZoom:false}),
                        view: new ol.View({
                            projection: "EPSG:3857",
                            center: ol.proj.transform([$scope.y, $scope.x], 'EPSG:4326', 'EPSG:3857'),
                            zoom: 6,
                            maxZoom: 16,
                            minZoom: 4,
                            restrictedExtent: ol.proj.transformExtent([-10, 52, 2, 62], 'EPSG:4326', 'EPSG:3857')
                        })
                    });



                    function defaultStyle(feature, resolution)
                    {
                        return [
                            new ol.style.Style({
                                image: new ol.style.Circle({
                                    radius: feature.radius,
                                    fill: new ol.style.Fill({ color: feature.fillColor, opacity: 0.8 }),
                                    stroke: new ol.style.Stroke({color: feature.outlineColor, width: 1})
                                }),
                                text: (resolution > 5000 ? null : new ol.style.Text({
                                    font: feature.fontSize + 'pt Arial, Helvetica, Helvetica Neue, Arial, sans-serif',
                                    text: feature.label,
                                    fill: new ol.style.Fill({ color: feature.textColor }),
                                    stroke: new ol.style.Stroke({color: feature.textoutlineColor, width: 3}),
                                    textAlign: 'left',
                                    textBaseline: 'bottom',
                                    offsetX: 5,
                                    offsetY: -5,
                                }))
                            })
                        ]
                    };
                    var vectorSource = new ol.source.Vector({
                        //attributions: [new ol.Attribution({
                        //	html: "Data from PA/Credit Suisse."})]
                    });



                    var centroidLL = ol.proj.transform([$scope.y, $scope.x], 'EPSG:4326', 'EPSG:3857');
                    var centroidPoint = new ol.geom.Point(centroidLL);
                    var feature = new ol.Feature({ geometry: centroidPoint });

                    feature.name = $scope.name;
                    feature.fid = $scope.fid;
                    feature.numsamples = '0';
                    feature.dec_time_str = '';
                    feature.dec_time_num = 0.5;
                    feature.elect_pc = 0.5;
                    feature.yes_rating = 10;
                    feature.radius = 7;
                    feature.label = $scope.name;

                    feature.fontSize = parseInt(feature.radius*0.7);
                    if (feature.fontSize < 8)
                    {
                        feature.fontSize = 10;
                    }

                    //var r = 1-(feature.yes_rating/10.0);
                    //var g = 0;
                    //var b = 1-r;
                    feature.fillColor = 'rgba(238,59,13,0.8)';
                    feature.outlineColor = 'rgba(255,255,255,0.9)';
                    feature.textColor  = 'rgba(238,59,13,1)';
                    feature.textoutlineColor  = '#fff';
                    vectorSource.addFeature(feature);

                    var layerData = new ol.layer.Vector({
                        title: "Localities",
                        source: vectorSource,
                        style: function(feature, resolution) { return defaultStyle(feature, resolution); }
                    })

                    olMap.addLayer(layerData);

                    /*olMap.getViewport().addEventListener('mousemove', function(evt)
                     {
                     var pixel = olMap.getEventPixel(evt);
                     displayFeatureInfo(pixel);
                     });

                     //olMap.on('click', function(evt) { displayFeatureInfo(evt.pixel); }); //Useful for touch-based viewing, e.g. on iPhone.
                     olMap.on('click', function(evt) { openLoc(evt.pixel); });
                     */
                }



                var openLoc = function(pixel) {

                    var feature = olMap.forEachFeatureAtPixel(pixel, function(feature, layer) {
                        return feature;
                    });

                    if (feature)
                    {
                        //window.location = '/locality/' + feature.fid;
                        window.open('/locality/' + feature.fid, '', 'width=750,height=750,scrollbars, resizable');
                    }
                    else
                    {
                        document.getElementById('hoverbox').style.display = 'none';
                    }
                };

            }]
        }
});

