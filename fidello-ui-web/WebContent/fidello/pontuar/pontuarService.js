(function() {

	angular.module('fidello').factory('pontuarService', pontuarService);

	pontuarService.$inject = [ '$resource', '$timeout', '$http' ];

	function pontuarService($resource, $timeout, $http) {

		var pontuarResource = $resource('http://localhost:8080/fidello-core/rest/pontuar', null, {
			'save' : {
				method : 'POST'
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