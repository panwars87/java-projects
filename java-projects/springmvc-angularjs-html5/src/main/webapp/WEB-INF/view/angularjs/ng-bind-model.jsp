<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS ng-bind ng-model
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<div ng-app>
	
	<h1>AngularJS ng-bind ng-model</h1>
	<div>
		<table class="table table-striped">
		  <tr>
		    <td><b>Username:</b></td> <td><input type="text" ng-model="username"/></td>
		  </tr>
		  <tr>
		    <td><b>Password:</b></td> <td><input type="text" ng-model="passwords"/></td>
		  </tr>
		  <tr>
		    <td><b>authorization:</b></td>  <td><input type="text" ng-model="authorization"/> </td>
		  </tr>
		</table>
	</div> 
	
	Hi {{ username }} welcome to Java Spring MVC Integrated with AngularJS by Google and HTML5<br/>
	You password is {{ passwords }} <br/>
	and login as <span ng-bind="authorization"></span> <br/>
	</div>

	
	</jsp:body>
</page:angular-template>



