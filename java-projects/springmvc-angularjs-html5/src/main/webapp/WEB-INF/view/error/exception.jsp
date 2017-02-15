<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	Exception
    </jsp:attribute>
    <jsp:body>
		<div class="alert alert-danger">
			<strong>${exception}</strong> 
		</div>		
	</jsp:body>
</page:template>   	