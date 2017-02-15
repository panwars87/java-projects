<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>
	<jsp:attribute name="title">
     	AngularJS by Google and HTML5 with Java Spring MVC Framework
    </jsp:attribute>
    <jsp:body>		
       			<figure style="text-align: left">
        			<img style="border-radius: 15px;" width="200" src="${pageContext.request.contextPath}/resources/images/AngularJS.png">    			
    				<figcaption><br/><b><a href="${about}">Promo</a></b></figcaption>
     			</figure>	

        		
        		<h2><b>JavaScript stringify and parse</b></h2>
				<c:url value="/jsonstringify.html" var="jsonstringify" />
				<a href="${jsonstringify}">Understanding JavaScript JSON.stringify</a><br/>   	
				
				<h2><b>AngularJS Dependency Injection</b></h2>
				<c:url value="/dependency-injection.html" var="dependencyinjection" />
				<a href="${dependencyinjection}">AngularJS Dependency Injection</a><br/>
								
 				<h2><b>AngularJS ng-Examples</b></h2>
 				<c:url value="/ng-init.html" var="nginit" />
				<a href="${nginit}">ng-init</a><br/>   
				
				<c:url value="/ng-bind-model.html" var="ngbindmodel" />
				<a href="${ngbindmodel}">ng-bind ng-model</a><br/>  
				
				<c:url value="/ng-if-switch.html" var="ngifswitch" />
				<a href="${ngifswitch}">ng-if-switch</a><br/>  
				
				<c:url value="/ng-click-show-hide.html" var="ngclickshowhide" />
				<a href="${ngclickshowhide}">ng-click ng-show ng-hide</a><br/>  
				
				<c:url value="/ng-class.html" var="ngclass" />
				<a href="${ngclass}">ng-class</a><br/>  
				
				<c:url value="/ng-repeat.html" var="ngrepeat" />
				<a href="${ngrepeat}">ng-repeat</a><br/>   
								
				<h2><b>AngularJS Filter</b></h2>
				<c:url value="/filter.html" var="filter" />
				<a href="${filter}">AngularJS Filter</a><br/>  
				
				<h2><b>AngularJS Form Validation</b></h2>
				<c:url value="/formvalidation.html" var="formvalidation" />
				<a href="${formvalidation}">AngularJS Form Validation</a><br/>  
				
				<h2><b>AngularJS $http and $resource services</b></h2>
				<c:url value="/httpresource.html" var="httpresource" />
				<a href="${httpresource}">AngularJS $http $resource</a><br/>  
				
				<h2><b>AngularJS Directive</b></h2>
				<c:url value="/directive.html" var="directive" />
				<a href="${directive}">AngularJS Directive</a><br/>
				
				<h2><b>AngularJS Expression</b></h2>
				<c:url value="/expression.html" var="expression" />
				<a href="${expression}">AngularJS Expression</a><br/> 
				
				<h2><b>AngularJS Routing</b></h2>
				<c:url value="/routing.html" var="routing" />
				<a href="${routing}">AngularJS Routing</a><br/> 
				
				<h2><b>AngularJS Controller</b></h2>
				<c:url value="/ng-controller.html" var="controller" />
				<a href="${controller}">AngularJS Controller</a><br/> 
								
				<h2><b>AngularJS two way data binding</b></h2>
				<c:url value="/two-way-databinding.html" var="twowaydatabinding" />
				<a href="${twowaydatabinding}">AngularJS two way data binding</a><br/>
				
				<br/> 		         
 				<a href="javascript:history.back()">Back</a>
	</jsp:body>
</page:angular-template>   		


