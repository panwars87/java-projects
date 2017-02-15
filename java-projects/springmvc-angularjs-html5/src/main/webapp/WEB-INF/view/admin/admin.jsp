<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	ADMIN or Super User
    </jsp:attribute>
    <jsp:body>
	<h1><b>Admin or Super User With Secured</b></h1>
	<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPER_USER')">
			<b>You are logged in as: </b><security:authentication property="principal.username"/> with the role of: <b><security:authentication property="principal.authorities"/></b><br/>
			<a style="color: #568C00!important;" href="<c:url value="/j_spring_security_logout"/>">Logout</a>
	</security:authorize> 	
	<br/>
	<br/>
	<a href="${pageContext.request.contextPath}">Index</a>	
	<a href="javascript:history.back()">Back</a>	
	</jsp:body>
</page:template>   		
