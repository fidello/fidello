

angular.module('fidello').controller("menuController",menuController); 

menuController.$inject = ['$mdSidenav','$state','$localStorage'];

function menuController($mdSidenav,$state,$localStorage){
    
    var vm = this;
    
    vm.$storage = $localStorage;
    
     vm.toggleSidenav = function(menuId) {
         $mdSidenav(menuId).toggle();
    };
    
 	vm.menuLateral = [
    {
      link : 'cadastroLoja',
      title: 'Cadastrar Loja',
      icon: 'dashboard'
    },
    {
      link : 'cadastroCampanha',
      title: 'Cadastrar Campanha',
      icon: 'group'
    },
    {
      link : 'pontuarCliente',
      title: 'Pontuar cliente',
      icon: 'message'
    }
    ]; 
 	
 	vm.navegar =  function(pagina){
     	$state.go(pagina);
     }
   

}    

