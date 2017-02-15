<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS ng-if ng-switch
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<script>
		  var app = angular.module('myApp', []);
		  app.controller('courseController', function($scope) {
			  $scope.udemyCourse = { name: "Core Java Spring and Certification 4", 
					  				 instructor: 'Tuna Tore', /** change here **/
					  				 email: 'tunatore@gmail.com',
					  				 link: 'https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/'};
		  });

	</script>
	
	
	<div ng-app="myApp">

		<div ng-controller="courseController"> 
		
			<h1>AngularJS ng-if</h1> 
			<div class="bg-success" ng-if="udemyCourse.instructor == 'Tuna Tore'">
	    		<b>ng-if="udemyCourse.instructor == 'Tuna Tore'"</b>
			</div>	
			<div class="bg-warning" ng-if="udemyCourse.instructor != 'Tuna Tore'">
	    		<b>ng-if="udemyCourse.instructor != 'Tuna Tore'"</b>
			</div>
			
			<h1>AngularJS ng-switch</h1>
			<div ng-switch on="udemyCourse.email"> 
			<div class="bg-success" ng-switch-when="tunatore@gmail.com">
	    		<b>ng-switch-when="tunatore@gmail.com"</b>
			</div>
			<div class="bg-success" ng-switch-when="tunatore@outlook.com">
	    		<b>ng-switch-when="tunatore@outlook.com"</b>
			</div>
			<div class="bg-warning" ng-switch-default>
	    		<b>ng-switch-default</b>
			</div>
			
		</div>
		
		<br/> 		         
 				<a href="javascript:history.back()">Back</a>
	</div>	
	
	</div>
	
	</jsp:body>
</page:angular-template>



