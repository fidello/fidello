angular.module('fidello').controller("campanhaController", campanhaController);

campanhaController.$inject = [ 'campanhaService', '$mdToast', '$state' ];

function campanhaController(campanhaService, $mdToast, $state) {

	var vm = this;

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
		vm.campanha.idPessoa = 11;
console.log('campanhar');
		console.log(vm.campanha);
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
