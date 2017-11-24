angular.module('av3').controller('MainController', function($scope) {

    $scope.hello = 'Hello World';

    $scope.validarCnpj = function() {

        ReceitaService.validarStatusCnpj($scope.cnpj).then(function(retorno) {
            if (retorno.isValid) {

            }
        });

    };

});