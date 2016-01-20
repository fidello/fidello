angular.module('fidello').controller("lojaController", lojaController);

lojaController.$inject = ['lojaService', '$mdToast', '$state', 'CidadesEstadosFactory', '$localStorage'];

function lojaController(lojaService, $mdToast, $state, CidadesEstadosFactory, $localStorage) {

    var vm = this;

    vm.loja = {};

    vm.$storage = $localStorage;

    CidadesEstadosFactory.getEstados().then(function (reposta) {
        vm.estados = reposta.data.estados;

    });

    vm.preencherCidades = preencherCidades

    vm.cadastrarLoja = cadastrarLoja;

    // METODOS PUBLICOS
    function cadastrarLoja() {
        vm.loja.endereco.estado = JSON.parse(vm.estadoSelecionado).sigla;

        vm.loja.idPessoa = vm.$storage.currentUser.idPessoa;

        lojaService.cadastrarloja(vm.loja).then(function (resposta) {
            __mostrarMensagem("O cadastro foi realizado com sucesso");
        }, function (error) {
            __mostrarMensagem("Não foi possivel realizar o cadastro. " + error.data.message);
        });
    }

    function preencherCidades() {
        vm.cidades = JSON.parse(vm.estadoSelecionado).cidades;
        vm.selectedItem = null;
        vm.searchText = null;
        vm.querySearch = __querySearch;
    };

    // METODOS PRIVADOS
    function __mostrarMensagem(mensagem) {
        $mdToast.show($mdToast.simple().content(mensagem).position("top right").hideDelay(3000));
    }


    function __querySearch(query) {

        var results = query ? vm.cidades.filter(__createFilterFor(query)) : [];

        return results;
    }

    function __createFilterFor(query) {
        var lowercaseQuery = angular.lowercase(query);
        return function filterFn(cidade) {
            cidade = angular.lowercase(cidade);
            return (cidade.indexOf(lowercaseQuery) === 0);
        };
    }

}