angular.module('av3').controller('CadastroController', function($scope, cliente, $location, UsuarioService) {

    $scope.cliente = cliente;

    $scope.cancelar = function() {
         $location.path('/');
    };

    $scope.salvar = function() {
        UsuarioService.salvarCliente(cliente).then( (retorno) => {
            //mensagem ok
        }, function () {
            //mensagem fudeu
        })
    };

});