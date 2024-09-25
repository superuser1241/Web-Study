<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
	<h3>저장된 정보 확인해보자 - application</h3>
	주소 : <%=application.getAttribute("addr") %><br>
	메세지 : <%=application.getAttribute("message") %><br>
	
	<h3>이동해보자</h3>
	<a href="<%=application.getContextPath()%>/session/sessionGet.jsp">sessionGet.jsp이동</a><br>
	<a href="${pageContext.request.contextPath}/sessionServlet">SessionServlet 이동</a><br>
</body>
</html>