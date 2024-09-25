<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getParameter("name") %>님의 혈액형은 <%=request.getParameter("blood") %>
</body>
</html>