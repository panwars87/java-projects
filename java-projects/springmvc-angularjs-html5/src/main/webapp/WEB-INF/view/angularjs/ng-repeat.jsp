<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS ng-repeat
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
			  
		  });
  
	</script>
	
	<div ng-app="myApp">
	<h1>AngularJS ng-repeat</h1>
	
	<h1>course in udemyCourses</h1>
	<div  ng-controller="courseController"> 
		<table class="table">
		  <tr ng-repeat="course in udemyCourses">
		    <td>{{ course.name }}</td>
		    <td>{{ course.instructor }}</td>
		  </tr>
		</table>
	</div>

	<h1>course in udemyCourses with $index and $last</h1>
	<!-- ng-repeat with $index and $last -->
	<div  ng-controller="courseController"> 
		<table class="table table-striped">
		  <tr ng-repeat="course in udemyCourses">
		    <td>{{ $index }}</td>
		    <td> is last element? {{ $last }}</td>
		    <td>{{ course.name }}</td>
		    <td>{{ course.instructor }}</td>
		    <td><a href="{{ course.link}}" target="_blank">{{ course.link }}</a></td>
		  </tr>
		</table>
	</div>

	<h1>course in udemyCourses | orderBy : 'name'</h1>
	<!-- ng-repeat with filter -->
	<div  ng-controller="courseController"> 
		<table class="table">
		  <tr ng-repeat="course in udemyCourses | orderBy : 'name'">
		    <td>{{ course.name }}</td>
		    <td>{{ course.instructor }}</td>
		  </tr>
		</table>
	</div>
	
	<h1>course in udemyCourses | orderBy : 'name' : reverse</h1>
	<!-- {{ orderBy_expression | orderBy : expression : reverse}} -->
	<!-- course in udemyCourses | orderBy : 'name' : reverse -->
	<div ng-controller="courseController"> 
		<table class="table">
		  <tr ng-repeat="course in udemyCourses | orderBy : 'name' : true">
		    <td>{{ $index }}</td>
		    <td>{{ course.name }}</td>
		    <td>{{ course.instructor }}</td>
		  </tr>
		</table>
	</div>
	
	</div>
	
	</jsp:body>
</page:angular-template>


