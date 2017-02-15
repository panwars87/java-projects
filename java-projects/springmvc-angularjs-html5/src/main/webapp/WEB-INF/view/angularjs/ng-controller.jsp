<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS Controller
    </jsp:attribute>
    
    <jsp:body>	
  
  <!-- external file controller -->
  <spring:url value="/resources/angularjs/controllers/testController.js" var="testController" />
  <script src="${testController}"></script>
      
  <script>
  
  //getting angularjs module
  var app = angular.module('myApp');
  //setting angularjs module var app = angular.module('myApp', [])
  
  app.controller('UserController', ['$scope', function($scope) {
	  $scope.controllerMethodCalled = false;
	  $scope.variableTest = 'in user controller';
	  $scope.name= 'UserName';
	  $scope.right = 'user';
	  
  }]);

  app.controller('AdminController', ['$scope', function($scope) {
	  $scope.name = 'AdminName';
	  $scope.right = 'admin';
	  
  }]);
  
  app.controller('SuperUserController', ['$scope', function($scope) {
	  $scope.name = 'SuperUser';
	  $scope.right = 'superuser';
	  
  }]);

  app.controller('controllerMethodTest', ['$scope', function($scope) {
	 	$scope.controllerMethodCalled = false;
		  
		//controller method definition
		$scope.controllerMethod = function () {
			  $scope.controllerMethodCalled = true;			 
		};
	  
  }]);
  
</script>

	<h1>AngularJS ng-controller $scope inheritance example</h1>	
	<div ng-app="myApp">
	
	
	<div ng-controller="UserController">
		<table class="table table-striped">	
		<tr>
			<td>{{variableTest}} -- {{name}} -- {{right}}</td></tr>
			<tr><td><div ng-controller="AdminController">{{variableTest}} -- {{name}} -- {{right}}</div></td></tr>
			<tr><td><div ng-controller="SuperUserController">{{variableTest}} -- {{name}} -- {{right}}</div></td></tr>		
		</table>
		</div>
		<div ng-controller="controllerMethodTest">
			 Controller is called = {{ controllerMethodCalled }}
			 <button ng-click="controllerMethod()">Call Controller Method</button>
		</div>
		<div ng-controller="NewController">
			 Controllers External Controller is called = {{ controllerCalled }}
			 <button ng-click=newMethod()>Controller Method</button>
		</div>	
	</div>

	 
	
	</jsp:body>
	
</page:angular-template>


