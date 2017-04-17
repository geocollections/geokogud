angular.module('geoApp').directive('hintText', function () {
    return {
        template: "<div><div class='col-lg-8'>" +
        "<h4 class='header-collection'>{{'SEARCH.'+table + '.HELP_POPUP.HEADING' | translate}}</h4><ul class='fa-ul ul-square'>" +
        "<li>{{'SEARCH.'+table + '.HELP_POPUP.PARAGRAPH_ONE' | translate}}</li>" +
        "<li data-ng-if=\"('SEARCH.'+table + '.HELP_POPUP.PARAGRAPH_TWO' | translate) != ''\">{{'SEARCH.'+table + '.HELP_POPUP.PARAGRAPH_TWO' | translate}}</li>" +
        "<li data-ng-if=\"('SEARCH.'+table + '.HELP_POPUP.PARAGRAPH_THREE' | translate) != ''\">{{'SEARCH.'+table + '.HELP_POPUP.PARAGRAPH_THREE' | translate}}</li>" +
        "<li data-ng-if=\"('SEARCH.'+table + '.HELP_POPUP.PARAGRAPH_FOUR' | translate) != ''\">{{'SEARCH.'+table + '.HELP_POPUP.PARAGRAPH_FOUR' | translate}}</li></ul></div></div>",
        restrict: 'AE',
        scope: {
            table: '@'
        }
    };
});