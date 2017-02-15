<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	Security Tags Example
    </jsp:attribute>
    <jsp:body>
		<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER', 'ROLE_SUPER_USER')">
			<b>You are logged in as: </b><security:authentication property="principal.username"/> with the role of: <b><security:authentication property="principal.authorities"/></b><br/>
			<span style="color: #568C00;"><security:authentication property="principal.username"/></span>
			<a style="color: #568C00!important;" href="<c:url value="/j_spring_security_logout"/>">Logout</a>
		</security:authorize> 
	
	
		<c:url value="/adminOrSuperUserCanCall" var="adminOrSuperUserCanCall" />
		<c:url value="/userOrAdminCanCallSpEL" var="userOrAdminCanCallSpEL" />
		<c:url value="/adminMethodSecured" var="adminMethodSecured" />
		<c:url value="/admin/admin.html" var="admin" />

		<h2>Spring Security</h2>
		<a href="${adminOrSuperUserCanCall}">@RolesAllowed(value={"ROLE_SUPER_USER","ROLE_ADMIN"}) JSR Security</a><br/>
		<a href="${userOrAdminCanCallSpEL}">@PreAuthorize("hasRole('ROLE_ADMIN') || hasRole('ROLE_SUPER_USER') || hasRole('ROLE_USER')") SpEL Spring Security</a><br/>
		<a href="${adminMethodSecured}">@Secured(value={"ROLE_ADMIN"}) JSR Security</a><br/><br/>
		<a href="${admin}">Admin</a><br/><br/>
		<a href="${pageContext.request.contextPath}">Index</a>
		
	</jsp:body>
</page:template>   		