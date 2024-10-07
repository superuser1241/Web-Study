<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping</title>

<link rel="StyleSheet" 
href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<script 
src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>

</head>
<body>
<div class="navbar navbar-default">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
     <a class="navbar-brand" href="${path}">Home0</a>
    <a class="navbar-brand" href="${path}/">Home1</a>
  
    <a class="navbar-brand" href="${path}/index.jsp">Home2</a>
  </div>
  
  <div class="navbar-collapse collapse navbar-responsive-collapse">
    <ul class="nav navbar-nav">
     
      <li><a href="${path}/user/login.jsp">Login</a></li>
      <li><a href="${pageContext.request.contextPath}/front?key=elec&methodName=select">Board</a></li>
     </ul>
     
     <!-- 로그인 되면 sessionScope에 loginUser 저장되어있다! -->
     <c:if test="${not empty loginUser}">
	     <ul class="nav navbar-nav navbar-right">
	     	<li class="active"><a href="#">${loginUser} / ${loginUser.userId}!</a></li>
	      	<li><a href="${pageContext.request.contextPath}/front?key=user&methodName=logout" class="btn btn-danger">Logout</a></li>
	     </ul>
     </c:if>
  </div>
</div>



