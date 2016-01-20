(function (angular) {
    'use strict';
    var opcoesLogin = {
            CPF: {
                codigoTipoUsuario: 1,
                textoTipoUsuario: "CPF"
            },
            CNPJ: {
                codigoTipoUsuario: 2,
                textoTipoUsuario: "CNPJ"
            },
            Email: {
                codigoTipoUsuario: 3,
                textoTipoUsuario: "E-mail"
            }
        },
        opcoesCadastro = {
            CPF: {
                codigoTipoUsuario: 1,
                textoTipoUsuario: "CPF"
            },
            CNPJ: {
                codigoTipoUsuario: 2,
                textoTipoUsuario: "CNPJ"
            }
        },

        constantes = {
            urlResource: 'http://www.fidello.com.br',
            //urlResource:  'http://localhost:8080',
            opcoesLogin: opcoesLogin,
            opcoesCadastro: opcoesCadastro
        };


    angular.module('fidello').constant('Constantes', constantes);


}(window.angular));