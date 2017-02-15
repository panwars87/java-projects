<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:angular-template>

	<jsp:attribute name="title">
     	 	AngularJS $http $resource
    </jsp:attribute>
    
    <jsp:body>		       		
	
    <script>
  
    //$http and $resource config ['ngResource']
    var app = angular.module("myApp", ['ngResource']);

    //$http
  	app.controller("getJSON", function($scope, $http) {
    $http.get('/springmvc-angularjs-html5/posts/1').
      success(function(data, status, headers, config) {
        $scope.post = data;
        console.log(data);
      }).
      error(function(data, status, headers, config) {
        // log error
     });
   
    //test JSON as post
    var post = {
    		userId: 'test',
			id : '1',
			title : 'test',
			body: 'test'
	};
    
    //$http
    $http.post('/springmvc-angularjs-html5/savePost', post).
    success(function(data, status, headers, config) {
      $scope.post = data;
      console.log(data);
    }).
    error(function(data, status, headers, config) {
      // log error
    });
  
    });

  	//$resource
  	//$resource configuration object is Posts used for CRUD
  	app.factory("Posts", function($resource) {
	  return $resource("/springmvc-angularjs-html5/posts/:id");
	});

    //$resource
  	//get post id mapped to @RestTemplateControllerExample getPostByID
  	app.controller("PostQueryByIdController", function($scope, Posts) {
  		Posts.get({ id: 1 }, function(data) {
  		  $scope.posts = data;
  		  console.log(data);
  	  });
  	});
  	
  	//$resource
  	//delete a post mapped to @RestTemplateControllerExample deletePostByID
  	app.controller("DeletePostByIdController", function($scope, Posts) {
  		  Posts.delete({ id: 1 });
  	});
  	

</script>

	<h1>AngularJS $http $resource</h1>
	
	<div ng-app="myApp">
	
	<div  ng-controller="getJSON">
		<table class="table table-striped">
			<tr>
				<td><b>userid</b></td>
				<td>{{ post.userId }}</td>
			</tr>
			<tr>
				<td><b>id</b></td>
				<td>{{ post.id }}</td>
			</tr>
			<tr>
				<td><b>title</b></td>
				<td>{{ post.title}}</td>
			</tr>
			<tr>
				<td><b>body</b></td>
				<td>{{ post.body }}</td>
			</tr>
		</table> 
	</div>
	
	<div ng-controller="PostQueryByIdController"></div> 
	<div ng-controller="DeletePostByIdController"></div> 

	</div>

	</jsp:body>
</page:angular-template>
