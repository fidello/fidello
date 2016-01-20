(function () {

    function usuarioService($resource, $timeout, $http, Contantes) {

        var cadastroResource = $resource(Contantes.urlResource + '/fidello-core/rest/usuario/', null, {
                'save': {
                    method: 'JSONP'
                }
            }),
            loginResource = $resource(Contantes.urlResource + '/fidello-core/rest/usuario/login', null, {
                'save': {
                    method: 'JSONP'
                }
            }),
            buscarPessoasResource = $resource(Contantes.urlResource + '/fidello-core/rest/usuario/pessoas', null, {
                'save': {
                    method: 'JSONP'
                }
            }),
            url = Contantes.urlResource + '/fidello-core/rest/usuario/pessoas';

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
    usuarioService.$inject = ['$resource', '$timeout', '$http', 'Contantes'];
})();