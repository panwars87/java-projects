<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS Expressions
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<script>
	  var app = angular.module('application', []);
	  app.controller('courseController', function($scope) {
			
		  	$scope.framework = {name:'Java Spring MVC Framework'};

		 	$scope.links = [{link:'https://javaspringframeworkcourse.wordpress.com/'}, 
		  	                {link:'tunatore.wordpress.com'},
		  	              	{link:'https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/'},
		  	              	{link:'https://twitter.com/learncorespring'},
		  	              	{link:'https://plus.google.com/communities/115847116743856428385'},
		  	              	{link:'https://www.udemy.com/u/tunatore/'},
		  	              	{link:'https://www.facebook.com/springframeworkedu'},	  	              		  	               
		  	              	{newFunction: function() { 
		  	              			return 'test' 
		  	              		}
		  	              	}	  	              	
		  					];

		 	
		  	$scope.newFunction = function(value){
		  	     return 'called function with: ' + value;
		  	 };

	  });
	</script>
	
	
	<div ng-app="application">

		<h1>AngularJS expressions</h1>
		<div  ng-controller="courseController"> 
			<table class="table table-striped">
				<tr><td><b>numbers:</b></td><td>{{ 1 + 1 }} </td></tr>
				<tr><td><b>strings:</b></td><td>{{ "AngularJS " + " " + "Spring MVC"}} </td></tr>
				<tr><td><b>$scope:</b></td><td>{{ framework }}</td></tr>
				<tr><td><b>Object example $scope.framework.name:</b></td><td>{{ framework.name }}</td></tr>
				<tr><td><b>Array example $scope.links[2].link:</b></td><td><a href="{{ links[2].link }}" target="_blank">{{ links[2].link }}</a></td></tr>
				<tr><td><b>function call:</b></td><td>{{ newFunction(1) }}</td></tr>
				<tr><td><b>function call2:</b></td><td>{{ links[7].newFunction()}}</td></tr>
			</table>
		</div>		
		<br/> 		         
 			<a href="javascript:history.back()">Back</a>
	</div>	
	
	</jsp:body>
</page:angular-template>



