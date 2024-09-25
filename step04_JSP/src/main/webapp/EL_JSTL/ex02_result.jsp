<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>&lt;c:set > and &lt;c:out>에 저장된 값 확인</h3>
	
	아이디 : ${id }<br>
	주소 : ${addr }<br>
	info : ${info }/ <c:out value="${info }"></c:out><br>
</body>
</html>