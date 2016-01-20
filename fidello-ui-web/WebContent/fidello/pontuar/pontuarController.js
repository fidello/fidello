angular.module('fidello').controller("pontuarController", pontuarController);

pontuarController.$inject = ['pontuarService', '$mdToast', '$state', 'usuarioService', '$mdDialog'];

function pontuarController(pontuarService, $mdToast, $state, usuarioService, $mdDialog) {

    var vm = this;

    usuarioService.buscarPessoas().then(function (dados) {

        vm.clientes = dados;

    }, function () {
        __mostrarMensagem("Falha ao buscar clientes");
    });

    function send(pagina) {
        $state.go(pagina);
    }

    vm.showAdvanced = function (ev) {
        $mdDialog.show({
                controller: DialogController,
                templateUrl: 'paginas/pontuarCliente-dialog.tpl.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose: true,
                fullscreen: false
            })
            .then(function (answer) {
                // alert('You said the information was "' + answer + '".');
            }, function () {
                // alert('You cancelled the dialog.');
            });
    };

    // METODOS PRIVADOS
    function __mostrarMensagem(mensagem) {
        $mdToast.show($mdToast.simple().content(mensagem).position("top right").hideDelay(3000));
    }


    function DialogController($scope, $mdDialog) {
        $scope.hide = function () {
            $mdDialog.hide();
        };
        $scope.cancel = function () {
            $mdDialog.cancel();
        };
        $scope.answer = function (answer) {
            $mdDialog.hide(answer);
        };
    }
}