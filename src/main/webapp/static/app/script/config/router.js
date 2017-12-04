angular.module('av3').config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider.state('cadastro', {
        url: '/cadastro?cnpj',
        templateUrl: 'static/app/pages/cadastro.html'
    });

    $stateProvider.state('home', {
        url: '/',
        templateUrl: 'static/app/pages/site.html'
    });

});