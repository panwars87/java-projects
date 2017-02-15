//organise and share your code across the application
//contains set of methods and provides communication across controllers
//services are singleton instantiated only one for angularjs app

angular.module("serviceModule", [])
.service('TestService', function(){
	   this.function1 = function(p) {
		  alert("function1");
	   }
	   this.function2 = function(p) {
		  alert("function2");
	   }
	   this.function3 = function(p) {
		  alert("function3");
	   }
	   this.serviceMethod = function(p) {
		  alert("serviceMethod");
	   }
}).controller("serviceDependency", function ($scope, TestService){
		TestService.function1();
}).controller("serviceController", function($scope, TestService) {
		TestService.function2();
		$scope.serviceMethod = function() {
			TestService.serviceMethod('');
		} 
});