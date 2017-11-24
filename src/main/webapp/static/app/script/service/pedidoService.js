angular.module('av3').service('PedidoService', function($http) {

    this.solicitarPrePedido = function(obj) {
        return $http.post('api/pre-predido', obj);
    };

});