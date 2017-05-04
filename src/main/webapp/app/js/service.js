var module = angular.module("geoApp");

var constructor = function (utils,configuration, $window) {

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

//    service.getWebPage = function (id, callback, error) {
//        return utils.httpGet(configuration.webPagesUrl + "/" + id, null, callback, error);
//    };

    service.getList = function (searchType, data, success,error,headers) {
        var url = getSearchUrl(searchType);
        if(url != null) utils.httpPost(url, data, success, error, headers, true);
    };

    service.getSearchParamsFromUrl = function () {
        return utils.decodeUrl();
    };
    service.getMapParamsFromUrl = function () {
        return utils.decodeMapUrl();
    };
    service.getEntity = function (searchType, id, callback, error) {
        var url = getDetailUrl(searchType);
        utils.httpGet(url + "/"+id, null, callback, error);
    };

    service.loadMapData = function (callback, error) {
        utils.httpGet(configuration.mapData.allLocalities, null, callback, error);
    };
    service.loadMapDataOnFilterChange = function (filters, callback, error, headers) {
        utils.httpPost(configuration.mapData.specificLocalities, filters, callback, error, headers, true);
    }

    service.autocompleteSearch = function (table, val, searchField) {
        utils.httpGet(configuration.autocompleteUrl, {table: table, term: val, searchField: searchField}, null, null);
    };

    service.composeImageUrl = function(imageData, readyUrl) {
        if(readyUrl) return readyUrl;
        if(imageData.image_url) return imageData.image_url;
        var imageUrl = "http://geokogud.info/"+imageData.database__acronym.toLowerCase()+"/image/";
        return imageUrl+ imageData.imageset__imageset_series + "/"+imageData.imageset__imageset_number+"/"+imageData.filename;
    };

    service.composeExternalImagePath = function(imageData) {
        if(imageData.specimen__database__acronym) {
            console.log(imageData)
            return composeSpecimenExternalPath(imageData);
        }
        if(imageData.database__acronym) {
            return composeImageExternalPath(imageData)
        }
    };

    service.getDownloadLink = function (fileName) {
        return "http://geokogud.info/files/"+fileName.substring(0,2)+"/"+fileName;
    };

    function composeSpecimenExternalPath (imageData) {
        //http://geokogud.info/di.php?f=/data/git/images/specimen/663/663-6.jpg&w=400
        return "http://geokogud.info/di.php?f=/data/"+imageData.specimen__database__acronym.toLowerCase()+"/images/specimen/"
            + imageData.image;
    }
    function composeImageExternalPath (imageData) {
        //            http://geokogud.info/di.php?f=/var/www/git/image/OH/OH07-1/OH07-1-4.jpg
        return "http://geokogud.info/di.php?f=/var/www/"+imageData.database__acronym.toLowerCase()+"/image/"
            + imageData.imageset__imageset_series + "/"+imageData.imageset__imageset_number+"/"+imageData.filename;
    }

    function getDetailUrl (searchType) {
        var url = null;
        switch (searchType) {
            case "specimens" : url = configuration.specimenDetailUrl; break;
            case "specimenImage" : url = configuration.specimenImageDetailUrl; break;
            case "samples" : url = configuration.sampleDetailUrl; break;
            case "drillCores" : url = configuration.drillCoreDetailUrl; break;
            case "corebox" : url = configuration.coreBoxDetailUrl; break;
            case "localities" : url = configuration.localityDetailUrl; break;
            case "references" : url = configuration.referenceDetailUrl; break;
            case "stratigraphy" : url = configuration.stratigraphyDetailUrl; break;
            case "analysis" : url = configuration.analysisDetailUrl; break;
            case "preparations" : url = configuration.preparationDetailUrl; break;
            case "photoArchive" : url = configuration.photoArchiveDetailUrl; break;
            case "soil" : url = configuration.soilDetailUrl; break;
            case "doi" : url = configuration.doiDetailUrl; break;
            default : break;
        }
        return url;
    }

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
        $window.open('/'+params.object+'/' + params.id, '', 'width=570,height=750,scrollbars, resizable');
    }

    function openUrlInNewWindow(params) {
        window.open(params.url, '', 'width=750,height=750,scrollbars, resizable');
    }

    return service;
};

constructor.$inject = ['utils','configuration','$window'];

module.service("ApplicationService", constructor);

