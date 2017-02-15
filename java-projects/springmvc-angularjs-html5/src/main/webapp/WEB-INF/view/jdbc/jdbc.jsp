<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	JDBC Example
    </jsp:attribute>
    <jsp:body>
		<c:url value="/jdbcInsert" var="jdbcInsert" />
		<c:url value="/jdbcSelectLogs" var="jdbcSelectLogs" />
		<c:url value="/jdbcDelete" var="jdbcDelete" />
		<c:url value="/jdbcUpdate" var="jdbcUpdate" />
		<c:url value="/jdbcSelectAllUsers" var="jdbcSelectAllUsers" />
		
		<h1><b>JDBC Examples</b></h1>
		
		<br/>
		<a href="${jdbcSelectAllUsers}">JDBCContoller jdbcSelectAllUsers</a><br/>
		Calling with the value : <b>${jdbcSelectAllUsers}</b>
		<br/>
		<br/>		
		<a href="${jdbcUpdate}/user/username/test2@outlook.com/enabled/false">JDBCContoller jdbcUpdate/user/username/test2@outlook.com/enabled/false</a><br/>
		Calling with the value : <b>${jdbcUpdate}/user/username/test2@outlook.com/enabled/false</b>
		<br/>
		<br/>	
		<a href="${jdbcDelete}/user/8">JDBCContoller jdbcDelete</a><br/>
		Calling with the value : <b>${jdbcDelete}/user/8</b>
		<br/>
		<br/>	
		<a href="${jdbcSelectLogs}">JDBCContoller jdbcSelectLogs</a><br/>
		Calling with the value : <b>${jdbcSelectLogs}</b>
		<br/>
		<br/>
		<a href="${jdbcInsert}/logstring/jdbcTestLogString">JDBCContoller jdbcInsert</a><br/>
		Calling with the value : <b>${jdbcInsert}/logstring/jdbcTestLogString</b>
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
		<br/>
		<c:if test="${not empty users}">
		<h2>User List</h2>					
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
		
		<c:if test="${not empty dbLogs}">
		<h2>DBLog List</h2>					
		<table>
			<c:forEach var="log" items="${dbLogs}">
	    		<tr><td><b>IDLOG: </b></td><td><c:out value="${log.IDLOG}"/><br/></td></tr>
	    		<tr><td><b>LOGSTRING:</b></td><td><c:out value="${log.LOGSTRING}"/><br/></td></tr>
			</c:forEach>
		</table>
		</c:if>
		<br/> 		         
 		<a href="javascript:history.back()">Back</a>
	</jsp:body>
</page:template>   		

