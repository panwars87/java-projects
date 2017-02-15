//configurable service factory

angular.module("myApp")
.constant("testConstant","constant value")
.provider("configuredService", function() {
	
	var name = '';

    this.setName = function(newName) {
        this.name = newName;
    };
    
    this.$get = function() {
    	 var name = this.name;
         return {
             	 getName: function() {
                 return "Java Spring MCV ";
             	 }
         }
    };
    
    
}) 
.config(function(configuredServiceProvider){
	configuredServiceProvider.setName('udemy course');
})
.controller("providerController", function($scope, configuredService) {
	$scope.courseName = configuredService.getName();
	alert(configuredService.getName());

});