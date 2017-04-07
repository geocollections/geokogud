angular.module('geoApp')
    .filter('trustedHtml', ['$sce', function($sce){
        return function(html){
            return $sce.trustAsHtml(html);
        }
    }]);