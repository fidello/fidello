angular
    .module('fidello')
    .factory('CidadesEstadosFactory', CidadesEstadosFactory);


function CidadesEstadosFactory($http) {

    return {
        getEstados: function () {
            return $http.get('json/cidades-estado-brasil.json');
        }

    };
}