<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	ORM Example
    </jsp:attribute>
    <jsp:body>
		
		<c:url value="/ormFindAllUsers" var="ormFindAllUsers" />
		<c:url value="/ormUpdateUser" var="ormUpdateUser" />
		<c:url value="/ormDeleteUser" var="ormDeleteUser" />
		<c:url value="/ormInsertUser" var="ormInsertUser" />
		
		<h1><b>ORM Hibernate JPA Examples</b></h1>
		
		<br/>
		<a href="${ormFindAllUsers}">ORMContoller ormFindAllUsers</a><br/>
		Calling with the value : <b>${ormFindAllUsers}</b>
		<br/>
		<br/>		
		<a href="${ormUpdateUser}/iduser/1/enabled/false">ORMContoller ormUpdateUser</a><br/>
		Calling with the value : <b>${ormUpdateUser}/user/iduser/1/enabled/false</b>
		<br/>
		<br/>	
		<a href="${ormDeleteUser}/iduser/8">ORMContoller ormDeleteUser</a><br/>
		Calling with the value : <b>${ormDeleteUser}/iduser/8</b>
		<br/>
		<br/>	
		<a href="${ormInsertUser}/username/testuser/password/testpassword/enabled/true">ORMContoller ormInsertUser</a><br/>
		Calling with the value : <b>${ormInsertUser}/username/testuser/password/testpassword/enabled/true</b>
		<br/>
		<br/>	
	
		<c:if test="${not empty result}">
			Result: <c:if test="${result == 'true'}">
						<font color="green"><b>${result}</b></font>
					</c:if>
					<c:if test="${result == 'false'}">
						<font color="red"><b>${result}</b></font>
					</c:if>
		</c:if>
		
		<c:if test="${not empty users}">
		<h2>ORM User List</h2>					
		<table>
			<c:forEach var="user" items="${users}">
	    		<tr><td><b>Iduser: </b></td><td><c:out value="${user.idUser}"/><br/></td></tr>
	    		<tr><td><b>Username:</b></td><td><c:out value="${user.username}"/><br/></td></tr>
	    		<tr><td><b>Password:</b></td><td><c:out value="${user.password}"/><br/></td></tr>
	    		<tr><td><b>Enabled:</b></td>
	    		<td>    
	    			<c:if test="${user.enabled == 'true'}">
						<font color="green"><b><c:out value="${user.enabled}"/></b></font>
					</c:if>
					<c:if test="${user.enabled == 'false'}">
						<font color="red"><b><c:out value="${user.enabled}"/></b></font>
					</c:if>
					<br/>
				</td></tr>
			</c:forEach>
		</table>
		</c:if>
		<br/> 		         
 		<a href="javascript:history.back()">Back</a>
	</jsp:body>
</page:template>   		

