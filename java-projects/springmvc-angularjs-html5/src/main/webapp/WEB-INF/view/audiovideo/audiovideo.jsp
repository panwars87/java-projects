<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Audio Video HTML5</title>
</head>
<body>
<b>Audio Video HTML5</b><br/>
<c:url value="/view/resources" var="resources" />
Audio:<br/>
<audio controls>
  <source src="${'resources'}/audio/testaudio.m4a" type="audio/mp4">
</audio><br/>
Video:<br/>
<video width="640px" height="450px" controls>
  <source src="${'resources'}/video/testvideo.mp4" type="video/mp4">
</video>
</body>
</html>