<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Register User</title>
		<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
		<link href="${bootstrap}" rel="stylesheet" />
	</head> 
	
	<body>
	
	<c:url value="/registerForm" var="registerForm" />
	<c:url value="/registerForm/passwordValidator" var="registerFormPasswordValidator" />
	
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="${pageContext.request.contextPath}">Spring MVC</a>
	    </div>
	    <div>
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="${pageContext.request.contextPath}">Index</a></li>
	        <li><a href="javascript:history.back()">Back</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<h1><b>Register User</b></h1>	
	<form:form action="${registerFormPasswordValidator}" modelAttribute="registerBean" method="post">
		<table style="width: 800px" class="table table-striped">
				<tr>
					<td><b>Username:</b></td>
					<td><form:input path="username"/><br/><font color="red"><form:errors path="username"/></font></td>
				</tr>
				<tr>
					<td><b>Password:</b></td>
					<td><form:password path="password"/><br/><font color="red"><form:errors path="password"/></font></td>
				</tr>
				<tr>
					<td><b>Birthdate:</b></td>
					<td><form:input path="birthdate"/> DD-MM-YYYY<br/><font color="red"><form:errors path="birthdate"/></font>
				</tr>
				<tr>
					<td><b>Gender:</b></td>
					<td>
						<form:radiobutton checked="checked" path="gender" value="Male" />Male 
						<form:radiobutton path="gender" value="Female" />Female 
						<br/><font color="red"><form:errors path="gender"/></font>
					</td>
				</tr>
				<tr>
					<td><b>Education:</b></td>
					<td>
						<form:select path="education">
						    <form:option value="nodegree">No degree</form:option>
							<form:option value="highschool">High school</form:option>
							<form:option value="university">Undergraduate</form:option>
							<form:option value="Graduate">Graduate</form:option>
						</form:select>
					</td>
				</tr>
				<tr>
					<td valign="top"><b>More Details:</b></td>
					<td>
						<form:textarea cssStyle="width:400px;height:150px" path="moreDetails"/>
						<br/><font color="red"><form:errors path="moreDetails"/></font>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="left"><input type="submit" value="Register"></td>
				</tr>
		</table>
    </form:form>    
    
	</body>
</html>
