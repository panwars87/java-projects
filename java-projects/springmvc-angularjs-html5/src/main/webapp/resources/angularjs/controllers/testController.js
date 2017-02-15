//this is the definition for a new angularjs single page application

var app = angular.module('myApp', []).controller('NewController', function($scope) {
    $scope.newMethod = function() {    	
    	//external controller is called
        $scope.controllerCalled = true;
    }
});