<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	Spring MVC File Upload Controller Example
    </jsp:attribute>
    <jsp:body>
			<c:url value="/uploadFile" var="fileUploadControllerURL" />
			<h1><b>Spring MVC FileUploadController Example</b></h1>	<br/>
			<form action="${fileUploadControllerURL}" method="post" enctype="multipart/form-data">
				<table>
					<tr><td><b>File:</b></td><td><input type="file" name="file"></td><td><input type="submit" value="Press to upload the File"></td></tr>
				</table>
			</form>	
			<br/><br/> 
			<c:url value="/excel" var="excelController" />
			<a href="${excelController}">Excel</a><br/>    	
			<c:url value="/pdf" var="PDFController" />
			<a href="${PDFController}">PDF</a> 
	</jsp:body>
</page:template>   		
