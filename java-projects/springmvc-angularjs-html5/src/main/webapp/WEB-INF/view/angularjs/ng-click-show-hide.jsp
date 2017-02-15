<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	AngularJS ng-click ng-show ng-hide
    </jsp:attribute>
    
    <jsp:body>		       		
	
	<div ng-app ng-init="visible=false">
		
	<h1>AngularJS ng-click ng-show ng-hide</h1>
	
	<div ng-show="visible">ng show Visible: {{visible}}</div>
	<div ng-hide="visible">ng-hide Visible: {{visible}}</div>

	<a href="" ng-click="visible=true">ng show</a>
	</div>
	<br/> 		         
 	<a href="javascript:history.back()">Back</a>
	</jsp:body>
</page:angular-template>



