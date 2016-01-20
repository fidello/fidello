(function (angular) {
    'use strict';

    function Utils($state, $mdToast) {

        function navegar(pagina) {
            $state.go(pagina);
        }

        function mostrarMensagem(mensagem, tempo) {
            $mdToast.show($mdToast.simple().content(mensagem).position("top right").hideDelay(tempo === undefined ? 3000 : tempo));

        }

        return {
            mostrarMensagem: mostrarMensagem,
            navegar: navegar
        };

    }

    angular.module('fidello').factory('Utils', Utils);

    Utils.$inject = ['$state', '$mdToast'];

}(window.angular));