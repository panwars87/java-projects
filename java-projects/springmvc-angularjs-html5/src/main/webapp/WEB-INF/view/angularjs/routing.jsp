<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS Routing
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<script>
	  
	  var app = angular.module('myApp', ['ngRoute']);
	  
	  app.controller('ListPostController', function($scope) {
			$scope.posts = [
						 	{id: "Java Programming", title: 'Tuna Tore'}, 
						 	{id: "Java Spring MVC Framework", title: 'Tuna Tore'},
						 	{id: "Core Spring Framework 4", title: 'Tuna Tore'},
						 	{id: "HTML5", title: 'Tuna Tore'},
						 	{id: "AngularJS", title: 'Tuna Tore'}
						  ];
	  });
	  
	  
	  app.controller('ListPostControllerJSON', function($scope,$http) {
		  $http.get('/springmvc-angularjs-html5/posts').
	      success(function(data, status, headers, config) {
	        $scope.posts = data;
	        console.log(data);
	      }).
	      error(function(data, status, headers, config) {
	        // log error
	    	 console.log(data);
	         console.log(status);
	      });
	  });
	  
	  app.controller('GetPostController', function($scope,$routeParams) { 		  		  	
		  		//$routeParams is used to get postId /posts/:postId
		  		$scope.post = {id:$routeParams.postId, title:"Test"};

	  });
	  	 
	  //ngRoute definition
	  //a route is defined after #sign #/posts/1 or #/postsJSON
	  app.config(['$routeProvider',
	      function($routeProvider) {
	          $routeProvider.
	            when('/posts', {
	              templateUrl: 'resources/angularjs/templates/listPost.html',
	              controller: 'ListPostController'
	            }).
	            when('/postsJSON', {
		          templateUrl: 'resources/angularjs/templates/listPost.html',
		          controller: 'ListPostControllerJSON'
		        }).
	            when('/posts/:postId', {
	              templateUrl: 'resources/angularjs/templates/getPost.html',
	              controller: 'GetPostController'
	            }).
	            otherwise({
	              redirectTo: '/posts'
	        	});             
	 	}]);
	  
	  
	</script>
	
	
	<div ng-app="myApp">
		<h1>AngularJS Routing</h1><br/>		
		<div ng-view></div><br/>      
		<a href="#/posts/1">#/posts/1</a><br/>
		<a href="#/postsJSON">#/postsJSON</a><br/>
	</div>	
	
	
	</jsp:body>
</page:angular-template>



