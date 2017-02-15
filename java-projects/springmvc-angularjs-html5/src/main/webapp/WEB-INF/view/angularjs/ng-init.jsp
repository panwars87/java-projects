<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS ng-init
    </jsp:attribute>
    
    <jsp:body>		       		

		
	<div ng-app ng-init="
					 sites=[
					 		{url:'https://tunatore.wordpress.com/'},
					 		{url:'https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/'},
					 		{url:'https://tunatore.wordpress.com/'}
					 	   ]
						">
	
	<h1>AngularJS ng-init</h1>
	<div> 
		<table  class="table" >
		  <tr ng-repeat="site in sites">
		    <td>{{ $index }}</td><td><a href="{{ site.url }}" target="_blank">{{ site.url }}</a></td>
		  </tr>
		</table>
	</div> <br/>

	<div ng-init=" username = 'Tuna Tore' ; password=1234 ; authorization = 'ROLE_ADMIN'">
		<table  class="table">
		  <tr>
		    <td><b>Username:</b></td> <td><input type="text" ng-model="username"/></td>
		  </tr>
		  <tr>
		    <td><b>Password:</b></td> <td><input type="number" ng-model="password"/></td>
		  </tr>
		  <tr>
		    <td><b>authorization:</b></td>  <td><input type="text" ng-model="authorization"/> </td>
		  </tr>
		</table>
	</div>
	</div>
	<br/> 		         
 				<a href="javascript:history.back()">Back</a>
 				
	</jsp:body>
</page:angular-template>



