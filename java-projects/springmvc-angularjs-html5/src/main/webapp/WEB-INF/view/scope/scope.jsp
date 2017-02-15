<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	Scope Calls
    </jsp:attribute>
    <jsp:body>
	<c:url value="/scopeSession" var="scopeSession" />
	<c:url value="/invalidate" var="invalidate" /><br/><br/>
	<a href="${scopeSession}">Session Scope Call</a><br/>	
	<a href="${invalidate}">Session Invalidate Call</a><br/>
	
	<h1><b>Scope Calls</b></h1><br/>
	<b>SessionScope attribute:</b> ${sessionScope.sessionObject}<br/>
	
	</jsp:body>
</page:template>   		
