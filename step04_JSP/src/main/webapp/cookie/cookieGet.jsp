<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UFT-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Cookie 정보 확인하기</h2>
	<%
		Cookie[] cookies= request.getCookies();
		if(cookies !=null){
			out.println("쿠키개수 = "+cookies.length+"<br>");
			
			for(Cookie c : cookies){
				String name = c.getName();
				String value = c.getValue();
				out.print(name+" = "+value+"<br>");
			}
		}else{
			out.print("저장된 Cookie정보가 없어 JSESSIONID를 저장합니다");
		}
	%>
</body>
</html>