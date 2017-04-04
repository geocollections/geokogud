var module = angular.module("geoApp");

var constructor = function (utils,configuration) {

    var service = {};

    service.departments = configuration.departments;
    service.pageSetUp = configuration.pageSetUp;
    service.openInNewWindow = openInNewWindow;
    service.openUrlInNewWindow = openUrlInNewWindow;
    service.showGoogleMap = showGoogleMap;
    service.showEstonianLandBoardMap = showEstonianLandBoardMap;
    service.getTranslationRoot = getTranslationRoot;

    service.toggle = function (el,array) {
        utils.toggleInArray(el,array)
    };

    service.getNews = function (callback, error) {
        utils.httpGet(configuration.newsUrl, null, callback, error);
    };

    service.getList = function (searchType, data, success, error) {
        var url = getSearchUrl(searchType);
        if(url != null) utils.httpPost(url, data, success, error);
    };

    service.getEntity = function (searchType, id, callback, error) {
        var url = getSearchUrl(searchType);
        utils.httpGet(configuration.sampleDetailUrl + "/"+id, null, callback, error);
    };

    function getSearchUrl (searchType) {
        var url = null;
        switch (searchType) {
            case "specimens" : url = configuration.specimenUrl; break;
            case "samples" : url = configuration.sampleUrl; break;
            case "drillCores" : url = configuration.drillCoreUrl; break;
            case "localities" : url = configuration.localityUrl; break;
            case "references" : url = configuration.referenceUrl; break;
            case "stratigraphy" : url = configuration.stratigraphyUrl; break;
            case "analyses" : url = configuration.analysesUrl; break;
            case "preparations" : url = configuration.preparationUrl; break;
            case "photoArchive" : url = configuration.photoArchiveUrl; break;
            case "soil" : url = configuration.soilUrl; break;
            case "doi" : url = configuration.doiUrl; break;
            default : break;
        }
        return url;
    }

    function getTranslationRoot (searchType) {
        var root = "SEARCH.";
        switch (searchType) {
            case "specimens" : root += "SPECIMENS"; break;
            case "samples" : root += "SAMPLES"; break;
            case "drillCores" : root += "DRILL_CORES"; break;
            case "localities" : root += "LOCALITIES"; break;
            case "references" : root += "REFERENCES"; break;
            case "stratigraphy" : root += "STRATIGRAPHY"; break;
            case "analyses" : root += "ANALYSES"; break;
            case "preparations" : root += "PREPARATIONS"; break;
            case "photoArchive" : root += "PHOTO_ARCHIVE"; break;
            case "soil" : root += "SOIL_SITES"; break;
            case "doi" : root += "DOI"; break;
            default : break;
        }
        return root;
    }

    function showGoogleMap(lat, lon, localityName) {
        window.open('http://maps.google.com/?q='+lat+','+lon+' ('+localityName+')', '', 'width=750,height=540,scrollbars, resizable');
    }

    function showEstonianLandBoardMap(lat,lon) {
        window.open('http://geoportaal.maaamet.ee/url/xgis-latlon.php?lat='+lat+'&lon='+lon+'&out=xgis&app_id=UU82', '', 'width=900,height=600,scrollbars, resizable');
    }

    function openInNewWindow(params) {
        console.log(params);
        window.open('/#/'+params.object+'/' + params.id, '', 'width=750,height=750,scrollbars, resizable');
    }

    function openUrlInNewWindow(params) {
        window.open(params.url, '', 'width=750,height=750,scrollbars, resizable');
    }

    return service;
};

constructor.$inject = ['utils','configuration'];

module.service("ApplicationService", constructor);