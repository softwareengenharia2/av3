angular.config('av3', function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider.state('home', {
        url: '/home',
        controller: 'MainController',
        templateUrl: 'pages/site/home.html'
    });

});