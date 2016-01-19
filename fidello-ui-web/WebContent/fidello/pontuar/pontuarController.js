angular.module('fidello').controller("pontuarController", pontuarController);

pontuarController.$inject = [ 'pontuarService', '$mdToast', '$state', 'usuarioService','$mdDialog' ];

function pontuarController(pontuarService, $mdToast, $state, usuarioService,$mdDialog) {

	var vm = this;

	usuarioService.buscarPessoas().then(function(dados) {

		vm.clientes = dados;
		
	}, function() {
		__mostrarMensagem("Falha ao buscar clientes");
	});

	function send(pagina) {
		$state.go(pagina);
	}
	
	 vm.showAdvanced = function(ev) {
		    $mdDialog.show({
		      controller: DialogController,
		      
		      templateUrl: 'paginas/dialog1.tmpl.html',
		      parent: angular.element(document.body),
		      targetEvent: ev,
		      clickOutsideToClose:true,
		      fullscreen: false
		    })
		    .then(function(answer) {
		     // alert('You said the information was "' + answer + '".');
		    }, function() {
		     // alert('You cancelled the dialog.');
		    });
		};

		vm.answer = function(answer) {
			alert('ansher');
		    $mdDialog.hide(answer);
		  };


	// METODOS PRIVADOS
	function __mostrarMensagem(mensagem) {
		$mdToast.show($mdToast.simple().content(mensagem).position("top right").hideDelay(3000));
	}
	
	  var imagePath = 'img/list/60.jpeg';
	    vm.phones = [
	      { type: 'Home', number: '(555) 251-1234' },
	      { type: 'Cell', number: '(555) 786-9841' },
	      { type: 'Office', number: '(555) 314-1592' }
	    ];
	    vm.todos = [
	      {
	        face : imagePath,
	        what: 'Brunch this weekend?',
	        who: 'Min Li Chan',
	        when: '3:08PM',
	        notes: " I'll be in your neighborhood doing errands"
	      },
	      {
	        face : imagePath,
	        what: 'Brunch this weekend?',
	        who: 'Min Li Chan',
	        when: '3:08PM',
	        notes: " I'll be in your neighborhood doing errands"
	      },
	      {
	        face : imagePath,
	        what: 'Brunch this weekend?',
	        who: 'Min Li Chan',
	        when: '3:08PM',
	        notes: " I'll be in your neighborhood doing errands"
	      },
	      {
	        face : imagePath,
	        what: 'Brunch this weekend?',
	        who: 'Min Li Chan',
	        when: '3:08PM',
	        notes: " I'll be in your neighborhood doing errands"
	      },
	      {
	        face : imagePath,
	        what: 'Brunch this weekend?',
	        who: 'Min Li Chan',
	        when: '3:08PM',
	        notes: " I'll be in your neighborhood doing errands"
	      },
	    ];
}

function DialogController($scope, $mdDialog) {
	  $scope.hide = function() {
	    $mdDialog.hide();
	  };
	  $scope.cancel = function() {
	    $mdDialog.cancel();
	  };
	  $scope.answer = function(answer) {
	    $mdDialog.hide(answer);
	  };
	}
