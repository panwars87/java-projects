<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	Success
    </jsp:attribute>
    <jsp:body>
		<div class="alert alert-success">
			<strong>${message}</strong> Indicates a successful or positive action.
		</div>		
	</jsp:body>
</page:template>   		