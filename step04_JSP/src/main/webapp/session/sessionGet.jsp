<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
	<h3>session에 저장된 정보 조회해보자</h3>
	이름: <%=session.getAttribute("name") %>
	아이디: <%=session.getAttribute("id") %>
	취미: <%=session.getAttribute("hobby") %>
	
	<h3>저장된 정보 확인해보자 - application</h3>
	주소 : <%=application.getAttribute("addr") %><br>
	메세지 : <%=application.getAttribute("message") %><br>
</body>
</html>