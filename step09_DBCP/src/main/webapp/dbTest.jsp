<%@page import="java.sql.Connection"%>
<%@page import="ex0930.dao.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
<h1>DB 연결 Test</h1>
<%
	Connection con= DBManager.getConnection();
%>
연결 : <%=con %>
</body>
</html>