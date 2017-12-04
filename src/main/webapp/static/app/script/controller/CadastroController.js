angular.module('av3').controller('CadastroController', function($scope, cliente, $location) {

    $scope.cliente = cliente;

    $scope.cancelar = function() {
         $location.path('/');
    };

});