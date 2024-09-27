<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
<h1>Cookie 저장하기</h1>
<%
	//쿠키 생성해서 저장하기
	Cookie co1 = new Cookie("id", "Young");
	Cookie co2 = new Cookie("age","20");
	
	//옵션 설정
	co1.setMaxAge(60*60*24); //1일
	co2.setMaxAge(60*60*24*365);//1년
	
	co1.setPath("/");//쿠키를 접근할 수 있는 경로 설정
	
	//클라이언트쪽에 전송해서 저장한다
	response.addCookie(co1);
	response.addCookie(co2);
%>

<a href="cookieGet.jsp">이동하기</a>
</body>
</html>