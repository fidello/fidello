(function(){
	
	var app =  angular.module('app');
	
	
    app.controller('fidelloController', fidelloController);

    
    fidelloController.$inject = ['$http','$resource','fidelloService'];
        		         
       function fidelloController($http,$resource, fidelloService) { 	
    	   
    	 var vm = this;
    	 
    	 
    	 var angularResource = $resource("/fidelloRestMaven/rest/atm");
    	   
    	 fidelloService.inicializar().then(function(data){
    		 vm.usuarios = data;
    		 
    		
    	 });
    	 
    	   		
     	vm.salvar = function(){
     		
     		
     		console.log("Salvou");
     		console.log(vm.usuario);
     		
     		var resource = new angularResource(vm.usuario);
     		
     		resource.$save(function(){
     			        console.log("salvou"); 
     		});
     	};
     	
    	 
    	 
    	                                                                                        
    }
	
})();
