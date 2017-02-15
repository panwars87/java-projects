<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS form validation
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<style type="text/css">
	  input.ng-invalid {
  		border: 2px solid red;
	  }
	  input.ng-valid {
 	   border: 2px solid green;
	  }
	 </style>
	  
	<script>
	  
	  var app = angular.module('myApp', []);
	  app.controller('userController', function($scope) {
			
		 	//$scope.user = {username:"Tuna",password:"ee"};
		 	
		 	$scope.submitForm = function() {
	            if ($scope.userForm.$valid) {
	                alert('User form is valid');
	            }else{
	            	alert('Úser form is NOT valid')
	            	
	            }

	        };

	  });
	</script>
	
	
	<div>

		<h1>AngularJS form validation</h1>		
			<div ng-app="myApp" ng-controller="userController">
			<!-- novalidate option on forms will disable HTML5 related validations -->
			
			<!-- 
			Specific AngularJS Form Properties
			
			Accessing input AngularJS properties
			syntax: formName.AngularJSProperty
			example: userForm.$invalid
			
			$invalid: style class:ng-invalid The content of the field is invalid
			$valid:   style class:ng-valid The content of the field is valid
			$touched: style class:ng-touched The form or input has been blurred
			$pristine: style class:ng-pristine The form or input has NOT been used
			$dirty: style class:ng-dirty The form or input has been used
			
			Accessing input AngularJS properties
			syntax: formName.fieldName.AngularJSProperty
			example: userForm.username.$invalid

			 -->
	
  			<form name="userForm" novalidate>
  			<div style="width: 250px">
	  			<table class="table table-striped">
	  				<tr><td>Username:</td><td><input type="text" name="username" ng-model="user.username" ng-required="true" /> 
	  					<span style="color:red" ng-show="userForm.username.$invalid">
  							<span ng-show="userForm.username.$error.required">Username is required</span>
  						</span>
	  					</td>
	  				</tr>
	  				<tr><td>Password</td><td><input type="password" ng-model="user.password"/></td></tr>
					<tr><td colspan="2" align="left"><button ng-click="submitForm()">Submit</button>  </td></tr>
									
	  			</table>
			</div>
  		   </form>
Form: <br/> 		   
<pre><code>{{userForm}}</code></pre>
Form is valid: <br/> 		   
<pre><code>{{userForm.$valid}}</code></pre>    
User: <br/>
<pre><code>{{user}}</code></pre>  
username $pristine: <br/>
<pre><code>{{userForm.username.$pristine}}</code></pre> 
username $valid: <br/>
<pre><code>{{userForm.username.$valid}}</code></pre> 
username $invalid: <br/>
<pre><code>{{userForm.username.$invalid}}</code></pre> 
username $touched: <br/>
<pre><code>{{userForm.username.$touched}}</code></pre> 
username $dirty: <br/>
<pre><code>{{userForm.username.$dirty}}</code></pre> 

		</div>
		</div>
		<br/> 		         
 				<a href="javascript:history.back()">Back</a>

	
	</jsp:body>
</page:angular-template>



