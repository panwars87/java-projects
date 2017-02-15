<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<html>
	<head>
		<meta charset="utf-8">
		<title>User Profile</title>
	</head> 
	<body>
		<h2>User Profile</h2>
		
			<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPER_USER', 'ROLE_USER')" var="isUSer"/>
			<font size="3" color="green"><b><c:if test="${isUSer}">You are logged in as <security:authentication property="principal.username"/> with the role of: <b><security:authentication property="principal.authorities"/></b></c:if></b></font>
			<br/>
			<a href="${pageContext.request.contextPath}">Index</a>	
			<a href="javascript:history.back()">Back</a>	
	</body>
</html>
