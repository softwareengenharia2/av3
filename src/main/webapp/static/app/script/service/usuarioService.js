angular.module('av3').service('UsuarioService', function($http) {

    this.urlBase = "api/usuario/"
    this.getCliente = function(cnpj) {
        return $http.get(`${urlBase}${cnpj}`);
    };

    this.salvarCliente = function(cliente){
      return $http.post(`${urlBase}completar-pre-cadastro`, cliente);
    };

});