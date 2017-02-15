<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS ng-bind ng-model
    </jsp:attribute>
    
    <jsp:body>		       		
	
	  <style type="text/css">
	  	.error{
	    	text-decoration: underline;
	    	color: red;
		}
		.bold {
	    	font-weight: bold;
		}
	  </style>
  
  	<script>
  
	  var app = angular.module('myApp', []);
	  app.controller('courseController', function($scope) {
			$scope.hasError = false;
	
	  });
  
 	</script>
 	
	<h1>AngularJS ng-class</h1>	
	<div ng-app="myApp" ng-controller="courseController">
		<p ng-class="{error: hasError, bold: hasError}">Error message</p>	
	</div>
	
	</jsp:body>
</page:angular-template>


