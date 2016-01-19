    angular.module("fidello",['ngResource','ui.router','ngMaterial','ngMdIcons','ngStorage']);
    
    angular.module('fidello').config(function($stateProvider, $urlRouterProvider,$mdThemingProvider) {

    	 $urlRouterProvider.otherwise("/inicial");
    	 
    	 $stateProvider.state('inicial', {
    		 	url:'/inicial',
    		 	controller: "usuarioController",
    		 	controllerAs: 'vm',
                templateUrl : 'paginas/inicial.html'			
            }).
            state('cadastroUsuario', {
            	url:"/cadastroUsuario",
                templateUrl : 'paginas/cadastroUsuario.tpl.html'	
                	
            }).state('cadastroLoja', {
            	
            	url:"/cadastroLoja",
            	controller: "lojaController",
    		 	controllerAs: 'vm',
                templateUrl : 'paginas/cadastroLoja.tpl.html'	
                	
            }).state('cadastroCampanha', {
            	url:"/cadastroCampanha",
            	controller: "campanhaController",
    		 	controllerAs: 'vm',
                templateUrl : 'paginas/cadastroCampanha.tpl.html'			
            }).state('pontuarCliente', {
            	url:"/pontuarCliente",
                templateUrl : 'paginas/pontuarCliente.tpl.html',
                controller: "pontuarController",
                controllerAs: "vm"
            });

            var customBlueMap = $mdThemingProvider.extendPalette('light-blue', {
                'contrastDefaultColor': 'light',
                'contrastDarkColors': ['50'],
                '50': 'ffffff'
            });
        
            $mdThemingProvider.definePalette('customBlue', customBlueMap);
            $mdThemingProvider.theme('default')
                .primaryPalette('customBlue', {
                    'default': '500',
                    'hue-1': '50'
                })
                .accentPalette('blue');
        
            $mdThemingProvider.theme('input', 'default').primaryPalette('grey');
            
            
            

        }).config(function($mdIconProvider) {
            $mdIconProvider
            .iconSet('social', 'img/icons/sets/social-icons.svg', 24)
            .iconSet('device', 'img/icons/sets/device-icons.svg', 24)
            .iconSet('communication', 'img/icons/sets/communication-icons.svg', 24)
            .defaultIconSet('img/icons/sets/core-icons.svg', 24);
        })
;


