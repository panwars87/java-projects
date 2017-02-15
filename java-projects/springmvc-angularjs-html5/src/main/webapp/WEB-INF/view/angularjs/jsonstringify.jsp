<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
  <head>

    <title>Java Spring MVC Framework with AngularJS by Google and HTML5</title>
    
	<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
	<spring:url value="/resources/css/starter-template.css" var="startertemplate" />
	
	<link href="${bootstrap}" rel="stylesheet" />
	<link href="${startertemplate}" rel="stylesheet"/>
	
	<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryjs" />
	<script src="${jqueryjs}" type="text/javascript"></script>
	
	<spring:url value="/resources/js/bootstrap.min.js" var="js" />
	<script src="${js}"></script>
  
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

		<div class="jumbotron text-center">
		    <div class="container">
		      <div class="row">
		        <div class="col col-lg-12 col-sm-12">
		          <h1><B>Java Spring MVC</B></h1>
		          <p>Integrated with AngularJS by Google and HTML5</p>
		        </div>
		      </div>
		    </div> 
		</div>
		
		<div class="container">
			<div class="starter-template">

<pre> 
<b>Script1: JavaScript Object</b>
<code>
var udemyCourseObject = {
 title: 'Java Spring MVC Framework with AngularJS by Google and HTML5',
 instructor: 'Tuna Tore'
};

var jsonUdemyCourseObject = JSON.stringify(udemyCourseObject);

var udemyCourseObjectParsed = JSON.parse(jsonUdemyCourseObject);
document.getElementById("resultParse").innerHTML = udemyCourseObjectParsed.title;
</code> 		
</pre>

<pre>
<b>Result1: JSON.stringify(udemyCourseObject)</b>
<code id="resultStringify"></code>
</pre>		


<pre>
<b>Result1: JSON.parse(jsonUdemyCourseObject)</b>
<code id="resultParse"></code>
</pre>			
	

<script type="text/javascript">
var udemyCourseObject = {
		 title: 'Java Spring MVC Framework with AngularJS by Google and HTML5',
		 instructor: 'Tuna Tore'
};

var jsonUdemyCourseObject = JSON.stringify(udemyCourseObject, null, 2); //2 spacing-pretty print	
document.getElementById("resultStringify").innerHTML = jsonUdemyCourseObject;

var udemyCourseObjectParsed = JSON.parse(jsonUdemyCourseObject);
document.getElementById("resultParse").innerHTML = udemyCourseObjectParsed.title;

</script>	

<pre> 
<b>Script2: JavaScript Array</b>
<code>
var array = ['Java Spring MVC', 'REST', 'JDBCTemplate', 'Maven', true, 2, false];
var jsonArray = JSON.stringify(array,null,2);
document.getElementById("resultArray").innerHTML = jsonArray;

var arrayParsed = JSON.parse(jsonArray);
document.getElementById("resultArrayParse").innerHTML = arrayParsed[0];
</code> 		
</pre>

<pre>
<b>Result2: JSON.stringify(array)</b>
<code id="resultArray"></code>
</pre>			

<pre>
<b>Result2: JSON.parse(jsonArray) arrayParsed[0]</b>
<code id="resultArrayParse"></code>
</pre>		

<script type="text/javascript">

var array = ['Java Spring MVC', 'REST', 'JDBCTemplate', 'Maven', true, 2, false];
var jsonArray = JSON.stringify(array,null,2);
document.getElementById("resultArray").innerHTML = jsonArray;

var arrayParsed = JSON.parse(jsonArray);
document.getElementById("resultArrayParse").innerHTML = arrayParsed[0];

</script>


<pre> 
<b>Script3: JavaScript Array with Objects</b>
<code>	
var arrayObjects = {
		udemyCourses: [
			{ title:'Java Spring MVC Framework with AngularJS by Google and HTML5', instructor: 'Tuna Tore' },
			{ title:'Java Spring Framework 4 and Core Spring Certification', instructor: 'Tuna Tore' }
			]
		};
document.getElementById("arrayObjects").innerHTML = JSON.stringify(arrayObjects,null,2);
document.getElementById("arrayObjects2").innerHTML = arrayObjects.udemyCourses[1].title;
</code> 		
</pre>

<pre>
<b>Result3:JSON.stringify(arrayObjects)</b>
<code id="arrayObjects"></code>
</pre>		

<pre>
<b>Result3: arrayObjects.udemyCourses[1].title</b>
<code id="arrayObjects2"></code>
</pre>		

<script type="text/javascript">
var arrayObjects = {
		udemyCourses: [
			{ title:'Java Spring MVC Framework with AngularJS by Google and HTML5', instructor: 'Tuna Tore' },
			{ title:'Java Spring Framework 4 and Core Spring Certification', instructor: 'Tuna Tore' }
			]
		};
document.getElementById("arrayObjects").innerHTML = JSON.stringify(arrayObjects,null,2);
document.getElementById("arrayObjects2").innerHTML = arrayObjects.udemyCourses[1].title;
</script>

<pre> 
<b>Script4: JavaScript Nested Objects</b>
<code>	
var udemyCourse = {
		  title:  'Java Spring Framework 4 and Core Spring Certification',
		  instructor: 'Tuna Tore',
		  information: {
		    students: 204,
		    promo: 'https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/',		    
		  }
};
document.getElementById("nestedObjects").innerHTML = udemyCourse.information.students;
</code> 		
</pre>

<pre>
<b>Result4: Nested Objects udemyCourse.information.students</b>
<code id="nestedObjects"></code>
</pre>		


<script type="text/javascript">
var udemyCourse = {
		  title:  'Java Spring Framework 4 and Core Spring Certification',
		  instructor: 'Tuna Tore',
		  information: {
		    students: 204,
		    promo: 'https://www.udemy.com/spring-framework-4-course-and-core-spring-certification/',		    
		  }
};
document.getElementById("nestedObjects").innerHTML = udemyCourse.information.students;
</script>
			
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
