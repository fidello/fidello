angular.module('fidello').controller("usuarioController", usuarioController);

usuarioController.$inject = ['usuarioService', '$localStorage', 'Constantes', 'Utils'];

function usuarioController(usuarioService, $localStorage, Constantes, Utils) {

    // Objetos //
    var vm = this;

    vm.Utils = Utils;

    vm.Constantes = Constantes;

    vm.$storage = $localStorage;

    vm.usuario = {};

    vm.login = {};

    vm.opcoesCadastro = Constantes.opcoesCadastro;

    vm.opcoesLogin = Constantes.opcoesLogin;

    // Métodos Públicos //

    vm.cadastrarUsuario = cadastrarUsuario;

    vm.entrar = entrar;

    vm.atualizaLabelLogin = atualizaLabelLogin;

    vm.atualizaLabelCadastro = atualizaLabelCadastro;



    function cadastrarUsuario() {
        usuarioService.cadastrarUsuario(vm.usuario).then(function (resposta) {
            Uils.mostrarMensagem("O cadastro foi realizado com sucesso");
        }, function (error) {
            Utils.mostrarMensagem("Não foi possivel realizar o cadastro. " + error.data.message);
        });
    }

    function entrar() {

        usuarioService.login(vm.login).then(function (resposta) {
            vm.$storage.currentUser = resposta;
            Utils.mostrarMensagem("Seja Bem vindo " + resposta.nome);
        }, function (error) {
            Utils.mostrarMensagem(error);
        });

    }

    function atualizaLabelLogin() {

        for (var i in vm.opcoesLogin) {
            if (vm.opcoesLogin[i].codigoTipoUsuario == vm.login.tipoUsuario) {
                vm.textoTipoUsuario = vm.opcoesLogin[i].textoTipoUsuario;
                break;
            }
        }


    }

    function atualizaLabelCadastro() {
        vm.textoTipoUsuario = JSON.parse(vm.usuario.tipoUsuario).textoTipoUsuario;
    }


}