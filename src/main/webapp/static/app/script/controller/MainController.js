angular.module('av3').controller('MainController', function($scope, PedidoService) {

    $scope.obj = {
        cnpj: '',
        email: '',
        nome: '',
        mensagem: '',
        quantidade: 0
    };

    $scope.solicitarPedido = function() {

        if (!$scope.validarCnpj($scope.obj)) {
            //dizer que o cnpj esta invalido
        }

        PedidoService.solicitarPrePedido($scope.obj).then(function(retorno) {
            //botar mensagem sucesso ok
        }, function(retorno) {
            //botar mensagem sucesso off
        });
    };

    $scope.validarCnpj = function() {

        ReceitaService.validarStatusCnpj($scope.cnpj).then(function(retorno) {
            if (retorno.isValid) {

            }
        });

    };

});