(function () {

    angular.module('fidello').factory('campanhaService', campanhaService);

    campanhaService.$inject = ['$resource', '$timeout', 'Contantes'];

    function campanhaService($resource, $timeout, Constantes) {

        var campanhaResource = $resource(Constantes.urlResource + 'fidello-core/rest/campanha', null, {
            'save': {
                method: 'POST'
            }
        });

        return {
            cadastrarCampanha: cadastrarCampanha

        };

        function cadastrarCampanha(campanha) {

            var resource = new campanhaResource(campanha);

            return resource.$save(function (resposta) {
                return resposta;
            }, function (error) {
                return error;
            });

        }

    }

})();