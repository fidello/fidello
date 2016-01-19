(function() {

	angular.module('fidello').factory('usuarioService', usuarioService);

	usuarioService.$inject = [ '$resource', '$timeout', '$http' ];

	function usuarioService($resource, $timeout, $http) {

		var cadastroResource = $resource('http://localhost:8080/fidello-core/rest/usuario/', null, {
			'save' : {
				method : 'POST'
			}
		});
		var loginResource = $resource('http://localhost:8080/fidello-core/rest/usuario/login', null, {
			'save' : {
				method : 'POST'
			}
		});
		var buscarPessoasResource = $resource('http://localhost:8080/fidello-core/rest/usuario/pessoas', null, {
			'save' : {
				method : 'POST'
			}
		});
		var url = 'http://localhost:8080/fidello-core/rest/usuario/pessoas';

		return {
			cadastrarUsuario : cadastrarUsuario,
			login : login,
			buscarPessoas : buscarPessoas
		};

		function cadastrarUsuario(usuario) {

			var resource = new cadastroResource(usuario);

			return resource.$save(function(resposta) {
				return resposta;
			}, function(error) {
				return error;
			});

		}

		function buscarPessoas() {

		return 	$http({
				method : 'GET',
				url : url
			}).then(function(resposta) {

				console.log('resposta');
				console.log(resposta);
				return resposta.data;
			}, function(error) {
				return error;
			});

		}

		function login(usuario) {
			var resource = new loginResource(usuario);

			return resource.$save(function(resposta) {
				return resposta;
			}, function(error) {
				return error;
			});

		}

	}

})();