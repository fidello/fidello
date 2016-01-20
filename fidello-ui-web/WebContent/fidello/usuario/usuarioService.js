(function () {

    function usuarioService($resource, $timeout, $http, Constantes) {

        var cadastroResource = $resource(Constantes.urlResource + '/fidello-core/rest/usuario/', null, {
                'save': {
                    method: 'POST'
                }
            }),
            loginResource = $resource(Constantes.urlResource +'/fidello-core/rest/usuario/login', null, {
                'save': {
                    method: 'POST'
                }
            }),
            buscarPessoasResource = $resource(Constantes.urlResource + '/fidello-core/rest/usuario/pessoas', null, {
                'save': {
                    method: 'POST'
                }
            }),
            url = Constantes.urlResource + '/fidello-core/rest/usuario/pessoas';

        return {
            cadastrarUsuario: cadastrarUsuario,
            login: login,
            buscarPessoas: buscarPessoas
        };

        function cadastrarUsuario(usuario) {

            var resource = new cadastroResource(usuario);

            return resource.$save(function (resposta) {
                return resposta;
            }, function (error) {
                return error;
            });

        }

        function buscarPessoas() {

            return $http({
                method: 'GET',
                url: url
            }).then(function (resposta) {
                return resposta.data;
            }, function (error) {
                return error;
            });

        }

        function login(usuario) {
            var resource = new loginResource(usuario);
           
            return resource.$save(function (resposta) {
                return resposta;
            }, function (error) {
                return error;
            });

        }

    }

    angular.module('fidello').factory('usuarioService', usuarioService);
    usuarioService.$inject = ['$resource', '$timeout', '$http', 'Constantes'];
})();