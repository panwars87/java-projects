<!DOCTYPE html>
<%@tag description="Template Site Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="logo" fragment="true" %>
<html lang="en">
  <head>

    <title><jsp:invoke fragment="title"/></title>

	<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
	<spring:url value="/resources/css/starter-template.css" var="startertemplate" />

	<link href="${bootstrap}" rel="stylesheet" />
	<link href="${startertemplate}" rel="stylesheet"/>

	<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryjs" />
	<script src="${jqueryjs}" type="text/javascript"></script>

	<spring:url value="/resources/js/bootstrap.min.js" var="js" />
	<script src="${js}"></script>

	<!-- AngularJS min production framework -->
  	<spring:url value="/resources/angularjs/angular.min.js" var="angularjs" />
	<script src="${angularjs}"></script>
	
	
	<!-- AngularJS min production routing framework -->
  	<spring:url value="/resources/angularjs/angular-route.min.js" var="angularroute" />
	<script src="${angularroute}"></script>
	
	<!-- AngularJS min production resource -->
  	<spring:url value="/resources/angularjs/angular-resource.min.js" var="angularresource" />
	<script src="${angularresource}"></script>
 

  </head>

  <body>

	    <nav class="navbar navbar-inverse navbar-fixed-top">
	      <div class="container">
	        <div class="navbar-header">
	          <b><a class="navbar-brand" href="${pageContext.request.contextPath}">Spring MVC</a></b>
	        </div>

	     	<div id="navbar" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav">
	             <li><a href="${pageContext.request.contextPath}">Home</a></li>

	             <li class="dropdown">

	                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Lectures<span class="caret"></span></a>

	                <ul class="dropdown-menu">

	                <c:url value="/rest.html" var="rest" />
	                <li><a href="${rest}"><b>REST Webservices (JSON XML)</b></a></li>

	                <c:url value="/jdbc.html" var="jdbc" />
	                <li><a href="${jdbc}"><b>JDBC with JdbcTemplates</b></a></li>
	                
	                <c:url value="/orm.html" var="orm" />
	                <li><a href="${orm}"><b>ORM Hibernate Framework</b></a></li>

	                <c:url value="/security.html" var="security" />
	                <li><a href="${security}"><b>Spring Security</b></a></li>

	                <c:url value="/jstl.html" var="jstl" />
	                <li><a href="${jstl}"><b>JSTL (Java Standard Tag Library) examples</b></a></li>

					<c:url value="/file.html" var="file" />
	                <li><a href="${file}"><b>File Upload Excel and PDF examples</b></a></li>

	                <c:url value="/controller.html" var="controller" />
	                <li><a href="${controller}"><b>Controller Mapping Example</b></a></li>

	                <c:url value="/registerForm" var="registerForm" />
	            	<li><a href="${registerForm}"><b>Spring MVC Form Handling and tags</b></a></li>

	                <c:url value="/cookieView.html" var="cookieView" />
	                <li><a href="${cookieView}"><b>Cookie and Session Scope examples</b></a></li>

	                <c:url value="/email.html" var="emailController" />
	                <li><a href="${emailController}"><b>Spring MVC Email (Velocity Email Templates)</b></a></li>

					<c:url value="/throwRunTimeException.html" var="throwRunTimeException" />
	                <li><a href="${throwRunTimeException}"><b>Exception Handler</b></a></li>

					<c:url value="/redirectExample.html" var="redirect" />
	                <li><a href="${redirect}"><b>Redirect example</b></a></li>

	            	<c:url value="/html5.html" var="html5" />
	                <li><a href="${html5}"><b>HTML5</b></a></li>

					<c:url value="/angularjs.html" var="angularjs" />
	                <li><a href="${angularjs}"><b>AngularJS by Google</b></a></li>

	              </ul>
	            </li>

	            <c:url value="/login.html" var="loginURL" />
	            <li><a href="${loginURL}">Login</a></li>

	            <c:url value="/about.html" var="about" />
	            <li><a href="${about}">Promo and About</a></li>

	          </ul>
	          <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPER_USER','ROLE_USER')">
				<span style="color: #568C00;font-size: 12px" ><b>You are logged in as: </b><security:authentication property="principal.username"/><br/><security:authentication property="principal.authorities"/></span>
				<b><a style="color: #568C00!important;text-decoration: underline;" href="<c:url value="/j_spring_security_logout"/>">Logout</a></b>
			  </security:authorize>
	        </div>
	      </div>
	    </nav>
		
<!-- 		<div class="jumbotron text-center">
		    <div class="container">
		      <div class="row">
		        <div class="col col-lg-12 col-sm-12">
		          <h1><B>AngularJS by Google</B></h1>
		          <p>with Java Spring MVC Framework</p>
		        </div>
		      </div>
		    </div>
		</div> -->

		<div class="container">
			<div class="starter-template">
				<jsp:doBody/>
			</div>
 	    </div>

  	 <footer class="footer">
      	<div class="container">
        	<p class="text-muted"><b>Tuna Tore 2015</b></p>
			<a href="<%=request.getContextPath()%>?language=en">EN</a>
 			<a href="<%=request.getContextPath()%>?language=de">DE</a>
 			<spring:message code="language"/>
 			<font color="green"><b><spring:message code="welcome.text"/></b></font>
        </div>
    </footer>

  </body>
</html>
