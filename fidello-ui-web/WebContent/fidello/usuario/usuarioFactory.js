angular
.module('fidello')
.service('UsuarioFactory',UsuarioFactory);


function UsuarioFactory() {
  var currentUser;

  return {
    login: function(usuario){
    	
    	currentUser = usuario;
    },
    getCurrentUser: function(){
    	
    	return currentUser;
    }
	  
  };
};