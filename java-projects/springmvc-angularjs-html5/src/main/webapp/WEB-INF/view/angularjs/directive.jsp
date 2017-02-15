<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS Custom Directive
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<script>
	  var myapp = angular.module("myApp", []);
	  myapp.directive('udemycourse', function() {
	      var directive = {};
	      directive.restrict = 'E'; // restrict the directive to element 
	      directive.template = "<b>Test Basic Custom Directive</b>";
	      return directive;
	  });
	</script>

	<h1>AngularJS Custom Directive</h1>
	<div ng-app="myApp">
		<udemycourse></udemycourse>
	</div>
</jsp:body>
</page:angular-template>