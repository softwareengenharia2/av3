angular.module('av3').config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider.state('home', {
        url: '/home',
        templateUrl: 'static/app/pages/pre-cadastro.html'
    });

});