<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS two-way-databinding
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<script>
  
	  var app = angular.module('myApp', []);
	  app.controller('controller', function($scope) {
			  $scope.lastName = "tore";						  
			  $scope.newMethod = function() {
					 alert($scope.lastName);
			  }
		  
	  });

	</script>

	<h1>AngularJS two-way-databinding</h1>
	
	<div ng-app="myApp" ng-controller="controller">
  	<strong>First name:</strong> {{firstName}}<br />
  	<strong>Last name:</strong> <span ng-bind="lastName"></span>
  	<br/>
  	<br/>
  	<label>Set the first name: <input type="text" ng-model="firstName" ng-change="newMethod()"/></label><br />
  	<label>Set the last name: <input type="text" ng-model="lastName"/></label>
  	<br/>
  	
    <a href="" ng-click='newMethod()'>click me</a><br/>
    <button ng-click="newMethod()">click me</button>   
	<br/><br/>	
	<select ng-model="selectedValue">
			<option value="test1">test1</option>
			<option value="test2">test2</option>
			<option value="test3">test3</option>
	</select> {{selectedValue}}<br/><br/>
	
	<input type="radio" name="selectedColor" value="Red" ng-model="selectedColor">Red</input>
	<input type="radio" name="selectedColor" value="Green" ng-model="selectedColor">Green</input>
	<span style="color:{{selectedColor}}">{{selectedColor}}</span>
		
	<br/><br/>
	CheckBox1 <span ng-bind="checkBox1"></span><input type="checkbox" value="testCheckBox1" ng-model="checkBox1"><br/>
	CheckBox2 <span ng-bind="checkBox2"></span><input  type="checkbox" value="testCheckBox2" ng-model="checkBox2"><br/>
	
	</div>

</jsp:body>
</page:angular-template>