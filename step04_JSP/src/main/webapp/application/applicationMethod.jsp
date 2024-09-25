<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ServletContext - application</h1>
	getRealPath : <%=application.getRealPath("/") %><br>
	getContextPath : <%=application.getContextPath() %><br>\
	
	<%
		//ServletContext에서 정보를 저장해보자
		application.setAttribute("addr", "오리역");
		application.setAttribute("message", "application학습중~");
	%>
	<h3>저장된 정보 확인해보자</h3>
	주소 : <%=application.getAttribute("addr") %><br>
	메세지 : <%=application.getAttribute("message") %><br>
	
	<a href="applicationGet.jsp">이동해보자</a>
</body>
</html>