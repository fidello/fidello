angular.module('fidello').controller("lojaController", lojaController);

lojaController.$inject = [ 'lojaService', '$mdToast', '$state', 'CidadesEstadosFactory','$localStorage'];

function lojaController(lojaService, $mdToast, $state, CidadesEstadosFactory, $localStorage) {

	var vm = this;

	vm.loja = {};
	
	vm.$storage = $localStorage;
		
	CidadesEstadosFactory.getEstados().then(function(reposta) {
		vm.estados = reposta.data.estados;

	});

	vm.preencherCidades = function() {
		vm.states = JSON.parse(vm.estadoSelecionado).cidades;
		vm.selectedItem = null;
		vm.searchText = null;
		vm.querySearch = querySearch;
	};

	vm.cadastrarLoja = cadastrarLoja;

	function querySearch(query) {

		var results = query ? vm.states.filter(createFilterFor(query)) : [];

		return results;
	}
    
	function createFilterFor(query) {
		var lowercaseQuery = angular.lowercase(query);
		return function filterFn(state) {
			state = angular.lowercase(state);
			return (state.indexOf(lowercaseQuery) === 0);
		};
	}

	function send(pagina) {
		$state.go(pagina);
	}

	// METODOS PUBLICOS
	function cadastrarLoja() {
		vm.loja.endereco.estado = JSON.parse(vm.estadoSelecionado).sigla;
				
		vm.loja.idPessoa = vm.$storage.currentUser.idPessoa;
		
		lojaService.cadastrarloja(vm.loja).then(function(resposta) {
			__mostrarMensagem("O cadastro foi realizado com sucesso");
		}, function(error) {
			__mostrarMensagem("Não foi possivel realizar o cadastro. " + error.data.message);
		});
	}

	// METODOS PRIVADOS
	function __mostrarMensagem(mensagem) {
		$mdToast.show($mdToast.simple().content(mensagem).position("top right").hideDelay(3000));
	}
}
