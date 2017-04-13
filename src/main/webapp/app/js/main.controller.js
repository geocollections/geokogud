var module = angular.module("geoApp");

var constructor = function (configuration,$translate,$http, applicationService,$state, $scope, $rootScope) {

    //$state.transitionTo('samples');
    var vm = this;
    vm.service = applicationService;
    //config from config.json
    vm.configuration = configuration;
    vm.news = [];
    vm.years = [];
    vm.showNews = showNews;
    vm.yearFilter = yearFilter;
    vm.getTitle = getTitle;
    vm.getText = getText;
    vm.getContent = getContent;
    vm.changeLanguage = changeLanguage;
    vm.webpages;
    var yearToShow;

    $rootScope.$on('$stateChangeStart',
            function(event, toState, toParams, fromState, fromParams) {
                if (toState.params != null) {
                    getWebPageById(toState.params.contentId);
                }
        });

    asyncLoadData(); //fixme make async request

    function asyncLoadData () {
        applicationService.getNews(onNewsData);
        applicationService.loadMapData(onMapData);
    }

    function getWebPageById(id) {
        vm.webpages = applicationService.getWebPage(id, onWebPagesData);
    }

    function onMapData(response) {
        //console.log(response);
    }

    function onNewsData(response) {
        vm.news = response.data;
        angular.forEach(vm.news.result, function(currentNews) {
            var year = currentNews.date_added.split("-")[0];
            if (vm.years.indexOf(year) == -1) { vm.years.push(year); }
        });
        yearToShow = vm.years[0];
    }

    function showNews($event) {
        yearToShow = $event.target.innerText;
    }

    function yearFilter(id) {
        return id.date_added.startsWith(yearToShow);
    }

    function getTitle(id) {
        return $translate.use() === "et" ? id.title_et : id.title_en;
    }

    function getText(id) {
        return $translate.use() === "et" ? id.text_et : id.text_en;
    }

    function getContent(webpage) {
        if (webpage != null) {
            return $translate.use() === "et" ? webpage.content_et : webpage.content_en;
        } return null;
    }

    function changeLanguage(langKey) {
        $translate.use(langKey);
    }

    function onWebPagesData(response) {
        vm.webpages = response.data;
    }
};

constructor.$inject = ["configuration",'$translate', '$http', 'ApplicationService','$state', '$scope', '$rootScope'];

module.controller("MainController", constructor);
