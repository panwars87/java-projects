<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	REST Calls
    </jsp:attribute>
    <jsp:body>
	
	<c:url value="/posts" var="RestTemplateControllerExamplePosts" />
	<c:url value="/posts/1" var="RestTemplateControllerExamplePosts1" />
	<c:url value="/responseStatusError" var="RestTemplateControllerExampleResponseStatusError" />
	<c:url value="/getAllDBLogsXML" var="RestControllerGetAllDBLogsXML" />
	<c:url value="/getAllDBLogsJSON" var="RestControllerGetAllDBLogsJSON" />
	<h1><b>REST calls</b></h1>
	<security:authorize access="hasRole('ROLE_ADMIN')">
			<b>You are logined as: </b><security:authentication property="principal.username"/> with the role of: <b><security:authentication property="principal.authorities"/></b><br/>
			<span style="color: #568C00;"><security:authentication property="principal.username"/></span>
			<a style="color: #568C00!important;" href="<c:url value="/j_spring_security_logout"/>">Logout</a>
		</security:authorize> 		
		<br/>
		<br/>
		<a href="${RestTemplateControllerExamplePosts}">@RestTemplateControllerExample/posts</a><br/>
		calling with the value : <b>${RestTemplateControllerExamplePosts}</b>
		<br/>
		<br/>
		<a href="${RestTemplateControllerExamplePosts1}">@RestTemplateControllerExample/posts/1</a><br/>
		calling with the value : <b>${RestTemplateControllerExamplePosts1}</b>
		<br/>
		<br/>
		<a href="${RestTemplateControllerExampleResponseStatusError}">@RestTemplateControllerExampleResponseStatusError</a><br/>
		calling with the value : <b>${RestTemplateControllerExampleResponseStatusError}</b>
		<br/>
		<br/>
		<a href="${RestControllerGetAllDBLogsXML}">@RestController/getAllDBLogsXML</a><br/>
		calling with the value : <b>${RestControllerGetAllDBLogsXML}</b>
		<br/>
		<br/>
		<a href="${RestControllerGetAllDBLogsJSON}">@RestController/getAllDBLogsJSON</a><br/>
		calling with the value : <b>${RestControllerGetAllDBLogsJSON}</b>
		<br/>
		<a href="javascript:history.back()">Back</a>		
	</jsp:body>
</page:template>   		

