(function() {

	angular.module('fidello').factory('pontuarService', pontuarService);

	pontuarService.$inject = [ '$resource', '$timeout', 'Contantes' ];

	function pontuarService($resource, $timeout, Contantes) {

		var pontuarResource = $resource(Contante.urlResource + '/fidello-core/rest/pontuar', null, {
			'save' : {
				method : 'JSONP'
			}
		});

		return {
			cadastrarpontuar : cadastrarpontuar
		};

		function cadastrarpontuar(pontuar) {

			var resource = new pontuarResource(pontuar);

			return resource.$save(function(resposta) {
								
				return resposta;
			}, function(error) {
				return error;
			});

		}

	}

})();