<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	Error
    </jsp:attribute>
    <jsp:body>
		<div class="alert alert-danger">
			<strong>${message}</strong> 
		</div>		
	</jsp:body>
</page:template>   		