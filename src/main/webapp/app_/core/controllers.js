angular.module('geoApp').controller('TooltipController', function($scope,$filter,$sce) {
    $scope.formatText = function (text) {
        if (!text || text == null) return;

        text = text.replace(/(?:\r\n|\r|\n)/g, '<br />');
        return $sce.trustAsHtml('<p>' + text + '</p>');
    };

    $scope.isMoreInfomationShown = [];
    var limitTo = 20;
    $scope.getLess = function (idx, text) {
        var less = null;
        if (text) {
            less = text;
            if ($scope.isShowMore(text)) {
                less = $filter('limitTo')(less, limitTo, 0);
                less += "...";
            }
        }

        return less;
    };

    $scope.isShowMore = function (text) {
        return (text && text.length > limitTo);
    };

    $scope.showMore = function (idx) {
        $scope.isMoreInfomationShown[idx] = true;
    };

    $scope.isMoreShown = function (index) {
        return $scope.isMoreInfomationShown[index];
    };
})