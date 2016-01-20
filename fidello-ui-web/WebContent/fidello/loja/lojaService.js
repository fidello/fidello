(function () {

    angular
        .module('fidello')
        .factory('lojaService', lojaService);

    lojaService.$inject = ['$resource', 'Constantes'];

    function lojaService($resource, Constantes) {

        var listarLojaResource = $resource(Constantes.urlResource + '/fidello-core/rest/loja/lojas/:id', {
            id: '@id'
        }, {
            'query': {
                method: 'GET',
                isArray: true
            }
        });
        var lojaResource = $resource(Constantes.urlResource + '/fidello-core/rest/loja', null, {
            'save': {
                method: 'JSONP'
            }
        });


        return {
            cadastrarloja: cadastrarloja,
            listarLojasPorPessoaid: listarLojasPorPessoaid

        };

        function cadastrarloja(loja) {

            var resource = new cadastroResource(loja);

            return resource.$save(function (resposta) {
                return resposta;
            }, function (error) {
                return error;
            });

        }

        function listarLojasPorPessoaid(idPessoa) {
            return listarLojaResource.query({
                    id: idPessoa
                }).$promise.then(function (resposta) {
                    return resposta;
                }),
                function (error) {
                    return error;
                };
        }

    }

})();