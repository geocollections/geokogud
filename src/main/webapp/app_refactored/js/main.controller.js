var module = angular.module("geoApp");

var constructor = function (configuration,$translate,$http, applicationService,$scope) {
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
    vm.changeLanguage = changeLanguage;

    applicationService.getNews(onNewsData);

    var yearToShow;
    function onNewsData(response) {
        vm.news = response.data;
        angular.forEach(vm.news.result, function(currentNews) {
            var year = currentNews.date_added.split("-")[0];
            if (vm.years.indexOf(year) == -1) { vm.years.push(year); }
        });
        vm.years = vm.years.reverse();
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

    function changeLanguage(langKey) {
        $translate.use(langKey);
    }



};

constructor.$inject = ["configuration",'$translate', '$http', 'ApplicationService','$scope'];

module.controller("MainController", constructor);