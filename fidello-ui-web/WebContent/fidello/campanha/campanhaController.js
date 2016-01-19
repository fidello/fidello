angular.module('fidello').controller("campanhaController", campanhaController);

campanhaController.$inject = [ 'campanhaService', '$mdToast', '$state', '$localStorage'];

function campanhaController(campanhaService, $mdToast, $state,$localStorage) {

	var vm = this;

    vm.$storage = $localStorage;

	vm.tiposValidade = [ {
		codigoTipoValidade : 1,
		textoTipoValidade : "dias"
	}, {
		codigoTipoValidade : 2,
		textoTipoValidade : "meses"

	}, {
		codigoTipoValidade : 3,
		textoTipoValidade : "anos"
	}

	];

	
	vm.campanha = {};

	vm.cadastrarCampanha = cadastrarCampanha;
	
	function send(pagina) {
		$state.go(pagina);
	}

	// METODOS PUBLICOS
	         
	function cadastrarCampanha() {
		vm.campanha.idPessoa = vm.$storage.currentUser.idPessoa;		
		campanhaService.cadastrarCampanha(vm.campanha).then(function(resposta) {
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
