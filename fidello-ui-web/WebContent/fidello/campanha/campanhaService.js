(function() {

	angular.module('fidello').factory('campanhaService', campanhaService);

	campanhaService.$inject = [ '$resource', '$timeout', '$http' ];

	function campanhaService($resource, $timeout, $http) {

		var campanhaResource = $resource('http://www.fidello.com.br/fidello-core/rest/campanha', null, {
			'save' : {
				method : 'POST'
			}
		});

		return {
			cadastrarCampanha : cadastrarCampanha

		};

		function cadastrarCampanha(campanha) {

			var resource = new campanhaResource(campanha);

			return resource.$save(function(resposta) {
				return resposta;
			}, function(error) {
				return error;
			});

		}

	}

})();