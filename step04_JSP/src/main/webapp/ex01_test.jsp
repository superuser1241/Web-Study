<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP(Java server Page) 테스트</h1>
<%
	//여기는 java영역
	String name = "영준"; // 지역변수
	int age = 1; //지역변수
%>
<h3>
	이름 : <%=name %><br>
	나이 : <%=age %><br>
</h3>
</body>
</html>