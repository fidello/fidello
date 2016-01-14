(function(){
	
	var app =  angular.module('app');
	
	
    app.factory('fidelloService', fidelloService);

    var usuarios;
    
    fidelloService.$inject = ['$resource','$timeout','$http'];
    
    function fidelloService($resource,$timeout,$http) {
    	return {    		
    		getUsuarios: getUsuarios,
    		inicializar: inicializar
    		
    	};  
    	function getUsuarios(){
    		return usuarios; 
    	 }
    	 
    	 function inicializar(){
    		 
//    		 
//    		 $timeout(function(){    			 
//    			 var angularResource = $resource("/fidelloRestMaven/rest/atm");    	      	   
//            	 return angularResource.query(function(){});
//            	             	 
//    		 }, 5000);
//    	
    		 var req = {
    				 method: 'GET',
    				 url: 'http://localhost:8080/fidelloRestMaven/rest/atm',
    				 headers: {
    				   'Content-Type': "application/json"
    				 }
    				}

    			return $http(req).then(function(response){console.log("1"); return response.data}, function(){console.log("2");});
    		         	 	    		 
    	 }
        
    }
    
    
    
	
})();