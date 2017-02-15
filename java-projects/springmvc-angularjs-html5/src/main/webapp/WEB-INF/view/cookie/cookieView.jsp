<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	Cookie value get Example
    </jsp:attribute>
    <jsp:body>
		<div class="well">
		<c:url value="/writecookie" var="writeCookieController" />
		<h1><b>Spring MVC writeCookieController Example</b></h1>	
		<a href="${writeCookieController}">CookieControllerExample writecookie</a>
		<br/>
	
		<c:url value="/readcookie" var="readCookieController" />
		<h1><b>Spring MVC readCookieController Example</b></h1>	
		<a href="${readCookieController}">CookieControllerExample readcookie</a>
		<br/>
	
		<c:url value="/readAllCookies" var="readAllCookiesController" />
		<h1><b>Spring MVC readAllCookiesController Example</b></h1>	
		<a href="${readAllCookiesController}">CookieControllerExample readAllCookies</a>
		<br/><br/>
	
		CookieValue: <b> ${cookieValue} </b> <br/> <br/>
	
		<c:url value="/scope.html" var="scope" />
		<a href="${scope}">Scope examples</a><br/>
		
		</div>		
	</jsp:body>
</page:template>   		
