(function(){
	
    angular
        .module('fidello')
        .factory('lojaService', lojaService);
    
    lojaService.$inject = ['$resource'];
    
    function lojaService($resource) {
    	
    	var listarLojaResource = $resource('http://localhost:8080/fidello-core/rest/loja/lojas/:id',{id:'@id'},{'query':  {method:'GET', isArray:true}});
        var lojaResource = $resource('http://localhost:8080/fidello-core/rest/loja',null,{'save': { method:'POST'}});
        
        
    	return {    		
    		cadastrarloja: 			cadastrarloja,
    		listarLojasPorPessoaid:	listarLojasPorPessoaid
    								
    	};  
        
        function cadastrarloja(loja){
    
            var resource = new cadastroResource(loja);
     		
     		return resource.$save(function(resposta){               
                return resposta;
     		}, function(error){                                
                return error;
            });
    	   
        }
        		 
        function listarLojasPorPessoaid(idPessoa){
        	 
        	return listarLojaResource.query({ id: idPessoa }).$promise.then(function(resposta){
        		console.log("respo");
        		console.log(resposta);
                return resposta;
     		}), function(error){                                
                return error;
            };
        	
        	
        }
 	
	}

})();