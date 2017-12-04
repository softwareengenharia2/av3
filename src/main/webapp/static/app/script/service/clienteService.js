angular.module('av3').service('ClienteService', function($http) {

    this.getCliente = function(cnpj) {
        return $http.get(`api/cliente/${cnpj}`);
    };

});