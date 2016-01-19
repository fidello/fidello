

angular.module('fidello').controller("usuarioController",usuarioController); 

usuarioController.$inject = ['usuarioService','$mdToast','$state','$localStorage'];

function usuarioController(usuarioService,$mdToast,$state, $localStorage){
   
    var vm = this;   
 
    vm.$storage = $localStorage;

    vm.usuario = {};
    
    vm.login = {};

    vm.cadastrarUsuario = cadastrarUsuario;
    
    vm.entrar = entrar;
    
    vm.send = send;
          
    vm.mudarInput = mudarInput;
    
    vm.mudarInputCadastro = mudarInputCadastro;

    vm.tiposUsuarioLogin = [
      {
    	  codigoTipoUsuario:  1,
    	  textoTipoUsuario: "CPF"
      },
      {
    	  codigoTipoUsuario:  2,
    	  textoTipoUsuario: "CNPJ"
      },
      {
    	  codigoTipoUsuario:  3,
    	  textoTipoUsuario: "E-mail"
      }
      
      ];
    
    
    vm.tiposUsuarioCadastro = [
      {
    	  codigoTipoUsuario:  1,
    	  textoTipoUsuario: "CPF"
      },
      {
    	  codigoTipoUsuario:  2,
    	  textoTipoUsuario: "CNPJ"
      },
      ];
    
      
    function mudarInput(){    	    	
    	vm.textoTipoUsuario = vm.tiposUsuarioLogin[vm.login.tipoUsuario-1].textoTipoUsuario;
    }
    
    function mudarInputCadastro(){
    	vm.textoTipoUsuario = vm.tiposUsuarioCadastro[vm.usuario.tipoUsuario-1].textoTipoUsuario;
    }
    
    function send(pagina){
    	$state.go(pagina);
    }
 
    // METODOS PUBLICOS
    function cadastrarUsuario(){    	    	
        usuarioService.cadastrarUsuario(vm.usuario).then(function(resposta){            
            __mostrarMensagem("O cadastro foi realizado com sucesso");            
        },function(error){            
            __mostrarMensagem("Não foi possivel realizar o cadastro. " + error.data.message);
        });    
    }
    
    function entrar(){
    		
        usuarioService.login(vm.login).then(function(resposta){                            
        	vm.$storage.currentUser = resposta;        	        	        	
            __mostrarMensagem("Seja Bem vindo " + resposta.nome);
        },function(error){                    		
            __mostrarMensagem(error.data.message);
        });   
    	
    }
    
    // METODOS PRIVADOS
    function __mostrarMensagem(mensagem) {
         $mdToast.show($mdToast.simple().content(mensagem).position("top right").hideDelay(3000));
    }    
}
