<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS Filter
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<script>
  
  	  var app = angular.module('myApp', []);	  
	  app.controller('courseController', function($scope) {
		  $scope.udemyCourses = [
		 	{name: "Java Programming", instructor: 'Tuna Tore', link: 'https://tunatore.wordpress.com/'}, 
		 	{name: "Java Spring MVC Framework", instructor: 'Tuna Tore', link: 'https://javaspringframeworkcourse.wordpress.com/'},
		 	{name: "Core Spring Framework 4", instructor: 'Tuna Tore', link: 'https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/'},
		 	{name: "HTML5", instructor: 'Tuna Tore' , link: 'https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/'},
		 	{name: "AngularJS", instructor: 'Tuna Tore', link: 'https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/'}
		  ];
		  
		  $scope.instructor = {name: 'Tuna Tore' , email: 'tunatore@gmail.com'};
		  $scope.currentDate = new Date();
	  });
 
	  //custom filter declaration
  	  app.filter('newFilter', function() {
	  //first parameter is filter input
	  //other parameters are optional parameters
	  return function(filterInput, optional1, optional2, optional3) {
		 var filterResult;
		 //filter function start here
		 filterResult = "filter result: " + filterInput + " " + optional1 + " " + optional2;	 
		 //filter function ends	 
	     return filterResult;

	  }
   	  }); 

</script>

	<h1>AngularJS filter</h1>

	<div ng-app="myApp" ng-controller="courseController"> 
		<h1>Filter order with pipe " expression | filter1 | filter2 | ... "</h1>

		<h1>course in udemyCourses | limitTo: 2</h1>
		<table class="table table-striped">
		  <tr ng-repeat="course in udemyCourses | limitTo:4">
		    <td>{{ course.name }}</td>
		    <td>{{ course.instructor }}</td>
		    <td>{{ course.link }}</td>
		  </tr>
		</table> 

		<h1>AngularJS built-in filters</h1>
		<table class="table table-striped">
		  <tr>
		    <td>Uppercase filter : {{ instructor.name | uppercase }}</td>
		    <td>Lowercase filter : {{ instructor.name | lowercase }} </td>
		  </tr>
		</table> 

		<h1>AngularJS json filter</h1>
		<pre>{{ udemyCourses[0] | json }}</pre>
		
		<h1>AngularJS date filter</h1>
		<span>{{currentDate| date:"MM/dd/yyyy"}}</span><br/>
		
		<h1>AngularJS custom filter</h1>	
		{{ "test" | newFilter }} <br/>
		{{ "test" | newFilter:"parameter1":"parameter2" }}
		<br/><br/>
		<br/><br/>
		
	</div>

</jsp:body>
</page:angular-template>