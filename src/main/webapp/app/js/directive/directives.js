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
}]).directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if(event.which === 13) {
                scope.$apply(function (){
                    scope.$eval(attrs.ngEnter);
                });
                event.preventDefault();
            }
        });
    };
})
    .directive('selectexact', function ($translate) {
        return {
            template:
                '<select class="{{selectCss}}" ng-model="field">' +
                    '<option value="exact" selected="selected">{{ \'SEARCH.SELECT.EQUALS\' | translate }}</option>' +
                    '<option value="iexact">{{ \'SEARCH.SELECT.DOESNOTEQUAL\' | translate }}</option>' +
                    '<option value="gt">{{ \'SEARCH.SELECT.GREATERTHAN\' | translate }}</option>' +
                    '<option value="lt">{{ \'SEARCH.SELECT.SMALLERTHAN\' | translate }}</option>' +
                    '<option value="in">{{ \'SEARCH.SELECT.ISINLIST\' | translate }}</option>' +
                    '<option value="range">{{ \'SEARCH.SELECT.ISBWETWEEN\' | translate }}</option>' +
                '</select>',
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
        template:
            '<select class="{{selectCss}}" ng-model="field">' +
                '<option value="contains" selected="selected">{{ \'SEARCH.SELECT.CONTAINS\' | translate }}</option>' +
                '<option value="exact">{{ \'SEARCH.SELECT.EQUALS\' | translate }}</option>' +
                '<option value="istartswith">{{ \'SEARCH.SELECT.STARTSWITH\' | translate }}</option>' +
                '<option value="endswith">{{ \'SEARCH.SELECT.ENDSWITH\' | translate }}</option>' +
                '<option value="icontains">{{ \'SEARCH.SELECT.DOESNOTCONTAIN\' | translate }}</option>' +
                '<option value="in">{{ \'SEARCH.SELECT.ISINLIST\' | translate }}</option>' +
            '</select>',
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
                name: 'start with', value: 'istartswith'
            }, {
                name: 'ends with', value: 'endswith'
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
        template:
            '<select class="{{selectCss}}" ng-model="field">' +
                '<option value="hierarchy" selected="selected">{{ \'SEARCH.SELECT.HIERARCHY\' | translate }}</option>' +
                '<option value="contains">{{ \'SEARCH.SELECT.CONTAINS\' | translate }}</option>' +
                '<option value="exact">{{ \'SEARCH.SELECT.EQUALS\' | translate }}</option>' +
                '<option value="istartswith">{{ \'SEARCH.SELECT.STARTSWITH\' | translate }}</option>' +
                '<option value="iendswith">{{ \'SEARCH.SELECT.ENDSWITH\' | translate }}</option>' +
                '<option value="icontains">{{ \'SEARCH.SELECT.DOESNOTCONTAIN\' | translate }}</option>' +
                '<option value="in">{{ \'SEARCH.SELECT.ISINLIST\' | translate }}</option>' +
            '</select>',
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
                name: 'ends with', value: 'endsswith'
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
}).directive('sectionOpenedIcon', function () {
    return {
        template: '<i class="pull-right glyphicon" ng-class="{\'glyphicon-chevron-down\': !isOpened, \'glyphicon-chevron-right\': isOpened}"></i>',
        restrict: 'E',
        transclude: true,
        replace: true,
        scope: {
            isOpened: '='
        }
    };
}).directive('showRowIfPresent', function () {
    return {
        template: '<tr ng-show=\"value\"><td>{{name}}</td><td>{{value}}</td></tr>',
        restrict: 'E',
        scope: {
            name: '@',
            value: '='
        }
    };
}).directive('localize', ['$translate', '$rootScope', function ($translate, $rootScope) {
    return {
        template: '{{localizedValue}}',
        restrict: 'E',
        scope: {
            et: '=',
            en: '='
        },
        link: function (scope) {
            scope.$watch('[et, en]', function(newValue) {
                scope.localizedValue = $translate.use() == 'et' ? newValue[0] : newValue[1];
            }, true);
            $rootScope.$on('$translateChangeSuccess', function() {
                scope.localizedValue = $translate.use() == 'et' ? scope.et : scope.en;
            });
        }
    };
}]).directive('firstNotNull',function(){
    return {
        template: '{{value}}',
        restrict: 'E',
        scope: {
            values: '='
        },
        //also accepts inner arrays:
        // [entity.id, [entity.name, entity.number]] - if id is null, will show non-null elements from the inner array
        link: function (scope) {
            values = scope.values;
            if (values) {
                for (var i = 0; i < values.length; i++) {
                    if (values[i]) {
                        if (values[i] instanceof Array) {
                            result = "";
                            for (var j = 0; j < values[i].length; j++) {
                                if (values[i][j]) {
                                    result += values[i][j] + " ";
                                }
                            }
                            scope.value = result;
                        } else {
                            scope.value = values[i];
                        }
                        break;
                    }
                }
            }
        }
    };
})
    .directive('localityMap',
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
            template: '<div id="map" style="height: 300px; width:99%; max-width: 1980px; padding: 0px; border: solid 1px #999; margin: 0;"></div>',
            controller: ['$scope', function ($scope) {
                var watcher = $scope.$watch('x', function () {
                    if ($scope.x === undefined) return;
                    // at this point it is defined, map can be initialized
                    init();
                    // delete watcher if appropriate
                    watcher();
                });

                var olMap;

                function init() {
                    olMap = new ol.Map({
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
                        interactions: ol.interaction.defaults({mouseWheelZoom: false}),
                        view: new ol.View({
                            projection: "EPSG:3857",
                            center: ol.proj.transform([$scope.y, $scope.x], 'EPSG:4326', 'EPSG:3857'),
                            zoom: 6,
                            maxZoom: 16,
                            minZoom: 4,
                            restrictedExtent: ol.proj.transformExtent([-10, 52, 2, 62], 'EPSG:4326', 'EPSG:3857')
                        })
                    });


                    function defaultStyle(feature, resolution) {
                        return [
                            new ol.style.Style({
                                image: new ol.style.Circle({
                                    radius: feature.radius,
                                    fill: new ol.style.Fill({color: feature.fillColor, opacity: 0.8}),
                                    stroke: new ol.style.Stroke({color: feature.outlineColor, width: 1})
                                }),
                                text: (resolution > 5000 ? null : new ol.style.Text({
                                        font: feature.fontSize + 'pt Arial, Helvetica, Helvetica Neue, Arial, sans-serif',
                                        text: feature.label,
                                        fill: new ol.style.Fill({color: feature.textColor}),
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
                    var feature = new ol.Feature({geometry: centroidPoint});

                    feature.name = $scope.name;
                    feature.fid = $scope.fid;
                    feature.numsamples = '0';
                    feature.dec_time_str = '';
                    feature.dec_time_num = 0.5;
                    feature.elect_pc = 0.5;
                    feature.yes_rating = 10;
                    feature.radius = 7;
                    feature.label = $scope.name;

                    feature.fontSize = parseInt(feature.radius * 0.7);
                    if (feature.fontSize < 8) {
                        feature.fontSize = 10;
                    }

                    //var r = 1-(feature.yes_rating/10.0);
                    //var g = 0;
                    //var b = 1-r;
                    feature.fillColor = 'rgba(238,59,13,0.8)';
                    feature.outlineColor = 'rgba(255,255,255,0.9)';
                    feature.textColor = 'rgba(238,59,13,1)';
                    feature.textoutlineColor = '#fff';
                    vectorSource.addFeature(feature);

                    var layerData = new ol.layer.Vector({
                        title: "Localities",
                        source: vectorSource,
                        style: function (feature, resolution) {
                            return defaultStyle(feature, resolution);
                        }
                    })

                    olMap.addLayer(layerData);

                    olMap.getViewport().addEventListener('mousemove', function (evt) {
                        var pixel = olMap.getEventPixel(evt);
                        displayFeatureInfo(pixel);
                    });

                    olMap.on('click', function (evt) {
                        displayFeatureInfo(evt.pixel);
                    }); //Useful for touch-based viewing, e.g. on iPhone.
                    olMap.on('click', function (evt) {
                        openLoc(evt.pixel);
                    });
                }


                var openLoc = function (pixel) {

                    var feature = olMap.forEachFeatureAtPixel(pixel, function (feature, layer) {
                        return feature;
                    });

                    if (feature) {
                        //window.location = '/locality/' + feature.fid;
                        window.open('/locality/' + feature.fid, '', 'width=750,height=750,scrollbars, resizable');
                    }
                    else {
                        document.getElementById('hoverbox').style.display = 'none';
                    }
                };

            }]
        }
    }).directive('localitiesMap',
    function () {
        return {
            scope: {
                localities: '='
            },
            restrict: 'AE',
            replace: true,
            template: '<div id="map"></div>',
            controller: ['$scope', function ($scope) {
                var watcher = $scope.$watch('localities', function () {
                    if ($scope.localities === undefined) return;

                    // at this point it is defined, map can be initialized
                    init();
                    // delete watcher if appropriate
                    watcher();
                });
                //======================================================================
                $scope.olMap;

                function init() {
                    if (!$scope.olMap) {
                        $scope.olMap = new ol.Map({
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
                            view: new ol.View({
                                projection: "EPSG:3857",
                                center: ol.proj.transform([25.0, 58.4], 'EPSG:4326', 'EPSG:3857'),
                                zoom: 6,
                                maxZoom: 16,
                                minZoom: 1,
                                restrictedExtent: ol.proj.transformExtent([-10, 52, 2, 62], 'EPSG:4326', 'EPSG:3857')
                            })
                        });
                    }

                    function defaultStyle(feature, resolution) {
                        return [
                            new ol.style.Style({
                                image: new ol.style.Circle({
                                    radius: 7,
                                    fill: new ol.style.Fill({color: 'rgba(236, 102, 37,0.7)', opacity: 0.8}),
                                    //stroke: new ol.style.Stroke({color: 'rgba(255,255,255,0)', width: 0})
                                }),
                                text: (resolution > 500 ? null : new ol.style.Text({
                                        font: '10pt Arial, Helvetica, Helvetica Neue, Arial, sans-serif',
                                        text: feature.name,
                                        fill: new ol.style.Fill({color: 'rgba(238,59,13,1)'}),
                                        stroke: new ol.style.Stroke({color: '#fff', width: 3}),
                                        textAlign: 'left',
                                        textBaseline: 'bottom',
                                        offsetX: 5,
                                        offsetY: -5,
                                    }))
                            })
                        ]
                    };

                    if (!$scope.vectorSource) {
                        $scope.vectorSource = new ol.source.Vector({
                            attributions: [new ol.Attribution({
                                html: "Data from PA/Credit Suisse."
                            })]
                        });
                    } else {
                        $scope.layerData.getSource().clear();
                    }

                    angular.forEach($scope.localities, function (locality) {
                        var centroidLL = ol.proj.transform([locality.longitude, locality.latitude], 'EPSG:4326', 'EPSG:3857');
                        var centroidPoint = new ol.geom.Point(centroidLL);
                        var feature = new ol.Feature({geometry: centroidPoint});
                        feature.name = locality.localityEng;
                        feature.fid = locality.fid;
                        $scope.vectorSource.addFeature(feature);
                    });
                    console.log($scope.localities);
                    $scope.layerData = new ol.layer.Vector({
                        title: "Localities",
                        source: $scope.vectorSource,
                        style: function (feature, resolution) {
                            return defaultStyle(feature, resolution);
                        }
                    });

                    $scope.olMap.addLayer($scope.layerData);
                    $scope.olMap.getViewport().addEventListener('mousemove', function (evt) {
                        var pixel = $scope.olMap.getEventPixel(evt);
                        displayFeatureInfo(pixel); //OLESJA
                    });


                    /*         commented by Olesja use fitExtend function */

                    var extent = $scope.layerData.getSource().getExtent();
                    $scope.olMap.getView().fit(extent, $scope.olMap.getSize());

                    var zz = $scope.olMap.getView().getZoom();
                    if (zz > 9) {
                        $scope.olMap.getView().setZoom(9);
                    }

                    $scope.olMap.on('click', function (evt) {
                        displayFeatureInfo(evt.pixel);
                    }); //Useful for touch-based viewing, e.g. on iPhone.
                    $scope.olMap.on('click', function (evt) {
                        openLoc(evt.pixel);
                    });
                }


                /*
                 var featureOverlay = new ol.FeatureOverlay({
                 map: olMap,
                 style: function(feature, resolution) { return defaultStyle(feature, resolution); }
                 });
                 */
                var openLoc = function (pixel) {

                    var feature = $scope.olMap.forEachFeatureAtPixel(pixel, function (feature, layer) {
                        return feature;
                    });

                    if (feature) {
                        //window.location = '/locality/' + feature.fid;
                        window.open('#/locality/' + feature.fid, '', 'width=750,height=750,scrollbars, resizable');
                    }
                    else {
                        document.getElementById('hoverbox').style.display = 'none';
                    }
                };

                //var highlight;
                //COMMENTED by OLESJA IT is not working right now
                var displayFeatureInfo = function (pixel) {

                    var feature = $scope.olMap.forEachFeatureAtPixel(pixel, function (feature, layer) {
                        return feature;
                    });

                    if (feature) {
                        //
                        document.getElementById('hoverbox').style.display = 'block';
                        //console.log(feature.name);
                        document.getElementById('hoversystem').innerHTML = feature.name;
                        document.getElementById('hoverstat').innerHTML = "";
                    } else {
                        document.getElementById('hoverbox').style.display = 'none';
                    }
                };
                //======================================================================
            }]
        }
    }).directive('mainMap',
    function () {
        return {
            scope: {
                localities: '='
            },
            restrict: 'AE',
            replace: true,
            template: '<div id="map" class="map"></div>',
            controller: ['$scope', 'ApplicationService', '$rootScope','$timeout', function ($scope, ApplicationService, $rootScope,$timeout) {
                ApplicationService.loadMapData(onMapData);

                function onMapData(response) {
                    var locs = response.data;
                    if (locs != undefined) {
                        $rootScope.countLocalities = response.data.count;
                        var earthquakeFill = new ol.style.Fill({
                            color: 'rgba(236, 102, 37,0.7)' //255, 153, 0,0.6
                        });
                        var earthquakeStroke = new ol.style.Stroke({
                            color: 'rgba(0, 0, 0,0.5)', //'rgba(236, 102, 37,1)',
                            width: 1
                        });
                        var textFill = new ol.style.Fill({
                            color: '#fff'
                        });
                        var textStroke = new ol.style.Stroke({
                            color: 'rgba(0, 0, 0, 0.5)',
                            width: 3
                        });
                        var textStrokeW = new ol.style.Stroke({
                            color: 'rgba(255, 255, 255, 0.5)',
                            width: 3
                        });
                        var invisibleFill = new ol.style.Fill({
                            color: 'rgba(238,59,13,0.5)'
                        });

                        function findSizeClass(arv){
                            var klass = 0;
                            if (arv < 10) {
                                klass = 1;
                            } else if (9 < arv & arv < 100) {
                                klass = 2;
                            } else if (99 < arv & arv < 1000) {
                                klass = 3;
                            } else if (999 < arv & arv < 5000) {
                                klass = 4;
                            } else if (arv > 4999) {
                                klass = 5;
                            }
                            return klass
                        }

                        function createEarthquakeStyle(feature, resolution) {
                            var name = feature.get('name');
                            var rec = feature.get('rec'); //magnitude = parseFloat(name.substr(2));
                            var klass = findSizeClass(rec);
                            //console.log(name, rec, klass);
                            var radius = 1+ 3 * klass;// * (magnitude - 5);

                            return new ol.style.Style({
                                geometry: feature.getGeometry(),
                                image: new ol.style.Circle({
                                    radius: radius,
                                    fill: earthquakeFill,
                                    //stroke: earthquakeStroke
                                }),
                                text: (resolution > 200 ? null : new ol.style.Text({
                                    font: feature.fontSize + 'pt Arial, Helvetica, Helvetica Neue, Arial, sans-serif',
                                    text: name,
                                    fill: earthquakeFill,
                                    stroke: textStrokeW,
                                    textAlign: 'left',
                                    textBaseline: 'bottom',
                                    offsetX: 5,
                                    offsetY: -5,
                                }))
                            });
                        }

                        var maxFeatureCount;
                        function calculateClusterInfo(resolution) {
                            maxFeatureCount = 0;
                            var features = vector.getSource().getFeatures();
                            var feature, radius;
                            for (var i = features.length - 1; i >= 0; --i) {
                                feature = features[i];
                                var originalFeatures = feature.get('features');
                                var extent = ol.extent.createEmpty();
                                for (var j = 0, jj = originalFeatures.length; j < jj; ++j) {
                                    ol.extent.extend(extent, originalFeatures[j].getGeometry().getExtent());
                                }
                                maxFeatureCount = Math.max(maxFeatureCount, jj);
                                radius = 0.25 * (ol.extent.getWidth(extent) + ol.extent.getHeight(extent)) /
                                    resolution;
                                feature.set('radius', radius);
                            }
                        }

                        var currentResolution;
                        function styleFunction(feature, resolution) {
                            if (resolution != currentResolution) {
                                calculateClusterInfo(resolution);
                                currentResolution = resolution;
                            }
                            var style;
                            var size = feature.get('features').length;
                            if (size > 1) {
                                style = [new ol.style.Style({
                                    image: new ol.style.Circle({
                                        radius: 16,//feature.get('radius'),
                                        fill: new ol.style.Fill({
                                            color: [255, 153, 0, Math.min(0.8, 0.4 + (size / maxFeatureCount))]
                                        }),
                                        stroke: new ol.style.Stroke({
                                            color: 'rgba(255, 255, 255, 0.6)',
                                            width: 1
                                        })
                                    }),
                                    text: new ol.style.Text({
                                        text: size.toString(),
                                        fill: textFill,
                                        stroke: textStroke
                                    })
                                })];
                            } else {
                                var originalFeature = feature.get('features')[0];
                                style = [createEarthquakeStyle(originalFeature, resolution)];
                            }
                            return style;
                        }


                        var currentResolution;
                        function styleFunction1(feature, resolution) {
                            if (resolution != currentResolution) {
                                calculateClusterInfo(resolution);
                                currentResolution = resolution;
                            }
                            var style;
                            style = [createEarthquakeStyle1(feature, resolution)];
                            return style;
                        }

                        function selectStyleFunction(feature, resolution) {
                            var styles = [new ol.style.Style({
                                image: new ol.style.Circle({
                                    radius: feature.get('radius'),
                                    fill: invisibleFill
                                }),
                                text: new ol.style.Text({
                                    text: feature.get('name'),
                                    fill: textFill,
                                    stroke: textStroke
                                })
                            })];
                            var originalFeatures = feature.get('features');
                            var originalFeature;
                            for (var i = originalFeatures.length - 1; i >= 0; --i) {
                                originalFeature = originalFeatures[i];
                                styles.push(createEarthquakeStyle(originalFeature));
                            }
                            return styles;
                        }




                        function createEarthquakeStyle1(feature, resolution) {
                            var name = feature.get('name');
                            var rec = feature.get('rec'); //magnitude = parseFloat(name.substr(2));
                            var klass = findSizeClass(rec);
                            //console.log(name, rec, klass);
                            var radius = 3 * klass;// * (magnitude - 5);

                            return new ol.style.Style({
                                geometry: feature.getGeometry(),
                                image: new ol.style.Circle({
                                    radius: radius,
                                    fill: earthquakeFill,
                                    //stroke: earthquakeStroke
                                }),
                                text: (resolution > 200 ? null : new ol.style.Text({
                                    font: feature.fontSize + 'pt Arial, Helvetica, Helvetica Neue, Arial, sans-serif',
                                    text: name,
                                    fill: earthquakeFill,
                                    stroke: textStrokeW,
                                    textAlign: 'left',
                                    textBaseline: 'bottom',
                                    offsetX: 5,
                                    offsetY: -5,
                                }))
                            });
                        }



                        var vectorSource = new ol.source.Vector({
                            //attributions: [new ol.Attribution({
                            //	html: "Data from PA/Credit Suisse."})]
                        });

                        for (var k in locs.results) {
                            var centroidLL = ol.proj.transform([
                                    locs.results[k].longitude,
                                    locs.results[k].latitude],
                                'EPSG:4326', 'EPSG:3857');
                            var centroidPoint = new ol.geom.Point(centroidLL);
                            var feature = new ol.Feature({geometry: centroidPoint});
                            feature.set('name', locs.results[k].name);
                            feature.set('fid', locs.results[k].id);
                            feature.set('rec', locs.results[k].total_related_records);
                            vectorSource.addFeature(feature);
                        }

                        var vector = new ol.layer.Vector({
                            title: 'Clustered',
                            visible: false,
                            distance: 40,
                            source: new ol.source.Cluster({
                                source: vectorSource
                            }),
                            style: styleFunction
                        });

                        var vector1 = new ol.layer.Vector({
                            title: 'Unclustered',
                            visible: true,
                            source: vectorSource,
                            style: styleFunction1
                        });





                        var vectors = new ol.layer.Group({
                            title: 'Localities',
                            //visible: false,
                            //type: 'base',
                            layers: [
                                vector,
                                vector1
                            ]
                        })

                        var mapbox = new ol.layer.Tile({
                            title: 'MapBox grayscale',
                            type: 'base',
                            visible: true,
                            source: new ol.source.XYZ({
                                url: 'https://api.tiles.mapbox.com/v4/mapbox.light/{z}/{x}/{y}.png?access_token=pk.eyJ1Ijoia3V1dG9iaW5lIiwiYSI6ImNpZWlxdXAzcjAwM2Nzd204enJvN2NieXYifQ.tp6-mmPsr95hfIWu3ASz2w'
                            }),
                        });

                        var basemaps = new ol.layer.Group({
                            'title': 'Base maps',
                            layers: [
                                new ol.layer.Tile({
                                    title: 'Stamen dark',
                                    type: 'base',
                                    visible: false,
                                    source: new ol.source.Stamen({
                                        layer: 'toner'
                                    })
                                }),
                                new ol.layer.Tile({
                                    title: 'OpenStreetMap',
                                    type: 'base',
                                    visible: false,
                                    source: new ol.source.OSM()
                                }),
                                new ol.layer.Tile({
                                    title: 'MapQuest satellite',
                                    type: 'base',
                                    visible: false,
                                    source: new ol.source.MapQuest({layer: 'sat'})
                                }),
                                mapbox
                            ]
                        });







                        var mapq =  new ol.layer.Group({
                            style: 'AerialWithLabels',

                            layers: [
                                new ol.layer.Tile({
                                    source: new ol.source.MapQuest({layer: 'sat'}),
                                    visible: false,
                                    type: 'base',
                                    title:'MapQuest satellite',
                                }),
                                new ol.layer.Tile({
                                    source: new ol.source.MapQuest({layer: 'hyb'}),
                                    visible: false,
                                    type: 'base',
                                    title:'MapQuest satellite',
                                })
                            ]
                        });




                        var map = new ol.Map({
                            layers: [basemaps, vectors],
                            /*  interactions: ol.interaction.defaults().extend([new ol.interaction.Select({
                             condition: function(evt) {
                             return evt.originalEvent.type == 'mousemove' ||
                             evt.type == 'singleclick';
                             },
                             style: selectStyleFunction
                             })]),*/
                            target: 'map',
                            view: new ol.View({
                                projection: "EPSG:3857",
                                center: ol.proj.transform([25.0, 58.4], 'EPSG:4326', 'EPSG:3857'),
                                zoom: 6,
                                maxZoom: 16,
                                minZoom: 2
                            }),
                            controls: ol.control.defaults({
                                attributionOptions: ({
                                    collapsible: true
                                })
                            }).extend([
                                new ol.control.ScaleLine({units: "metric"}),
                                new ol.control.FullScreen()
                            ])
                        });





                        var openLoc = function(pixel) {

                            var feature = map.forEachFeatureAtPixel(pixel, function(feature, layer) {
                                return feature;

                            });

                            if (feature) {
                                var fid, pikk;
                                if (fid = feature.get('fid')) {
                                    //document.getElementById('hoversystem').innerHTML = name;
                                    window.open('#/locality/' + fid, '', 'width=750,height=750,scrollbars, resizable');
                                } else if (pikk = feature.get('features').length ) {
                                    if (pikk == 1) {
                                        fid = feature.get('features')[0].get('fid');
                                        //document.getElementById('hoversystem').innerHTML = name;
                                        window.open('#/locality/' + fid, '', 'width=750,height=750,scrollbars, resizable');
                                    }
                                }
                            }
                            /*
                             //var numFeatures = feature.get('features').length;
                             //var originalFeature = feature.get('features')[0];
                             var fid;
                             //var num = feature.get('features').length;
                             //console.log(feature);

                             if (fid = feature.get('fid')) {
                             window.open('/locality/' + fid, '', 'width=750,height=750,scrollbars, resizable');
                             }

                             else if (feature.get('features').length == 1 & feature.get('features')[0].get('fid')) {
                             window.open('/locality/' + feature.get('features')[0].get('fid'), '', 'width=750,height=750,scrollbars, resizable');
                             }*/

                        };



                        var displayFeatureInfo = function(pixel) {
                            var feature = map.forEachFeatureAtPixel(pixel, function(feature, layer) {
                                return feature;
                            });

                            if (feature) {
                                var name, pikk;
                                document.getElementById('hoverbox').style.display = 'block';
                                if (name = feature.get('name')) {
                                    document.getElementById('hoversystem').innerHTML = name + '<br />Click to see details';
                                } else if (pikk = feature.get('features').length ) {
                                    if (pikk == 1) {
                                        name = feature.get('features')[0].get('name');
                                        document.getElementById('hoversystem').innerHTML = name + '<br />Click to see details';
                                    } else {
                                        document.getElementById('hoversystem').innerHTML = pikk + ' clustered localities<br />Zoom in to see';
                                    }
                                }
                                document.getElementById('hoverstat').innerHTML = "";
                            } else {
                                document.getElementById('hoverbox').style.display = 'none';
                            }
                        };



                        map.on('click', function(evt) { openLoc(evt.pixel); });

                        map.getViewport().addEventListener('mousemove', function(evt)
                        {
                            var pixel = map.getEventPixel(evt);
                            displayFeatureInfo(pixel);
                        });







                        var layerSwitcher = new ol.control.LayerSwitcher({
                            //tipLabel: 'Légende' // Optional label for button
                        });
                        map.addControl(layerSwitcher);
                        //----------------------------------------------
                        var tooltip = document.querySelectorAll('.coupontooltip');
                        document.addEventListener('mousemove', fn, false);
                        function fn(e) {
                            for (var i = tooltip.length; i--;) {
                                tooltip[i].style.left = e.pageX + 'px';
                                tooltip[i].style.top = e.pageY + 'px';
                            }
                        }
                    }
                }
                $rootScope.submitFilterForm = function () {
                    var allFilters = ["specimens", "samples", "drillcores", "citing_references", "analyses",
                        "stratotypes", "images", "taxon_occurrences"];

                    var filterData = {
                        filters: [],
                        localityName: "",
                    };

                    for(var index in allFilters) {
                        if(angular.element("input[name="+allFilters[index]+"]").is(':checked')) {
                            filterData.filters.push(allFilters[index]);
                        }
                    }
                    if(angular.element("input[name=localityName]").val().length > 0) {
                        filterData.localityName = angular.element("input[name=localityName]").val();
                    } else {
                        filterData.localityName = "";
                    }

                    ApplicationService.loadMapDataOnFilterChange(filterData, onMapDataFilter);
                    function onMapDataFilter(response) {
                        $("#map").empty();
                        onMapData(response);
                    }
                };

            }]
        }
    });