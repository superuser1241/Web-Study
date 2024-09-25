<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		주소 : <%=request.getParameter("addr") %><br>
		작성자 : Programmer <%=request.getParameter("id") %>
	</h3>
</body>
</html>