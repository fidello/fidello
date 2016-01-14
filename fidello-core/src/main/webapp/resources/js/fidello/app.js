(function() {
	angular.module('app', [ 'ngRoute', 'ngResource' ]);

	angular.module('app').config(function($routeProvider, $locationProvider) {

		$routeProvider.when('/', {
			templateUrl : 'paginas/inicial.html'			
		}).otherwise({
			redirectTo : '/'
		});

	});

})();
