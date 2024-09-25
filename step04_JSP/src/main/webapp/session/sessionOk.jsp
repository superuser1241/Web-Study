<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sessionOk 입니다</h2>
	<h3>session에 저장된 정보 조회해보자</h3>
	이름: <%=session.getAttribute("name") %>
	아이디: <%=session.getAttribute("id") %>
	취미: <%=session.getAttribute("hobby") %><br>
	
	<hr>
	<h3>메뉴정보 출력</h3>
	
	<%
		//request scope에 저장된 메뉴 조회
		List<String> menus= (List<String>)request.getAttribute("menus");
		out.println(menus); //
	%>
</body>
</html>