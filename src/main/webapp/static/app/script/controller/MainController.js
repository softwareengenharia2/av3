angular.module('av3').controller('MainController', function($scope, PedidoService) {

    $scope.obj = {
        cnpj: '',
        email: '',
        nome: '',
        mensagem: '',
        quantidade: 0
    };

    $scope.solicitarPedido = function() {

        PedidoService.solicitarPrePedido($scope.obj).then(function(retorno) {
            //botar mensagem sucesso ok
        }, function(retorno) {
            //botar mensagem sucesso off
        });
    };

});