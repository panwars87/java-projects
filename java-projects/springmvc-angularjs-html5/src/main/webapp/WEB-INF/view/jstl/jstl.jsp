<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>
<page:template>
	<jsp:attribute name="title">
     	JSTL Java Standard Tag Library
    </jsp:attribute>
    <jsp:body>
		<c:url value="/jstlReturnUsers" var="jstlReturnUsers" />
		<c:url value="/jstlUser" var="jstlUser" />
		<c:url value="/jstlHTML" var="jstlHTML" />
		
		<h1><b>JSTL Examples</b></h1>
		
		<br/>
		<a href="${jstlReturnUsers}">JSTLTestController jstlReturnUsers</a><br/>
		Calling with the value : <b>${jstlReturnUsers}</b>
		<br/>
		<br/>
		<a href="${jstlUser}">JSTLTestController jstlUser</a><br/>
		Calling with the value : <b>${jstlUser}</b>
		<br/>
		<br/>
		<a href="${jstlHTML}">JSTLTestController jstlHTML</a><br/>
		Calling with the value : <b>${jstlHTML}</b>
		<br/>		
		
		<!-- More JSTL information http://docs.oracle.com/javaee/5/tutorial/doc/bnakc.html -->
		<c:if test="${not empty users}">
		<h2>User List</h2>					
		<table>
			<c:forEach var="user" items="${users}">
	    		<tr><td><b>Iduser: </b></td><td><c:out value="${user.idUser}"/><br/></td></tr>
	    		<tr><td><b>Username:</b></td><td><c:out value="${user.username}"/><br/></td></tr>
	    		<tr><td><b>Password:</b></td><td><c:out value="${user.password}"/><br/></td></tr>
	    		<tr><td><b>Enabled:</b></td><td><c:out value="${user.enabled}"/><br/></td></tr>
			</c:forEach>
		</table>
		</c:if>
		<br/> 
		
		<c:if test="${not empty user}">
		<c:choose>
	    	 <c:when test="${user.username == 'tunatore@gmail.com'}" >
	         	ROLE_ADMIN: ${user.username}
	     	 </c:when>
	     	 <c:when test="${user.username == 'tunatore@outlook.com'}" >
	         	ROLE_ADMIN: ${user.username}
	    	 </c:when>
	    	 <c:when test="${user.username == 'admin@springweb.com'}" >
	         	ROLE_ADMIN: ${user.username}
	    	 </c:when>
	     	 <c:otherwise>
	        	ROLE_USER: ${user.username}
	     	 </c:otherwise>
 		</c:choose>
 		</c:if> 		

		<br/>		
		<c:out value="${html}" escapeXml="false"/>		
		<c:catch var ="exception">
    		${methodBackend()}
		</c:catch>		

		<b>
 		<c:if test = "${not empty exception}">
  		 	Exception Message: ${exception} 
		</c:if>
		</b>
		<br/>
		<br/>
		<c:set var="date" value="<%=new java.util.Date()%>" />

		Date Format: <b><fmt:formatDate pattern="dd MMM yyyy" value="${date}" /></b> <br/>
          
		<c:set var="number" value="80000000" />
		Number Format: <b><fmt:formatNumber type="number" groupingUsed="true" value="${number}"/></b>
		<br/><br/>       
 		<a href="javascript:history.back()">Back</a>
	</jsp:body>
</page:template>   		
