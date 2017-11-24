angular.module('av3').service('ReceitaService', function($http) {

    //DOC: https://receitaws.com.br/api

    this.validarStatusCnpj = function(cnpj) {
        return new Promise((resolve, reject) => {
            $http.get('https://receitaws.com.br/api/' + cnpj).then(function(response) {
                response.data.isValido = response.data.status == 'OK' ? true : false;
                resolve(response.data);
            }, () => {
                reject({isValido: false, message: 'CNPJ não encontrado'});
            });
        });
    };

});