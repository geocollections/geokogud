angular.module('geoApp').filter('newline', function() {
    return function(text) {
        if (text) {
            return text.replace(/\n/g, '<br />');
        }
        return '';
    }
});
angular.module('geoApp').filter('listToCommaSeparatedString', function() {
    return function(list, labelFieldName) {
        return Helper.arrayToStringUsingArrayObjectProperty(list, labelFieldName, ', ');
    }
});